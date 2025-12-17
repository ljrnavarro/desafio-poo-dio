package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    // Construtor com nome
    public Dev(String nome) {
        setNome(nome);
    }

    // Construtor vazio
    public Dev() {
    }

    // Inscrever em bootcamp
    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            throw new IllegalArgumentException("Bootcamp não pode ser nulo");
        }

        if (!bootcamp.isAtivo()) {
            throw new IllegalStateException("Bootcamp não está ativo para inscrições");
        }

        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.inscreverDev(this);
    }

    // Progredir no próximo conteúdo
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            Conteudo c = conteudo.get();
            this.conteudosConcluidos.add(c);
            this.conteudosInscritos.remove(c);
            System.out.println("✅ " + nome + " concluiu: " + c.getTitulo() +
                    " (+" + c.calcularXp() + " XP)");
        } else {
            System.err.println("❌ " + nome + " não está matriculado em nenhum conteúdo!");
        }
    }

    // Concluir conteúdo específico
    public void concluirConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Conteúdo não pode ser nulo");
        }

        if (!conteudosInscritos.contains(conteudo)) {
            throw new IllegalArgumentException("Conteúdo não encontrado nos conteúdos inscritos");
        }

        conteudosInscritos.remove(conteudo);
        conteudosConcluidos.add(conteudo);
        System.out.println("✅ " + nome + " concluiu: " + conteudo.getTitulo() +
                " (+" + conteudo.calcularXp() + " XP)");
    }

    // Calcular XP total
    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    // Métodos utilitários
    public int getTotalConteudosInscritos() {
        return conteudosInscritos.size();
    }

    public int getTotalConteudosConcluidos() {
        return conteudosConcluidos.size();
    }

    public double getPercentualConclusao() {
        int total = getTotalConteudosInscritos() + getTotalConteudosConcluidos();
        if (total == 0) return 0.0;
        return (getTotalConteudosConcluidos() * 100.0) / total;
    }

    public List<Conteudo> getConteudosInscritosList() {
        return new ArrayList<>(conteudosInscritos);
    }

    public List<Conteudo> getConteudosConcluidosList() {
        return new ArrayList<>(conteudosConcluidos);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome.trim();
    }

    public Set<Conteudo> getConteudosInscritos() {
        return new LinkedHashSet<>(conteudosInscritos); // Cópia defensiva
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        if (conteudosInscritos == null) {
            throw new IllegalArgumentException("Conteúdos inscritos não pode ser nulo");
        }
        this.conteudosInscritos = new LinkedHashSet<>(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return new LinkedHashSet<>(conteudosConcluidos); // Cópia defensiva
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        if (conteudosConcluidos == null) {
            throw new IllegalArgumentException("Conteúdos concluídos não pode ser nulo");
        }
        this.conteudosConcluidos = new LinkedHashSet<>(conteudosConcluidos);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", inscritos=" + getTotalConteudosInscritos() +
                ", concluidos=" + getTotalConteudosConcluidos() +
                ", XP=" + String.format("%.1f", calcularTotalXp()) +
                ", progresso=" + String.format("%.1f%%", getPercentualConclusao()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
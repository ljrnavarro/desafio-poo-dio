package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    // Construtor vazio (para frameworks como JPA)
    public Bootcamp() {
    }

    // Construtor com parâmetros obrigatórios
    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Método para adicionar conteúdo individualmente
    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Conteúdo não pode ser nulo");
        }
        this.conteudos.add(conteudo);
    }

    // Método para remover conteúdo
    public void removerConteudo(Conteudo conteudo) {
        this.conteudos.remove(conteudo);
    }

    // Método para verificar se bootcamp está ativo
    public boolean isAtivo() {
        LocalDate hoje = LocalDate.now();
        return !hoje.isBefore(dataInicial) && !hoje.isAfter(dataFinal);
    }

    // Método para inscrever dev
    public void inscreverDev(Dev dev) {
        if (dev == null) {
            throw new IllegalArgumentException("Dev não pode ser nulo");
        }
        this.devsInscritos.add(dev);
    }

    // Método para remover dev
    public void removerDev(Dev dev) {
        this.devsInscritos.remove(dev);
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
        this.descricao = descricao.trim();
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return new HashSet<>(devsInscritos); // Retorna cópia defensiva
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        if (devsInscritos == null) {
            throw new IllegalArgumentException("Set de devs não pode ser nulo");
        }
        this.devsInscritos = new HashSet<>(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return new LinkedHashSet<>(conteudos); // Retorna cópia defensiva
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        if (conteudos == null) {
            throw new IllegalArgumentException("Set de conteúdos não pode ser nulo");
        }
        this.conteudos = new LinkedHashSet<>(conteudos);
    }

    // Métodos utilitários
    public int getTotalDevsInscritos() {
        return devsInscritos.size();
    }

    public int getTotalConteudos() {
        return conteudos.size();
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", ativo=" + isAtivo() +
                ", totalDevs=" + getTotalDevsInscritos() +
                ", totalConteudos=" + getTotalConteudos() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao) &&
                Objects.equals(dataInicial, bootcamp.dataInicial) &&
                Objects.equals(dataFinal, bootcamp.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal);
    }
}
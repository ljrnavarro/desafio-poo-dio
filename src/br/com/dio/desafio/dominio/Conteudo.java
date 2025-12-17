package br.com.dio.desafio.dominio;

public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    // Construtor protegido
    protected Conteudo(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
    }

    // Construtor vazio protegido (para frameworks como JPA)
    protected Conteudo() {
    }

    // Método abstrato para calcular XP
    public abstract double calcularXp();

    // Método para validar dados do conteúdo
    public boolean isValid() {
        return titulo != null && !titulo.trim().isEmpty() &&
                descricao != null && !descricao.trim().isEmpty();
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        this.titulo = titulo.trim();
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {
    private int cargaHoraria;

    // Construtor completo
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        setCargaHoraria(cargaHoraria);
    }

    // Construtor vazio
    public Curso() {
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    // Getters e Setters
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser positiva");
        }
        this.cargaHoraria = cargaHoraria;
    }

    // Sobrescrever isValid
    @Override
    public boolean isValid() {
        return super.isValid() && cargaHoraria > 0;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", xp=" + calcularXp() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Curso curso = (Curso) o;
        return cargaHoraria == curso.cargaHoraria;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + cargaHoraria;
    }
}
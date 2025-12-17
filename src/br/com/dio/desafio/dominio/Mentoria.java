package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria extends Conteudo {
    private LocalDate data;

    // Construtor completo
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        setData(data);
    }

    // Construtor vazio
    public Mentoria() {
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    // Verificar se mentoria já ocorreu
    public boolean isRealizada() {
        return data != null && data.isBefore(LocalDate.now());
    }

    // Verificar se mentoria é futura
    public boolean isFutura() {
        return data != null && data.isAfter(LocalDate.now());
    }

    // Sobrescrever isValid
    @Override
    public boolean isValid() {
        return super.isValid() && data != null;
    }

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                ", realizada=" + isRealizada() +
                ", xp=" + calcularXp() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mentoria mentoria = (Mentoria) o;
        return Objects.equals(data, mentoria.data);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + (data != null ? data.hashCode() : 0);
    }
}
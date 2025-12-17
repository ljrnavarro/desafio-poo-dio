import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BOOTCAMP DIO - SISTEMA DE APRENDIZADO ===\n");

        // Criar bootcamp
        Bootcamp bootcampJava = new Bootcamp("Java Developer",
                "Bootcamp completo para formação em Java e Spring Boot");

        System.out.println("Bootcamp criado: " + bootcampJava);

        // Criar conteúdos
        Curso cursoJava = new Curso("Java Básico",
                "Fundamentos da linguagem Java", 8);
        Curso cursoOOP = new Curso("Java OOP",
                "Programação Orientada a Objetos com Java", 12);
        Mentoria mentoriaCarreira = new Mentoria("Carreira Dev Java",
                "Como se tornar um desenvolvedor Java profissional",
                LocalDate.now().plusDays(7));

        // Adicionar conteúdos ao bootcamp
        bootcampJava.adicionarConteudo(cursoJava);
        bootcampJava.adicionarConteudo(cursoOOP);
        bootcampJava.adicionarConteudo(mentoriaCarreira);

        System.out.println("\nConteúdos adicionados:");
        bootcampJava.getConteudos().forEach(System.out::println);

        // Criar desenvolvedores
        Dev devAna = new Dev("Ana Silva");
        Dev devCarlos = new Dev("Carlos Oliveira");

        System.out.println("\n=== INSCRIÇÕES NO BOOTCAMP ===");

        // Inscrever desenvolvedores
        devAna.inscreverBootcamp(bootcampJava);
        devCarlos.inscreverBootcamp(bootcampJava);

        System.out.println("\nStatus inicial:");
        System.out.println(devAna);
        System.out.println(devCarlos);

        System.out.println("\n=== PROGRESSO DOS DEVS ===");

        // Ana progride em todos os conteúdos
        System.out.println("\n--- Progresso da Ana ---");
        while (devAna.getTotalConteudosInscritos() > 0) {
            devAna.progredir();
        }

        // Carlos progride em alguns conteúdos
        System.out.println("\n--- Progresso do Carlos ---");
        devCarlos.progredir();
        devCarlos.progredir();

        System.out.println("\n=== STATUS FINAL ===");
        System.out.println(devAna);
        System.out.println("Conteúdos concluídos pela Ana:");
        devAna.getConteudosConcluidosList().forEach(c ->
                System.out.println("  - " + c.getTitulo() + " (" + c.calcularXp() + " XP)"));

        System.out.println("\n" + devCarlos);
        System.out.println("Conteúdos concluídos pelo Carlos:");
        devCarlos.getConteudosConcluidosList().forEach(c ->
                System.out.println("  - " + c.getTitulo() + " (" + c.calcularXp() + " XP)"));

        System.out.println("\n=== RESUMO DO BOOTCAMP ===");
        System.out.println(bootcampJava);
        System.out.println("Total de devs inscritos: " + bootcampJava.getTotalDevsInscritos());
        System.out.println("Bootcamp ativo: " + (bootcampJava.isAtivo() ? "✅ Sim" : "❌ Não"));
    }
}
package view;

import model.Pessoa;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        LocalDate dataNascimento = LocalDate.of(1963, 06, 19);
        Pessoa pessoa = criarPessoa("Lucas", dataNascimento, "QA");
        if (pessoa != null) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
            System.out.println("Profissão: " + pessoa.getProfissao());
            System.out.println("Idade: " + pessoa.getIdade());
        }
    }

    public static Pessoa criarPessoa(String nome, LocalDate dataNascimento, String profissao) {
        if (idadeMaiorQue150(dataNascimento)) {
            System.out.println("Idade superior a 150 anos não é permitida.");
            return null;
        }
        return new Pessoa(nome, dataNascimento, profissao);
    }

    private static boolean idadeMaiorQue150(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - dataNascimento.getYear();
        if (hoje.getMonthValue() < dataNascimento.getMonthValue() ||
                (hoje.getMonthValue() == dataNascimento.getMonthValue() &&
                        hoje.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idade--;
        }
        return idade > 150;
    }
}

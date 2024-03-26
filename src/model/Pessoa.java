package model;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String profissao;

    public Pessoa(String nome, LocalDate dataNascimento, String profissao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - this.dataNascimento.getYear();
        if (hoje.getMonthValue() < this.dataNascimento.getMonthValue() ||
                (hoje.getMonthValue() == this.dataNascimento.getMonthValue() &&
                        hoje.getDayOfMonth() < this.dataNascimento.getDayOfMonth())) {
            idade--;
        }
        return idade;
    }
}



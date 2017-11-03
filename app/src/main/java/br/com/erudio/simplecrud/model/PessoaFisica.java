package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PessoaFisica extends Pessoa{

    private static final long serialVersionUID = 1L;

    @SerializedName("dataDeNascimento")
    @Expose
    private String dataDeNascimento;

    public PessoaFisica() {}

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaFisica that = (PessoaFisica) o;

        return dataDeNascimento != null ? dataDeNascimento.equals(that.dataDeNascimento) : that.dataDeNascimento == null;

    }

    @Override
    public int hashCode() {
        return dataDeNascimento != null ? dataDeNascimento.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "dataDeNascimento='" + dataDeNascimento + '\'' +
                '}';
    }
}
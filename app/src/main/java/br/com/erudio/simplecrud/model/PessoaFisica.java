package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PessoaFisica extends Pessoa{

    private static final long serialVersionUID = 1L;

    @SerializedName("dataDeNascimento")
    @Expose
    private Date dataDeNascimento;

    public PessoaFisica() {}

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PessoaFisica that = (PessoaFisica) o;

        return dataDeNascimento.equals(that.dataDeNascimento);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + dataDeNascimento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PessoaFisica{dataDeNascimento=" + dataDeNascimento + '}';
    }
}
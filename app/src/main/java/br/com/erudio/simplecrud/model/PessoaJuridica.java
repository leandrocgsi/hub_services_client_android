package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PessoaJuridica extends Pessoa{

    private static final long serialVersionUID = 1L;

    @SerializedName("nomeRazaoSocial")
    @Expose
    private String nomeRazaoSocial;

    public PessoaJuridica() {}

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PessoaJuridica that = (PessoaJuridica) o;

        return nomeRazaoSocial != null ? nomeRazaoSocial.equals(that.nomeRazaoSocial) : that.nomeRazaoSocial == null;

    }

    @Override
    public int hashCode() {
        return nomeRazaoSocial != null ? nomeRazaoSocial.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "nomeRazaoSocial='" + nomeRazaoSocial + '\'' +
                '}';
    }
}
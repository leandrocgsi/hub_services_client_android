package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Long id;

    @Expose @SerializedName("cpfcnpj")
    private String cpfcnpj;

    @Expose @SerializedName("nomeNomeFantasia")
    private String nomeNomeFantasia;

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getNomeNomeFantasia() {
        return nomeNomeFantasia;
    }

    public void setNomeNomeFantasia(String nomeNomeFantasia) {
        this.nomeNomeFantasia = nomeNomeFantasia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (id != null ? !id.equals(pessoa.id) : pessoa.id != null) return false;
        if (cpfcnpj != null ? !cpfcnpj.equals(pessoa.cpfcnpj) : pessoa.cpfcnpj != null)
            return false;
        return nomeNomeFantasia != null ? nomeNomeFantasia.equals(pessoa.nomeNomeFantasia) : pessoa.nomeNomeFantasia == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cpfcnpj != null ? cpfcnpj.hashCode() : 0);
        result = 31 * result + (nomeNomeFantasia != null ? nomeNomeFantasia.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", cpfcnpj='" + cpfcnpj + '\'' +
                ", nomeNomeFantasia='" + nomeNomeFantasia + '\'' +
                '}';
    }
}
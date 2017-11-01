package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PessoaFisica {

    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("cpfcnpj")
    @Expose
    private String cpfcnpj;

    @SerializedName("nomeNomeFantasia")
    @Expose
    private String nomeNomeFantasia;

    @SerializedName("dataDeNascimento")
    @Expose
    private Date dataDeNascimento;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

        PessoaFisica that = (PessoaFisica) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (cpfcnpj != null ? !cpfcnpj.equals(that.cpfcnpj) : that.cpfcnpj != null) return false;
        if (nomeNomeFantasia != null ? !nomeNomeFantasia.equals(that.nomeNomeFantasia) : that.nomeNomeFantasia != null)
            return false;
        return dataDeNascimento != null ? dataDeNascimento.equals(that.dataDeNascimento) : that.dataDeNascimento == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cpfcnpj != null ? cpfcnpj.hashCode() : 0);
        result = 31 * result + (nomeNomeFantasia != null ? nomeNomeFantasia.hashCode() : 0);
        result = 31 * result + (dataDeNascimento != null ? dataDeNascimento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "id=" + id +
                ", cpfcnpj='" + cpfcnpj + '\'' +
                ", nomeNomeFantasia='" + nomeNomeFantasia + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}
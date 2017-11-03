package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TipoTransacao implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Integer id;

    @Expose @SerializedName("descricao")
    private String descricao;

    public TipoTransacao() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoTransacao that = (TipoTransacao) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return descricao != null ? descricao.equals(that.descricao) : that.descricao == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TipoTransacao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
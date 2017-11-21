package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AccountType implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Integer id;

    @Expose @SerializedName("descricao")
    private String description;

    public AccountType() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountType accountType = (AccountType) o;

        if (id != null ? !id.equals(accountType.id) : accountType.id != null) return false;
        return description != null ? description.equals(accountType.description) : accountType.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
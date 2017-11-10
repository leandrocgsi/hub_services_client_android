package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AccountStatus implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Integer id;

    @Expose @SerializedName("descricao")
    private String description;

    public AccountStatus() {}

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

        AccountStatus that = (AccountStatus) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountStatus{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
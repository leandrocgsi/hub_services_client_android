package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Long id;

    @Expose @SerializedName("cpfcnpj")
    private String cpfcnpj;

    @Expose @SerializedName("nomeNomeFantasia")
    private String nameTradeName;

    public Person() {}

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

    public String getNameTradeName() {
        return nameTradeName;
    }

    public void setNameTradeName(String nameTradeName) {
        this.nameTradeName = nameTradeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (cpfcnpj != null ? !cpfcnpj.equals(person.cpfcnpj) : person.cpfcnpj != null)
            return false;
        return nameTradeName != null ? nameTradeName.equals(person.nameTradeName) : person.nameTradeName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cpfcnpj != null ? cpfcnpj.hashCode() : 0);
        result = 31 * result + (nameTradeName != null ? nameTradeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", cpfcnpj='" + cpfcnpj + '\'' +
                ", nameTradeName='" + nameTradeName + '\'' +
                '}';
    }
}
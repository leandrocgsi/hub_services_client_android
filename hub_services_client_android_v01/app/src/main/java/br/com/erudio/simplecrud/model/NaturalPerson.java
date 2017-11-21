package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NaturalPerson extends Person{

    private static final long serialVersionUID = 1L;

    @SerializedName("dataDeNascimento")
    @Expose
    private String birthday;

    public NaturalPerson() {}

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NaturalPerson that = (NaturalPerson) o;

        return birthday != null ? birthday.equals(that.birthday) : that.birthday == null;

    }

    @Override
    public int hashCode() {
        return birthday != null ? birthday.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NaturalPerson{" +
                "birthday='" + birthday
                + '\'' + " " + super.toString() +
        '}';
    }
}
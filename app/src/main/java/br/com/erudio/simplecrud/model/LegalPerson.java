package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LegalPerson extends Person{

    private static final long serialVersionUID = 1L;

    @SerializedName("nomeRazaoSocial")
    @Expose
    private String companyName;

    public LegalPerson() {}

    public LegalPerson(Long id, String companyName, String nameTradeName, String cpfcnpj) {
        this.id = id;
        this.cpfcnpj = cpfcnpj;
        this.nameTradeName = nameTradeName;
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LegalPerson that = (LegalPerson) o;

        return companyName != null ? companyName.equals(that.companyName) : that.companyName == null;

    }

    @Override
    public int hashCode() {
        return companyName != null ? companyName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LegalPerson{" +
                "companyName='" + companyName + '\'' +
                + '\'' + " " + super.toString() +
                '}';
    }
}
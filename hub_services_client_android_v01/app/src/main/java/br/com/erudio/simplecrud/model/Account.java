package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Long id;

    @Expose @SerializedName("dataCriacao")
    private Date creationDate;

    @Expose @SerializedName("nome")
    private String name;

    @Expose @SerializedName("saldo")
    private BigDecimal balance;

    @Expose @SerializedName("tipoConta")
    private AccountType accountType;

    @Expose @SerializedName("statusConta")
    private AccountStatus accountStatus;

    @Expose @SerializedName("contaMatriz")
    private Account parentAccount;

    @Expose @SerializedName("pessoa")
    private Person person;

    public Account() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Account getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(Account parentAccount) {
        this.parentAccount = parentAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (creationDate != null ? !creationDate.equals(account.creationDate) : account.creationDate != null)
            return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null)
            return false;
        if (accountStatus != null ? !accountStatus.equals(account.accountStatus) : account.accountStatus != null)
            return false;
        if (parentAccount != null ? !parentAccount.equals(account.parentAccount) : account.parentAccount != null)
            return false;
        return person != null ? person.equals(account.person) : account.person == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (accountStatus != null ? accountStatus.hashCode() : 0);
        result = 31 * result + (parentAccount != null ? parentAccount.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                ", parentAccount=" + parentAccount +
                ", person=" + person +
                '}';
    }
}
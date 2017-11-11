package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Long id;

    @Expose @SerializedName("dataCriacao")
    private Date dataCriacao;

    @Expose @SerializedName("nome")
    private String nome;

    @Expose @SerializedName("saldo")
    private BigDecimal saldo;

    @Expose @SerializedName("tipoConta")
    private AccountType accountType;

    @Expose @SerializedName("statusConta")
    private AccountStatus accountStatus;

    @Expose @SerializedName("contaMatriz")
    private Conta contaMatriz;

    @Expose @SerializedName("pessoa")
    private Person person;

    public Conta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AccountType getTipoConta() {
        return accountType;
    }

    public void setTipoConta(AccountType accountType) {
        this.accountType = accountType;
    }

    public Conta getContaMatriz() {
        return contaMatriz;
    }

    public void setContaMatriz(Conta contaMatriz) {
        this.contaMatriz = contaMatriz;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
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

        Conta conta = (Conta) o;

        if (id != null ? !id.equals(conta.id) : conta.id != null) return false;
        if (dataCriacao != null ? !dataCriacao.equals(conta.dataCriacao) : conta.dataCriacao != null)
            return false;
        if (nome != null ? !nome.equals(conta.nome) : conta.nome != null) return false;
        if (saldo != null ? !saldo.equals(conta.saldo) : conta.saldo != null) return false;
        if (accountType != null ? !accountType.equals(conta.accountType) : conta.accountType != null)
            return false;
        if (accountStatus != null ? !accountStatus.equals(conta.accountStatus) : conta.accountStatus != null)
            return false;
        if (contaMatriz != null ? !contaMatriz.equals(conta.contaMatriz) : conta.contaMatriz != null)
            return false;
        return person != null ? person.equals(conta.person) : conta.person == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (accountStatus != null ? accountStatus.hashCode() : 0);
        result = 31 * result + (contaMatriz != null ? contaMatriz.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", dataCriacao=" + dataCriacao +
                ", nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                ", contaMatriz=" + contaMatriz +
                ", person=" + person +
                '}';
    }
}
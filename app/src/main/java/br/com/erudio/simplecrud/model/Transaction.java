package br.com.erudio.simplecrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Expose @SerializedName("id")
    private Long id;

    @Expose @SerializedName("origem")
    private Account origin;

    @Expose @SerializedName("destino")
    private Account destiny;

    @Expose @SerializedName("tipoTransacao")
    private TransactionType transactionType;
    
    @Expose @SerializedName("dataTransacao")
    private Date transactionDate;

    @Expose @SerializedName("codigo")
    private String code;
    
    @Expose @SerializedName("estornada")
    private Boolean reversed;
    
    @Expose @SerializedName("valor")
    private BigDecimal value;

    public Transaction() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public Account getDestiny() {
        return destiny;
    }

    public void setDestiny(Account destiny) {
        this.destiny = destiny;
    }

    public TransactionType getTipoTransacao() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public void setReversed(Boolean reversed) {
        this.reversed = reversed;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction transacao = (Transaction) o;

        if (id != null ? !id.equals(transacao.id) : transacao.id != null) return false;
        if (origin != null ? !origin.equals(transacao.origin) : transacao.origin != null)
            return false;
        if (destiny != null ? !destiny.equals(transacao.destiny) : transacao.destiny != null)
            return false;
        if (transactionType != null ? !transactionType.equals(transacao.transactionType) : transacao.transactionType != null)
            return false;
        if (transactionDate != null ? !transactionDate.equals(transacao.transactionDate) : transacao.transactionDate != null)
            return false;
        if (code != null ? !code.equals(transacao.code) : transacao.code != null)
            return false;
        if (reversed != null ? !reversed.equals(transacao.reversed) : transacao.reversed != null)
            return false;
        return value != null ? value.equals(transacao.value) : transacao.value == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (destiny != null ? destiny.hashCode() : 0);
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (reversed != null ? reversed.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", origin=" + origin +
                ", destiny=" + destiny +
                ", transactionType=" + transactionType +
                ", transactionDate=" + transactionDate +
                ", code='" + code + '\'' +
                ", reversed=" + reversed +
                ", value=" + value +
                '}';
    }
}
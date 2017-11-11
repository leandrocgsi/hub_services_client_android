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
    private Conta origem;

    @Expose @SerializedName("destino")
    private Conta destino;

    @Expose @SerializedName("tipoTransacao")
    private TransactionType transactionType;
    
    @Expose @SerializedName("dataTransacao")
    private Date dataTransacao;

    @Expose @SerializedName("codigo")
    private String codigo;
    
    @Expose @SerializedName("estornada")
    private Boolean estornada;
    
    @Expose @SerializedName("valor")
    private BigDecimal valor;

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

    public Conta getOrigem() {
        return origem;
    }

    public void setOrigem(Conta origem) {
        this.origem = origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    public TransactionType getTipoTransacao() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstornada() {
        return estornada;
    }

    public void setEstornada(Boolean estornada) {
        this.estornada = estornada;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction transacao = (Transaction) o;

        if (id != null ? !id.equals(transacao.id) : transacao.id != null) return false;
        if (origem != null ? !origem.equals(transacao.origem) : transacao.origem != null)
            return false;
        if (destino != null ? !destino.equals(transacao.destino) : transacao.destino != null)
            return false;
        if (transactionType != null ? !transactionType.equals(transacao.transactionType) : transacao.transactionType != null)
            return false;
        if (dataTransacao != null ? !dataTransacao.equals(transacao.dataTransacao) : transacao.dataTransacao != null)
            return false;
        if (codigo != null ? !codigo.equals(transacao.codigo) : transacao.codigo != null)
            return false;
        if (estornada != null ? !estornada.equals(transacao.estornada) : transacao.estornada != null)
            return false;
        return valor != null ? valor.equals(transacao.valor) : transacao.valor == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (origem != null ? origem.hashCode() : 0);
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (dataTransacao != null ? dataTransacao.hashCode() : 0);
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (estornada != null ? estornada.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", origem=" + origem +
                ", destino=" + destino +
                ", transactionType=" + transactionType +
                ", dataTransacao=" + dataTransacao +
                ", codigo='" + codigo + '\'' +
                ", estornada=" + estornada +
                ", valor=" + valor +
                '}';
    }
}
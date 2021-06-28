/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xirtek
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByCodigoPe", query = "SELECT p FROM Pedido p WHERE p.codigoPe = :codigoPe"),
    @NamedQuery(name = "Pedido.findByDespachoPe", query = "SELECT p FROM Pedido p WHERE p.despachoPe = :despachoPe"),
    @NamedQuery(name = "Pedido.findByTotalPe", query = "SELECT p FROM Pedido p WHERE p.totalPe = :totalPe"),
    @NamedQuery(name = "Pedido.findByFechaHoraPe", query = "SELECT p FROM Pedido p WHERE p.fechaHoraPe = :fechaHoraPe")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoPe")
    private Integer codigoPe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "despachoPe")
    private boolean despachoPe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPe")
    private int totalPe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraPe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPe;
    @JoinColumn(name = "bebida_codBe", referencedColumnName = "codBe")
    @ManyToOne(optional = false)
    private Bebida bebidacodBe;
    @JoinColumn(name = "cliente_rutCli", referencedColumnName = "rutCli")
    @ManyToOne(optional = false)
    private Cliente clienterutCli;
    @JoinColumn(name = "plato_codPla", referencedColumnName = "codPla")
    @ManyToOne(optional = false)
    private Plato platocodPla;

    public Pedido() {
    }

    public Pedido(Integer codigoPe) {
        this.codigoPe = codigoPe;
    }

    public Pedido(Integer codigoPe, boolean despachoPe, int totalPe, Date fechaHoraPe) {
        this.codigoPe = codigoPe;
        this.despachoPe = despachoPe;
        this.totalPe = totalPe;
        this.fechaHoraPe = fechaHoraPe;
    }

    public Integer getCodigoPe() {
        return codigoPe;
    }

    public void setCodigoPe(Integer codigoPe) {
        this.codigoPe = codigoPe;
    }

    public boolean getDespachoPe() {
        return despachoPe;
    }

    public void setDespachoPe(boolean despachoPe) {
        this.despachoPe = despachoPe;
    }

    public int getTotalPe() {
        return totalPe;
    }

    public void setTotalPe(int totalPe) {
        this.totalPe = totalPe;
    }

    public Date getFechaHoraPe() {
        return fechaHoraPe;
    }

    public void setFechaHoraPe(Date fechaHoraPe) {
        this.fechaHoraPe = fechaHoraPe;
    }

    public Bebida getBebidacodBe() {
        return bebidacodBe;
    }

    public void setBebidacodBe(Bebida bebidacodBe) {
        this.bebidacodBe = bebidacodBe;
    }

    public Cliente getClienterutCli() {
        return clienterutCli;
    }

    public void setClienterutCli(Cliente clienterutCli) {
        this.clienterutCli = clienterutCli;
    }

    public Plato getPlatocodPla() {
        return platocodPla;
    }

    public void setPlatocodPla(Plato platocodPla) {
        this.platocodPla = platocodPla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPe != null ? codigoPe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.codigoPe == null && other.codigoPe != null) || (this.codigoPe != null && !this.codigoPe.equals(other.codigoPe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Pedido[ codigoPe=" + codigoPe + " ]";
    }
    
}

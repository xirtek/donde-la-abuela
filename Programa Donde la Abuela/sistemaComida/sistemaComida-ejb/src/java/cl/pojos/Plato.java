/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xirtek
 */
@Entity
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findByCodPla", query = "SELECT p FROM Plato p WHERE p.codPla = :codPla"),
    @NamedQuery(name = "Plato.findByNombrePla", query = "SELECT p FROM Plato p WHERE p.nombrePla = :nombrePla"),
    @NamedQuery(name = "Plato.findByPrecioPla", query = "SELECT p FROM Plato p WHERE p.precioPla = :precioPla")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codPla")
    private Integer codPla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombrePla")
    private String nombrePla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioPla")
    private int precioPla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platocodPla")
    private List<Pedido> pedidoList;

    public Plato() {
    }

    public Plato(Integer codPla) {
        this.codPla = codPla;
    }

    public Plato(Integer codPla, String nombrePla, int precioPla) {
        this.codPla = codPla;
        this.nombrePla = nombrePla;
        this.precioPla = precioPla;
    }

    public Integer getCodPla() {
        return codPla;
    }

    public void setCodPla(Integer codPla) {
        this.codPla = codPla;
    }

    public String getNombrePla() {
        return nombrePla;
    }

    public void setNombrePla(String nombrePla) {
        this.nombrePla = nombrePla;
    }

    public int getPrecioPla() {
        return precioPla;
    }

    public void setPrecioPla(int precioPla) {
        this.precioPla = precioPla;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPla != null ? codPla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.codPla == null && other.codPla != null) || (this.codPla != null && !this.codPla.equals(other.codPla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Plato[ codPla=" + codPla + " ]";
    }
    
}

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
@Table(name = "bebida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bebida.findAll", query = "SELECT b FROM Bebida b"),
    @NamedQuery(name = "Bebida.findByCodBe", query = "SELECT b FROM Bebida b WHERE b.codBe = :codBe"),
    @NamedQuery(name = "Bebida.findByNombreBe", query = "SELECT b FROM Bebida b WHERE b.nombreBe = :nombreBe"),
    @NamedQuery(name = "Bebida.findByPrecioBe", query = "SELECT b FROM Bebida b WHERE b.precioBe = :precioBe")})
public class Bebida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codBe")
    private Integer codBe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreBe")
    private String nombreBe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioBe")
    private int precioBe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bebidacodBe")
    private List<Pedido> pedidoList;

    public Bebida() {
    }

    public Bebida(Integer codBe) {
        this.codBe = codBe;
    }

    public Bebida(Integer codBe, String nombreBe, int precioBe) {
        this.codBe = codBe;
        this.nombreBe = nombreBe;
        this.precioBe = precioBe;
    }

    public Integer getCodBe() {
        return codBe;
    }

    public void setCodBe(Integer codBe) {
        this.codBe = codBe;
    }

    public String getNombreBe() {
        return nombreBe;
    }

    public void setNombreBe(String nombreBe) {
        this.nombreBe = nombreBe;
    }

    public int getPrecioBe() {
        return precioBe;
    }

    public void setPrecioBe(int precioBe) {
        this.precioBe = precioBe;
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
        hash += (codBe != null ? codBe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bebida)) {
            return false;
        }
        Bebida other = (Bebida) object;
        if ((this.codBe == null && other.codBe != null) || (this.codBe != null && !this.codBe.equals(other.codBe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Bebida[ codBe=" + codBe + " ]";
    }
    
}

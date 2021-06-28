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
@Table(name = "comuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c"),
    @NamedQuery(name = "Comuna.findByCodComuna", query = "SELECT c FROM Comuna c WHERE c.codComuna = :codComuna"),
    @NamedQuery(name = "Comuna.findByNombreCom", query = "SELECT c FROM Comuna c WHERE c.nombreCom = :nombreCom")})
public class Comuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codComuna")
    private Integer codComuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreCom")
    private String nombreCom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunacodComuna")
    private List<Cliente> clienteList;

    public Comuna() {
    }

    public Comuna(Integer codComuna) {
        this.codComuna = codComuna;
    }

    public Comuna(Integer codComuna, String nombreCom) {
        this.codComuna = codComuna;
        this.nombreCom = nombreCom;
    }

    public Integer getCodComuna() {
        return codComuna;
    }

    public void setCodComuna(Integer codComuna) {
        this.codComuna = codComuna;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComuna != null ? codComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.codComuna == null && other.codComuna != null) || (this.codComuna != null && !this.codComuna.equals(other.codComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Comuna[ codComuna=" + codComuna + " ]";
    }
    
}

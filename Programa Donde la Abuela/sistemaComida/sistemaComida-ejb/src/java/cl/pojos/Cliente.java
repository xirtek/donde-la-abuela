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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByRutCli", query = "SELECT c FROM Cliente c WHERE c.rutCli = :rutCli"),
    @NamedQuery(name = "Cliente.findByClaveCli", query = "SELECT c FROM Cliente c WHERE c.claveCli = :claveCli"),
    @NamedQuery(name = "Cliente.findByNombreCli", query = "SELECT c FROM Cliente c WHERE c.nombreCli = :nombreCli"),
    @NamedQuery(name = "Cliente.findByApellidoPaternoCli", query = "SELECT c FROM Cliente c WHERE c.apellidoPaternoCli = :apellidoPaternoCli"),
    @NamedQuery(name = "Cliente.findByApellidoMaternoCli", query = "SELECT c FROM Cliente c WHERE c.apellidoMaternoCli = :apellidoMaternoCli"),
    @NamedQuery(name = "Cliente.findByDireccionCli", query = "SELECT c FROM Cliente c WHERE c.direccionCli = :direccionCli"),
    @NamedQuery(name = "Cliente.findByNumeracionCli", query = "SELECT c FROM Cliente c WHERE c.numeracionCli = :numeracionCli"),
    @NamedQuery(name = "Cliente.findByTelefonoCli", query = "SELECT c FROM Cliente c WHERE c.telefonoCli = :telefonoCli")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rutCli")
    private String rutCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "claveCli")
    private String claveCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreCli")
    private String nombreCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellidoPaternoCli")
    private String apellidoPaternoCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellidoMaternoCli")
    private String apellidoMaternoCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "direccionCli")
    private String direccionCli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeracionCli")
    private int numeracionCli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonoCli")
    private int telefonoCli;
    @JoinColumn(name = "comuna_codComuna", referencedColumnName = "codComuna")
    @ManyToOne(optional = false)
    private Comuna comunacodComuna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienterutCli")
    private List<Pedido> pedidoList;

    public Cliente() {
    }

    public Cliente(String rutCli) {
        this.rutCli = rutCli;
    }

    public Cliente(String rutCli, String claveCli, String nombreCli, String apellidoPaternoCli, String apellidoMaternoCli, String direccionCli, int numeracionCli, int telefonoCli) {
        this.rutCli = rutCli;
        this.claveCli = claveCli;
        this.nombreCli = nombreCli;
        this.apellidoPaternoCli = apellidoPaternoCli;
        this.apellidoMaternoCli = apellidoMaternoCli;
        this.direccionCli = direccionCli;
        this.numeracionCli = numeracionCli;
        this.telefonoCli = telefonoCli;
    }

    public String getRutCli() {
        return rutCli;
    }

    public void setRutCli(String rutCli) {
        this.rutCli = rutCli;
    }

    public String getClaveCli() {
        return claveCli;
    }

    public void setClaveCli(String claveCli) {
        this.claveCli = claveCli;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApellidoPaternoCli() {
        return apellidoPaternoCli;
    }

    public void setApellidoPaternoCli(String apellidoPaternoCli) {
        this.apellidoPaternoCli = apellidoPaternoCli;
    }

    public String getApellidoMaternoCli() {
        return apellidoMaternoCli;
    }

    public void setApellidoMaternoCli(String apellidoMaternoCli) {
        this.apellidoMaternoCli = apellidoMaternoCli;
    }

    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    public int getNumeracionCli() {
        return numeracionCli;
    }

    public void setNumeracionCli(int numeracionCli) {
        this.numeracionCli = numeracionCli;
    }

    public int getTelefonoCli() {
        return telefonoCli;
    }

    public void setTelefonoCli(int telefonoCli) {
        this.telefonoCli = telefonoCli;
    }

    public Comuna getComunacodComuna() {
        return comunacodComuna;
    }

    public void setComunacodComuna(Comuna comunacodComuna) {
        this.comunacodComuna = comunacodComuna;
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
        hash += (rutCli != null ? rutCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rutCli == null && other.rutCli != null) || (this.rutCli != null && !this.rutCli.equals(other.rutCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Cliente[ rutCli=" + rutCli + " ]";
    }
    
}

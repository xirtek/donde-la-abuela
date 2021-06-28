/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Cliente;
import cl.pojos.Comuna;
import cl.services.ClienteFacadeLocal;
import cl.services.ComunaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author xirtek
 */
@Named(value = "clienteBean")
@RequestScoped
//@SessionScoped
public class ClienteBean implements Serializable{

    /**
     * Creates a new instance of ClienteBean
     */
    @EJB
    private ComunaFacadeLocal comunaFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    private String rutCli;
    private String claveCli;
    private String nombreCli;
    private String apellidoPaternoCli;
    private String apellidoMaternoCli;
    private String direccionCli;
    private int numeracionCli;
    private int telefonoCli;

    private Cliente cliente;
    private Comuna comuna;

    public ClienteBean() {
        cliente = new Cliente();
        comuna = new Comuna();
    }

    public List<Cliente> getClientes() {
        return clienteFacade.findAll();
    }

    public String registrar() {

        Cliente cli = new Cliente();

        cli.setRutCli(rutCli);
        cli.setClaveCli(claveCli);
        cli.setNombreCli(nombreCli);
        cli.setApellidoPaternoCli(apellidoPaternoCli);
        cli.setApellidoMaternoCli(apellidoMaternoCli);
        cli.setDireccionCli(direccionCli);
        cli.setNumeracionCli(numeracionCli);
        cli.setTelefonoCli(telefonoCli);

        cli.setComunacodComuna(comunaFacade.find(comuna.getCodComuna()));

        clienteFacade.create(cli);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CLIENTE REGISTRADO"));

        return "index";
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
}

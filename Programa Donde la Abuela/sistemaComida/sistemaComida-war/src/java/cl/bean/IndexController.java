/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;


import cl.pojos.Cliente;
import cl.services.ClienteFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;

/**
 *
 * @author xirtek
 */
@Named
@SessionScoped
//@ViewScoped //varía al hacerse import view o bean
public class IndexController implements Serializable {

    @EJB
    private ClienteFacadeLocal EJBCliente;
    private Cliente cliente;
    private PedidoBean peBean;



    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String iniciarSesion() {
        Cliente cli;
        String redireccion = null;
        try {
            cli = EJBCliente.iniciarSesion(cliente);
            if (cli != null) {
                //Almacenar en sesión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cli);
                redireccion = "menuCliente";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Rut o contraseña erróneas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        return redireccion;
    }

    public String usuarioConectado() {
        Cliente c;
        String conectado = null;

        c = EJBCliente.iniciarSesion(cliente);
        conectado = c.getNombreCli() + " " + c.getApellidoPaternoCli() + " " + c.getApellidoMaternoCli();
        return conectado;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }

    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Cliente cl = (Cliente) context.getExternalContext().getSessionMap().get("cliente");

            if (cl == null) {
                context.getExternalContext().redirect("login.xhtml");
            }
        } catch (Exception e) {
            //caso de error
        }
    }
    
 



}

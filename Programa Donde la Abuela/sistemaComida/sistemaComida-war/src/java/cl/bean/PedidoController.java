/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Bebida;
import cl.pojos.Cliente;
import cl.pojos.Pedido;
import cl.pojos.Plato;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author xirtek
 */
@Named
//@ViewScoped
@RequestScoped
public class PedidoController implements  Serializable{
    
    @Inject
    private PedidoBean pedBean;
    private Pedido pedido;
    private Bebida bebida;
    private Plato plato;

    
    @PostConstruct
    public void Init(){
        pedido = pedBean.getPedido();
        bebida = pedBean.getBebida();
        plato = pedBean.getPlato();

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    
    //funciona al ser llamado en la ventana confirmarPedido
    public String esDespacho() {
        String resul = null;

        if (pedido.getDespachoPe() == true) {
            resul = "Sí";
        } else {
            resul = "No";
        }

        return resul;
    }
    
    public int calcularTotal(){
        int tot=0;
        
        tot = plato.getPrecioPla() + bebida.getPrecioBe();
        
        return tot;
    }
    
    public String obtenerNombrePlato(){
        String nombre = null;
        
        nombre = plato.getNombrePla();
        
        return nombre;
    }
            
    
    
    

}

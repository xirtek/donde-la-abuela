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
import cl.services.BebidaFacadeLocal;
import cl.services.ClienteFacadeLocal;
import cl.services.PedidoFacadeLocal;
import cl.services.PlatoFacadeLocal;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;

/**
 *
 * @author xirtek
 */
@Named(value = "pedidoBean")
@RequestScoped
//@SessionScoped
public class PedidoBean implements Serializable {

    /**
     * Creates a new instance of PedidoBean
     */
    @EJB
    private PlatoFacadeLocal platoFacade;

    @EJB
    private BebidaFacadeLocal bebidaFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private PedidoFacadeLocal pedidoFacade;

    private int codigoPed;
    private boolean despachoPe;
    private int totalPe;
    private Date fechaHoraPe;

    private Cliente cliente;
    private Plato plato;
    private Bebida bebida;
    private Pedido pedido;

    //variable local
    private int cont = 2;
    private boolean estadoPedido = false;

    @PostConstruct
    public void init() {
        pedidoFacade.findAll();
    }

    public PedidoBean() {
        cliente = new Cliente();
        plato = new Plato();
        bebida = new Bebida();
        pedido = new Pedido();
    }

    public List<Pedido> getPedidos() { //mostrar todos los datos
        return pedidoFacade.findAll();
    }

    //método para pedidos por usuario
    public List<Pedido> getPedidosDeUsuario() {
        Cliente clPe = new Cliente();
        List<Pedido> listaUsuarioPe = null;
        
        clPe = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");

        //
        String rutCl = clPe.getRutCli();

        for (Pedido pedido1 : pedidoFacade.findAll()) {

            //String rutPe1 = pedido1.getClienterutCli().getRutCli();

            //if((rutPe1.compareToIgnoreCase(rutCl)) == 0){
            //if (pedido1.getClienterutCli() == (clPe)) {
            //listaUsuarioPe.add(pedidoFacade.find(pedido1.getCodigoPe()));
            //listaUsuarioPe.add(pedido1);
            listaUsuarioPe.add(pedido1);
            //}
        }

        return listaUsuarioPe;
    }

    public int getCodigoPed() {
        return codigoPed;
    }

    public void setCodigoPed(int codigoPed) {
        this.codigoPed = codigoPed;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoFacadeLocal getPedidoFacade() {
        return pedidoFacade;
    }

    public void setPedidoFacade(PedidoFacadeLocal pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
    }

    //método ventana paso 1
    public String prepararPedido() {
        Pedido ped2 = new Pedido();

        
        Cliente cl = new Cliente();
        
        int largopl = platoFacade.findAll().size();
        Plato pl = platoFacade.find(largopl);
        
        int largobeb = bebidaFacade.findAll().size();
        Bebida beb = bebidaFacade.find(largobeb);

        Date dNow = new Date();

        int preBe = 0;
        int prePla = 0;


        prePla = pl.getPrecioPla();
        preBe = beb.getPrecioBe();

        cl = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");

        ped2.setBebidacodBe(bebidaFacade.find(beb.getCodBe()));
        ped2.setClienterutCli(clienteFacade.find(cl.getRutCli()));
        
        
        ped2.setCodigoPe(codigoPed);
        ped2.setDespachoPe(true);
        ped2.setFechaHoraPe(dNow); // Devuelve el objeto Date con los nuevos días añadidos
        ped2.setPlatocodPla(platoFacade.find(pl.getCodPla()));
        ped2.setTotalPe(prePla + preBe);

        pedidoFacade.create(ped2);

        return "prepararPedido";

    }

    //método ventana paso 2
    public String generarPedido() {
        
        int largo = pedidoFacade.findAll().size();
        Pedido ped3 = pedidoFacade.find(largo);

        Plato pl = new Plato();
        Bebida beb = new Bebida();
        Cliente cl = new Cliente();

        Date dNow = new Date();

        int preBe = 0;
        int prePla = 0;

        pl = platoFacade.find(plato.getCodPla());
        beb = bebidaFacade.find(bebida.getCodBe());

        prePla = pl.getPrecioPla();
        preBe = beb.getPrecioBe();

        cl = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");

        ped3.setBebidacodBe(bebidaFacade.find(bebida.getCodBe()));
        ped3.setClienterutCli(clienteFacade.find(cl.getRutCli()));
        //ped2.setCodigoPe(codigoPed);
        ped3.setDespachoPe(pedido.getDespachoPe());
        ped3.setFechaHoraPe(dNow); // Devuelve el objeto Date con los nuevos días añadidos
        ped3.setPlatocodPla(platoFacade.find(plato.getCodPla()));
        ped3.setTotalPe(prePla + preBe);

        pedidoFacade.edit(ped3);
        
        return "confirmarPedido";
    }
   
    public String confirmarPedido(){
        return "desplegarPedido";
    }

    public String tipoDespacho(Pedido pe) {
        String retiro = null;

        if (pe.getDespachoPe() == true) {
            retiro = pe.getClienterutCli().getDireccionCli() + " #" + pe.getClienterutCli().getNumeracionCli();
        } else {
            retiro = "Retiro en Tienda";
        }
        return retiro;
    }

    public Date horaArreglada(Pedido pe) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(pe.getFechaHoraPe()); // Configuramos la fecha que se recibe
        calendar.add(Calendar.HOUR, -4);  // número de horas a restar
        return (calendar.getTime());
    }

    public String retornarNombrePlato() {
        String nom = null;
        int largo = pedidoFacade.findAll().size();
        Pedido pe = pedidoFacade.find(largo);
        nom = pe.getPlatocodPla().getNombrePla();
        return nom;
    }

    public int retornarPrecioPlato() {
        int prec = 0;
        int largo = pedidoFacade.findAll().size();
        Pedido pe = pedidoFacade.find(largo);
        prec = pe.getPlatocodPla().getPrecioPla();
        return prec;
    }

    public String retornarNombreBebida() {
        String nom = null;
        int largo = pedidoFacade.findAll().size();
        Pedido pe = pedidoFacade.find(largo);
        nom = pe.getBebidacodBe().getNombreBe();
        return nom;
    }

    public int retornarPrecioBebida() {
        int prec = 0;
        int largo = pedidoFacade.findAll().size();
        Pedido pe = pedidoFacade.find(largo);
        prec = pe.getBebidacodBe().getPrecioBe();
        return prec;
    }

    public int retornarTotalPlatoBebida() {
        int tot = 0;
        int largo = pedidoFacade.findAll().size();
        Pedido pe = pedidoFacade.find(largo);
        tot = pe.getTotalPe();
        return tot;
    }

    public String retornarEsDespachoPedido() {
        String resul = null;
        int largo = pedidoFacade.findAll().size();
        Pedido pe = pedidoFacade.find(largo);

        if (pe.getDespachoPe() == true) {
            resul = "Sí";
        } else {
            resul = "No";
        }

        return resul;
    }
    
    public Cliente filtrarCliente(Pedido ped){
        Cliente cl = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        return cl;
    }

}

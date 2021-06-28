/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Plato;
import cl.services.PlatoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author xirtek
 */
@Named(value = "platoBean")
@RequestScoped
//@SessionScoped
public class PlatoBean implements Serializable{

    /**
     * Creates a new instance of PlatoBean
     */
    @EJB
    private PlatoFacadeLocal platoFacade;
    
    private int codPla;
    private String nombrePla;
    private int precioPla;
    
    private Plato plato;

    private List<Plato> listPlato;
    
    @PostConstruct
    public void init(){
        listPlato = platoFacade.findAll();
    } 
    
    public PlatoBean() {
        plato = new Plato();
    }
    
    private List<Plato> getPlatos(){
        return platoFacade.findAll();
    }

    public int getCodPla() {
        return codPla;
    }

    public void setCodPla(int codPla) {
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
    

    public List<Plato> getListPlato() {
        return listPlato;
    }

    public void setListPlato(List<Plato> listPlato) {
        this.listPlato = listPlato;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
    
    
    //para llenar el label del cbo de forma manual
    public String verNombrePlato(int cod){
        String nombreRequerido=null;
        Plato pl = new Plato();
        
        pl = platoFacade.find(cod);
        
        nombreRequerido = pl.getNombrePla() + " - $ " + pl.getPrecioPla();
        
        return nombreRequerido;
    }
    
    
    
    
    
    
}

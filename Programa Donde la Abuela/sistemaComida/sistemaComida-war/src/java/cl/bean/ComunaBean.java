/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Comuna;
import cl.services.ComunaFacadeLocal;
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
@Named(value = "comunaBean")
@RequestScoped
//@SessionScoped
public class ComunaBean implements Serializable{

    /**
     * Creates a new instance of ComunaBean
     */
    @EJB
    private ComunaFacadeLocal comunaFacade;
    
    private int codComuna;
    private String nombreCom;
    
    private Comuna comuna;
    
    private List<Comuna> listComuna;

    @PostConstruct
    public void init(){
        listComuna = comunaFacade.findAll();
        
    } 
    
    public ComunaBean() {
        comuna = new Comuna();
    }
    
    public List<Comuna> getComunas(){
        return comunaFacade.findAll();
    }
    

    public int getCodComuna() {
        return codComuna;
    }

    public void setCodComuna(int codComuna) {
        this.codComuna = codComuna;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public List<Comuna> getListComuna() {
        return listComuna;
    }

    public void setListComuna(List<Comuna> listComuna) {
        this.listComuna = listComuna;
    }
    
}

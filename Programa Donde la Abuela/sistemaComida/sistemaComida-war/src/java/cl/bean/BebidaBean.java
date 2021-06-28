/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Bebida;
import cl.services.BebidaFacadeLocal;
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
@Named(value = "bebidaBean")
@RequestScoped
//@SessionScoped
public class BebidaBean implements Serializable{

    /**
     * Creates a new instance of BebidaBean
     */
    @EJB
    private BebidaFacadeLocal bebidaFacade;
    
    private int codBe;
    private String nombreBe;
    private String precioBe;

    private Bebida bebida;
    
    private List<Bebida> listBebida;
    
    @PostConstruct
    public void init(){
        listBebida = bebidaFacade.findAll();
    } 
    
    public BebidaBean() {
        bebida = new Bebida();
    }
    
    
    public List<Bebida> getBebidas(){
        return bebidaFacade.findAll();
    }

    public int getCodBe() {
        return codBe;
    }

    public void setCodBe(int codBe) {
        this.codBe = codBe;
    }

    public String getNombreBe() {
        return nombreBe;
    }

    public void setNombreBe(String nombreBe) {
        this.nombreBe = nombreBe;
    }

    public String getPrecioBe() {
        return precioBe;
    }

    public void setPrecioBe(String precioBe) {
        this.precioBe = precioBe;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public List<Bebida> getListBebida() {
        return listBebida;
    }

    public void setListBebida(List<Bebida> listBebida) {
        this.listBebida = listBebida;
    }
    
    
    
}

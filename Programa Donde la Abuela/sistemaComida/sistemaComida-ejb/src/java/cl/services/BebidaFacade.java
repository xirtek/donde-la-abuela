/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Bebida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xirtek
 */
@Stateless
public class BebidaFacade extends AbstractFacade<Bebida> implements BebidaFacadeLocal {

    @PersistenceContext(unitName = "sistemaComida-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BebidaFacade() {
        super(Bebida.class);
    }
    
}

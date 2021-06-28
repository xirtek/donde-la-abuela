/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author xirtek
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "sistemaComida-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    @Override
    public Cliente iniciarSesion(Cliente cl){
        Cliente cliente = null;
        String consulta;
        try{
            consulta = "FROM Cliente u WHERE u.rutCli = ?1 and u.claveCli = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cl.getRutCli());
            query.setParameter(2, cl.getClaveCli());
            
            List<Cliente> lista = query.getResultList();
            if(!lista.isEmpty()){
                cliente = lista.get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return cliente;
    }
    
}

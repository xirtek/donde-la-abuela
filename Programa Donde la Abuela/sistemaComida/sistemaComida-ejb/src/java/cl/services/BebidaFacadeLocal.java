/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Bebida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xirtek
 */
@Local
public interface BebidaFacadeLocal {

    void create(Bebida bebida);

    void edit(Bebida bebida);

    void remove(Bebida bebida);

    Bebida find(Object id);

    List<Bebida> findAll();

    List<Bebida> findRange(int[] range);

    int count();
    
}

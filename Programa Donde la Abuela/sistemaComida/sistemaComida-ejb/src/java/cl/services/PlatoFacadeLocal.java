/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Plato;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xirtek
 */
@Local
public interface PlatoFacadeLocal {

    void create(Plato plato);

    void edit(Plato plato);

    void remove(Plato plato);

    Plato find(Object id);

    List<Plato> findAll();

    List<Plato> findRange(int[] range);

    int count();
    
}

package cl.pojos;

import cl.pojos.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-13T17:58:30")
@StaticMetamodel(Plato.class)
public class Plato_ { 

    public static volatile SingularAttribute<Plato, Integer> codPla;
    public static volatile SingularAttribute<Plato, Integer> precioPla;
    public static volatile ListAttribute<Plato, Pedido> pedidoList;
    public static volatile SingularAttribute<Plato, String> nombrePla;

}
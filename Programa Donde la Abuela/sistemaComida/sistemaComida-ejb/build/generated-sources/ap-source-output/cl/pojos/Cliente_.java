package cl.pojos;

import cl.pojos.Comuna;
import cl.pojos.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-13T17:58:30")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> claveCli;
    public static volatile SingularAttribute<Cliente, String> rutCli;
    public static volatile SingularAttribute<Cliente, String> nombreCli;
    public static volatile SingularAttribute<Cliente, String> apellidoPaternoCli;
    public static volatile ListAttribute<Cliente, Pedido> pedidoList;
    public static volatile SingularAttribute<Cliente, Integer> numeracionCli;
    public static volatile SingularAttribute<Cliente, Integer> telefonoCli;
    public static volatile SingularAttribute<Cliente, Comuna> comunacodComuna;
    public static volatile SingularAttribute<Cliente, String> apellidoMaternoCli;
    public static volatile SingularAttribute<Cliente, String> direccionCli;

}
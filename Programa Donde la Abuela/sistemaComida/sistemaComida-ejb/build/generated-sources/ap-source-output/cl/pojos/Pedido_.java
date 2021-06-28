package cl.pojos;

import cl.pojos.Bebida;
import cl.pojos.Cliente;
import cl.pojos.Plato;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-13T17:58:30")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Cliente> clienterutCli;
    public static volatile SingularAttribute<Pedido, Plato> platocodPla;
    public static volatile SingularAttribute<Pedido, Integer> totalPe;
    public static volatile SingularAttribute<Pedido, Bebida> bebidacodBe;
    public static volatile SingularAttribute<Pedido, Boolean> despachoPe;
    public static volatile SingularAttribute<Pedido, Integer> codigoPe;
    public static volatile SingularAttribute<Pedido, Date> fechaHoraPe;

}
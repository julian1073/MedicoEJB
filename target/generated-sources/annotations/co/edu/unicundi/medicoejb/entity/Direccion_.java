package co.edu.unicundi.medicoejb.entity;

import co.edu.unicundi.medicoejb.entity.Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-25T20:35:38")
@StaticMetamodel(Direccion.class)
public class Direccion_ { 

    public static volatile SingularAttribute<Direccion, String> barrio;
    public static volatile SingularAttribute<Direccion, String> codigoPostal;
    public static volatile SingularAttribute<Direccion, String> direccionDetallada;
    public static volatile SingularAttribute<Direccion, Medico> medico;
    public static volatile SingularAttribute<Direccion, Integer> id;

}
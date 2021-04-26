package co.edu.unicundi.medicoejb.entity;

import co.edu.unicundi.medicoejb.entity.Consulta;
import co.edu.unicundi.medicoejb.entity.Direccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-25T20:35:38")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> apellido;
    public static volatile SingularAttribute<Medico, String> correo;
    public static volatile SingularAttribute<Medico, Direccion> direccion;
    public static volatile SingularAttribute<Medico, Integer> id;
    public static volatile SingularAttribute<Medico, String> nombre;
    public static volatile ListAttribute<Medico, Consulta> consulta;

}
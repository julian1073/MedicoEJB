package co.edu.unicundi.medicoejb.entity;

import co.edu.unicundi.medicoejb.entity.Consulta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-25T20:35:38")
@StaticMetamodel(DetalleConsulta.class)
public class DetalleConsulta_ { 

    public static volatile SingularAttribute<DetalleConsulta, String> diagnostico;
    public static volatile SingularAttribute<DetalleConsulta, Integer> id;
    public static volatile SingularAttribute<DetalleConsulta, Consulta> consulta;
    public static volatile SingularAttribute<DetalleConsulta, String> tratamiento;

}
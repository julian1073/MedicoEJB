/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.repositorio;

import co.edu.unicundi.medicoejb.entity.DetalleConsulta;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IDetalleConsultaRepo {
    
    void create(DetalleConsulta consulta);

    void edit(DetalleConsulta detalleConsulta);

    void remove(DetalleConsulta detalleConsulta);

    DetalleConsulta find(Object id);

    List<DetalleConsulta> findAll();
}

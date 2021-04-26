/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.repositorio;

import co.edu.unicundi.medicoejb.entity.Consulta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian
 */
@Local
public interface IConsultaRepo {
    
    void create(Consulta consulta);

    void edit(Consulta consulta);

    void remove(Consulta consulta);

    Consulta find(Object id);

    List<Consulta> findAll();
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.repositorio;

import co.edu.unicundi.medicoejb.entity.Medico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian
 */
@Local
public interface IMedicoRepo {
    
    public void create(Medico medico);

    public void edit(Medico medico);

    public void remove(Medico medico);

    public Medico find(Object id);

    public List<Medico> findAll();
    
    public Medico findByEmail(String correo);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.interfaz;

import co.edu.unicundi.medicoejb.entity.Medico;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian
 */
@Local
public interface IMedicoService {
    
    /**
     * Método para listar medicos
     * @return List
     */
    public List<Medico> getListaMedicos();

    /**
     * Método para agregar medico en la tabla de base de datos
     * @param medico
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     */
    public void agregarMedico(Medico medico) throws IntegridadException;

    /**
     * Busqueda de medico por id
     * @param id
     * @return Medico
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     */
    public Medico buscarMedico(Integer id) throws ModelNotFoundException;
    
    /**
     * Busqueda de medico por Email
     * @param correo
     * @return Medico
     * @throws ModelNotFoundException 
     */
    public Medico buscarMedicoPorEmail(String correo) throws ModelNotFoundException;
    
    /**
     * Método para editar un registro de la tabla medico
     * @param medico
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     */
    public void editarMedico(Medico medico) throws ModelNotFoundException, IntegridadException; 
    /**
     * Método para eliminar un medico de la tabla
     * @param id
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     */
    public void eliminarMedico(Integer id) throws ModelNotFoundException;
}

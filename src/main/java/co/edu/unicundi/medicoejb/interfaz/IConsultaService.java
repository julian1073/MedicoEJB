/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.interfaz;

import co.edu.unicundi.medicoejb.entity.Consulta;
import co.edu.unicundi.medicoejb.exception.EmptyModelException;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian
 */
@Local
public interface IConsultaService {
    
    /**
     * Método para listar consultas
     * @return List
     */
    public List<Consulta> getListaConsultas();

    /**
     * Método para agregar medico en la tabla de base de datos
     * @param consulta
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public void agregarConsulta(Consulta consulta) throws IntegridadException, EmptyModelException;

    /**
     * Busqueda de medico por id
     * @param id
     * @return Medico
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public Consulta buscarConsulta(Integer id) throws ModelNotFoundException, EmptyModelException;
    
    /**
     * Método para editar un registro de la tabla medico
     * @param consulta
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public void editarConsulta(Consulta consulta) throws ModelNotFoundException, IntegridadException, EmptyModelException; 
    /**
     * Método para eliminar un medico de la tabla
     * @param id
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public void eliminarConsulta(Integer id) throws ModelNotFoundException, EmptyModelException;
}

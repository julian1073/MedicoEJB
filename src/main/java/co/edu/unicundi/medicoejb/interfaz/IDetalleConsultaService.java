/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.interfaz;

import co.edu.unicundi.medicoejb.entity.DetalleConsulta;
import co.edu.unicundi.medicoejb.exception.EmptyModelException;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import java.util.List;

/**
 *
 * @author Julian
 */
public interface IDetalleConsultaService {
    
    /**
     * Método para listar detalleConsultas
     * @return List
     */
    public List<DetalleConsulta> getListaDetalleConsultas();

    /**
     * Método para agregar detalleConsulta en la tabla de base de datos
     * @param detalleConsulta
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public void agregarDetalleConsulta(DetalleConsulta detalleConsulta) throws IntegridadException, EmptyModelException;

    /**
     * Busqueda de detalleConsulta por id
     * @param id
     * @return DetalleConsulta
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public DetalleConsulta buscarDetalleConsulta(Integer id) throws ModelNotFoundException, EmptyModelException;
    
    /**
     * Método para editar un registro de la tabla detalleConsulta
     * @param detalleConsulta
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.IntegridadException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public void editarDetalleConsulta(DetalleConsulta detalleConsulta) throws ModelNotFoundException, IntegridadException, EmptyModelException; 
    /**
     * Método para eliminar un detalleConsulta de la tabla
     * @param id
     * @throws co.edu.unicundi.medicoejb.exception.ModelNotFoundException
     * @throws co.edu.unicundi.medicoejb.exception.EmptyModelException
     */
    public void eliminarDetalleConsulta(Integer id) throws ModelNotFoundException, EmptyModelException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.service;

import co.edu.unicundi.medicoejb.entity.Consulta;
import co.edu.unicundi.medicoejb.entity.DetalleConsulta;
import co.edu.unicundi.medicoejb.exception.EmptyModelException;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import co.edu.unicundi.medicoejb.interfaz.IDetalleConsultaService;
import co.edu.unicundi.medicoejb.repositorio.IConsultaRepo;
import co.edu.unicundi.medicoejb.repositorio.IDetalleConsultaRepo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Julian
 */
@Stateless
public class DetalleConsultaService implements IDetalleConsultaService{
    
    @EJB
    IDetalleConsultaRepo detalleRepo;
    
    @EJB
    IConsultaRepo consultaRepo;
    
    @Override
    public List<DetalleConsulta> getListaDetalleConsultas() {

        return detalleRepo.findAll();
    }

    @Override
    public void agregarDetalleConsulta(DetalleConsulta detalleConsulta) throws IntegridadException, EmptyModelException {
    
        if (detalleConsulta.getConsulta().getId() == null) {
            
            throw new EmptyModelException("El id de la consulta no puede ser nulo");
        }
        else{
            Consulta auxConsulta = consultaRepo.find(detalleConsulta.getConsulta().getId());
            detalleConsulta.setConsulta(auxConsulta);
            detalleRepo.create(detalleConsulta);
        }
    }

    @Override
    public DetalleConsulta buscarDetalleConsulta(Integer id) throws ModelNotFoundException, EmptyModelException {
        
        if (id == null) {
            throw new EmptyModelException("La id no puede ser nula");
        }
        
        DetalleConsulta detalleConsulta = detalleRepo.find(id);

        if(detalleConsulta != null)
          return detalleConsulta;
        else 
          throw new ModelNotFoundException("Consulta no enontrada");
    }

    @Override
    public void editarDetalleConsulta(DetalleConsulta detalleConsulta) throws ModelNotFoundException, IntegridadException, EmptyModelException {
    
        DetalleConsulta detalleConsultaEntity = this.buscarDetalleConsulta(detalleConsulta.getId());

        if (detalleConsulta.getConsulta().getId() != null ) {

            Consulta nuevaConsulta = consultaRepo.find(detalleConsulta.getConsulta().getId());
            detalleConsultaEntity.setConsulta(nuevaConsulta);
        }

        detalleConsultaEntity.setDiagnostico(detalleConsulta.getDiagnostico());
        detalleConsultaEntity.setTratamiento(detalleConsulta.getTratamiento());
        
        detalleRepo.edit(detalleConsultaEntity);
    }

    @Override
    public void eliminarDetalleConsulta(Integer id) throws ModelNotFoundException, EmptyModelException {
    
        DetalleConsulta detalleConsulta = this.buscarDetalleConsulta(id);
        
        if(detalleConsulta != null)
            detalleRepo.remove(detalleConsulta);
        else 
            throw new ModelNotFoundException("Consulta no enontrada");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.service;

import co.edu.unicundi.medicoejb.entity.Consulta;
import co.edu.unicundi.medicoejb.entity.DetalleConsulta;
import co.edu.unicundi.medicoejb.entity.Medico;
import co.edu.unicundi.medicoejb.exception.EmptyModelException;
import co.edu.unicundi.medicoejb.exception.IntegridadException;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import co.edu.unicundi.medicoejb.interfaz.IConsultaService;
import co.edu.unicundi.medicoejb.repositorio.IConsultaRepo;
import co.edu.unicundi.medicoejb.repositorio.IMedicoRepo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Julian
 */
@Stateless
public class ConsultaService implements IConsultaService {
    
    @EJB
    private IConsultaRepo repo;
    
    @EJB
    private IMedicoRepo medicoRepo;
    
    @Override
    public List<Consulta> getListaConsultas() {

        return repo.findAll();
    }

    @Override
    public Consulta buscarConsulta(Integer id) throws ModelNotFoundException, EmptyModelException {
        
        if (id == null) {
            throw new EmptyModelException("La id no puede ser nula");
        }
        
        Consulta consulta = repo.find(id);

        if(consulta != null)
          return consulta;
        else 
          throw new ModelNotFoundException("Consulta no enontrada");        
    }

    @Override
    public void agregarConsulta(Consulta consulta) throws IntegridadException, EmptyModelException {
        
        if(consulta.getDetalleConsulta() != null) {
            for (DetalleConsulta dc : consulta.getDetalleConsulta()) {
                dc.setConsulta(consulta);
            }
        }
        if (consulta.getMedico().getId() == null) {
            
            throw new EmptyModelException("El id del medico no puede ser nulo");
        }
        else{
            Medico auxMedico = medicoRepo.find(consulta.getMedico().getId());
            consulta.setMedico(auxMedico);
            repo.create(consulta);
        }
    }

    @Override
    public void editarConsulta(Consulta consulta) throws ModelNotFoundException, EmptyModelException {
            
        Consulta consultaEntity = this.buscarConsulta(consulta.getId());

        if (consulta.getMedico().getId() != null ) {

            Medico nuevoMedico = medicoRepo.find(consulta.getMedico().getId());
            consultaEntity.setMedico(nuevoMedico);
        }

        consultaEntity.setFecha(consulta.getFecha());

        repo.edit(consultaEntity);
        
    }

    @Override
    public void eliminarConsulta(Integer idConsulta) throws ModelNotFoundException, EmptyModelException{
            
        Consulta consulta = repo.find(idConsulta);
        
        if(consulta != null)
            repo.remove(consulta);
        else 
            throw new ModelNotFoundException("Consulta no enontrada");
    }
}
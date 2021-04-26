/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.service;

import co.edu.unicundi.medicoejb.entity.Medico;
import co.edu.unicundi.medicoejb.exception.ModelNotFoundException;
import co.edu.unicundi.medicoejb.interfaz.IMedicoService;
import co.edu.unicundi.medicoejb.repositorio.IMedicoRepo;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Julian
 */
@Stateless
public class MedicoService implements IMedicoService{
    
    @EJB
    private IMedicoRepo repo;
    
    
    @Override
    public List<Medico> getListaMedicos() {
        
        return repo.findAll();
        
    }

    @Override
    public Medico buscarMedico(Integer id) throws ModelNotFoundException {

        Medico auxEstudiante = repo.find(id);

        if (auxEstudiante == null) {

            throw new ModelNotFoundException("No encontrado");

        } else {
            return auxEstudiante;
        }
    }

    @Override
    public void agregarMedico(Medico medico) {
        
        if (medico.getDireccion() == null) {
            
            throw new NullPointerException("La direccion no puede ser nula");
        }
        else{
            medico.getDireccion().setMedico(medico);
            repo.create(medico);
        }
    }

    @Override
    public void editarMedico(Medico medico) throws ModelNotFoundException {
        if (medico.getId() == null) {
            throw new NullPointerException("La id no puede ser nula");
        } else {
            Medico medicoEntity = this.buscarMedico(medico.getId());
            medicoEntity.setNombre(medico.getNombre());
            medicoEntity.setApellido(medico.getApellido());
            medicoEntity.setCorreo(medico.getCorreo());

            if (medico.getDireccion() != null) {
                medicoEntity.getDireccion().setBarrio(medico.getDireccion().getBarrio());
                medicoEntity.getDireccion().setCodigoPostal(medico.getDireccion().getCodigoPostal());
            }

            repo.edit(medicoEntity);
        }
    }
    
    @Override
    public void eliminarMedico(Integer idMedico) throws ModelNotFoundException {    
           Medico medico = this.buscarMedico(idMedico);
           repo.remove(medico);
    }

    @Override
    public Medico buscarMedicoPorEmail(String correo) throws ModelNotFoundException {
        
        Medico auxEstudiante = repo.findByEmail(correo);

        if (auxEstudiante == null) {

            throw new ModelNotFoundException("No encontrado");

        } else {
            return auxEstudiante;
        }
    }
}

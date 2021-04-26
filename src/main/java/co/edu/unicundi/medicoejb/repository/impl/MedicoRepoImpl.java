/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.repository.impl;

import co.edu.unicundi.medicoejb.entity.Medico;
import co.edu.unicundi.medicoejb.repositorio.IMedicoRepo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Julian
 */
@Stateless
public class MedicoRepoImpl extends GeneralFacade<Medico> implements IMedicoRepo{

    //Invoca a la unidad de persistencia
    @PersistenceContext(unitName = "MedicoPU")
    //Permite manejar las invocaciones CRUD
    private EntityManager em;

    //Sobrescritura de metodos abstractos 
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    //Constructor 
    public MedicoRepoImpl() {
        super(Medico.class);
    }
    
    @Override
    public Medico findByEmail(String correo) {
       Query query = em.createQuery("FROM Medico e WHERE e.correo =: correo");
       query.setParameter("correo", correo);
       return (Medico) query.getSingleResult();
    }
}

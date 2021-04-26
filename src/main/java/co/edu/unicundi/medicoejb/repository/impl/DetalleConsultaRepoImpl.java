/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.repository.impl;

import co.edu.unicundi.medicoejb.entity.DetalleConsulta;
import co.edu.unicundi.medicoejb.repositorio.IDetalleConsultaRepo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian
 */
@Stateless
public class DetalleConsultaRepoImpl extends GeneralFacade<DetalleConsulta> implements IDetalleConsultaRepo{
    
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
    public DetalleConsultaRepoImpl() {
        super(DetalleConsulta.class);
    }
}

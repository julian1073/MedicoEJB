/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.medicoejb.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Julian
 */
@Entity
@Table(name = "direccion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Direccion implements Serializable {
    
    @Id
    @Column(name = "medico_id")
    private Integer id;
    
    @Size(min = 2, max = 25, message = "Minimo 2 carácteres, maximo 25")
    @NotNull(message = "El campo es obligatorio")
    @Column(name = "direccion_detallada", nullable = false, length = 25)
    private String direccionDetallada;
    
    @Size(min = 2, max = 25, message = "Minimo 2 carácteres, maximo 25")
    @NotNull(message = "El campo es obligatorio")
    @Column(name = "barrio", nullable = false, length = 25)
    private String barrio;
    
    @Size(min = 2, max = 6, message = "Minimo 2 carácteres, maximo 6")
    @NotNull(message = "El campo es obligatorio")
    @Column(name = "codigo_postal", nullable = false, length = 6)
    private String codigoPostal; 
    
    @OneToOne
    @MapsId
    private Medico medico;

    public Direccion() {
    }

    public Direccion(String direccionDetallada, String barrio, String codigoPostal, Medico medico) {
        this.direccionDetallada = direccionDetallada;
        this.barrio = barrio;
        this.codigoPostal = codigoPostal;
        this.medico = medico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccionDetallada() {
        return direccionDetallada;
    }

    public void setDireccionDetallada(String direccionDetallada) {
        this.direccionDetallada = direccionDetallada;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}

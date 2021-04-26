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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Julian
 */
@Entity
@Table(name = "detalleconsulta")
@NamedQueries({
    @NamedQuery( name = "DetalleConsulta.listarTodos", query = "SELECT d FROM DetalleConsulta d")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DetalleConsulta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min = 2, max = 25, message = "Minimo 2 carácteres, maximo 25")
    @NotNull(message = "El campo es obligatorio")
    @Column(name = "diagnostico", nullable = false, length = 25)
    private String diagnostico;
    
    @Size(min = 2, max = 50, message = "Minimo 2 carácteres, maximo 50")
    @NotNull(message = "El campo es obligatorio")
    @Column(name = "tratamiento", nullable = false, length = 50)
    private String tratamiento;
    
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;

    public DetalleConsulta() {
    }

    public DetalleConsulta(Integer id, String diagnostico, String tratamiento, Consulta consulta) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.consulta = consulta;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}

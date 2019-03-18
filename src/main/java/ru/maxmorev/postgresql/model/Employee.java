package ru.maxmorev.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity(name = "employee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long departamentId;

    private Long employeeLevelId;

    private String name;

    @ManyToOne(optional=false)
    @JoinColumn(name="departamentId", referencedColumnName="id", insertable=false, updatable=false)
    private Departament departament;

    @ManyToOne(optional=false)
    @JoinColumn(name="employeeLevelId", referencedColumnName="id", insertable=false, updatable=false)
    private EmployeeLevel employeeLevel;


    public Employee(){
        super();
    }
    public Employee(String name, Long departamendId, Long employeeLevelId){
        this.name = name;
        this.departamentId = departamendId;
        this.employeeLevelId = employeeLevelId;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public EmployeeLevel getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevel employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Long departamentId) {
        this.departamentId = departamentId;
    }

    public Long getEmployeeLevelId() {
        return employeeLevelId;
    }

    public void setEmployeeLevelId(Long employeeLevelId) {
        this.employeeLevelId = employeeLevelId;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(this);
        }catch(Exception e) {

        }
        return jsonStr;
    }
}

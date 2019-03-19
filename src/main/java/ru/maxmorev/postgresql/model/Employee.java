package ru.maxmorev.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) &&
                departamentId.equals(employee.departamentId) &&
                employeeLevelId.equals(employee.employeeLevelId) &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departamentId, employeeLevelId, name);
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


    /**
     *  Gets a builder which is used to create Employee objects.
     * @param name
     * @param departamentId
     * @param employeeLevelId
     * @return
     */
    public static Builder getBuilder(String name, Long departamentId, Long employeeLevelId) {
        return new Builder(name, departamentId, employeeLevelId);
    }

    /**
     * A Builder class used to create new Employee objects.
     */
    public static class Builder {
        Employee built;

        /**
         *  Creates a new Builder instance.
         * @param name
         * @param departamentId
         * @param employeeLevelId
         */
        Builder(String name, Long departamentId, Long employeeLevelId) {
            built = new Employee();
            built.name = name;
            built.departamentId = departamentId;
            built.employeeLevelId = employeeLevelId;
        }

        /**
         * Builds the new Person object.
         * @return  The created Person object.
         */
        public Employee build() {
            return built;
        }
    }

}

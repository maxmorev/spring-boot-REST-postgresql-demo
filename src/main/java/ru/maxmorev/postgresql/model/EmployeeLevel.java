package ru.maxmorev.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "employeelevel")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeLevel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "employeeLevelId", targetEntity=Employee.class)
    @JsonIgnore
    private Set<Employee> employeeSet;


    public EmployeeLevel(){
        super();
    }
    public EmployeeLevel(String name){
        this.name = name;
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
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

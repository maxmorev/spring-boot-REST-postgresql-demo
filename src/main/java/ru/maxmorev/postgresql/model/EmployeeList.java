package ru.maxmorev.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeList {

    //information about data
    private long countOfTotalRecords; //countOfTotalRecords
    private int countOfRecords;//records on page
    private int pageSize = 4; //pageSize - records by page
    private int page = 0;
    private List<Employee> employeeList;

    public long getCountOfTotalRecords() {
        return countOfTotalRecords;
    }

    public void setCountOfTotalRecords(long countOfTotalRecords) {
        this.countOfTotalRecords = countOfTotalRecords;
    }

    public int getCountOfRecords() {
        return countOfRecords;
    }

    public void setCountOfRecords(int countOfRecords) {
        this.countOfRecords = countOfRecords;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

package ru.maxmorev.postgresql.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maxmorev.postgresql.model.Employee;
import ru.maxmorev.postgresql.model.EmployeeList;
import ru.maxmorev.postgresql.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/employeeList/")
    public EmployeeList employeeList(
            @RequestParam(value="page", required = false) Optional<Integer> page,
            @RequestParam(value="departamentId", required = false) Optional<Integer> departamentId
            )
    {
        EmployeeList employeeList = new EmployeeList();
        Integer pageNumber = employeeList.getPage();
        employeeList.setPageSize(3);
        if(page.isPresent()){
            pageNumber = page.get();
            employeeList.setPage(pageNumber);
        }
        Iterable<Employee> employeeSet;
        if(departamentId.isPresent()){
            long departId = departamentId.get();
            employeeList.setCountOfTotalRecords(employeeRepository.countByDepartamentId(departId));
            employeeSet = employeeRepository.findByDepartamentId(departId, new PageRequest(employeeList.getPage(), employeeList.getPageSize(), Sort.Direction.ASC, "name"));
        }else{
            employeeList.setCountOfTotalRecords(employeeRepository.count());
            employeeSet = employeeRepository.findAll(new PageRequest(employeeList.getPage(), employeeList.getPageSize(), Sort.Direction.ASC, "id"));
        }
        List<Employee> employeeDataList = ((Page<Employee>) employeeSet).getContent();
        employeeList.setCountOfRecords(employeeDataList.size());
        employeeList.setEmployeeList( employeeDataList );
        return employeeList;

    }

}

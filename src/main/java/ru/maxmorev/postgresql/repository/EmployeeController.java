package ru.maxmorev.postgresql.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxmorev.postgresql.model.Employee;
import ru.maxmorev.postgresql.model.EmployeeList;

import java.util.Optional;


@RestController
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping({"/employeeList/{page}/", "/employeeList/"})
    public EmployeeList employeeList(@PathVariable(name = "page", required = false) Optional<Integer> page ) {
        EmployeeList employeeList = new EmployeeList();
        Integer pageNumber = employeeList.getPage();
        if(page.isPresent()){
            pageNumber = page.get();
            employeeList.setPage(pageNumber);
        }

        employeeList.setCount(employeeRepository.count());


        Iterable<Employee> employeeSet = employeeRepository.findAll(new PageRequest(employeeList.getPage(), employeeList.getPageSize(), Sort.Direction.ASC, "id"));
        employeeList.setEmployeeList( ((Page<Employee>) employeeSet).getContent() );
        return employeeList;

    }

}

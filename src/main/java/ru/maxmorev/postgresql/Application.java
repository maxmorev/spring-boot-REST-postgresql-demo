package ru.maxmorev.postgresql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.maxmorev.postgresql.model.Employee;
import ru.maxmorev.postgresql.repository.EmployeeRepository;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository) {
        return (args) -> {
            // save a couple of customers
            //employeeRepository.save(new Employee("Maxim", 1L, 1L));
            //employeeRepository.save(new Employee("Vika", 1L, 1L));
            //employeeRepository.save(new Employee("Vika2", 1L, 1L));
            //employeeRepository.save(new Employee("Vika", 1L, 1L));
            //employeeRepository.save(new Employee("Navi", 2L, 2L));

            // fetch all customers
            log.info("Employees found with findAll():");

            long count = employeeRepository.count();
            log.info("Employee entity total size: " + count);
            log.info("-------------------------------");
            Iterable<Employee> employeeList = employeeRepository.findAll(new PageRequest(0, 4, Sort.Direction.ASC, "id"));
            log.info("EmployeeList size = " + ((Page<Employee>) employeeList).getSize());


            for (Employee employee : employeeList) {
                log.info(employee.toString());
            }


            log.info("");

            // fetch customers by last name
            log.info("Employee found with findByName('Vika'):");
            log.info("--------------------------------------------");
            employeeRepository.findByName("Vika").forEach(employee -> {
                log.info(employee.toString());
            });
        };
    }
}

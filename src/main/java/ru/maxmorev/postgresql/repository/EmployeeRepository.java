package ru.maxmorev.postgresql.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.maxmorev.postgresql.model.Employee;

import java.util.List;

public interface EmployeeRepository  extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Iterable<Employee> findAll(Sort sort);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByDepartamentId(Long departamentId, Pageable pageable);

    long countByDepartamentId(Long departamentId);



}


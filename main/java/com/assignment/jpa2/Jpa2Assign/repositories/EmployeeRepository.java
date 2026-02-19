package com.assignment.jpa2.Jpa2Assign.repositories;

import com.assignment.jpa2.Jpa2Assign.entities.Employee;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeAgeDTO;
import com.assignment.jpa2.Jpa2Assign.entities.EmployeeDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select e.firstName, e.lastName from Employee e where e.salary > :avg order by e.age asc, e.salary desc")
    List<Object[]> findNameAndLastNameOrderByAgeAndSalary(@Param("avg") Double avg);


    @Query("select avg(e.salary) from Employee e")
    Double findAverageSalary();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Employee e set e.salary=:s where e.salary>:avg")
    int updateEmployees(@Param("s") double salary,@Param("avg") Double avg);

    @Query("select min(e.salary) from Employee e")
    Double findingMin();
    @Transactional
    @Modifying
    @Query("delete from Employee e where e.salary=:s")
    int deleteEmployeesHavingSalaryLess(@Param("s") Double salary);

    @Query(value = "select emp_id,emp_first_name,emp_age from employee_table where emp_last_name like CONCAT('%', :n)",nativeQuery = true)
    List<Object[]> findingNameWithSingh(@Param("n")String lastName);

    @Transactional
    @Modifying
    @Query(value = "delete from employee_table where emp_age>:a",nativeQuery = true)
    int deleteEmployeeByAge(@Param("a") int age);
}

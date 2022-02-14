package com.example.demo;

import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.employee.QEmployee;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class EmployeeTest {
    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("querydsl Test")
    void test() {
        // given

        // when
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        List<Employee> employee = queryFactory
                        .select(Projections.fields(Employee.class, QEmployee.employee.empNo))
                        .from(QEmployee.employee)
                        .orderBy(QEmployee.employee.empNo.asc())
                        .limit(1)
                        .fetch();

        assertEquals(employee.get(0).getEmpNo(), 10001);
    }
}

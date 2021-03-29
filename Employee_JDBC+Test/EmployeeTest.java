package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Test
    public void test_add_small_numbers() {

        EmployeeDAO empDAO = new EmployeeDAO();

        empDAO.insertTest(TestData.name, TestData.age, TestData.address, TestData.salary);

        String actual_result = String.format("%s %s %s %s",
                empDAO.selectLastRow("name"), empDAO.selectLastRow("age"),
                empDAO.selectLastRow("address"), empDAO.selectLastRow("salary"));

        String expected_result = String.format("%s %d %s %.1f",
                TestData.name, TestData.age, TestData.address, TestData.salary);

        assertEquals(expected_result, actual_result);
    }
}

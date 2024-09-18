package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import jakarta.annotation.security.RunAs;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmployeeService employeeService;

	//we want to mock the repo so we use @MockBean
	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void getUsersTest(){
		when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(1,"Raju Rastogi","Pune",20000.0),
				new Employee(2,"Tiwari Seth","Mumbai",4000000.0),
				new Employee(3,"Pappu Panwala","Delhi",200000.0)).toList());

		assertEquals(3,employeeService.getListOfEmployees().size());
	}

	@Test
	public void getUserAddressTest(){
		String address = "Indore";

		when(employeeRepository.findByAddress(address)).thenReturn(Stream.of(
				new Employee(1,"Raju Rastogi","Pune",20000.0),
				new Employee(2,"Tiwari Seth","Indore",4000000.0),
				new Employee(3,"Pappu Panwala","Delhi",200000.0)).toList());

		assertEquals(3,employeeService.getByAddress(address).size());
	}

	@Test
	public void saveEmployeeTest(){
		Employee employee = new Employee(1,"Raju Rastogi","Pune",20000.0);

		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeService.saveEmployee(employee));
	}

}

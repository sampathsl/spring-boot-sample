package com.sampath.restful;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sampath.restful.model.Employee;
import com.sampath.restful.service.EmployeeService;

/**
 * 
 * @author SAMPATH
 *
 */

@Component
public final class DataLoader implements ApplicationRunner {

	@Autowired
	EmployeeService empService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Employee> employee = Arrays.asList(
                new Employee("AF","AFFD","DTD",2000),
                new Employee("AFS","AFDF","DTD",5000),
                new Employee("AFF","AFAF","DTD",1000),
                new Employee("AFA","ASF","DTD",20000),
                new Employee("AFSD","GDAF","DTD",500000),
                new Employee("AFCS","AFGA","DTD",10),
                new Employee("AFCSS","GD","DTD",500),
                new Employee("AADF","GDAF","DTD",20),
                new Employee("SDF","ADGF","DTD",5),
                new Employee("FDSG","GFDAF","DTD",2000),
                new Employee("FSF","GDA","DTD",2000),
                new Employee("DGAD","DA","DTD",2000),
                new Employee("VD","DGA","DTD",2000),
                new Employee("AFVD","BFS","DTD",2000)
        );
        
        employee.forEach(e -> empService.save(e));

    }

}

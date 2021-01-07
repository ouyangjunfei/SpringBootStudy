package org.example.springboot01basic.controller;

import org.example.springboot01basic.dao.DepartmentMapper;
import org.example.springboot01basic.dao.EmployeeMapper;
import org.example.springboot01basic.pojo.Department;
import org.example.springboot01basic.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class EmployeeController {

    private EmployeeMapper employeeMapper;

    private DepartmentMapper departmentMapper;

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @RequestMapping("/get")
    public ModelAndView getEmployees() {
        List<Employee> employeeList = employeeMapper.getEmployees();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @GetMapping("/toAdd")
    public String toAddEmployee(Model model) {
        List<Department> departmentList = departmentMapper.getDepartments();
        model.addAttribute("departmentList", departmentList);
        return "employee_add";
    }

    @PostMapping("/toAdd")
    public String addEmployee() {
        return "forward:/get";
    }
}

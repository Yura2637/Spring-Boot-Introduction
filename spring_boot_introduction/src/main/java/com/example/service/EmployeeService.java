package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee findEmployee(Integer employeeId) {
        // データの1件取得
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        // OptionalからEntityクラスの取得を試みる
        Employee employee = optionalEmployee.get();
        return employee;
    }


    public List<Employee> findAllEmployee() {
        // employeesテーブルのデータをemployeeオブジェクトにつめて全件取得する
        return this.employeeRepository.findAll();
    }
    public Employee insert(String name, String department) {
        // 保存したいEntityクラスのインスタンスを作成する
        Employee employee = new Employee();

        // 引数で受けたname, departmentをEmployeeオブジェクトにセットします
        employee.setName(name);
        employee.setDepartment(department);

        // データベースに保存する
        return this.employeeRepository.save(employee);
    }
    public Employee update(Integer employeeId, String name, String department) {
        // 更新したいデータを取得する
    	Optional <Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.get();

        // Entityクラスのフィールドに更新内容をセットする
        employee.setName(name);
        employee.setDepartment(department);

        // データベースに保存する
        return this.employeeRepository.save(employee);
    }
    public void delete(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
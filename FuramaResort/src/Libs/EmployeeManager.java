package Libs;

import Commons.ReadAndWriteEmployee;
import Models.Employee;

import java.util.*;

public class EmployeeManager {
    Scanner scanner = new Scanner(System.in);
    public void addEmployee() {
        List<Employee> listEmployee = new ArrayList<>();
        System.out.print("Enter ID employee: ");
        int idEmp = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name employee: ");
        String nameEmployee = scanner.nextLine();
        System.out.print("Enter age employee: ");
        int ageEmployee = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter address employee: ");
        String addressEmployee = scanner.nextLine();
        Employee employee = new Employee(idEmp,nameEmployee, ageEmployee, addressEmployee);
        listEmployee.add(employee);
        ReadAndWriteEmployee.writeEmployee(listEmployee, true);
    }
    public void showEmployee() {
        List<Employee> listEmployee = ReadAndWriteEmployee.readEmployee();
        List<Integer> listIdEmp = new ArrayList<>();
        for(Employee employee : listEmployee){
            listIdEmp.add(employee.getIdEmp());
        }

        Map<Integer, Employee> mapEmployee = new HashMap<>();
        for (int i = 0; i < listIdEmp.size(); i++) {
            mapEmployee.put(listIdEmp.get(i), listEmployee.get(i));
        }
        for (Map.Entry<Integer, Employee> entry : mapEmployee.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

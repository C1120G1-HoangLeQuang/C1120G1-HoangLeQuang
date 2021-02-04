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
    public void showToCheckMap(TreeMap tree) {
        Set<Integer> keySet = tree.keySet();
        for (Integer key : keySet) {
            System.out.println(key);
        }
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
//    public Stack<Map.Entry<Integer, Employee>> stackEmployee() {
//        Stack<Map.Entry<Integer, Employee>> employeeStack = new Stack<>();
//        Map<Integer, Employee> mapEmployee = new HashMap<>();
//        for (Map.Entry<Integer, Employee> entry : mapEmployee.entrySet()) {
//            employeeStack.push(entry);
//        }
//        return employeeStack;
//    }
    public Stack<Employee> saveStackEmployee() {
        Stack<Employee> employeeStack = new Stack<>();
        List<Employee> listEmployee = ReadAndWriteEmployee.readEmployee();
        for (Employee employee: listEmployee) {
            employeeStack.push(employee);
        }
        return employeeStack;
    }
    public Employee findEmployee(int id) {
        Employee foundEmp = null;
        Stack<Employee> employeeStack = saveStackEmployee();
        for(Employee employee : employeeStack) {
            if (id == employee.getIdEmp()) {
                foundEmp = employee;
            }
        }
        return foundEmp;
    }
}

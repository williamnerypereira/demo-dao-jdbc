package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentdao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TESTE 1: department insert ");
		Department newDepartment = new Department(null, "D3");
		departmentdao.insert(newDepartment);
		System.out.println("\nInserted! New id = " + newDepartment.getId());
		
		System.out.println("===== TESTE 2: department update ");
		Department department = departmentdao.findById(7);
		department.setName("Engine");
		departmentdao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n==== TESTE 3: department findAll ==== ");
		List<Department> list = departmentdao.findAll();
		
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TESTE 4: department findById ==== ");
		department = departmentdao.findById(1);
		System.out.println(department);
		
		System.out.println("\n==== TESTE 5: department findById ==== ");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		departmentdao.deleteById(id);
		
		sc.close();

	}

}

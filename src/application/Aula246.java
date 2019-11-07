package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Aula246 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = depDao.findAll();
		for (Department depall : list) {
			System.out.println(depall);
		}
	
		System.out.println("\n=== TEST 3: department insert ===");
		Department newDep = new Department(null, "music");
		depDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		dep = depDao.findById(1);
		dep.setName("picture");
		depDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}

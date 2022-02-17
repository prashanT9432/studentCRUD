package studentManagement.main;

import java.sql.Date;
import java.util.Scanner;

import studentManagement.model.Student;
import studentManagement.service.DatabaseService;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseService databaseService = new DatabaseService();
		
		try (Scanner scanner = new Scanner(System.in);) {

			boolean isRunning = true;

			while (isRunning) {
				System.out.println();
				System.out.println("---CRUD MENU---");
				System.out.println();
				System.out.println("1. Create Student");
				System.out.println("2. Show all Student");
				System.out.println("3. Search Student by id");
				System.out.println("4. Update Student");
				System.out.println("5. Delete Student");
				

				int choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Enter name, Date of birth, Date of joining");

					databaseService.createStudent(new Student(scanner.nextLine(), Date.valueOf(scanner.nextLine()),
							Date.valueOf(scanner.nextLine())));
					break;

				case 2:
					
					databaseService.getAllStudents();
					
					break;

				case 3:
					System.out.print("Enter Id of an Student : ");
					
					databaseService.getStudentById(Integer.parseInt(scanner.nextLine()));
					System.out.println();
					break;

				case 4:
					System.out.print("Enter Id of an student to update : ");
					int updateNo = Integer.parseInt(scanner.nextLine());
					boolean isFound = databaseService.getStudentById(updateNo);
					if(isFound) {
						System.out.println("Enter name, address, salary");
						Student student = new Student(updateNo,scanner.nextLine(),Date.valueOf(scanner.nextLine()),
								Date.valueOf(scanner.nextLine()));
						databaseService.updateStudent(student);
						
					}
					break;

				case 5:
					System.out.print("Enter Id of an student to delete : ");
					databaseService.deleteStudentById(Integer.parseInt(scanner.nextLine()));
					break;

				default:
					System.out.println("incorrect choice");
					break;
				}

			}

		} catch (Exception e) {
            System.out.print("Something went wrong: " + e);
         
        }
		
	}

}

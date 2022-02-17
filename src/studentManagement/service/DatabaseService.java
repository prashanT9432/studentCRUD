package studentManagement.service;

import java.sql.*;
import studentManagement.model.Student;
import studentManagement.util.DatabaseUtil;
import studentManagement.util.QueryUtil;

public class DatabaseService {
	
	DatabaseUtil databaseUtil = new DatabaseUtil();
//-----------------------------------------CREATE--------------------------------------
	public void createStudent(Student student) throws SQLException {
		
		try(Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.createStudentQuery())
						){
			preparedStatement.setString(1, student.getStudent_name());
			preparedStatement.setDate(2, student.getStudent_dob());
			preparedStatement.setDate(3, student.getStudent_doj());
			
			
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("Record created successfully.");
				System.out.println();
			} else {
				System.out.println("insert record failed..");
			}
			
		}
	}
//-----------------------------------------VIEW ALL--------------------------------------

	public void getAllStudents() throws SQLException {
	
		try(Connection connection = databaseUtil.getConnection();){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllStudentQuery());
			
			while (resultSet.next()) {
				printStudent(new Student(resultSet.getInt("STUDENT_NO"),resultSet.getString("STUDENT_NAME"),resultSet.getDate("STUDENT_DOB"),resultSet.getDate("STUDENT_DOJ")
						));
				System.out.println("--------------------------");
				
			}
		}
	}
	public void printStudent(Student student) {
		System.out.println("Student No      : " + student.getStudent_no());
		System.out.println("Student Name    : " + student.getStudent_name());
		System.out.println("Student Salary  : " + student.getStudent_dob());
		System.out.println("Student Address : " + student.getStudent_doj());
	}
	//-----------------------------------------VIEW BY ID--------------------------------------

	public boolean getStudentById(int no) throws SQLException {
		boolean isFound = false;
		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement(); 
				ResultSet resultSet = statement.executeQuery(QueryUtil.selectStudentById(no));

		) {
			System.out.println();
			if (resultSet.next()) {
				isFound = true;
				printStudent(new Student(resultSet.getInt("student_no"),resultSet.getString("student_name"),resultSet.getDate("student_dob"),resultSet.getDate("student_doj")	
				));
			}

			else {
				System.out.println("Record not found for id " + no);
			}
			System.out.println("----------------------------");

		}

		return isFound;
	}
	//------------------------------------DELETE----------------------------------------
	public void deleteStudentById(int student_no) throws SQLException {
		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();) {

			int rows = statement.executeUpdate(QueryUtil.deleteStudentById(student_no));
			if (rows > 0) {
				System.out.println("Record deleted.");
			} else {
				System.out.println("Somthing went wrong");
			}
			
		}
	}

	//------------------------------------update----------------------------------------

	public void updateStudent(Student student) throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.updateStudentQuery(student.getStudent_no()))) 
		{
			preparedStatement.setString(1, student.getStudent_name());
			preparedStatement.setDate(2, student.getStudent_dob());
			preparedStatement.setDate(3, student.getStudent_doj());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("Record updated successfully.");
				System.out.println();
			} else {
				System.out.println("update record failed..");
			}
		}

	}
	
	
	
	
	
	
	
	
}

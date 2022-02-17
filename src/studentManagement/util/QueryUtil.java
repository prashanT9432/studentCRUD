package studentManagement.util;

public class QueryUtil {

	public static String createStudentQuery() {
		return "insert into student (student_name,student_dob,student_doj) values(?,?,?);";
		}
	
	public static String selectAllStudentQuery() {
		return "select * from student;";
	}
	
	public static String selectStudentById(int student_no) {
		return "select * from student where student_no = "+student_no;
	}
	
	public static String updateStudentQuery(int student_no) {
		return "update student set student_name = ?, student_dob = ?, student_doj = ? where student_no = "+student_no;
	}
	
	public static String deleteStudentById(int student_no) {
		return "delete from student where student_no = "+ student_no;
	}

}

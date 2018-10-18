package nice.school.model.tables;

import java.util.Date;

import com.ashok.util.myUtil.MyUtil;

public class Student extends DefaultCols{

	Integer studentId;
	String studentName;
	String firstName;
	String lastName;
	String gender;
	Date dob;
	Integer age;
	String courseId;
	
	public Integer getStudentId() {
		return studentId;
	}
	public Student setStudentId(Integer studentId) {
		this.studentId = studentId;
		return this;
	}
	public String getStudentName() {
		return studentName;
	}
	public Student setStudentName(String studentName) {
		this.studentName= studentName;
		return this;
	}
	public Student setStudentName() {
		studentName = firstName != null && !firstName.equals("") ? firstName+" ":"";
		studentName = studentName + ((lastName != null && !lastName.equals("")) ? lastName:"");
		studentName= studentName.trim();
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public Student setFirstName(String firstName) {
		this.firstName = firstName;
		setStudentName();
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public Student setLastName(String lastName) {
		this.lastName = lastName;
		setStudentName();
		return this;
	}
	public String getGender() {
		return gender;
	}
	public Student setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public Date getDob() {
		return dob;
	}
	public Student setDob(Date dob) {
		this.dob = dob;
		setAge();
		return this;
	}
	public Integer getAge() {
		return age;
	}
	public Student setAge(Integer age) {
		this.age = age;
		return this;
	}
	public Student setAge() {
		if(this.dob != null)
			this.age = MyUtil.getAge(this.dob);
		return this;
	}
	public String getCourseId() {
		return courseId;
	}
	public Student setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [studentId=");
		builder.append(studentId);
		builder.append(", studentName=");
		builder.append(studentName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", courseId=");
		builder.append(courseId);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", lastModifiedOn=");
		builder.append(lastModifiedOn);
		builder.append("]");
		return builder.toString();
	}
	
}

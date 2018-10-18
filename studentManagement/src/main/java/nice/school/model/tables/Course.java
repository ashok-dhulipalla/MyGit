package nice.school.model.tables;

public class Course extends DefaultCols{

	String courseId;
	String courseName;
	public String getCourseId() {
		return courseId;
	}
	public Course setCourseId(String courseId) {
		this.courseId = courseId;
		return this;
	}
	public String getCourseName() {
		return courseName;
	}
	public Course setCourseName(String courseName) {
		this.courseName = courseName;
		return this;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [courseId=");
		builder.append(courseId);
		builder.append(", courseName=");
		builder.append(courseName);
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

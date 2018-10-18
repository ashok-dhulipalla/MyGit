package nice.school.dao;

import org.hibernate.Session;

import nice.school.model.tables.Config;
import nice.school.model.tables.Student;

public interface SchoolDao {

	Config getConfig(Session session, String configKey);

	Student getStudent(Session session, Integer studentId);

}

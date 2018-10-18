package nice.school.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ashok.util.hibernate.HibernateUtil;

import nice.school.dao.SchoolDao;
import nice.school.model.tables.Config;
import nice.school.model.tables.Student;
import nice.school.util.Constants;

public class SchoolDbDaoImpl implements SchoolDao{

	public Config getConfig(Session session,String configKey)
	{
		return HibernateUtil.selectOne(session, Config.class, Constants.COLUMN_CONFIG_CONFIG_KEY, configKey);
	}
	
	public Student getStudent(Session session,Integer studentId)
	{
		return HibernateUtil.selectOne(session, Student.class, Constants.COLUMN_STUDENT_STUDENT_ID, studentId);
	}
	

}

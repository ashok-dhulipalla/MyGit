package nice.school.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashok.util.configFiles.ConfigFilesUtil;
import com.ashok.util.hibernate.HibernateUtil;
import com.ashok.util.properties.PropertyFile;

import nice.school.dao.SchoolDao;
import nice.school.dao.impl.SchoolDbDaoImpl;
import nice.school.model.tables.Config;
import nice.school.model.tables.Course;
import nice.school.model.tables.Student;
import nice.school.struts.action.SchoolAction;
import nice.school.util.Constants;

public class StartUpServlet extends HttpServlet{
	
	private static Logger logger= LoggerFactory.getLogger(SchoolAction.class);
	
	public void init()
	{
		try {
			PropertyFile.loadProperties("school.properties");
			logger.info("school properties loaded");
			ConfigFilesUtil.loadLog4JFile("log4j.properties");
			logger.info("log4j properties loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		Session session = HibernateUtil.openSession();
		session.close();
		SchoolDao studentDao= new SchoolDbDaoImpl();
		System.out.println(studentDao.getConfig(session, Constants.CONFIG_KEY_API_KEY).toString());
		session.beginTransaction();
		Student student= new Student();
		Calendar cal = Calendar.getInstance();
		cal.set(1994, 11-1, 19);
//		try {
			student.setStudentId(123123)
			.setFirstName("Aishwarya")
			.setLastName("Pavithram")
			.setGender("F")
			.setDob(cal.getTime())
			.setCourseId("MS");
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.save(student);
		
		Course course= new Course();
		course.setCourseId("MCA").setCourseName("Master Of Computer Applications");
		session.save(course);
		session.getTransaction().commit();*/
	}

}

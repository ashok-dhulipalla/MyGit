package nice.school.struts.action;

import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ashok.util.hibernate.HibernateUtil;

import nice.school.dao.SchoolDao;
import nice.school.dao.impl.SchoolDbDaoImpl;
import nice.school.model.tables.Student;

public class SchoolAction extends DispatchAction{

	private static Logger logger= LoggerFactory.getLogger(SchoolAction.class);
	
	public ActionForward insertStudent(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception 
	{
		logger.info("studentId: "+Integer.valueOf(request.getParameter("studentId")));
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Student student= new Student();
		Calendar cal = Calendar.getInstance();
		cal.set(1994, 11-1, 19);
		student.setStudentId(Integer.valueOf(request.getParameter("studentId")))
		.setFirstName(request.getParameter("firstName"))
		.setLastName(request.getParameter("lastName"))
		.setGender(request.getParameter("gender"))
		.setDob(cal.getTime())
		.setCourseId(request.getParameter("courseId"));
		session.save(student);
		session.getTransaction().commit();
		return mapping.findForward("success");
	}

	public ActionForward isStudentPresent(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception 
	{
		Session session = HibernateUtil.openSession();
		SchoolDao schoolDao= new SchoolDbDaoImpl();
		PrintWriter out = response.getWriter();
		try
		{
			if(schoolDao.getStudent(session, Integer.valueOf(request.getParameter("studentId"))) != null)
				out.print("yes");
			else
				out.print("no");
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			session.close();
		}
		return null;
	}
}

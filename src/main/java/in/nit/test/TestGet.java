package in.nit.test;

import org.hibernate.Session;

import in.nit.model.Course;
import in.nit.model.Student;
import in.nit.util.HibernateUtil;

public class TestGet {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			Student s=ses.get(Student.class, 52);
			//Do not print complete object > may result Stack Overflow Error
			System.out.println(s.getStdName());
			System.out.println(s.getCobs().get(0).getCourseName());
			//--result must be same from two sides.. then valid bi-directional
			Course c=ses.get(Course.class, 902);
			System.out.println(c.getCourseName());
			System.out.println(c.getStdObs().get(0).getStdName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

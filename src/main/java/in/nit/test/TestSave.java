package in.nit.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Course;
import in.nit.model.Student;
import in.nit.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Course c1=new Course(902,"Core Java", 1500.0);
			Course c2=new Course(903,"Adv Java", 2500.0);
			Course c3=new Course(904,"Hibernate", 3200.0);
			Course c4=new Course(905,"Spring and Boot", 4500.0);
			
			
			Student s1=new Student(52,"AR", "ar@gm.com", Arrays.asList(c1,c3));
			Student s2=new Student(53,"BR", "br@gm.com", Arrays.asList(c1,c2));
			Student s3=new Student(54,"CR", "cr@gm.com", Arrays.asList(c2,c4));
			
			ses.save(s1);
			ses.save(s2);
			ses.save(s3);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}

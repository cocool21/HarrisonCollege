import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HcClass;
import model.HcStudentreg;
import model.HcInstructor;
import model.HcStudent;

public class ViewGradeSheetDb {

	public long findAnyClasses(long instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery queryCount = (TypedQuery) em.createQuery(
				"SELECT Count(h) FROM HcClass h where h.hcInstructor.instructorid=:_instructorid",HcClass.class)
				.setParameter("_instructorid", instructorid);
		long count = (long) queryCount.getSingleResult();
		return count;
	}

	public TypedQuery<HcClass> findAllClassesList(long instructorid) {

		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<HcClass> query= (em1.createQuery(
				"SELECT h FROM HcClass h "
						+ "where h.hcInstructor.instructorid=:_instructorid",HcClass.class)
				.setParameter("_instructorid", instructorid));
		return query;
	}

	//select student info for all classes by one instructor
	public static List<HcStudentreg> findAllClassStudentReg(long instructorid, long classid, String semester) {
		List<HcStudentreg> records=null;

		EntityManager em2 = DBUtil.getEmFactory().createEntityManager();
		
		String qString = "select r "
				+ "from HcStudentreg r " 
				+ "where r.hcClass.hcInstructor.instructorid=:_instructorid "
				+ "and r.hcClass.classid=:_classid "
				+ "and r.hcClass.semester=:_semester";
		
		TypedQuery<HcStudentreg> query = em2.createQuery(qString, model.HcStudentreg.class);
		query.setParameter("_instructorid", instructorid)
				.setParameter("_classid", classid)
				.setParameter("_semester", semester);
		try {
			records = query.getResultList();
			if (records== null || records.isEmpty()){
				records = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
	        em2.close();
		}
		
	    return records;	
	}
	
	
	//select all classes for one instructor
	public static List<HcClass> findAllInstructorClass(long instructorid, String semester) {
		List<HcClass> records=null;
		
		EntityManager em3 = DBUtil.getEmFactory().createEntityManager();
		
		String qString = "select c "
				+ "from HcClasses c " 
				+ "where c.hcInstructor.instructorid=:_instructorid "
				+ "and c.semester=:_semester";
		
		TypedQuery<HcClass> query= em3.createQuery(qString, model.HcClass.class);
		query.setParameter("_instructorid", instructorid)
				.setParameter("_semester", semester);
		
		try {
			records = query.getResultList();
			if (records== null || records.isEmpty()){
				records = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
	        em3.close();
		}
		
	    return records;
	}

	
	//	public TypedQuery<HcStudentreg> findAllClassStudentList(int instructorid) {
	//
	//		EntityManager em2 = DBUtil.getEmFactory().createEntityManager();
	//		TypedQuery<HcStudentreg> query= (em2.createQuery(
	//				"select s.studentid, s.studentname, r.grade "
	//				+ "from HcInstructors i, HcStudent s, HcClasses c, HcStudentreg r" 
	//				+ "where c.hcInstructor.instructorid = i.instructorid" 
	//				+ "and c.classid=r.hcClass.classid" 
	//				+ "and s.studentid=r.hcStudent.studentid" 
	//				+ "and i.instructorid=:_instructorid", HcStudentreg.class)
	//				.setParameter("_instructorid", instructorid));
	//		return query;
	//	}
	//	

}

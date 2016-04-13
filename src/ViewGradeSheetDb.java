import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HcClass;
import model.HcStudentreg;
import model.HcInstructor;
import model.HcStudent;

public class ViewGradeSheetDb {

	public long findAnyClasses(int instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery queryCount = (TypedQuery) em.createQuery(
				"SELECT Count(h) FROM HcClass h where h.hcInstructor.instructorid=:_instructorid",HcClass.class)
				.setParameter("_instructorid", instructorid);
		long count = (long) queryCount.getSingleResult();
		return count;
	}

	public TypedQuery<HcClass> findAllClassesList(int instructorid) {

		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<HcClass> query= (em1.createQuery(
				"SELECT h FROM HcClass h "
				+ "where h.hcInstructor.instructorid=:_instructorid",HcClass.class)
				.setParameter("_instructorid", instructorid));
		return query;
	}

	public TypedQuery<HcStudentreg> findAllClassStudentList(int instructorid) {

		EntityManager em2 = DBUtil.getEmFactory().createEntityManager();
		TypedQuery<HcStudentreg> query= (em2.createQuery(
				"select r "
				+ "from HcInstructors i, HcStudent s, HcClasses c, HcStudentreg r" 
				+ "where c.hcInstructor.instructorid = i.instructorid" 
				+ "and c.classid=r.hcClass.classid" 
				+ "and s.studentid=r.hcStudent.studentid" 
				+ "and i.instructorid=:_instructorid", HcStudentreg.class)
				.setParameter("_instructorid", instructorid));
		return query;
	}
	
	
}

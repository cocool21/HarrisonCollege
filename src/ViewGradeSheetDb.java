import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HcClass;

public class ViewGradeSheetDb {

	public long findAnyClasses(int instructorid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		TypedQuery queryCount = (TypedQuery) em.createQuery(
				"SELECT Count(h) FROM HcClass h where h.hcInstructor.instructorid=:_instructorid",HcClass.class)
				.setParameter("_instructorid", instructorid);
		long count = (long) queryCount.getSingleResult();
		return count;
	}

	public TypedQuery<HcClass> findAllAccountList(int instructorid) {

		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		return (TypedQuery<HcClass>) (em1.createQuery(
				"SELECT h FROM HcClass h where h.instructorid=:_instructorid",HcClass.class)
				.setParameter("_instructorid", instructorid));
	}

}

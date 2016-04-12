import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HcStudentreg;

public class getRoster {

	public getRoster() {
		// TODO Auto-generated constructor stub
	}

	public static List<HcStudentreg> getStudentRoster(long classid) {
		List<HcStudentreg> records = null;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select h from HcStudentreg h where h.hcClass.classid= :classid";
		TypedQuery<HcStudentreg> q = em.createQuery(qString, model.HcStudentreg.class);
		q.setParameter("classid", classid);
		try {

			records = q.getResultList();
			if (records == null || records.isEmpty() || records.size() == 0) {
				records = null;
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			return records;
		}
	}
}

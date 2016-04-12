import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HcUser;
public class dblogin {

	public dblogin() {
		
	}
	public TypedQuery <HcUser> searchUser(String user_name ,String password)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HcUser> query =em1.createQuery("SELECT h FROM HcUser h where h.username =:username and h.password=:password",HcUser.class)
				.setParameter("username",user_name)
				.setParameter("password", password);
		return query ;
		
	}

}

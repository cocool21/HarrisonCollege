import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HcInstructor;
import model.HcMajor;
import model.HcStudent;
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
	public void insertNewUser(String name ,String user_name ,String password)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		String user_type="student";
		HcUser hcu = new HcUser();
		hcu.setHcType(user_type);
		hcu.setPassword(password);
		hcu.setUsername(user_name);
		System.out.println(user_name);
		
		hcu.setUserid(getNextUserid()+1);
		trans.begin();
		try
		{
			System.out.println("im here 2");
			em1.persist(hcu);
			em1.flush();
			trans.commit();
		}
		catch(Exception e)
		{
			
			trans.rollback();
		}
		finally
		{
			em1.close();
		}
		
		
	}
	
	protected long getNextUserid()
	{
		
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query =em1.createQuery("SELECT max(h.userid) FROM HcUser h",Long.class);
		
		return (long) query.getSingleResult();
	}
	
	public long getStudentID(long userid)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery query =em1.createQuery("SELECT h.studentid FROM HcStudent h where h.hcUser.userid=:user_id",  HcStudent.class)
				.setParameter("user_id", userid);
		System.out.println((long)query.getSingleResult());
		return (long)query.getSingleResult();
	}
	public long getTeacherID(long userid)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery query =em1.createQuery("SELECT h.instructorid FROM HcInstructor h where h.hcUser.userid=:user_id",HcInstructor.class)
				.setParameter("user_id", userid);
		System.out.println((long)query.getSingleResult());
		return (long)query.getSingleResult();
		
		
	}
	public void insertNewStudent(String name ,String user_name ,String year ,long major)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		HcStudent hcs = new HcStudent();
		HcMajor hcm =new HcMajor();
		HcUser hcu =new HcUser();
		hcm.setMajorid(major);
		hcs.setHcMajor(hcm);
		hcs.setStudentname(name);
		hcs.setYearofentry(year);
		hcu.setUserid(getUseridfromTable(user_name));//add your method to get id
		hcs.setHcUser(hcu);
		hcs.setStudentid(getNewStudentID()+1);
		
		
		
		trans.begin();
		try
		{
			System.out.println("im here try");
			em1.persist(hcs);
			em1.flush();
			trans.commit();
		}
		catch(Exception e)
		{
			
			trans.rollback();
		}
		finally
		{
			em1.close();
		}
		
		
	}
	protected long getUseridfromTable(String username)
	{
		
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query =em1.createQuery("SELECT distinct(h.userid) FROM HcUser h where h.username=:user_name",Long.class)
				.setParameter("user_name", username);
		
		return (long) query.getSingleResult();
	}
	
	public long getNewStudentID()
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery query =em1.createQuery("SELECT max(h.studentid) FROM HcStudent h ",  HcStudent.class);
		System.out.println((long)query.getSingleResult());
		return (long)query.getSingleResult();
	}

}

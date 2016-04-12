package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.HcClass;
import model.HcStudentreg;
import model.HcStudent;

import java.util.ArrayList;
import java.util.List;

public class ProcessStudentReg {
public ProcessStudentReg(){}
public static long getNewId(){
	EntityManager em=DBUtil.getEmFactory().createEntityManager();
	String qString="SELECT (max(r.regid)+1) FROM HcStudentreg r";
	Query q=em.createQuery(qString,model.HcStudentreg.class);
	long newid=0;
	try{
		newid=(long)q.getSingleResult();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			em.close();
			if(newid==0){
			newid=1;
			}
			
			return newid;
		} 
}
public static void addClass(long studentid,long classid){
	HcStudentreg record=new HcStudentreg();
	HcClass c=new HcClass();
	HcStudent s=new HcStudent();
	c.setClassid(classid);
	s.setStudentid(studentid);
	record.setGrade("");
	record.setRegid(getNewId());
	record.setHcClass(c);
	record.setHcStudent(s);
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	EntityTransaction trans = em.getTransaction();
	trans.begin();
	try {
	em.persist(record);
	trans.commit();
	} catch (Exception e) {
	System.out.println(e);
	trans.rollback();
	} finally {
	em.close();
	}
}

public static void dropClass(long studentid,long classid){
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	EntityTransaction trans = em.getTransaction();
	String qString = "update HcStudentreg r set r.grade = :grade "
			+ "where r.hcStudent.studentid = :studentid and r.hcClass.classid= :classid";
	TypedQuery<HcStudentreg> q = em.createQuery(qString, model.HcStudentreg.class);
	q.setParameter("grade", "W");
	q.setParameter("studentid", studentid);
	q.setParameter("classid", classid);
	int count = 0;

	try {
		trans.begin();
		count = q.executeUpdate();
		trans.commit();

	} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
	} finally {

		em.close();
		System.out.println(count);
	}
}
public static HcStudentreg getRecord(long studentid,long classid){
	EntityManager em=DBUtil.getEmFactory().createEntityManager();
	String qString="SELECT r FROM HcStudentreg r where r.hcStudent.studentid = :studentid and r.hcClass.classid= :classid";
	Query q=em.createQuery(qString,model.HcStudentreg.class);
	q.setParameter("studentid", studentid);
	q.setParameter("classid", classid);
	HcStudentreg record=null;
	List<HcStudentreg> list=null;
	try{
		list= q.getResultList();
		if(list==null||list.isEmpty()){
			record=null;
		}
		record=list.get(0);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			em.close();
			return record;
		}
}
public static void updateGrade(long studentid,long classid,String grade){
	HcStudentreg record=getRecord(studentid,classid);
	if(record.getGrade().equalsIgnoreCase("w")){
		System.out.println("Student dropped class, no grade will be added");
	}else{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		String qString = "update HcStudentreg r set r.grade = :grade "
				+ "where r.hcStudent.studentid = :studentid and r.hcClass.classid= :classid";
		TypedQuery<HcStudentreg> q = em.createQuery(qString, model.HcStudentreg.class);
		q.setParameter("grade", grade);
		q.setParameter("studentid", studentid);
		q.setParameter("classid", classid);
		int count = 0;

		try {
			trans.begin();
			count = q.executeUpdate();
			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {

			em.close();
			System.out.println(count);
		}
	}
		
	}

public static List<HcStudent> getStudentList(long classid){
	List<HcStudentreg> records=null;
	List<HcStudent> list = new ArrayList<HcStudent>();
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select r from HcStudentreg r where r.hcClass.classid= :classid";
	TypedQuery<HcStudentreg> q = em.createQuery(qString, model.HcStudentreg.class);
	q.setParameter("classid", classid);
	try {

		records = q.getResultList();
		if (records== null || records.isEmpty()){
			records = null;
			list = null;
		}else{
			for(HcStudentreg record:records){
			list.add(record.getHcStudent());
			}
		}
	} catch (Exception e) {
		System.out.println(e);
	} finally {
        em.close();
	}
	
    return list;
}
public static List<HcStudentreg> getTranscript(long studentid){
	List<HcStudentreg> records=null;
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	String qString = "Select r from HcStudentreg r where r.hcStudent.studentid= :studentid";
	TypedQuery<HcStudentreg> q = em.createQuery(qString, model.HcStudentreg.class);
	q.setParameter("studentid", studentid);
	try {

		records = q.getResultList();
		if (records== null || records.isEmpty()){
			records = null;
		}
	} catch (Exception e) {
		System.out.println(e);
	} finally {
        em.close();
	}
	
    return records;
}

}

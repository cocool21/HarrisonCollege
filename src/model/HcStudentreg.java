package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HC_STUDENTREG database table.
 * 
 */
@Entity
@Table(name="HC_STUDENTREG")
@NamedQuery(name="HcStudentreg.findAll", query="SELECT h FROM HcStudentreg h")
public class HcStudentreg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long regid;

	private String grade;

	//bi-directional many-to-one association to HcClass
	@ManyToOne
	@JoinColumn(name="CLASSID")
	private HcClass hcClass;

	//bi-directional many-to-one association to HcStudent
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private HcStudent hcStudent;

	public HcStudentreg() {
	}

	public long getRegid() {
		return this.regid;
	}

	public void setRegid(long regid) {
		this.regid = regid;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public HcClass getHcClass() {
		return this.hcClass;
	}

	public void setHcClass(HcClass hcClass) {
		this.hcClass = hcClass;
	}

	public HcStudent getHcStudent() {
		return this.hcStudent;
	}

	public void setHcStudent(HcStudent hcStudent) {
		this.hcStudent = hcStudent;
	}

}
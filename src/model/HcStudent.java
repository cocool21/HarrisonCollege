package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_STUDENTS database table.
 * 
 */
@Entity
@Table(name="HC_STUDENTS")
@NamedQuery(name="HcStudent.findAll", query="SELECT h FROM HcStudent h")
public class HcStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long studentid;

	private String studentname;

	private String yearofentry;

	//bi-directional many-to-one association to HcStudentreg
	@OneToMany(mappedBy="hcStudent")
	private List<HcStudentreg> hcStudentregs;

	//bi-directional many-to-one association to HcMajor
	@ManyToOne
	@JoinColumn(name="MAJORID")
	private HcMajor hcMajor;

	//bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name="USERID")
	private HcUser hcUser;

	public HcStudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getYearofentry() {
		return this.yearofentry;
	}

	public void setYearofentry(String yearofentry) {
		this.yearofentry = yearofentry;
	}

	public List<HcStudentreg> getHcStudentregs() {
		return this.hcStudentregs;
	}

	public void setHcStudentregs(List<HcStudentreg> hcStudentregs) {
		this.hcStudentregs = hcStudentregs;
	}

	public HcStudentreg addHcStudentreg(HcStudentreg hcStudentreg) {
		getHcStudentregs().add(hcStudentreg);
		hcStudentreg.setHcStudent(this);

		return hcStudentreg;
	}

	public HcStudentreg removeHcStudentreg(HcStudentreg hcStudentreg) {
		getHcStudentregs().remove(hcStudentreg);
		hcStudentreg.setHcStudent(null);

		return hcStudentreg;
	}

	public HcMajor getHcMajor() {
		return this.hcMajor;
	}

	public void setHcMajor(HcMajor hcMajor) {
		this.hcMajor = hcMajor;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

}
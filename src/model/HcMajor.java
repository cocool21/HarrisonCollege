package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_MAJORS database table.
 * 
 */
@Entity
@Table(name="HC_MAJORS")
@NamedQuery(name="HcMajor.findAll", query="SELECT h FROM HcMajor h")
public class HcMajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long majorid;

	private String majorname;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="DEPTID")
	private HcDepartment hcDepartment;

	//bi-directional many-to-one association to HcStudent
	@OneToMany(mappedBy="hcMajor")
	private List<HcStudent> hcStudents;

	public HcMajor() {
	}

	public long getMajorid() {
		return this.majorid;
	}

	public void setMajorid(long majorid) {
		this.majorid = majorid;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

	public List<HcStudent> getHcStudents() {
		return this.hcStudents;
	}

	public void setHcStudents(List<HcStudent> hcStudents) {
		this.hcStudents = hcStudents;
	}

	public HcStudent addHcStudent(HcStudent hcStudent) {
		getHcStudents().add(hcStudent);
		hcStudent.setHcMajor(this);

		return hcStudent;
	}

	public HcStudent removeHcStudent(HcStudent hcStudent) {
		getHcStudents().remove(hcStudent);
		hcStudent.setHcMajor(null);

		return hcStudent;
	}

}
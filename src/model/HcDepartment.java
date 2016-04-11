package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="HC_DEPARTMENTS")
@NamedQuery(name="HcDepartment.findAll", query="SELECT h FROM HcDepartment h")
public class HcDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long deptid;

	private String deptname;

	//bi-directional many-to-one association to HcCours
	@OneToMany(mappedBy="hcDepartment")
	private List<HcCours> hcCourses;

	//bi-directional many-to-one association to HcInstructor
	@OneToMany(mappedBy="hcDepartment")
	private List<HcInstructor> hcInstructors;

	//bi-directional many-to-one association to HcMajor
	@OneToMany(mappedBy="hcDepartment")
	private List<HcMajor> hcMajors;

	public HcDepartment() {
	}

	public long getDeptid() {
		return this.deptid;
	}

	public void setDeptid(long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<HcCours> getHcCourses() {
		return this.hcCourses;
	}

	public void setHcCourses(List<HcCours> hcCourses) {
		this.hcCourses = hcCourses;
	}

	public HcCours addHcCours(HcCours hcCours) {
		getHcCourses().add(hcCours);
		hcCours.setHcDepartment(this);

		return hcCours;
	}

	public HcCours removeHcCours(HcCours hcCours) {
		getHcCourses().remove(hcCours);
		hcCours.setHcDepartment(null);

		return hcCours;
	}

	public List<HcInstructor> getHcInstructors() {
		return this.hcInstructors;
	}

	public void setHcInstructors(List<HcInstructor> hcInstructors) {
		this.hcInstructors = hcInstructors;
	}

	public HcInstructor addHcInstructor(HcInstructor hcInstructor) {
		getHcInstructors().add(hcInstructor);
		hcInstructor.setHcDepartment(this);

		return hcInstructor;
	}

	public HcInstructor removeHcInstructor(HcInstructor hcInstructor) {
		getHcInstructors().remove(hcInstructor);
		hcInstructor.setHcDepartment(null);

		return hcInstructor;
	}

	public List<HcMajor> getHcMajors() {
		return this.hcMajors;
	}

	public void setHcMajors(List<HcMajor> hcMajors) {
		this.hcMajors = hcMajors;
	}

	public HcMajor addHcMajor(HcMajor hcMajor) {
		getHcMajors().add(hcMajor);
		hcMajor.setHcDepartment(this);

		return hcMajor;
	}

	public HcMajor removeHcMajor(HcMajor hcMajor) {
		getHcMajors().remove(hcMajor);
		hcMajor.setHcDepartment(null);

		return hcMajor;
	}

}
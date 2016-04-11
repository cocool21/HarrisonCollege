package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HC_COURSES database table.
 * 
 */
@Entity
@Table(name="HC_COURSES")
@NamedQuery(name="HcCours.findAll", query="SELECT h FROM HcCours h")
public class HcCours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String courseid;

	private String coursedescription;

	private String coursename;

	private BigDecimal credits;

	//bi-directional many-to-one association to HcClass
	@OneToMany(mappedBy="hcCours")
	private List<HcClass> hcClasses;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="DEPTID")
	private HcDepartment hcDepartment;

	public HcCours() {
	}

	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursedescription() {
		return this.coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public List<HcClass> getHcClasses() {
		return this.hcClasses;
	}

	public void setHcClasses(List<HcClass> hcClasses) {
		this.hcClasses = hcClasses;
	}

	public HcClass addHcClass(HcClass hcClass) {
		getHcClasses().add(hcClass);
		hcClass.setHcCours(this);

		return hcClass;
	}

	public HcClass removeHcClass(HcClass hcClass) {
		getHcClasses().remove(hcClass);
		hcClass.setHcCours(null);

		return hcClass;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

}
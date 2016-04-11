package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HC_INSTRUCTORS database table.
 * 
 */
@Entity
@Table(name="HC_INSTRUCTORS")
@NamedQuery(name="HcInstructor.findAll", query="SELECT h FROM HcInstructor h")
public class HcInstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long instructorid;

	private String instructorname;

	private BigDecimal officenumber;

	//bi-directional many-to-one association to HcClass
	@OneToMany(mappedBy="hcInstructor")
	private List<HcClass> hcClasses;

	//bi-directional many-to-one association to HcDepartment
	@ManyToOne
	@JoinColumn(name="DEPTID")
	private HcDepartment hcDepartment;

	//bi-directional many-to-one association to HcUser
	@ManyToOne
	@JoinColumn(name="USERID")
	private HcUser hcUser;

	public HcInstructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public String getInstructorname() {
		return this.instructorname;
	}

	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}

	public BigDecimal getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(BigDecimal officenumber) {
		this.officenumber = officenumber;
	}

	public List<HcClass> getHcClasses() {
		return this.hcClasses;
	}

	public void setHcClasses(List<HcClass> hcClasses) {
		this.hcClasses = hcClasses;
	}

	public HcClass addHcClass(HcClass hcClass) {
		getHcClasses().add(hcClass);
		hcClass.setHcInstructor(this);

		return hcClass;
	}

	public HcClass removeHcClass(HcClass hcClass) {
		getHcClasses().remove(hcClass);
		hcClass.setHcInstructor(null);

		return hcClass;
	}

	public HcDepartment getHcDepartment() {
		return this.hcDepartment;
	}

	public void setHcDepartment(HcDepartment hcDepartment) {
		this.hcDepartment = hcDepartment;
	}

	public HcUser getHcUser() {
		return this.hcUser;
	}

	public void setHcUser(HcUser hcUser) {
		this.hcUser = hcUser;
	}

}
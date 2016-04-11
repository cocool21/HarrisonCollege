package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_USER database table.
 * 
 */
@Entity
@Table(name="HC_USER")
@NamedQuery(name="HcUser.findAll", query="SELECT h FROM HcUser h")
public class HcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	@Column(name="HC_TYPE")
	private String hcType;

	private String password;

	private String username;

	//bi-directional many-to-one association to HcInstructor
	@OneToMany(mappedBy="hcUser")
	private List<HcInstructor> hcInstructors;

	//bi-directional many-to-one association to HcStudent
	@OneToMany(mappedBy="hcUser")
	private List<HcStudent> hcStudents;

	public HcUser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getHcType() {
		return this.hcType;
	}

	public void setHcType(String hcType) {
		this.hcType = hcType;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<HcInstructor> getHcInstructors() {
		return this.hcInstructors;
	}

	public void setHcInstructors(List<HcInstructor> hcInstructors) {
		this.hcInstructors = hcInstructors;
	}

	public HcInstructor addHcInstructor(HcInstructor hcInstructor) {
		getHcInstructors().add(hcInstructor);
		hcInstructor.setHcUser(this);

		return hcInstructor;
	}

	public HcInstructor removeHcInstructor(HcInstructor hcInstructor) {
		getHcInstructors().remove(hcInstructor);
		hcInstructor.setHcUser(null);

		return hcInstructor;
	}

	public List<HcStudent> getHcStudents() {
		return this.hcStudents;
	}

	public void setHcStudents(List<HcStudent> hcStudents) {
		this.hcStudents = hcStudents;
	}

	public HcStudent addHcStudent(HcStudent hcStudent) {
		getHcStudents().add(hcStudent);
		hcStudent.setHcUser(this);

		return hcStudent;
	}

	public HcStudent removeHcStudent(HcStudent hcStudent) {
		getHcStudents().remove(hcStudent);
		hcStudent.setHcUser(null);

		return hcStudent;
	}

}
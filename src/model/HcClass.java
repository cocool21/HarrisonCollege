package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HC_CLASSES database table.
 * 
 */
@Entity
@Table(name="HC_CLASSES")
@NamedQuery(name="HcClass.findAll", query="SELECT h FROM HcClass h")
public class HcClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long classid;

	@Column(name="\"SCHEDULE\"")
	private String schedule;

	private String semester;

	//bi-directional many-to-one association to HcClassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOMID")
	private HcClassroom hcClassroom;

	//bi-directional many-to-one association to HcCours
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private HcCours hcCours;

	//bi-directional many-to-one association to HcInstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private HcInstructor hcInstructor;

	//bi-directional many-to-one association to HcStudentreg
	@OneToMany(mappedBy="hcClass")
	private List<HcStudentreg> hcStudentregs;

	public HcClass() {
	}

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public String getSchedule() {
		return this.schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public HcClassroom getHcClassroom() {
		return this.hcClassroom;
	}

	public void setHcClassroom(HcClassroom hcClassroom) {
		this.hcClassroom = hcClassroom;
	}

	public HcCours getHcCours() {
		return this.hcCours;
	}

	public void setHcCours(HcCours hcCours) {
		this.hcCours = hcCours;
	}

	public HcInstructor getHcInstructor() {
		return this.hcInstructor;
	}

	public void setHcInstructor(HcInstructor hcInstructor) {
		this.hcInstructor = hcInstructor;
	}

	public List<HcStudentreg> getHcStudentregs() {
		return this.hcStudentregs;
	}

	public void setHcStudentregs(List<HcStudentreg> hcStudentregs) {
		this.hcStudentregs = hcStudentregs;
	}

	public HcStudentreg addHcStudentreg(HcStudentreg hcStudentreg) {
		getHcStudentregs().add(hcStudentreg);
		hcStudentreg.setHcClass(this);

		return hcStudentreg;
	}

	public HcStudentreg removeHcStudentreg(HcStudentreg hcStudentreg) {
		getHcStudentregs().remove(hcStudentreg);
		hcStudentreg.setHcClass(null);

		return hcStudentreg;
	}

}
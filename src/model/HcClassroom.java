package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HC_CLASSROOMS database table.
 * 
 */
@Entity
@Table(name="HC_CLASSROOMS")
@NamedQuery(name="HcClassroom.findAll", query="SELECT h FROM HcClassroom h")
public class HcClassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long classroomid;

	private String buildingname;

	private BigDecimal maxcapacity;

	private BigDecimal roomnumber;

	//bi-directional many-to-one association to HcClass
	@OneToMany(mappedBy="hcClassroom")
	private List<HcClass> hcClasses;

	public HcClassroom() {
	}

	public long getClassroomid() {
		return this.classroomid;
	}

	public void setClassroomid(long classroomid) {
		this.classroomid = classroomid;
	}

	public String getBuildingname() {
		return this.buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public BigDecimal getMaxcapacity() {
		return this.maxcapacity;
	}

	public void setMaxcapacity(BigDecimal maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	public BigDecimal getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(BigDecimal roomnumber) {
		this.roomnumber = roomnumber;
	}

	public List<HcClass> getHcClasses() {
		return this.hcClasses;
	}

	public void setHcClasses(List<HcClass> hcClasses) {
		this.hcClasses = hcClasses;
	}

	public HcClass addHcClass(HcClass hcClass) {
		getHcClasses().add(hcClass);
		hcClass.setHcClassroom(this);

		return hcClass;
	}

	public HcClass removeHcClass(HcClass hcClass) {
		getHcClasses().remove(hcClass);
		hcClass.setHcClassroom(null);

		return hcClass;
	}

}
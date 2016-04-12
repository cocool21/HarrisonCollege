package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HC_CUR_SEMESTER database table.
 * 
 */
@Entity
@Table(name="HC_CUR_SEMESTER")
@NamedQuery(name="HcCurSemester.findAll", query="SELECT h FROM HcCurSemester h")
public class HcCurSemester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long semesterid;

	private String currentsem;

	public HcCurSemester() {
	}

	public long getSemesterid() {
		return this.semesterid;
	}

	public void setSemesterid(long semesterid) {
		this.semesterid = semesterid;
	}

	public String getCurrentsem() {
		return this.currentsem;
	}

	public void setCurrentsem(String currentsem) {
		this.currentsem = currentsem;
	}

}
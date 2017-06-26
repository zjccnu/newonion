package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
@Entity
@Table(name="course")
public class Course extends Model implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -735642656979773800L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="courseid")
    private long  courseId;
	
	@Column(name="courseName")
	private  String courseName;
	
	@Column(name="courseTeacher")
	private String courseTeacher;
	
	@Column(name="bz1")
	private String bz1;
	
	@Column(name="bz2")
	private String bz2;
	
	@Column(name="bz3")
	private String bz3;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public String getBz1() {
		return bz1;
	}

	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}

	public String getBz2() {
		return bz2;
	}

	public void setBz2(String bz2) {
		this.bz2 = bz2;
	}

	public String getBz3() {
		return bz3;
	}

	public void setBz3(String bz3) {
		this.bz3 = bz3;
	}
	
	
	
}

package models;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.db.ebean.Model;
@Entity
@Table(name="courseComment")
public class CourseComment extends Model implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5213798732872250443L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="courseCommentId")
    private long  courseCommentId;
	//以course为主键
	@OneToOne()
    @JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;
	//课程内容
	@Column(name="courseContent")
	private  String courseContent;
	//课程质量
	@Column(name="courseQuality")
	private String courseQuality;
	
	@Column(name="courseScore")
	private String courseScore;
	
	@Column(name="courseLike")
	private String courseLike;

	@Column(name="score")
	private String score;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="time")
	private String time;
	//是否匿名
	@Column(name="idAnonymous")
	private String idAnonymous;
	//url头像连接
	@Column(name="url")
	private String url;
	
	//用户姓名
	@Column(name="usname")
	private String usname;
	
	//
	@Column(name="count")
	private String count;
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Column(name="bz1")
	private String bz1;
	
	@Column(name="bz2")
	private String bz2;
	
	@Column(name="bz3")
	private String bz3;

	public long getCourseCommentId() {
		return courseCommentId;
	}

	public void setCourseCommentId(long courseCommentId) {
		this.courseCommentId = courseCommentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(String courseContent) {
		this.courseContent = courseContent;
	}

	public String getCourseQuality() {
		return courseQuality;
	}

	public void setCourseQuality(String courseQuality) {
		this.courseQuality = courseQuality;
	}

	public String getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(String courseScore) {
		this.courseScore = courseScore;
	}

	public String getCourseLike() {
		return courseLike;
	}

	public void setCourseLike(String courseLike) {
		this.courseLike = courseLike;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIdAnonymous() {
		return idAnonymous;
	}

	public void setIdAnonymous(String idAnonymous) {
		this.idAnonymous = idAnonymous;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsname() {
		return usname;
	}

	public void setUsname(String usname) {
		this.usname = usname;
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

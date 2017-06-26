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
@Table(name="thumbsUp")
public class ThumbsUp extends Model implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1012130747946280321L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="thumbsUpId")
	private long thumbsUpId;
	
	@Column(name="username")
	private String  username;
	
	@Column(name="courseCommentId")
	private String  courseCommentId;

	public long getThumbsUpId() {
		return thumbsUpId;
	}

	public void setThumbsUpId(long thumbsUpId) {
		this.thumbsUpId = thumbsUpId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCourseCommentId() {
		return courseCommentId;
	}

	public void setCourseCommentId(String courseCommentId) {
		this.courseCommentId = courseCommentId;
	}
	
	
}

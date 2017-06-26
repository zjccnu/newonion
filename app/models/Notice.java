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
@Table(name="notice")
public class Notice extends Model implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8293363140184705634L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="noticeId")
    private long  noticeId;
	@Column(name="title")
    private String title;
	@Column(name="url")
    private String url;
	@Column(name="type")
    private String type;
	@Column(name="noticetime")
    private String noticeTime;
    @Column(name="bz1")
    private String bz1;
	@Column(name="bz2")
    private String bz2;
	@Column(name="bz3")
    private String bz3;
	public long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
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

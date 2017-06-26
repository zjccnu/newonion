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
@Table(name="userinfo")
public class UserInfo extends Model implements Serializable{
      /**
	 * 
	 */
	
	private static final long serialVersionUID = -5101195573453568148L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private long userId;
	@Column(name="username")
      private String username;
	@Column(name="password")
      private String password;
	@Column(name="token")
      private String token;
	@Column(name="expire")
      private String expire;
	@Column(name="bz1")
      private String bz1;
	@Column(name="bz2")
      private String bz2;
	@Column(name="bz3")
      private String bz3;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
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

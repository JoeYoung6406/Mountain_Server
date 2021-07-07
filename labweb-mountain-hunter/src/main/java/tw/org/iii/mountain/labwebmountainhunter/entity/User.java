package tw.org.iii.mountain.labwebmountainhunter.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wp_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@Column(name = "user_login")
	String account;
	@Column(name="user_pass")
	String password;
	String user_nickname;
	String user_email;
	Date birth;
	String user_url;
	Timestamp user_registered;
	String user_activation_key;
	Integer user_status;
	String display_name;
	String realname;
	String phone;
	Integer points;
	Integer cash;
	
}

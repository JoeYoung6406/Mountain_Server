package tw.org.iii.mountain.labwebmountainhunter.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
	// 建立col & Talbe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer status;
	String account;
	String password;
	String realname;
	Date birthday;
	String email;
	String tel;
	String point;
	String cash;

//	    @CreatedDate
//	    @Column(updatable = false, nullable = false)
//	    Date createTime = new Date();
//
//	    @LastModifiedDate
//	    @Column(nullable = false)
//	    Date updateTime = new Date();
}

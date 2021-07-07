package tw.org.iii.mountain.labwebmountainhunter.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wp_bp_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer creator_id;
	String name;
	String slug;
	String description;
	String status;
	Integer parent_id;
	Integer enable_forum;
	@CreatedDate
	Timestamp date_created;
	String start_date;
	String mountain_name;
	Integer total_num;
	String image;
	String attendee;
	Integer points;
	Timestamp start_time;
	Timestamp finish_time;
	Time total_time;
	String start_lat;
	String start_lng;
	String finish_lat;
	String finish_lng;
	

}

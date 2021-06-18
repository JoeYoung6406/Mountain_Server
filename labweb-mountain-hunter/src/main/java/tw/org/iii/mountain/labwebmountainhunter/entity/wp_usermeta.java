package tw.org.iii.mountain.labwebmountainhunter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "wp_usermeta")
@Data
public class wp_usermeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer umeta_id;
	
	@Column
	Integer user_id;
	
	@Column
	String meta_key;
	
	@Column
	String meta_value;
	
}

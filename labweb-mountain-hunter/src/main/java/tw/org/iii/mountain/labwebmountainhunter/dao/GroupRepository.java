package tw.org.iii.mountain.labwebmountainhunter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.org.iii.mountain.labwebmountainhunter.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

	Group findByName(String name);

	//利用id尋找正在參加的團
	@Query(value ="Select * from wp_bp_groups where ((attendee like %?%) or (creator_id like ?)) AND (total_time IS null)"
			, nativeQuery=true)
	List<Group> showIngGroups(String attendee_id, String creator_id);
	
	//利用id尋找還未參加的團
	@Query(value ="Select * from wp_bp_groups where ((attendee not like %?%) and (creator_id not like ?)) AND (total_time IS null)"
			, nativeQuery=true)
	List<Group> showJoinGroups(String attendee_id, String creator_id);
	
	//利用id尋找已結束的團
	@Query(value ="Select * from wp_bp_groups where ((attendee like %?%) or (creator_id like ?)) AND (total_time IS NOT null)"
			, nativeQuery=true)
	List<Group> showHistoryGroups(String attendee_id, String creator_id);
}

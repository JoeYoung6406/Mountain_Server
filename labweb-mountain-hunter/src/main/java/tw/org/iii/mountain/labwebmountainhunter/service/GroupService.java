package tw.org.iii.mountain.labwebmountainhunter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.mountain.labwebmountainhunter.dao.GroupRepository;
import tw.org.iii.mountain.labwebmountainhunter.entity.Group;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRe;

	public List<Group> getGroup() {
		return groupRe.findAll();
	}

	public Group createGroup(Group group) {
		return groupRe.save(group);
	}

	public Group getInfoById(Integer id) {
		return groupRe.findById(id).orElse(null);
	}

	public Group getInfoByName(Group group) {
		return groupRe.findByName(group.getName());
	}

	public Boolean updateGroup(Integer id, Group group) {
		Group exitGroup = groupRe.findById(id).orElse(null);
		if (exitGroup == null) {
			return false;
		} else {
			if (group.getCreator_id() != null) {
				exitGroup.setCreator_id(group.getCreator_id());
			}
			;
			if (group.getName() != null) {
				exitGroup.setName(group.getName());
			}
			;
			if (group.getSlug() != null) {
				exitGroup.setSlug(group.getSlug());
			}
			;
			if (group.getDescription() != null) {
				exitGroup.setDescription(group.getDescription());
			}
			;
			if (group.getStatus() != null) {
				exitGroup.setStatus(group.getStatus());
			}
			;
			if (group.getParent_id() != null) {
				exitGroup.setParent_id(group.getParent_id());
			}
			;
			if (group.getEnable_forum() != null) {
				exitGroup.setEnable_forum(group.getEnable_forum());
			}
			;
			if (group.getDate_created() != null) {
				exitGroup.setDate_created(group.getDate_created());
			}
			;
			if (group.getStart_date() != null) {
				exitGroup.setStart_date(group.getStart_date());
			}
			;
			if (group.getMountain_name() != null) {
				exitGroup.setMountain_name(group.getMountain_name());
			}
			;
			if (group.getTotal_num() != null) {
				exitGroup.setTotal_num(group.getTotal_num());
			}
			;
			if (group.getImage() != null) {
				exitGroup.setImage(group.getImage());
			}
			;
			if (group.getAttendee() != null) {
				exitGroup.setAttendee(group.getAttendee());
			}
			;
			if (group.getPoints() != null) {
				exitGroup.setPoints(group.getPoints());
			}
			;
			if (group.getStart_time() != null) {
				exitGroup.setStart_time(group.getStart_time());
			}
			;
			if (group.getFinish_time() != null) {
				exitGroup.setFinish_time(group.getFinish_time());
			}
			;
			if (group.getTotal_time() != null) {
				exitGroup.setTotal_time(group.getTotal_time());
			}
			;
			if (group.getStart_lat() != null) {
				exitGroup.setStart_lat(group.getStart_lat());
			}
			;
			if (group.getStart_lng() !=null) {
				exitGroup.setStart_lng(group.getStart_lng());
			}
			;
			if (group.getFinish_lat() != null) {
				exitGroup.setFinish_lat(group.getFinish_lat());
			}
			;
			if (group.getFinish_lng() != null) {
				exitGroup.setFinish_lng(group.getFinish_lng());
			}
			;
			groupRe.save(exitGroup);
			return true;
		}
	}

	public Boolean deleteGroup(Integer id) {
		Group group = groupRe.findById(id).orElse(null);
		if (group == null) {
			return false;
		} else {
			groupRe.deleteById(id);
			return true;
		}
	}

	public Group findById(Integer id) {
		return groupRe.findById(id).orElse(null);
	}
	public List<Group> showIngGroups(String id){
		return groupRe.showIngGroups(id, id);
	}
	public List<Group> showJoinGroups(String id) {
		return groupRe.showJoinGroups(id, id);
	}
	public List<Group> showHistoryGroups(String id) {
		return groupRe.showHistoryGroups(id, id);
	}
}

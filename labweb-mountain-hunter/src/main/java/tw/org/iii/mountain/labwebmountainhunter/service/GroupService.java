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

	public Integer createGroup(Group group) {
		Group rltGroup = groupRe.save(group);
		return rltGroup.getId();
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
			exitGroup.setCreator_id(group.getCreator_id());
			exitGroup.setName(group.getName());
			exitGroup.setDescription(group.getDescription());
			exitGroup.setStatus(group.getStatus());
			exitGroup.setStart_date(group.getStart_date());
			exitGroup.setMountain_name(group.getMountain_name());
			exitGroup.setTotal_num(group.getTotal_num());
			exitGroup.setImage(group.getImage());
			exitGroup.setAttendee(group.getAttendee());
			exitGroup.setPoints(group.getPoints());
			exitGroup.setStart_time(group.getStart_time());
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
}

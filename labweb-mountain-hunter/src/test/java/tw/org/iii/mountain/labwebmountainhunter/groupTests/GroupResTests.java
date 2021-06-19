package tw.org.iii.mountain.labwebmountainhunter.groupTests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.mountain.labwebmountainhunter.dao.GroupRepository;
import tw.org.iii.mountain.labwebmountainhunter.entity.Group;

@SpringBootTest
public class GroupResTests {

	
	@Autowired
	private GroupRepository groupRepository;
	
	@Test
	public void testRE() {
		List<Group> group = groupRepository.findAll();
		System.out.println("ALL== "+group);
	}

}

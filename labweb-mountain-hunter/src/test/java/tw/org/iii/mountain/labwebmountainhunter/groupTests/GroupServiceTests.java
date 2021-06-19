package tw.org.iii.mountain.labwebmountainhunter.groupTests;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.mountain.labwebmountainhunter.entity.Group;
import tw.org.iii.mountain.labwebmountainhunter.service.GroupService;

@SpringBootTest
public class GroupServiceTests {

	@Autowired
	public GroupService service;
	
	@Test
	public void testService() {
		List<Group> groups = service.getGroup();
		System.out.println("all= "+groups);
	}
}

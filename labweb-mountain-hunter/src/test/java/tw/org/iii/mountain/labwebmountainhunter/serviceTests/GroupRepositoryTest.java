package tw.org.iii.mountain.labwebmountainhunter.serviceTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ch.qos.logback.core.db.BindDataSourceToJNDIAction;
import tw.org.iii.mountain.labwebmountainhunter.dao.GroupRepository;
import tw.org.iii.mountain.labwebmountainhunter.dao.UserRepository;

@SpringBootTest
public class GroupRepositoryTest {
	@Autowired
		GroupRepository group;
	
	@Test
	public void testGroupTest() {
//		System.out.println("用名字找= "+group.findByName("日出看看團"));
//		System.out.println("用query= "+group.method1(1));
		System.out.println("JoinGroups= "+group.showJoinGroups("42", "42"));
		System.out.println("IngGroups= "+group.showIngGroups("42", "42"));
		System.out.println("IngGroups= "+group.showHistoryGroups("42", "42"));

	}
	
}

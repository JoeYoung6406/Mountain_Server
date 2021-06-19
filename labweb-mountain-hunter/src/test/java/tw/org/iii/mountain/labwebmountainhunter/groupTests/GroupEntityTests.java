package tw.org.iii.mountain.labwebmountainhunter.groupTests;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.mountain.labwebmountainhunter.entity.Group;

@SpringBootTest
public class GroupEntityTests {

//	@Autowired
//	Group group;
	
	@PersistenceContext
	private Session session;
	
	@Test
	private void test() {
		Group group = session.get(Group.class, 1);
		System.out.println("Result= "+group);
	}
}

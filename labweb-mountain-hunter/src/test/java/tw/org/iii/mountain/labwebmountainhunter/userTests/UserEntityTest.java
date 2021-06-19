package tw.org.iii.mountain.labwebmountainhunter.userTests;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.mountain.labwebmountainhunter.entity.User;

@SpringBootTest
public class UserEntityTest {
	@PersistenceContext
	private Session session;
	
	@Test
	private void test() {
		User users = session.get(User.class, 1);
		System.out.println("Result= "+users);
	}
}

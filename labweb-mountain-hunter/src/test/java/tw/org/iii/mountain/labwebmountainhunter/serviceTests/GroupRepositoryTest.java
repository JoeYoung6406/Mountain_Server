package tw.org.iii.mountain.labwebmountainhunter.serviceTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.mountain.labwebmountainhunter.dao.UserRepository;

@SpringBootTest
public class GroupRepositoryTest {
	@Autowired
	UserRepository userRepository;
	@Test
	public void testUserTest() {
		System.out.println("rlt= "+userRepository.findAll());
	}
}

package tw.org.iii.mountain.labwebmountainhunter.userTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.mountain.labwebmountainhunter.service.UserService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testCha() {
//		
//		System.out.println(userService.changInfo("user123", user));
	}
}

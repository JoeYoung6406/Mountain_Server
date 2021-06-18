package tw.org.iii.mountain.labwebmountainhunter.serviceTests;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import tw.org.iii.mountain.labwebmountainhunter.dao.TodoDao;
import tw.org.iii.mountain.labwebmountainhunter.entity.Todo;
import tw.org.iii.mountain.labwebmountainhunter.service.TodoService;

@SpringBootTest
@Transactional
public class serviceTests {
	
	@Test
	void contextLoads() {
	}
	@Autowired
	private TodoDao todoDao;
	
	
	@Test
	public void getTo() {
		System.out.println("todoDao.find方法===="+todoDao.findAll());

	}
}

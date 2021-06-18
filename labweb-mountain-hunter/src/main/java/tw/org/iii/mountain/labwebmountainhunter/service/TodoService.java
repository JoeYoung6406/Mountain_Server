package tw.org.iii.mountain.labwebmountainhunter.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.Return;
import tw.org.iii.mountain.labwebmountainhunter.dao.TodoDao;
import tw.org.iii.mountain.labwebmountainhunter.entity.Todo;

@Service
public class TodoService {

	@Autowired
	TodoDao todoDao;
	//查看所有ID內容
	public List<Todo> getTodo() {
		return todoDao.findAll();
	}
	//創建新資料，回傳新創建ID號碼
	public Integer createTodo(Todo todo) {
		Todo rltTodo = todoDao.save(todo);
		return rltTodo.getId();
	}
	//使用ID尋找整筆資料
	public Todo getId(Integer id) {
		return todoDao.findById(id).orElse(null);
	}
	
	//使用帳號尋找整個ID資料
	public Todo getAccount(String account) {
		return todoDao.findByAccount(account);
	}

	
	//更新個人資料
	public Boolean updateTodo(Integer id, Todo todo) {
		Todo exitsingTodo = todoDao.findById(id).orElse(null);
		if (exitsingTodo==null) {
			return false;
		}else {
			exitsingTodo.setAccount(todo.getAccount());
			exitsingTodo.setPassword(todo.getPassword());
			exitsingTodo.setRealname(todo.getRealname());
			exitsingTodo.setBirthday(todo.getBirthday());
			exitsingTodo.setEmail(todo.getEmail());
			exitsingTodo.setTel(todo.getTel());
			todoDao.save(exitsingTodo);
			return true; 
		}
	}
	public Boolean deleteTodo(int id) {
		Todo todo = todoDao.findById(id).orElse(null);
		if (todo == null) {
			return false;
		}else {
			todoDao.deleteById(id);
			return true;
		}
	}
//	public Boolean updateTodo(Integer id, Todo todo) {
//		Optional<Todo> isExistTodo = findById(id);
//		if (!isExistTodo.isPresent()) {
//			return false;
//		}
//		Todo newTodo = isExistTodo.get();
//		if (todo.getStatus() == null) {
//			return false;
//		}
//		newTodo.setAccount(todo.getAccount());
//		newTodo.setStatus(todo.getStatus());
//		newTodo.setPassword(todo.getPassword());
//		todoDao.save(newTodo);
//	
//		return true;
//	}

	public Todo findById(Integer id) {
		return todoDao.findById(id).orElse(null);

	}

//	public Boolean deleteTodo(Integer id) {
//		Optional<Todo> findTodo = findById(id);
//		if (!findTodo.isPresent()) {
//			return false;
//		}
//		todoDao.deleteById(id);
//		return true;
//	}
}

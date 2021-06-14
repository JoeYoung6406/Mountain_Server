package tw.org.iii.mountain.labwebmountainhunter.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.mountain.labwebmountainhunter.dao.TodoDao;
import tw.org.iii.mountain.labwebmountainhunter.entity.Todo;

@Service
public class TodoService {

	@Autowired
	TodoDao todoDao;

	public Iterable<Todo> getTodo() {
		return todoDao.findAll();
	}

	public Integer createTodo(Todo todo) {
		Todo rltTodo = todoDao.save(todo);
		return rltTodo.getId();
	}

	public Boolean updateTodo(Integer id, Todo todo) {
		Optional<Todo> isExistTodo = findById(id);
		if (!isExistTodo.isPresent()) {
			return false;
		}
		Todo newTodo = isExistTodo.get();
		if (todo.getStatus() == null) {
			return false;
		}
		newTodo.setStatus(todo.getStatus());
		todoDao.save(newTodo);
		return true;
	}

	public Optional<Todo> findById(Integer id) {
		Optional<Todo> todo = todoDao.findById(id);
		return todo;
	}

	public Boolean deleteTodo(Integer id) {
		Optional<Todo> findTodo = findById(id);
		if (!findTodo.isPresent()) {
			return false;
		}
		todoDao.deleteById(id);
		return true;
	}
}

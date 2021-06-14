package tw.org.iii.mountain.labwebmountainhunter.dao;

import org.springframework.data.repository.CrudRepository;

import tw.org.iii.mountain.labwebmountainhunter.entity.Todo;



public interface TodoDao extends CrudRepository<Todo, Integer> {

}

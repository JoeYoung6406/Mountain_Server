package tw.org.iii.mountain.labwebmountainhunter.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import tw.org.iii.mountain.labwebmountainhunter.entity.Todo;



public interface TodoDao extends JpaRepository<Todo, Integer> {

	Todo findByAccount(String account);
}


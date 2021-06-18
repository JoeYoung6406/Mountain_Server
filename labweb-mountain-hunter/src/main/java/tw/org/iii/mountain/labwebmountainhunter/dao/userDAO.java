package tw.org.iii.mountain.labwebmountainhunter.dao;

import org.springframework.data.repository.CrudRepository;

import tw.org.iii.mountain.labwebmountainhunter.entity.wp_usermeta;

public interface userDAO extends CrudRepository<wp_usermeta, Integer> {

}

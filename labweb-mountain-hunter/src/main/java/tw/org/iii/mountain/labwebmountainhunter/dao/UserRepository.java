package tw.org.iii.mountain.labwebmountainhunter.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.org.iii.mountain.labwebmountainhunter.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByAccount(String account);

	User findByPassword(String password);

	@Query(value = "SELECT * FROM wp_users ORDER BY points DESC"
			, nativeQuery=true)
	List<User> showRankBypoint();
}

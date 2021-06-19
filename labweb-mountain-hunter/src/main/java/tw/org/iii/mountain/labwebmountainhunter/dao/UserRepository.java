package tw.org.iii.mountain.labwebmountainhunter.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import tw.org.iii.mountain.labwebmountainhunter.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByAccount(String account);

	User findByPassword(String password);

}

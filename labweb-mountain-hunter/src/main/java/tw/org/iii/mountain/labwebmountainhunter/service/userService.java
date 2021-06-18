package tw.org.iii.mountain.labwebmountainhunter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.mountain.labwebmountainhunter.dao.userDAO;
import tw.org.iii.mountain.labwebmountainhunter.entity.wp_usermeta;

@Service
public class userService {

	@Autowired
	userDAO userDao;
	
	public Iterable<wp_usermeta> getUser() {
		return userDao.findAll();
	}
	
	public Integer createUser(wp_usermeta user) {
		wp_usermeta rltUser =  userDao.save(user);
		return rltUser.getUmeta_id();
	}
	
	public Optional<wp_usermeta> findById(Integer Id) {
		Optional<wp_usermeta> user = userDao.findById(Id);
		return user;
	}
}

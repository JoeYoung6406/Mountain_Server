package tw.org.iii.mountain.labwebmountainhunter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tw.org.iii.mountain.labwebmountainhunter.dao.UserRepository;
import tw.org.iii.mountain.labwebmountainhunter.entity.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRe;

	public List<User> getGroup() {
		return userRe.findAll();
	}

	public User createUser(User user) {
		return userRe.save(user);
	}

	public User getUserInfoByID(Integer id) {
		return userRe.findById(id).orElse(null);
	}

	public User getUserIdByLogin(String account) {
		return userRe.findByAccount(account);
	}

	public Boolean updateUser(Integer id, User user) {
		User exitUser = userRe.findById(id).orElse(null);
		if (exitUser != null) {
			if (user.getAccount()!=null) {
				exitUser.setAccount(user.getAccount());
			};
			if (user.getPassword()!=null) {
				exitUser.setPassword(user.getPassword());
			};if(user.getUser_nickname()!=null){
				exitUser.setUser_nickname(user.getUser_nickname());
			};if (user.getUser_email() != null) {
				exitUser.setUser_email(user.getUser_email());
			};if (user.getBirth()!=null) {
				exitUser.setBirth(user.getBirth());
			};if (user.getUser_url()!=null) {
				exitUser.setUser_url(user.getUser_url());
			};if (user.getUser_registered()!=null) {
				exitUser.setUser_registered(user.getUser_registered());
			};if (user.getUser_activation_key()!=null) {
				exitUser.setUser_activation_key(user.getUser_activation_key());
			};if(user.getUser_status()!=null){
				exitUser.setUser_status(user.getUser_status());
			};if(user.getDisplay_name()!=null){
				exitUser.setDisplay_name(user.getDisplay_name());
			};if (user.getRealname()!=null) {
				exitUser.setRealname(user.getRealname());
			};if(user.getPhone()!=null){
				exitUser.setPhone(user.getPhone());
			};if (user.getPoints()!=null) {
				exitUser.setPoints(user.getPoints());
			};if (user.getCash()!=null) {
				exitUser.setCash(user.getCash());
			}userRe.save(exitUser);
			return true;
		}
		return false;
	}

	public Boolean deleteUser(Integer id) {
		User rlt = userRe.findById(id).orElse(null);
		if (rlt != null) {
			userRe.deleteById(id);
			return true;
		}
		return false;
	}

	public User findById(Integer id) {
		return userRe.findById(id).orElse(null);
	}

	public Boolean changInfo(String account, User user) {
		
		User rlt = userRe.findByAccount(account);
		if (rlt != null) {
			rlt.setPassword(user.getPassword());
			userRe.save(user);
			return true;
		}return false;
	}
	
	public User getInfoByPassword(String password) {
		return userRe.findByPassword(password);
	}
	public List<User> showRank() {
		return userRe.showRankBypoint();
	}
}

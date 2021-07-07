package tw.org.iii.mountain.labwebmountainhunter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.org.iii.mountain.labwebmountainhunter.entity.Group;
import tw.org.iii.mountain.labwebmountainhunter.service.GroupService;

@RestController
@RequestMapping("/api")
public class GroupController {

	@Autowired
	GroupService Gservice;

	// 找出所有資料
	@GetMapping("/groups")
	public ResponseEntity getAllGroup() {
		List<Group> groups = Gservice.getGroup();
		return ResponseEntity.status(HttpStatus.OK).body(groups);
	}

	//找出單個id資料
	@GetMapping("/groups/{id}")
	public ResponseEntity findGroup(@PathVariable Integer id) {
		if (Gservice.findById(id) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(Gservice.findById(id));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("請輸入正確ID");
	}

	//藉由名稱找出整筆資料
	@GetMapping("/groups/name")
	public ResponseEntity findInfoByName(@RequestBody Group group) {
		 if (Gservice.getInfoByName(group) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(Gservice.getInfoByName(group));
		}return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No this Info.");
	}
	
	//新增資料
	@PostMapping("/groups")
	public ResponseEntity createGroup(@RequestBody Group group) {
		return ResponseEntity.status(HttpStatus.OK).body(Gservice.createGroup(group));
	}
	
	//更新資料
	@PutMapping("/groups/{id}")
	public ResponseEntity updateGroup(@PathVariable Integer id , @RequestBody Group group) {
		if (Gservice.updateGroup(id, group)) {
			return ResponseEntity.status(HttpStatus.OK).body("Success Update!");
		} return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Try Again!");
	}
	
	//依據id刪除資料 
	@DeleteMapping("/groups/{id}")
	public ResponseEntity deleteGroup(@PathVariable Integer id) {
		if (Gservice.deleteGroup(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Delete Success!");
		} return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faild!");
	}
	
	//顯示正在參加的團
	@GetMapping("/groups/ing/{id}")
	public ResponseEntity showIngGroups(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(Gservice.showIngGroups(id));
	}
	//顯示未參加的團
	@GetMapping("groups/join/{id}")
	public ResponseEntity showJoinGroups(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(Gservice.showJoinGroups(id));
	}
	//顯示歷史任務團
	@GetMapping("groups/his/{id}")
	public ResponseEntity showHistory(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(Gservice.showHistoryGroups(id));
	}
}

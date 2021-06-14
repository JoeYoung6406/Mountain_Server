package tw.org.iii.mountain.labwebmountainhunter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tw.org.iii.mountain.labwebmountainhunter.Person;

@Controller
public class appController {

	@GetMapping(path = "/hello")
	public String hello(Model model) {
		model.addAttribute("hello", "Hello World");
		
		return "hello";
	}
	
	@GetMapping("/person")
	public String showGender(Model model) {
		model.addAttribute("gender", "female");
		
		return "person";
	}
	@GetMapping("/list")
	public String listNumber(Model model) {
		List<String> list = new ArrayList<>();
		for(int i = 0 ; i<=10; i++) {
			list.add("This is ArrayList" + i);
		}
		model.addAttribute("list",list);
		return "list";
	}
	
	 @GetMapping("/form")
	    public String form(Model model) {
	        Person person = new Person(); // 將Person 實體化
	        model.addAttribute("person", person);
	        return "form"; // 導至form.html
	    }
	 
	 @PostMapping("/add")
	    public String add(@ModelAttribute Person person, Model model) {
	        model.addAttribute("person", person);
	        return "add";
	    }
	 
	
}

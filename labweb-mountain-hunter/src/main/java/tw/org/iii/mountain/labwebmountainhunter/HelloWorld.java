package tw.org.iii.mountain.labwebmountainhunter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@RequestMapping(path = "/lab")
	public String name() {
		return "Hello World haha";
	}
}

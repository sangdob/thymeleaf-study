package hello.thymeleaf.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/basic/")
public class BasicController {

	@GetMapping
	public String mainPage(){
		return "index";
	}

	@GetMapping("text-basic")
	public String textBasic(Model model){
		model.addAttribute("data","basicTest");
		return "basic/text-basic";
	}

	@GetMapping("text-unescaped")
	public String textUnescaped(Model model){
		model.addAttribute("data", "Hello <b>Spring!</b>");		return "basic/text-unescaped";
	}

	@GetMapping("variable")
	public String variable(Model model) {
		User user1 = new User("userA", 10);
		User user2 = new User("userB", 20);

		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);

		Map<String, User> map = new HashMap<>();
		map.put("userA", user1);
		map.put("userB", user2);

		model.addAttribute("user", user1);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);

		return "basic/variable";
	}

	@GetMapping("basic-objects")
	public String basicObjects(HttpSession session) {
		session.setAttribute("sessionData", "hello Session");

		return "basic/basic-objects";
	}

	@Component("helloBean")
	static class HelloBean {
		public String hello(String data){
			return "hello" + data;
		}
	}


}

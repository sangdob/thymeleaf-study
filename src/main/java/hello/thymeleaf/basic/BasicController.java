package hello.thymeleaf.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

package wcci.spring.jpalibrary;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public class BookController {
	public String books(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "books";
	}
}
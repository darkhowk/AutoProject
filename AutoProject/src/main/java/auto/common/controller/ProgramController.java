package auto.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "program")
public class ProgramController {


	@RequestMapping(value = "searchList", method = { RequestMethod.POST, RequestMethod.GET })
	public String site(Model model) {
		return "program/searchList";
	}
}

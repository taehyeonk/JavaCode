package kr.or.kfq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.kfq.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	MyService service;
	
	@RequestMapping(value="/totalCount")
	public String getTotalCount(Model model) {
		model.addAttribute("totalCount", service.getTotalCount());
		return "totalCount";
	}

}

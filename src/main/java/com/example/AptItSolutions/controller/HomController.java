package com.example.AptItSolutions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "about";
	}
	
	
	@GetMapping("/download")
	public String download() {
		return "download";
	}

	@GetMapping("/training")
	public String training() {
		return "training";
	}

	@GetMapping("/products")
	public String products() {
		return "products";
	}
	
	@GetMapping("/service")
	public String service() {
		return "service";
	}

	@GetMapping("/solution")
	public String solution() {
		return "solution";
	}

	@GetMapping("/careers")
	public String careers() {
		return "careers";
	}

	@GetMapping("/news")
	public String news() {
		return "news";
	}

	@GetMapping("/gallery")
	public String gallery() {
		return "gallery";
	}
	
	
	@GetMapping("/galleryform")
	public String galleryform() {
		return "galleryform";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contactus";
	}

	@GetMapping("/web")
	public String web() {
		return "web";
	}

	@GetMapping("/ecommerce")
	public String ecommerce() {
		return "ecommerce";
	}

	@GetMapping("/digital")
	public String digital() {
		return "digital";
	}

	@GetMapping("/hr")
	public String hr() {
		return "hr";
	}

	//

	@GetMapping("/wedesign")
	public String wedesign() {
		return "wedesign";
	}

	@GetMapping("/payment")
	public String payment() {
		return "payment";
	}

	@GetMapping("/refund")
	public String refund() {
		return "refund";
	}

	@GetMapping("/newsandevents")
	public String newsandevents() {
		return "newsandevents";
	}

	@GetMapping("/termsandcondition")
	public String termsandcondition() {
		return "termsandcondition";
	}

	@GetMapping("/business")
	public String business() {
		return "business";
	}
	
	
	@GetMapping("/applicationform")
	public String applicationform() {
		return "applicationform";
	}

	//

	@GetMapping("/realapt")
	public String realapt() {
		return "realapt";
	}

	@GetMapping("/aptcms")
	public String aptcms() {
		return "aptcms";
	}

	@GetMapping("/aptlms")
	public String aptlms() {
		return "aptlms";
	}

	@GetMapping("/apttest")
	public String apttest() {
		return "apttest";
	}

	@GetMapping("/aptlib")
	public String aptlib() {
		return "aptlib";
	}

	@GetMapping("/privacy")
	public String privacy() {
		return "privacy";
	}

	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	
	
	
	@GetMapping("/adminDashboard")
	public String adminDashboard() {
		return "admindashboard";
	}
	
	
	
	@GetMapping("/addnewnews")
	public String addnewnews() {
		return "addnewnews";
	}
	
	
	@GetMapping("/addnewcareers")
	public String addnewcareers() {
		return "addnewcareers";
	}
	
	
	@GetMapping("/scrollform")
	public String scrollform() {
		return "scrollform";
	}
	
	
	

	@GetMapping("/editscrollform")
	public String editscrollform() {
		return "editscrollform";
	}
	

	@GetMapping("/editnewsform")
	public String editnewsform() {
		return "editnewsform";
	}
	
	

	@GetMapping("/editjobopeningform")
	public String editjobopeningform() {
		return "editjobopeningform";
	}
	
	
	@GetMapping("/editimage")
	public String editimage() {
		return "editimage";
	}
	

	@GetMapping("/navbar")
	public String navbar() {
		return "navbar";
	}
	
	@GetMapping("/error401")
	public String error401() {
		return "401";
	}
	
	@GetMapping("/Configuration")
	public String Configuration() {
		return "Configuration";
	}
}
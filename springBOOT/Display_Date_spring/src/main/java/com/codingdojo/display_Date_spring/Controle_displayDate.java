package com.codingdojo.display_Date_spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controle_displayDate {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat format_date = new SimpleDateFormat("EEEE, MMM d, yyyy");
		Date date = new Date();
		model.addAttribute("date", format_date.format(date));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat format_time = new SimpleDateFormat("h:mm a");
		
		Date date = new Date();
		
		model.addAttribute("time", format_time.format(date));
		
		return "time.jsp";
	}

}

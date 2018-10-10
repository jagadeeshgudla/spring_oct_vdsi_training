package com.demo.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping(path="/greet/{user}/{location}",method=RequestMethod.GET,produces="text/plain")
	public String greet(@PathVariable("user") String user,@PathVariable("location") String location,@RequestParam String worldName) {
		return "Hello "+user+" weclome to the "+worldName+" "+location;
	}
	
}

package org.gj.demo.web;

import org.gj.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@CrossOrigin
public class DemoController {
	@Autowired
	DemoService demoService;
	@RequestMapping("/start")
	@ResponseBody
	public String start() {
		//demoService.start();
		return "ok";
	}
	@RequestMapping("/addoperator")
	@ResponseBody
	public String addoperator() {
		//demoService.start();
		return "ok";
	}
	@RequestMapping("/updateoperator")
	@ResponseBody
	public String updateoperator() {
		//demoService.start();
		return "ok";
	}
	@RequestMapping("/removeoperator")
	@ResponseBody
	public String removeoperator() {
		//demoService.start();
		return "ok";
	}
}

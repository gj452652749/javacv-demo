package org.gj.demo.web;

import java.io.IOException;
import java.util.List;

import org.gj.context.AppContext;
import org.gj.demo.dao.DemoDao;
import org.gj.demo.vo.OperatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@CrossOrigin(origins = "*", maxAge = 3600) 
public class DemoController {
	@Autowired
	DemoDao demoDao;
	@Autowired
	AppContext appContext;
	@RequestMapping("/start")
	@ResponseBody
	public String start() {
		//demoService.start();
		return "ok";
	}
	@RequestMapping(value="/addoperator/{index}", method = RequestMethod.POST)
	@ResponseBody
	public String addOperator(@PathVariable(value = "index") int index, @RequestBody OperatorRequest activedOperator) {
		System.out.println(index+activedOperator.toString());
		//demoDao.getOperatorChain().add(index, activedOperator);
		return "{\"code\":0}";
	}
	//要加上post，默认为get，否则前端回报跨域错误，实际上是404
	@RequestMapping(value ="/updateoperator/{index}", method = RequestMethod.POST)
	@ResponseBody
	public String updateOperator(@PathVariable(value = "index") int index, @RequestBody OperatorRequest activedOperator) {
		//demoService.start();
		System.out.println(index+activedOperator.toString());
		//demoDao.getOperatorChain().set(index, activedOperator);
		return "{\"code\":0}";
	}
	@RequestMapping(value ="/updateoperatorchain/{version}", method = RequestMethod.POST)
	@ResponseBody
	public String updateOperatorChain(@PathVariable(value = "version") int version,@RequestBody List<OperatorRequest> operatorReqs) throws IOException {
		//demoService.start();
		System.out.println("version:"+version+" "+operatorReqs.size()+
				operatorReqs.get(operatorReqs.size()-1).toString());
		appContext.getVersion().set(version);
		demoDao.doOperator(operatorReqs);
		return "{\"code\":0}";
	}
	@RequestMapping("/removeoperator/{index}")
	@ResponseBody
	public String removeOperator(@PathVariable(value = "index") int index) {
		System.out.println("remove:"+index);
		demoDao.getOperatorChain().remove(index);
		return "{\"code\":0}";
	}
}

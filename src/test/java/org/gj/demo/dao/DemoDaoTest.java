package org.gj.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.gj.demo.vo.OperatorRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDaoTest {
	@Autowired
	DemoDao demoDao;
	@Test
	public void doOperator() {
		List<OperatorRequest> operatorReqs=new ArrayList<OperatorRequest>();
		operatorReqs.add(new OperatorRequest("gamma","1", 50));
		operatorReqs.add(new OperatorRequest("canny","1", 50));
		demoDao.doOperator(operatorReqs);
	}

}

package com.du;

import com.du.controll.ManagerControll;
import com.du.dao.ManagerMapper;
import com.du.entry.Emaile_M;
import com.du.service.Email_MService;
import com.du.service.StudentUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoserbackApplicationTests {

	@Test
	public void contextLoads() {
		/*Emaile_M emaile_m=new Emaile_M(1,"ssss","qw","sffsasdas");

		System.out.println(emaile_m.toString());
		Email_MService email_mService=new Email_MService();
		email_mService.sendemail(emaile_m);*/
		System.out.println(System.nanoTime());


	}

}

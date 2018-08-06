package com.project.polling;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.polling.models.db.Option;
import com.project.polling.models.db.Polling;
import com.project.polling.models.db.UserOption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollingApplicationTests {
	
	
	@Test
	public void testAssertNotNull(){
		assertNotNull("should not be null", new Polling());
		assertNotNull("should not be null", new UserOption());
		assertNotNull("should not be null", new Option());
	}
	
	
}

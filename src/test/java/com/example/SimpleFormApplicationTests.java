package com.example;

import com.example.model.State;
import com.example.repository.StateRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleFormApplicationTests {

	@Autowired
	StateRepo stateRepo;

	@Test
	public void contextLoads() {
		State state1 = new State();
		state1.setName("SP");
		stateRepo.save(state1);
	}

}

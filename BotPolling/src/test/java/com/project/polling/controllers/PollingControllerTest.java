package com.project.polling.controllers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.polling.ConstantMessage;
import com.project.polling.models.db.Option;
import com.project.polling.models.db.OptionRepository;
import com.project.polling.models.db.Polling;
import com.project.polling.models.db.PollingRepository;
import com.project.polling.models.db.UserOptionRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PollingControllerTest {
	@Mock
	PollingRepository pRepository;
	@Mock
	OptionRepository oRepository;
	@Mock
	UserOptionRepository uRepository;
	@Mock
	KaskusController kController;
	@Mock
	MessageController mController;
	
	PollingController pollingController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		pollingController = new PollingController();
		pollingController.setkController(kController);
		pollingController.setmController(mController);
		pollingController.setoRepository(oRepository);
		pollingController.setpRepository(pRepository);
		pollingController.setuRepository(uRepository);
	}
	
	@Test
	public void showPollingTest(){
		String id = "123";
		List<String> teks = new ArrayList<>();
		when(pRepository.findTopByOrderByIdDesc()).thenReturn(new Polling("123","Tes","","Tes"));
		pollingController.showPolling(id);
		verify(kController,times(1)).sendButton(id, "123:\n", teks);
	}
	
	@Test
	public void turnOffPollingTest_Succeeded(){
		String id = "123";
		String author = "Tes";
		when(pRepository.findTopByOrderByIdDesc()).thenReturn(new Polling("123","Tes","","Tes"));
		pollingController.turnOffPolling(id, author);
		verify(kController,times(1)).sendMessageText(id, ConstantMessage.TURN_OFF_POLLING);
	}
	
	@Test
	public void insertOptionTest_Succeeded(){
		String id = "123";
		String text = "Tes";
		String author = "Tes";
		when(pRepository.findTopByOrderByIdDesc()).thenReturn(new Polling(id,text,"",author));
		when(oRepository.findOptionByOptionNameAndPolling(any(String.class), any(Polling.class))).
		thenReturn(new Option("123", 0, new Polling("123","Tes","","Tes")));
		pollingController.insertOption(id, text, author);
		verify(kController,times(1)).sendMessageText(id, ConstantMessage.COMPLETED_INSERTION);
	}
	
}

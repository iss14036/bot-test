package com.project.polling.controllers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.polling.Constant;
import com.project.polling.ConstantMessage;
import com.project.polling.models.db.OptionRepository;
import com.project.polling.models.db.Polling;
import com.project.polling.models.db.PollingRepository;

public class MessageControllerTest {
	@Mock
	KaskusController kController;
	
	@Mock
	PollingRepository pRepository;
	
	@Mock
	OptionRepository oRepository;
	
	@Mock
	PollingController pollingController;
	
	MessageController messageController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		messageController = new MessageController(); 	
		messageController.setkController(kController);
		messageController.setPollingController(pollingController);
		messageController.setoRepository(oRepository);
		messageController.setpRepository(pRepository);
	}
	
	@Test
	public void testMakeNamePolling_sendWarning(){
		String id = "1";
		String text = "text";
		String author = "aaa";
		messageController.makeNamePolling(id, text, author);
		verify(kController,times(1)).sendMessageText(id, ConstantMessage.VALIDATION_WARN);
	}
	
	@Test
	public void testMakeNamePolling_Succeeded(){
		String id = "1";
		String text = "text";
		String author = "aaa";
		messageController.makeNamePolling(id, text, author);
		when(pRepository.save(any(Polling.class))).thenReturn(new Polling(id,author,"",Constant.ACTIVE));
		verify(kController,times(1)).sendMessageText(id, ConstantMessage.INPUT_OPTION_POLLING);
	}
	
	@Test
	public void testMakeOptionPolling_sendWarning(){
		String id = "1";
		String text = "text";
		String author = "aaa";
		messageController.makeOptionPolling(id, text, author);
		when(pRepository.findTopByOrderByIdDesc()).thenReturn(new Polling());
		verify(kController,times(1)).sendMessageText(id, ConstantMessage.VALIDATION_WARN);
		verify(pRepository, times(0)).findTopByOrderByIdDesc();
	}
	
	@Test
	public void testMakeOptionPolling_Succeeded(){
		String id = "1";
		String text = "text";
		String author = "Tes";
		messageController.makeOptionPolling(id, text, author);
		when(pRepository.findTopByOrderByIdDesc()).thenReturn(new Polling());
		verify(pollingController,times(1)).showPolling(id);
	}
	
	
}

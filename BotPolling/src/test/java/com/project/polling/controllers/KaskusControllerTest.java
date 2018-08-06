package com.project.polling.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.project.polling.Constant;
import com.project.polling.models.kaskus.KaskusSendList;

public class KaskusControllerTest {
	@Mock
	RestTemplate restTemplate;
	@Mock
	MessageController mController;
	
	KaskusController kaskusController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		kaskusController = new KaskusController();
		kaskusController.setmController(mController);
		kaskusController.setRestTemplate(restTemplate);
	}
	
	@Test
	public void sendMessageTextTest(){
		String id = "123";
		String text = "tes";
		List<KaskusSendList> kSendLists = new ArrayList<>();
		KaskusSendList kSendList = new KaskusSendList(id, text);
		kSendLists.add(kSendList);
		kaskusController.sendMessageText(id, text);
	}
	
	public HttpHeaders setHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, Constant.ACCESS_PAGE);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		return headers;
	}
}

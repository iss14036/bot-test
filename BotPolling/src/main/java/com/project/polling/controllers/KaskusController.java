package com.project.polling.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.polling.Constant;
import com.project.polling.ConstantMessage;
import com.project.polling.models.kaskus.Kaskus;
import com.project.polling.models.kaskus.KaskusBody;
import com.project.polling.models.kaskus.KaskusButton;
import com.project.polling.models.kaskus.KaskusInteractive;
import com.project.polling.models.kaskus.KaskusList;
import com.project.polling.models.kaskus.KaskusListButton;
import com.project.polling.models.kaskus.KaskusSend;
import com.project.polling.models.kaskus.KaskusSendButton;
import com.project.polling.models.kaskus.KaskusSendInteractive;
import com.project.polling.models.kaskus.KaskusSendList;

@RestController
public class KaskusController {
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	MessageController mController;

	@RequestMapping("/kaskus")
	public String getResponse(HttpServletRequest request) {
		return null;
	}

	@RequestMapping(value = "/kaskus", method = RequestMethod.POST)
	public void receiveMessage(@RequestBody Kaskus kaskus) {
		try {
			System.out.println(mapper.writeValueAsString(kaskus));
		} catch (JsonProcessingException e) {
			e.printStackTrace();// hapus
		}
		String id = kaskus.getFromPlain() + Constant.DOMAIN_KASKUS;
		String text = kaskus.getBody().toLowerCase();
		int slash = kaskus.getFrom().indexOf("/");
		String author = kaskus.getFrom().substring(slash + 1, kaskus.getFrom().length());
		mController.processMessage(id, text, author);// ganti
	}

	public void sendMessageText(String id, String text) {
		List<KaskusSendList> kSendLists = new ArrayList<>();
		KaskusSendList kSendList = new KaskusSendList(id, text);
		kSendLists.add(kSendList);
		KaskusSend kaskusSend = new KaskusSend(Constant.ID_BOT, kSendLists);
		try {
			System.out.println(mapper.writeValueAsString(kaskusSend));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpHeaders headers = setHeader();
		HttpEntity<KaskusSend> entity1 = new HttpEntity<>(kaskusSend, headers);

		restTemplate.postForEntity(Constant.KASKUS_API, entity1, String.class);
	}

	public void sendButton(String id, String title, List<String> text) {
		List<KaskusButton> buttons = new ArrayList<>();
		text.stream().forEach(result -> {
			KaskusButton button = new KaskusButton(result, result, Constant.RECIPIENT);
			buttons.add(button);
		});
		List<KaskusInteractive> interactives = new ArrayList<>();
		KaskusInteractive interactive = new KaskusInteractive(title, buttons);
		interactives.add(interactive);
		KaskusBody body = new KaskusBody(interactives);
		List<KaskusListButton> sendLists = new ArrayList<>();
		KaskusListButton sendList = new KaskusListButton(id, body);
		sendLists.add(sendList);
		KaskusSendButton kaskusSend = new KaskusSendButton(Constant.ID_BOT, sendLists);
		HttpHeaders headers = setHeader();
		HttpEntity<KaskusSendButton> entity1 = new HttpEntity<>(kaskusSend, headers);
		try {
			System.out.println(mapper.writeValueAsString(kaskusSend));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> result = restTemplate.postForEntity(Constant.KASKUS_API, entity1, String.class);
		System.out.println(result.getStatusCode());
		System.out.println(result.getBody());
	}

	public void sendGuide(String id) {
		KaskusButton buttonGuide = new KaskusButton(Constant.GUIDE, Constant.GUIDE, Constant.SHOW_RECIPIENT);
		List<KaskusButton> buttons = new ArrayList<>();
		buttons.add(buttonGuide);
		List<KaskusInteractive> kInteractives = new ArrayList<>();
		KaskusInteractive kInteractive = new KaskusInteractive(buttons, Constant.WELCOME_IMAGE, ConstantMessage.VAPO,
				ConstantMessage.VAPO_REAL);
		kInteractives.add(kInteractive);
		KaskusBody kBody = new KaskusBody(kInteractives);
		List<KaskusList> kSendLists = new ArrayList<>();
		KaskusList kSendList = new KaskusList(id, kBody);
		kSendLists.add(kSendList);
		KaskusSendInteractive kSendInteractive = new KaskusSendInteractive(Constant.ID_BOT, kSendLists,
				ConstantMessage.VAPO, Constant.PLACEHOLDER);
		HttpHeaders headers = setHeader();
		HttpEntity<KaskusSendInteractive> entityOptionButton = new HttpEntity<>(kSendInteractive, headers);
		try {
			System.out.println(mapper.writeValueAsString(kSendInteractive));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> result = restTemplate.postForEntity(Constant.KASKUS_API, entityOptionButton,
				String.class);
		System.out.println(result.getStatusCode());
		System.out.println(result.getBody());
	}

	public HttpHeaders setHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, Constant.ACCESS_PAGE);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		return headers;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setmController(MessageController mController) {
		this.mController = mController;
	}
	
}

package com.project.polling.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.polling.Constant;
import com.project.polling.ConstantMessage;
import com.project.polling.models.db.Option;
import com.project.polling.models.db.OptionRepository;
import com.project.polling.models.db.Polling;
import com.project.polling.models.db.PollingRepository;
import com.project.polling.models.db.State;
import com.project.polling.models.db.StateRepository;
import com.project.polling.models.db.UserOptionRepository;

@Service
public class MessageController {
	@Autowired
	PollingRepository pRepository;
	@Autowired
	OptionRepository oRepository;
	@Autowired
	UserOptionRepository uRepository;
	@Autowired
	KaskusController kController;
	@Autowired
	PollingController pollingController;
	@Autowired
	StateRepository sRepository;

	public void processMessage(String id,String text,String author){
		Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
		if(polling != null){
			pollingController.processMessagePolling(id, text,author);
		}
		else if(text.equalsIgnoreCase(ConstantMessage.POLLING_CREATE) 
				&& polling == null){
			sendRequestValidation(id);
			State state = new State(id, author, Constant.POLLING);
			sRepository.save(state);
		}
		else if(text.equalsIgnoreCase(ConstantMessage.CANCEL) 
				&& sRepository.findStateByIdGroup(id).getIdUser().equalsIgnoreCase(author)){
			turnOffPollingCreate(id);
		}
		else if(text.equalsIgnoreCase(Constant.HELP) || text.equalsIgnoreCase(Constant.GUIDE)){
			kController.sendMessageText(id, ConstantMessage.HELP);
		}
		else if(text.equalsIgnoreCase(ConstantMessage.POLLING)){
			kController.sendGuide(id);
		}
		else{
			cekState(id,text,author);
		}
	}
	
	public void cekState(String id,String text,String author){
		try{
			State state = sRepository.findStateByIdGroup(id);
			if(state.getStateDescription().equalsIgnoreCase(Constant.POLLING)){
				validationPolling(id,text,author);
			}
			else if(state.getStateDescription().equalsIgnoreCase(Constant.INPUT_NAME_POLLING)){
				makeNamePolling(id,text,author);
			}
			else if(state.getStateDescription().equalsIgnoreCase(Constant.INPUT_OPTION_POLLING)){
				makeOptionPolling(id,text,author);
			}
			else{
				cekSyntax(id,text);
			}
		}catch(NullPointerException ie){
			
		}
	}
	
	public void cekSyntax(String id,String text){
		if(text.equalsIgnoreCase(Constant.POLLING_SHOW)
				|| text.equalsIgnoreCase(Constant.POLLING_RESULT)
				|| text.equalsIgnoreCase(ConstantMessage.POLLING_OFF)){
			kController.sendMessageText(id, ConstantMessage.EMPTY_POLLING);
		}
	}
	
	
	public void makeNamePolling(String id,String text,String author){
		State state = sRepository.findStateByIdGroup(id);
		if(!author.equalsIgnoreCase(state.getIdUser())){
			kController.sendMessageText(id, ConstantMessage.VALIDATION_WARN);
		}
		else{
			Polling polling = new Polling(text, author, id, Constant.PENDING);
			pRepository.save(polling);
			state.setStateDescription(Constant.INPUT_OPTION_POLLING);
			sRepository.save(state);
			kController.sendMessageText(id, ConstantMessage.INPUT_OPTION_POLLING);
		}
	}
	
	public void makeOptionPolling(String id,String text,String author){
		State state = sRepository.findStateByIdGroup(id);
		if(!author.equalsIgnoreCase(state.getIdUser())){
			kController.sendMessageText(id, ConstantMessage.VALIDATION_WARN);
		}
		else{
			Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.PENDING);
			String dataOption[] = text.split(",");
			List<Option> options = new ArrayList<>();
			for(int i=0; i<dataOption.length; i++){
				Option option = new Option(dataOption[i], 0, polling);
				options.add(option);
			}
			polling.setStatusPolling(Constant.ACTIVE);
			pRepository.save(polling);
			oRepository.save(options);
			state.setStateDescription(Constant.NONE);
			sRepository.save(state);
			pollingController.showPolling(id);
		}
	}
	
	public void validationPolling(String id,String text,String author){
		State state = sRepository.findStateByIdGroup(id);
		if(!author.equalsIgnoreCase(state.getIdUser())){
			kController.sendMessageText(id, ConstantMessage.VALIDATION_WARN);
		}
		else if(text.equalsIgnoreCase(Constant.YA)){
			state.setStateDescription(Constant.INPUT_NAME_POLLING);
			sRepository.save(state);
			kController.sendMessageText(id,ConstantMessage.INPUT_NAMA_POLLING);
		}
		else if(text.equalsIgnoreCase(Constant.TIDAK)){
			turnOffPollingCreate(id);
		}
		else{
			kController.sendMessageText(id,ConstantMessage.AMBIGUOUS_MESSAGE);
		}
	}
	
	public void sendRequestValidation(String id){
		List<String> texts = new ArrayList<>();
		String text1 = Constant.YA;
		String text2 = Constant.TIDAK;
		texts.add(text1);
		texts.add(text2);
		kController.sendButton(id, ConstantMessage.REQUEST_POLLING, texts);
	}
	
	public void turnOffPollingCreate(String id){
		try{
			Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
			polling.setStatusPolling(Constant.NON_ACTIVE);
		}
		catch(NullPointerException ie){
		}
		finally{
			State state = sRepository.findStateByIdGroup(id);
			state.setStateDescription(Constant.NONE);
			sRepository.save(state);
			kController.sendMessageText(id, ConstantMessage.CANCEL_POLLING);
		}
	}

	public void setuRepository(UserOptionRepository uRepository) {
		this.uRepository = uRepository;
	}
	
	public void setpRepository(PollingRepository pRepository) {
		this.pRepository = pRepository;
	}

	public void setkController(KaskusController kController) {
		this.kController = kController;
	}

	public void setoRepository(OptionRepository oRepository) {
		this.oRepository = oRepository;
	}

	public void setPollingController(PollingController pollingController) {
		this.pollingController = pollingController;
	}
}

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
import com.project.polling.models.db.UserOption;
import com.project.polling.models.db.UserOptionRepository;

@Service
public class PollingController {
	@Autowired
	PollingRepository pRepository;
	@Autowired
	OptionRepository oRepository;
	@Autowired
	UserOptionRepository uRepository;
	@Autowired
	KaskusController kController;
	@Autowired
	MessageController mController;
	
	
	public void processMessagePolling(String id, String text,String author){
		Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
		if(text.equalsIgnoreCase(ConstantMessage.POLLING_CREATE)){
			if(polling != null){
				kController.sendMessageText(id, ConstantMessage.WARN_POLLING_ACTIVE);
			}
		}
		else if(text.equalsIgnoreCase(ConstantMessage.POLLING_OFF)){
			turnOffPolling(id,author);
		}
		else if(text.equalsIgnoreCase(Constant.HELP)){
			kController.sendMessageText(id, ConstantMessage.HELP);
		}
		else if(text.equalsIgnoreCase(Constant.POLLING_SHOW)){
			showPolling(id);
		}
		else if(text.equalsIgnoreCase(Constant.POLLING_RESULT)){
			showResultPolling(id);
		}
		else{
			insertOption(id,text,author);
		}
	}
	
	public void showPolling(String id){
		List<String> texts = new ArrayList<>(); 
		Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
		String title = polling.getNamePolling()+"\n";
		List<Option> options = oRepository.findAllOptionByPolling(polling);
		for(int i=0; i<options.size(); i++){
			texts.add(options.get(i).getOptionName());
		}
		kController.sendButton(id, title, texts);
	}
	
	public void turnOffPolling(String id,String author){
		Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
		if(author.equalsIgnoreCase(polling.getAuthorPolling())){
			polling.setStatusPolling(Constant.NON_ACTIVE);
			pRepository.save(polling);
			kController.sendMessageText(id, ConstantMessage.TURN_OFF_POLLING);
		}
		else{
			kController.sendMessageText(id, ConstantMessage.UNMATCHED_AUTHOR);
		}
	}
	
	public void showResultPolling(String id){
		String text = null;
		Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
		text = polling.getNamePolling()+":\n";
		List<Option> options = oRepository.findAllOptionByPolling(polling);
		for(int i=1; i<=options.size(); i++){
			text+=(i+". ")+options.get(i-1).getOptionName()+"	: "+options.get(i-1).getOptionResult()+" Orang\n";
		}
		kController.sendMessageText(id, text);
	}
	
	public void insertOption(String id,String text,String author){
		Polling polling = pRepository.findPollingByGroupPollingAndStatusPolling(id, Constant.ACTIVE);
		Option option = oRepository.findOptionByOptionNameAndPolling(text, polling);
		if(option!=null){
			UserOption userOption = uRepository.findByUserIdAndPolling(author, polling);
			if(userOption==null){
				UserOption uOption = new UserOption(author, option.getOptionName(), polling);
				option.setOptionResult(option.getOptionResult()+1);
				uRepository.save(uOption);
				oRepository.save(option);
				kController.sendMessageText(id, ConstantMessage.COMPLETED_INSERTION);
			}
			else{
				kController.sendMessageText(id, ConstantMessage.CANCELED_INSERTION);
			}
		}
	}

	public void setpRepository(PollingRepository pRepository) {
		this.pRepository = pRepository;
	}

	public void setoRepository(OptionRepository oRepository) {
		this.oRepository = oRepository;
	}

	public void setuRepository(UserOptionRepository uRepository) {
		this.uRepository = uRepository;
	}

	public void setkController(KaskusController kController) {
		this.kController = kController;
	}

	public void setmController(MessageController mController) {
		this.mController = mController;
	}
	
	
}

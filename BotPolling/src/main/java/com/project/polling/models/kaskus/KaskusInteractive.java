package com.project.polling.models.kaskus;

import java.util.List;

public class KaskusInteractive {
	private List<KaskusButton> buttons;
	private String image;
	private String title;
	private String caption;
	
	public KaskusInteractive(String title,List<KaskusButton> buttons) {
		super();
		this.title = title;
		this.buttons = buttons;
	}
	public KaskusInteractive(List<KaskusButton> buttons, String image, String title, String caption) {
		super();
		this.buttons = buttons;
		this.image = image;
		this.title = title;
		this.caption = caption;
	}
	public KaskusInteractive() {
		super();
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public List<KaskusButton> getButtons() {
		return buttons;
	}

	public void setButtons(List<KaskusButton> buttons) {
		this.buttons = buttons;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}

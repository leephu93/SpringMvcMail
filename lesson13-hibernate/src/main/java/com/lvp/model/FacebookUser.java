package com.lvp.model;

import com.restfb.Facebook;

public class FacebookUser {

	@Facebook("id")
	private String id;

	@Facebook("name")
	private String name;

	@Facebook("email")
	private String email;

	@Facebook("picture")
	private String picture;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}

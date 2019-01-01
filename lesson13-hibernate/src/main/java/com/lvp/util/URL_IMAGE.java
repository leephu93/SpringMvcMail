package com.lvp.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class URL_IMAGE {

	public static String getURL_FB(String json_picture) {
		ObjectMapper mapper = new ObjectMapper();
		String url = "";
		try {
			url = mapper.readTree(json_picture).get("data").get("url").toString().replaceAll("\"", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

}

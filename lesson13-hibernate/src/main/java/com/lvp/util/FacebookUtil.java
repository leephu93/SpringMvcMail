package com.lvp.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvp.config.Constants;
import com.lvp.model.FacebookUser;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
//import com.restfb.types.User;

public class FacebookUtil {

	public static String getToken(final String code) throws ClientProtocolException, IOException {
		String link = String.format(Constants.FACEBOOK_LINK_GET_TOKEN, Constants.FACEBOOK_APP_ID,
				Constants.FACEBOOK_APP_SECRET, Constants.FACEBOOK_REDIRECT_URL, code);
		String response = Request.Get(link).execute().returnContent().toString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
		return node.textValue();
	}

	public static FacebookUser getUserInfo(final String accessToken) {
		FacebookClient FU = new DefaultFacebookClient(accessToken, Constants.FACEBOOK_APP_SECRET, Version.LATEST);
		return FU.fetchObject("me", FacebookUser.class, Parameter.with("fields", "id, name, email, picture"));
	}

}

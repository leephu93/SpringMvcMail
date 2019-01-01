package com.lvp.config;

public class Constants {
	
	// FACEBOOK
	public static String FACEBOOK_APP_ID = "2270798753194391";
	public static String FACEBOOK_APP_SECRET = "7970b59fe80a7e122f883e08b090c0b4";
	public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/lesson13-hibernate/auth/facebook";
	public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
	// GOOGLE
	public static String GOOGLE_CLIENT_ID = "737176525344-iuad7rinph1rt8ulm0vlk28r5njuk6g1.apps.googleusercontent.com";
	public static String GOOGLE_CLIENT_SECRET = "ced6ZWNNDNKBRQw74iyIhAgr";
	public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/lesson13-hibernate/auth/google";
	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	public static String GOOGLE_GRANT_TYPE = "authorization_code";
	//GITHUB
	public static String GITHUB_APP_ID = "66d08ff3589bef4c52c2";
	public static String GITHUB_APP_SECRET = "a8abc59cf6196e825f23da595b458c428bd5e84e";
	
}

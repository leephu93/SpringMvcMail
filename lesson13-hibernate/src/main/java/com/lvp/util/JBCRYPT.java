package com.lvp.util;

import org.mindrot.jbcrypt.BCrypt;
import com.lvp.config.Key;

public class JBCRYPT {
	
	public static String HASHCODE(String str) {
		String rs = BCrypt.hashpw(str, BCrypt.gensalt(Key.GEN_SALT));
		return rs;
	}
	
	public static boolean CHECKCODE(String str, String hashcode) {
		boolean rs = false;
		try {
			rs = BCrypt.checkpw(str, hashcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}

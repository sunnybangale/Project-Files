package com.cts.cbc.util;

import java.util.Locale;
import java.util.ResourceBundle;

import com.cts.cbc.constants.UserConstants;

/**
 * The Class MyUtil.
 */
public final class MyUtil {
	
	private MyUtil() {
		
	}
	
	/**
	 * Gets the bundle.
	 *
	 * @param fileName the file name
	 * @return the bundle
	 */
	public static ResourceBundle getBundle(final String fileName) {
		final Locale locale = Locale.getDefault();
		//System.out.println("inside resource");
		return ResourceBundle.getBundle(fileName, locale);

	}

	/**
	 * Gets the mes.
	 *
	 * @param key the key
	 * @return the mes
	 */
	public static String getMes(final String key) {

		final ResourceBundle msg = getBundle(UserConstants.USERMESSAGES);
		return msg.getString(key);
	}

	/**
	 * Gets the conn.
	 *
	 * @param key the key
	 * @return the conn
	 */
	public static String getConn(final String key) {

		final ResourceBundle msg = getBundle(UserConstants.DATABASE);
		return msg.getString(key);
	}
}

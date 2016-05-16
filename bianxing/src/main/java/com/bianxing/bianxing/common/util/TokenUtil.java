package com.bianxing.bianxing.common.util;

public class TokenUtil {
	public static String encode(long id) {
		return id + "_" + System.currentTimeMillis();
	}

	public static long getIdByToken(String token) {
		return Long.valueOf(token.split("_")[0]);
	}

	public static long getTimeByToken(String token) {
		return Long.valueOf(token.split("_")[1]);
	}
	
	public static void main(String[] args) {
		System.out.println(encode(1));
	}
}

package com.shnlng.showcast.base.util;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class IdGenerator {
	
	public static String id32(){
		UUID guid = UUID.randomUUID();
		String id32 = guid.toString().replace("-", "");
		return id32;
	}

	public static String id8(){
		return RandomStringUtils.randomAlphabetic(8);
	}
	
	public static String id(int len){
		return RandomStringUtils.randomAlphabetic(len);
	}

	public static void main(String[] args) {
		for(int i =0; i < 20; i++)System.out.println(IdGenerator.id32());
	}

}

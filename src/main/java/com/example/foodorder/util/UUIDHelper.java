package com.example.foodorder.util;

import java.util.UUID;

public class UUIDHelper {
	
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}

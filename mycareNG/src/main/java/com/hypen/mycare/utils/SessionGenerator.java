package com.hypen.mycare.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class SessionGenerator {
	
	static SecureRandom random = new SecureRandom();

	static Random rand = new Random();

	  public static String nextSessionId()
	  {
	    return new BigInteger(40, random).toString(22);
	  }

	public static int getInv(){

	int n = rand.nextInt(1999999)+107238;

	return n;

	}

}

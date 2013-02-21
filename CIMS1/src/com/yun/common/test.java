package com.yun.common;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger=(Logger) Logger.getInstance(test.class.getName());
		System.out.println(Level.DEBUG_INT);
	}

}

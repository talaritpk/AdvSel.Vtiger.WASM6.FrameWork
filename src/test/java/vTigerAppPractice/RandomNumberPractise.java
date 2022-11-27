package vTigerAppPractice;

import java.util.Random;

import vTiger.GenericLibrary.JavaLibrary;

public class RandomNumberPractise {

	public static void main(String[] args) {
		//Random ran=new Random();
		//System.out.println(ran.nextInt(500));
		JavaLibrary w=new JavaLibrary();
		int value=w.getRandomNumber();
		System.out.println(value);

	}

}

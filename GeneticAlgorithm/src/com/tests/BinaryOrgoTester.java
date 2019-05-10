package com.tests;

public class BinaryOrgoTester {
	public static void main(String[] args) {
		BinaryOrgoCommunity com = new BinaryOrgoCommunity(50, true, false);
		for(int i = 1; com.avgFit() < 0.8; i++) {
			System.out.println(com);
			com.newGen();
		}
		System.out.println(com);
	}
}

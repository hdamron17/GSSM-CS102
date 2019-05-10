package com.tests;

import com.base.Community;

public class BinaryOrgoCommunity extends Community<BinaryOrgo> {
	public BinaryOrgoCommunity(int popCount, boolean elite, boolean random) {
		super(popCount, elite, random);
	}

	@Override
	public BinaryOrgo[] spawnCommunity(int popCount, boolean random) {
		BinaryOrgo[] spawn = new BinaryOrgo[popCount];
		for(int i = 0; i < popCount; i++) {
			spawn[i] = new BinaryOrgo(random);
		}
		return spawn;
	}
}

package com.check;

import org.springframework.stereotype.Component;

@Component
public class AdditionService {
	
	public int makeAddition(int i, int k) {
		return i+k;
	}

}

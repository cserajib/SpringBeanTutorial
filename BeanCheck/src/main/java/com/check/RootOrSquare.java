package com.check;

public class RootOrSquare {
	
	public int getRoot(int num) {
		double t;  
		double sqrtroot=num/2;  
		do   
		{  
		t=sqrtroot;  
		sqrtroot=(t+(num/t))/2;  
		}   
		while((t-sqrtroot)!= 0);  
		return (int) sqrtroot;  
	}
	
	public int getSquare(int i) {
		return i*i;
	}


}

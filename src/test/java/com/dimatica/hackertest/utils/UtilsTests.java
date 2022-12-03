package com.dimatica.hackertest.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class UtilsTests {
	
	
	@Test
	 void timeCalculate()  {
		
		String methodFailed =Thread.currentThread().getStackTrace()[1].getMethodName() + " failed";
		
		Assertions.assertEquals(1L,Utils.timeCalculate("Tue, 07 Feb 1984 12:34:56 +0700","Tue, 07 Feb 1984 12:35:56 +0700"), methodFailed);
	
		
	}

}

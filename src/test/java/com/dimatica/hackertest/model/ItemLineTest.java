package com.dimatica.hackertest.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;





 class ItemLineTest {
	

		
	@Test
	void equalsTest() {
		String methodFailed =Thread.currentThread().getStackTrace()[1].getMethodName() + " failed";
		
		ItemLine itemLine = new ItemLine("80.238.9.179,1336129471,SIGNIN_FAILURE,Will.Smith");
		ItemLine otherLine = new ItemLine("80.238.9.179,1336129472,SIGNIN_FAILURE,Will.Smith"); 
		
		Assertions.assertEquals(itemLine,otherLine, methodFailed);
	}
	
	@Test
	void isSuspiciusIpTrueTest (){
		String methodFailed =Thread.currentThread().getStackTrace()[1].getMethodName() + " failed";
		ItemLine itemLine = new ItemLine("80.238.9.179,1336129471,SIGNIN_FAILURE,Will.Smith");
		ItemLine otherLine = new ItemLine("80.238.9.179,1336129771,SIGNIN_FAILURE,Will.Smith");

		Assertions.assertTrue(itemLine.isSuspiciusIp(otherLine),methodFailed);
	}

	@Test
	void isSuspiciusIpFalseTest (){
		String methodFailed =Thread.currentThread().getStackTrace()[1].getMethodName() + " failed";
		ItemLine itemLine  = new ItemLine("80.238.9.179,1336129420,SIGNIN_FAILURE,Will.Smith");
		ItemLine otherLine = new ItemLine("80.238.9.179,1336129790,SIGNIN_FAILURE,Will.Smith");
 
		Assertions.assertFalse(itemLine.isSuspiciusIp(otherLine),methodFailed);
	}

}

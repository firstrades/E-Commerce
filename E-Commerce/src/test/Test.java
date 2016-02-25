package test;

import extra.Base64;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Jewel Saha";
		
		
		
		String encodeStr = Base64.toString(str.getBytes());			
		System.out.println("Ecncoded value is: " + new String(encodeStr ));	
		

		// Decode data on other side, by processing encoded data		
		byte[] decodeStr = Base64.toBytes(encodeStr);
		System.out.println("Decoded value is: " + new String(decodeStr));
		
	}
	
}

package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {

	public static void main(String...args) throws UnknownHostException {
		
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println(inetAddress);
	}
}

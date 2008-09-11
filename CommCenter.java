
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

import java.net.InetSocketAddress;
import java.net.InetAddress;


import static java.lang.System.*;

class CommCenter extends Thread
{
	private DatagramSocket socket;
	private InetAddress addr;
	private Data data;
	
	private String hostname;
	private String robotName;
	private int port;
	
	public static void main(String[] args)
	{
		CommCenter center = new CommCenter("localhost","bob");
		
		center.registerRobot(1);
	}
	 
	
	CommCenter(String hostname,String robotName)//localhost:6000
	{
		this.hostname = hostname;
		this.port = port;
		this.robotName = robotName;
		
		if(hostname==null||hostname.equals(""))
			hostname="localhost";
		
		port = 6000;
		
		try
		{
		addr = InetAddress.getByName(hostname);
		}
		catch(UnknownHostException exc)
		{
			exc.printStackTrace();
		}
		
		try
		{
			socket = new DatagramSocket();
		}
		catch(SocketException exc)
		{
			exc.printStackTrace();
		}
		
		System.out.println(socket);
	}
	
	public boolean registerRobot(int pos)
	{
		// pos is the position
		String ini = "<Robot Id=\"" + pos + "\""+" Name=\"" + robotName + "\" />";
		
		out.println(ini);
		
		byte[] iniBytes = ini.getBytes();
		
        DatagramPacket packet = new DatagramPacket(iniBytes, iniBytes.length, addr, port);
        
		try
		{        
        	socket.send(packet);
		}
		catch(java.io.IOException exc)
		{
			exc.printStackTrace();
		}

		
		byte[] bufread = new byte[1024];
        packet = new DatagramPacket(bufread, bufread.length);
		try {
	            socket.receive(packet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
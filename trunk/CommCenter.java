
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

import java.net.InetSocketAddress;
import java.net.InetAddress;

import java.io.IOException;

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
		CommCenter center = new CommCenter("localhost","bob",6000);
		
		center.registerRobot(1);
	}
	 
	
	CommCenter(String hostname,String robotName,int port)
	{
		this.hostname = hostname;
		this.robotName = robotName;
		this.port = port;
		
		if(hostname==null||hostname.equals(""))
			hostname="localhost";
				
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
	
	public boolean registerRobot(int pos) // port = 6000 to register
	{
		String ini = "<Robot Id=\"" + pos + "\""+" Name=\"" + robotName + "\" />";
				
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
	
		// server will return port to be used in future
		byte[] bufread = new byte[1024];
        packet = new DatagramPacket(bufread, bufread.length);
		try
		{
			socket.receive(packet);
		}
		catch(IOException exc)
		{
			exc.printStackTrace();
		}
		
		return true;
	}
	
	public int getPort(){
		return port;
	}
}
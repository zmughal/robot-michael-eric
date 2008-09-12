
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

import java.net.InetSocketAddress;
import java.net.InetAddress;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;

import java.util.Scanner;

import static java.lang.System.*;

import org.simpleframework.xml.*;
import org.simpleframework.xml.load.*;


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
		
		while(true)
		{
			try
			{
				Measures m = center.receive();
				out.println(m.getTime());
				
			}
			catch(Exception exc){}
		}
	}
	
	public Measures receive()
	{
	    byte[] bufread = new byte[4096];
	    DatagramPacket packet = new DatagramPacket(bufread, bufread.length);
		try
		{
			Serializer ser = new Persister();
			socket.receive(packet);
			
			BufferedInputStream inStream = new BufferedInputStream(new ByteArrayInputStream(packet.getData()));
			
			Measures m = new Measures();
			m = ser.read(Measures.class,inStream);
			return m;
		}
		catch(IOException exc){exc.printStackTrace();}
		catch(Exception exc){exc.printStackTrace();}
		return null;
	}
	
	public void send(SendActions act)
	{
		Serializer ser = new Persister();
		try
		{
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			ser.write(act,outStream);
			byte[] outArr = outStream.toByteArray();
			DatagramPacket pack = new DatagramPacket(outArr,outArr.length,addr,port);
			
			socket.send(pack);
		}
		catch(Exception exc){}
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
	
	public RegisterReply registerRobot(int pos) // port = 6000 to register
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
		RegisterReply replyData=null;
		// server will return port to be used in future
		byte[] bufread = new byte[1024];
        packet = new DatagramPacket(bufread, bufread.length);
		try
		{
			socket.receive(packet);
			setPort(packet.getPort());
			
			BufferedInputStream inStream = new BufferedInputStream(new ByteArrayInputStream(packet.getData()));
			
			replyData = new RegisterReply();
			
			Serializer ser = new Persister();
			ser.read(replyData,inStream);
			//out.println(replyData);
		}
		catch(IOException exc)
		{
			exc.printStackTrace();
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		
		return (replyData.getStatus().equals("Refused")?null:replyData);
	}
	protected void setPort(int port){
		this.port = port;
	}
	
	public int getPort(){
		return port;
	}
}
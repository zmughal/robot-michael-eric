import org.simpleframework.xml.*;
import org.simpleframework.xml.load.*;

import java.util.List;

@Root(name="Reply",strict=false)
class RegisterReply
{
	@Attribute(name="Status",required=true)
		private String status;

	@Element(name="Parameters",required=false)
	private String Paramaters;
		
		@Attribute(name="SimTime",required=false)
			private int SimTime;
		@Attribute(name="CycleTime",required=false)
			private int CycleTime;
		@Attribute(name="NBeacons",required=false)
			private int NBeacons;
		@Attribute(name="CompassNoise",required=false)
			private double CompassNoise;
		@Attribute(name="BeaconNoise",required=false)
			private double BeaconNoise;
		@Attribute(name="ObstacleNoise",required=false)
			private double ObstacleNoise;
		@Attribute(name="MotorNoise",required=false)
			private double MotorNoise;
		
		public int getSimTime(){
			return SimTime;
		}
		public int getCycleTime(){
			return CycleTime;
		}
		public int getNBeacons(){
			return NBeacons;
		}
		public double getCompassNoise(){
			return CompassNoise;
		}
		public double getObstacleNoise(){
			return ObstacleNoise;
		}
		public double getMotorNoise(){
			return MotorNoise;
		}
		
	public String getStatus(){
		return status;
	}
}

@Root(name="Actions",strict=false)
class SendActions
{
	SendActions()
	{
		reqs = new SensorRequests();
	}
	
	@Attribute(name="LeftMotor",required=false)
		private double LeftMotor;
	@Attribute(name="RightMotor",required=false)
		private double RightMotor;
	@Attribute(name="EndLed",required=false)
		private String EndLed;
		
	@Element(name="SensorRequests",required=false)
	private SensorRequests reqs;
	
	@Element(name="Say",required=false,data=true)
		private String sayData;
	
	class SensorRequests
	{
		@Attribute(name="IRSensor0",required=false)
			private String sens0;
		@Attribute(name="IRSensor1",required=false)
			private String sens1;
		@Attribute(name="IRSensor2",required=false)
			private String sens2;
		@Attribute(name="IRSensor3",required=false)
			private String sens3;
		@Attribute(name="Beacon0",required=false)
			private String Beacon0;
		@Attribute(name="Ground",required=false)
			private String Ground;
		@Attribute(name="Compass",required=false)
			private String Compass;
		
		
	}
	
	public void requestSensors(boolean i0,boolean i1,boolean i2,boolean i3,boolean comp,boolean beac,boolean ground)
	{
		if(i0)
			reqs.sens0="Yes";
		if(i1)
			reqs.sens1="Yes";
		if(i2)
			reqs.sens2="Yes";
		if(i3)
			reqs.sens3="Yes";
		if(comp)
			reqs.Compass="Yes";
		if(beac)
			reqs.Beacon0="Yes";
		if(ground)
			reqs.Ground="Yes";
	}
	
	public void setMessage(String msg){
		sayData = msg;
	}
}

@Root(name="Measures",strict=false)
class Measures
{
	Measures()
		{
			sensors = new Sensors();
		}
	
	@Attribute(name="Time",required=false)
		private int time;		
		
	@Element(name="Sensors",required=false)
		private Sensors sensors;
	
	@Element(name="Leds",required = false)
		private String ledElement;
	@Attribute(name="EndLed",required=false)
		private String endLed;
	@Element(name="Buttons",required=false)
		private String buttonElement;
	@Attribute(name="Start",required=false)
		private String buttonStart;
	@Attribute(name="Stop",required=false)
		private String buttonStop;
		
	class Sensors
	{
		Sensors()
		{
			gps = new GPS();
			msg = new Message();
			beacon = new Beacon();
		}
		
		@Attribute(name="Compass",required=false)
			private double angle;
		@Attribute(name="Collision",required=false)
			private String collision;
		@Attribute(name="Ground",required=false)
			private int ground;
			
		@Element(name="BeaconSensor",required=false)
			private Beacon beacon;
			
		@ElementList(entry="IRSensor",required=false,inline=true)
			List<IRSensor> sensorList;
		
		@Element(name="Message",required=false)
			private Message msg;
		
		@Element(name="GPS",required=false)
			private GPS gps;
		
		class Message
		{
			Message(){}
			
			@Attribute(name="From",required=false)
				private int id;
			@Text(data=true,required=false)
				private String data;
			
			public String getMessageData(){
				return data;
			}
			public int getMessageId(){
				return id;
			}
		}
		
		class Beacon
		{
			Beacon(){}
			
			@Attribute(name="Id",required=false)
				private int id;
			@Attribute(name="Value",required=false)
				private double beaconValue;
			
			public int getBeaconId(){
				return id;
			}
			public double getBeaconValue(){
				return beaconValue;
			}
		}
		
		class IRSensor
		{
			IRSensor(){}
			
			@Attribute(name="Id",required=false)
				private int sensorId;
			@Attribute(name="Value",required=false)
				private double sensorValue;
				
			public int getSensorId(){
				return sensorId;
			}
			public double getSensorValue(){
				return sensorValue;
			}
		}
		
		class GPS
		{
			GPS(){}
			
			@Attribute(name="X",required=false)
				private double xVal;
			@Attribute(name="Y",required=false)
				private double yVal;
				
			public double getX(){
				return xVal;
			}	
			public double getY(){
				return yVal;
			}
				
		}
		
		public Beacon getBeacon(){
			return beacon;
		}
		
		
		public GPS getGPS(){
			return gps;
		}
		
		public Message getMessage(){
			return msg;
		}
		
		public String getEndLed(){
			return endLed;
		}
		
		public List<IRSensor> getSensorList(){
			return sensorList;
		}
	}
	
	public int getTime(){
			return time;
	}

}

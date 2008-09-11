import org.simpleframework.xml.*;
import org.simpleframework.xml.load.*;


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
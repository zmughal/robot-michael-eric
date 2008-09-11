import org.simpleframework.xml.*;
import org.simpleframework.xml.load.*;


@Root(name="Reply")
class RegisterReply
{
	@Attribute(name="Status",required=true)
		private String status;
	
	public String getStatus(){
		return status;
	}
	
	@Element(name="Parameters",required=false)
	//ReplyParams params;
	private String Paramaters;
		
//	class ReplyParams
//	{
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
//	}
	public String toString()
	{
		String temp = new String();
		String nl = "\n";
		temp +="Status: "+status+nl;
		return temp;
	}
}
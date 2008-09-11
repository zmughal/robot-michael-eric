import org.simpleframework.xml.*;
import org.simpleframework.xml.load.*;


@Root(name="Reply")
class RegisterReply
{
	@Attribute(name="Status")
		private String status;
	
	public String getStatus(){
		return status;
	}
	
	@Element(name="Parameters")
	class ReplyParams
	{
		@Attribute(name="SimTime")
			private int SimTime;
		@Attribute(name="CycleTime")
			private int CycleTime;
		@Attribute(name="NBeacons",required=false)
			private int NBeacons;
		@Attribute(name="CompassNoise")
			private double CompassNoise;
		@Attribute(name="BeaconNoise")
			private double BeaconNoise;
		@Attribute(name="ObstacleNoise")
			private double ObstacleNoise;
		@Attribute(name="MotorNoise")
			private double MotorNoise;
	}
}
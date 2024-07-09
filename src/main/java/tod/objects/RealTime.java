package tod.objects;

public class RealTime{
	long lastTime;

	public RealTime(int CreatedAt){
		this.lastTime = CreatedAt;
	}

	public long reset(){
		return lastTime = System.currentTimeMillis();
	}
	
	public Time tick(){
		long tick = System.currentTimeMillis();
		long diff = tick - lastTime;
		lastTime = tick;
		return new Time(diff, lastTime);
	}
};

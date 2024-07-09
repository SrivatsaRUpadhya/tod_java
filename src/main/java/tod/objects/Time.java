package tod.objects;
public class Time{
	long delta;
	long CreatedAt;

	public Time(long delta, long CreatedAt){
		this.delta = delta;
		this.CreatedAt = CreatedAt;
	}

	public long since(){
		return System.currentTimeMillis() - CreatedAt;
	}

	public long getDelta(){
		return delta;
	}
};

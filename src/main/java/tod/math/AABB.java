package tod.math;

public class AABB{
	Vec2 min;
	Vec2 max;

	public AABB(Vec2 _min, Vec2 _max){
		min = _min;
		max = _max;
	}

	public boolean contains(Vec2 v){
		return 
			(v.x > min.x) &&
			(v.y > min.y) &&
			(v.x < max.x) &&
			(v.y < max.y);
	}
	public String to_string(){
		return "AABB: min: " + min.x + " " + min.y  + " max: " + max.x + " " + max.y;
	}
}

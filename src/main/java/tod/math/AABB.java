package tod.math;

public class AABB{
	Vec2 min;
	Vec2 max;

	AABB(Vec2 _min, Vec2 _max){
		min = _max;
		max = _max;
	}

	boolean contains(Vec2 v){
		return 
			(v.x > min.x) &&
			(v.y > min.y) &&
			(v.x < max.x) &&
			(v.y < max.y);
	}
}

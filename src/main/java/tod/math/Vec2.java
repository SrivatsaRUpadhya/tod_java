package tod.math;

public class Vec2{
	public float x;
	public float y;

	public Vec2(float _x,float _y){
		x = _x;
		y = _y;
	}

	public double length(){
		return Math.sqrt(x*x + y*y);
	}

	public double sqlength(){
		return x * x + y * y;
	}

	public 	Vec2 scale(float scaleVal){
		x = x * scaleVal;
		y = y * scaleVal;
		return this;
	}

	public Vec2 add(Vec2 vecToAdd){
		return new Vec2(x + vecToAdd.x, y + vecToAdd.y);
	}

	public Vec2 sub(Vec2 vecToSub){
		return new Vec2(x - vecToSub.x, y - vecToSub.y);
	}
	public Vec2 sub(Position p){
		return new Vec2(x - (float)p.row, y - (float)p.col);
	}
	public boolean equals(Vec2 v){
		return x == v.x && y == v.y;
	}

	public Position toPosition(){
		return new Position((int)x,(int)y);
	}

	public Vec2 norm(){
		return new Vec2((float)(x/length()), (float)(y/length()));
	}
	public boolean closeEnough(Vec2 b, double enough) {
		return Math.abs(x - b.x) < enough &&
			Math.abs(y - b.y) < enough;
	}

}


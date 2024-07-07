package tod.objects;
import tod.math.*;
public class Projectile{
    int id;
    enum Target {
		CREEP,
		TOWER
	};

    Vec2 pos;
    float speed;
    boolean alive;

    // rendered
    Color rColor;
    Sized rSized;
    Cell[] rCells;

	Projectile(){
		id = 0;
		pos = Constants.ZERO_VEC2;
		speed = 0;
		alive = true;
		rColor = new Color(0,1,0);
		rSized = new Sized(1,Constants.INITIAL_POSITION);
		rCells = new Cell[1];
		rCells[0] = new Cell((byte)'x',new Color(255,0,0)); // Color of projectile is red
	}
};

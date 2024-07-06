package tod.objects;
import tod.math.Constants;
import tod.math.*;

public class Creep{
	protected int id;
    protected int team;
    protected int cols;


    protected Vec2 pos;
    protected int life;
    protected int speed;
    protected boolean alive;

    //rendered
    protected int rLife;
    protected Color rColor;
    protected Cell[] rCells;
    protected Sized rSized;

    protected int path;
    protected int pathIdx;
    protected int pathLen;

	Creep(){
		id = 0;
		team = 0;
		cols = 0;
		pos = Constants.ZERO_VEC2;
		life = Constants.INITIAL_CREEP_LIFE;
		speed = Constants.INITIAL_CREEP_SPEED;
		alive = true;

		rLife = Constants.INITIAL_CREEP_LIFE;
		rColor = Constants.INITIAL_CREEP_COLOR;
		rSized = new Sized(1, Constants.INITIAL_POSITION);
		rCells = new Cell[1];
	}


};

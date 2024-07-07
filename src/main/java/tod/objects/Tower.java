package tod.objects;
import tod.math.*;

public class Tower{
	protected int id;
	protected int team;

	protected Vec2 pos;
	protected AABB towAABB;
	protected int maxAmmo;
	protected int ammo;
	protected boolean alive;
	protected int level;
	protected int radius;
	protected int damage;
	protected int fireRateMS;
	protected int lastFiredMS;
	protected boolean fired;

	// rendered
    protected Sized rSized;
	protected int rAmmo;
	protected Cell[] rCells;

	public Tower(){
		//protected Vec2 pos: math.Vec2 = math.ZERO_VEC2,
		maxAmmo = Constants.INITIAL_AMMO;
		ammo = Constants.INITIAL_AMMO;
		alive = true;
		level = 1;
		radius = 1;
		damage = 1;
		fireRateMS = Constants.INITIAL_FIRERATE_MS;
		lastFiredMS = 0;
		fired = false;
		rAmmo = 0;

		Color TowerColor = new Color(0,0,0);

		rCells = new Cell[3];
		rCells[0] = new Cell((byte)'/', TowerColor);
		rCells[1] = new Cell((byte)'*', TowerColor);
		rCells[2] = new Cell((byte)'\\', TowerColor);

		rSized = Constants.ZERO_SIZED;
		pos = new Vec2(0, 0);
		towAABB = Constants.ZERO_AABB;
	}

	public void setTowerPos(Vec2 _pos){
		pos = _pos;
		rSized = new Sized(3, new Position((int)_pos.x, (int)_pos.y));
	}

	public boolean isAlive() {
		return alive;
	}

	public float getTowerHealthPercentage(){
		return (float)ammo/(float)maxAmmo;
	}
	public Vec2 getTowerPos(){
		return pos;
	}
	public Cell[] getCells(){
		return rCells;
	}
	public Sized getrSized() {
		return rSized;
	}
};

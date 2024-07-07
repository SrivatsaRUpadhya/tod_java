package tod.math;
import tod.objects.*;

public interface Constants{
	public static final int INITIAL_AMMO = 150; 
	public static final int INITIAL_FIRERATE_MS = 1000;
	public static final int INITIAL_PROJECTILE_SPEED = 0;
	public static final int INITIAL_CREEP_LIFE = 3;
	public static final int INITIAL_CREEP_SPEED = 3;
	public static final int CANVAS_ROWS = 80;
	public static final int CANVAS_COLS = 30;
	public static final Color INITIAL_CREEP_COLOR = new Color(255,255,255);
	public static final Color BLACK_COLOR = new Color(0,0,0);
	public static final Vec2 ZERO_VEC2 = new Vec2(0,0);
	public static final AABB ZERO_AABB = new AABB(ZERO_VEC2,ZERO_VEC2);
	public static final Position INITIAL_POSITION = new Position(0,0);
	public static final Sized ZERO_SIZED = new Sized(3,INITIAL_POSITION);
	byte t = ' ';
	public static final Cell EMPTY_CELL = new Cell(t,BLACK_COLOR);
	public static final char[] INITIAL_CLEAR = {};
	byte[] topLeftFull = {'', '[', '1', ';', '1', 'H'};
	byte[] clear = {'', '[', '2', 'J'};
	byte[] newFrame = { '', '[', ';', 'H', };
	byte[] initialClear = {'', '[', '1', ';', '1', 'H','', '[', '2', 'J', '', '[', ';', 'H' };
	byte[] foregroundColor = { '', '[', '3', '8', ';', '2', ';', };
	byte[] newline = { '\r', '\n', };
}

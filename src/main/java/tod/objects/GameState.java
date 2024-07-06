package tod.objects;
import java.util.ArrayList;

public class GameState{
	protected boolean playing;
	protected int round;
	protected int one;
	protected int two;
	protected int rows;
	protected int cols;

	protected int time;
	protected int loopDeltaUS;
	protected int updates;

	protected ArrayList<Tower>towers;
	protected ArrayList<Creep>creeps;
	protected ArrayList<Projectile>projectile;

	public GameState(){
		playing = false;
		round = 1;
		one = 0;
		two = 0;
		rows = 0;
		cols = 0;
		time = 0;
		loopDeltaUS = 0;
		updates = 0;
		towers = new ArrayList<Tower>();
		creeps = new ArrayList<Creep>();
		projectile = new ArrayList<Projectile>();
	}

	public void setPlaying(boolean playing){
		this.playing = playing;
	}
	public void addTower(Tower t){
		towers.add(t);
	}
	public ArrayList<Tower> getTowers() {
		return towers;
	}
};

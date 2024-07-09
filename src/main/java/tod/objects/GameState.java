package tod.objects;
import java.util.ArrayList;

import tod.math.Constants;
import tod.math.Position;

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
		loopDeltaUS = 16000;
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
	public void addCreep(Creep c){
		creeps.add(c);
	}
	public ArrayList<Tower> getTowers() {
		return towers;
	}
	public ArrayList<Creep> getCreeps() {
		return creeps;
	}
	public boolean canPlaceTower(Position pos) {
		if (pos.getCol() == 0  || pos.getCol() == Constants.CANVAS_COLS- 1) {
			return false;
		}

		for(int i = 0; i < towers.size(); i++){
			if(towers.get(i).getTowerPos().toPosition().equals(pos)){
				return false;
			}
		}

		for(int i = 0; i < creeps.size(); i++){
			if(creeps.get(i).getPos().toPosition().equals(pos)){
				return false;
			}
		}

		return true;
	}
};

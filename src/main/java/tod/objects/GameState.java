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
	protected boolean noBuildZone;
	protected boolean[] board;

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
		noBuildZone = true;
		loopDeltaUS = 16000;
		updates = 0;
		board = new boolean[Constants.BOARD_SIZE];
		for(int i = 0; i < Constants.BOARD_SIZE;i++)
			board[i] = true;
		towers = new ArrayList<Tower>();
		creeps = new ArrayList<Creep>();
		projectile = new ArrayList<Projectile>();
	}

	public void setPlaying(boolean playing){
		this.playing = playing;
	}
	public void addTower(Tower t){
		towers.add(t);
		board[t.getTowerPos().toPosition().toIdx(Constants.CANVAS_COLS)] = false;
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

		if(noBuildZone){
			int idx = pos.toIdx(Constants.CANVAS_COLS);
			int rowPerTeam = (Constants.CANVAS_ROWS - Constants.NO_BUILD_ROW_COUNT) / 2;
			int noBuildBegin = rowPerTeam * Constants.CANVAS_COLS;
			int noBuildEnd = noBuildBegin + Constants.NO_BUILD_ZONE_SIZE;
			if(idx > noBuildBegin && idx < noBuildEnd) return false;
		}

		for(int i = 0; i < towers.size(); i++){
			if(towers.get(i).getTowAABB().contains(pos.getVec2())){
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
	public boolean[] getBoard() {
		return board;
	}

	public boolean isNoBuildZone() {
		return noBuildZone;
	}

	public void setNoBuildZone(boolean noBuildZone) {
		this.noBuildZone = noBuildZone;
	}
};

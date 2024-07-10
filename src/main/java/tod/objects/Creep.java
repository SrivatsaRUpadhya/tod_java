package tod.objects;
import tod.math.Constants;

import java.util.ArrayList;

import tod.math.*;

public class Creep{
	protected int id;
	protected int team;


	protected Vec2 pos;
	protected int life;
	protected int speed;
	protected boolean alive;

	//rendered
	protected int rLife;
	protected Color rColor;
	protected Cell[] rCells;
	protected Sized rSized;

	protected int[] path;
	protected int pathIdx;
	protected int pathLen;

	public Creep(Vec2 v, int _team, int _id){
		id = _id;
		team = _team;
		pos = v;
		life = Constants.INITIAL_CREEP_LIFE;
		speed = Constants.INITIAL_CREEP_SPEED;
		alive = true;

		rLife = Constants.INITIAL_CREEP_LIFE;
		rColor = Constants.RED_COLOR;
		rSized = new Sized(1, v.toPosition());
		rCells = new Cell[1];
		rCells[0] = new Cell((byte)'*',new Color(255,0,0));
	}

	public Cell[] getCells() {
		return rCells;
	}

	public Sized getrSized() {
		return rSized;
	}

	public int walk(int from, int pos, int[] seen,boolean[] board, int boardCols){
		if(pos >= seen.length || board[pos] == false || seen[pos] != -1)
			return 0;

		seen[pos] = from;
		if(pos % boardCols == boardCols - 1)
			return pos;

		int[] nextMoves = {1,-boardCols, boardCols, -1};
		for(int i = 0; i < nextMoves.length; i++){
			int newMove = pos + nextMoves[i];
			if(newMove < 0)
				continue;
			int out = walk(pos, newMove, seen,board,boardCols);
			if(out != 0)
				return out;
		}
		return 0;
	}

	public int getPath(int[] seen, int pos){
		ArrayList<Integer> out = new ArrayList<Integer>();
		while(seen[pos] != pos){
			out.add(pos);
			pos = seen[pos];
		}
		path = new int[out.size()];
		int n = out.size();
		for(int j = n-1; j >= 0; j--){
			path[n - j - 1] = out.get(j);
		}
		pathLen = path.length;
		pathIdx = 0;
		return n;
	}

	public void createPath(boolean[] board){
		int[] seen = new int[Constants.BOARD_SIZE];
		for(int i = 0; i < seen.length; i++)
			seen[i] = -1;
		
		int startPos = pos.toPosition().toIdx(Constants.CANVAS_COLS);
		int finalPos = walk(startPos,startPos,seen,board, Constants.CANVAS_COLS);
		getPath(seen,finalPos);
	}

	public int[] getCreepCurrentPath(){
		return path;
	}
	public boolean completed(){
		return pos.toPosition().getCol() == Constants.CANVAS_COLS - 1;
	}

	public boolean dead() {
		return alive;
	}

	public void update(GameState gs) {
		if (completed() || !alive) {
			return;
		}

		int consumedUS = 0;
		double MICROSECOND = 1000000.0;
		while (consumedUS < gs.loopDeltaUS && !completed()) {
			int delta = gs.loopDeltaUS - consumedUS;

			Position to = Position.idxToPos(path[pathIdx], Constants.CANVAS_COLS);
			Vec2 dist = pos.sub(to);
			Vec2 normDist = dist.norm();
			double len = dist.length();
			int maxUS = (int)(len / (double)speed * MICROSECOND);
			int usConsumed = Math.min(maxUS, delta);

			float deltaF = usConsumed;
			double deltaP = deltaF / MICROSECOND * speed;
			Vec2 change = normDist.scale((float)-deltaP);
			pos = pos.add(change);

			//TODO: check close enough value
			if (pos.closeEnough(to.getVec2(), 0.01)) {
				pos = Position.idxToPos(path[pathIdx], Constants.CANVAS_COLS).getVec2();
				pathIdx += 1;
				render();
			}

			consumedUS += usConsumed;
			//System.out.println(consumedUS);
		}
	}
	public void render(){
		rSized.setPos(pos.toPosition());
	}
	public Vec2 getPos() {
		return pos;
	}
}

package tod.objects;
import tod.math.Constants;
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

	protected int path;
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
		rColor = Constants.INITIAL_CREEP_COLOR;
		rSized = new Sized(1, v.toPosition());
		rCells = new Cell[1];
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

	public int path(int[] seen, int pos, int[] out){
		int i = 0;	
		while(seen[pos] != pos){
			out[i++] = pos;
			pos = seen[pos];
		}

		for(int j = 0; j < out.length / 2; j++){
			int temp = out[j];
			out[j] = out[out.length - j - 1];
			out[out.length - j - 1] = temp;
		}
		return i;
	}
};

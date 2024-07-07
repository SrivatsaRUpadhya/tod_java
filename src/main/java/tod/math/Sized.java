package tod.math;

public class Sized {
	int cols;
	Position pos;

	public Sized(int _cols, Position _pos){
		cols = _cols;
		pos = _pos;
	}

	String to_string() {
		String res = STR."cols = {\{this.cols}}, pos = {\{this.pos.toString()}}";
		return res;
	}

	public int getCols() {
		return cols;
	}
	public Position getPos() {
		return pos;
	}
};

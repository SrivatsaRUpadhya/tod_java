package tod.math;

public class Position{
	int row;	
	int col;	

	public Position(int _row, int _col){
		row = _row;
		col = _col;
	}

	public Position(String str) throws Exception{
		final int index = str.indexOf(",");
		if (index == -1) {
			throw new Exception("Invalid input str");
		}

		try{

			final int _row = Integer.parseInt(str.substring(0,index), 10);
			final int _col = Integer.parseInt(str.substring(index), 10);
			this.row = _row;
			this.col = _col;
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		;
	}

	public Vec2 getVec2(){
		return new Vec2((float)row,(float)col);
	}

	public boolean equals(Position p){
		return this.row == p.row && this.col == p.col;
	}

	public int toIdx(int cols){
		return this.row * cols + this.col;
	}

	public static Position idxToPos(int idx, int cols){
		return new Position(idx/cols,idx%cols);
	}

	public String to_string(){
		String res = STR."vec(r = {\{this.row}}, c = {\{this.col}})";
		return res;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}

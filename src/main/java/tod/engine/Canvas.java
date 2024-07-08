package tod.engine;
import tod.math.*;
import tod.objects.Cell;

public class Canvas{
	byte[] buffer;
	Framer framer;
	Cell[] cells;
	int rows;
	int cols;

	public Canvas(byte[] _buf){
		buffer = _buf;
		framer = new Framer();
		rows = Constants.CANVAS_ROWS;
		cols = Constants.CANVAS_COLS;
		cells = new Cell[Constants.BOARD_SIZE];		//TODO: How many cells?
		resetCells();
	}

	public void placeCells(Cell[] objectCells, Sized sd){
		for(int i = 0; i < objectCells.length; i++){
			int rowOffest = i / sd.getCols();
			int colOffset = i % sd.getCols();

			Position pos = sd.getPos();
			int offset = ((pos.getRow() + rowOffest) * cols) + (pos.getCol() + colOffset);
			if(offset >= cells.length){
				throw new RuntimeException("Canvas: placeCells: offset out of bounds" + offset + " " + cells.length);
			}
			cells[offset] = objectCells[i];
		}
	}

	public void render(){
		framer.frame(cells,buffer);
		resetCells();
	}

	public void resetCells(){
		for(int i = 0; i < cells.length;i++){
			cells[i] = Constants.EMPTY_CELL;
		}
	}

	public Cell[] getCells() {
		return cells;
	}
};

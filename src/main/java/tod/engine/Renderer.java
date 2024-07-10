package tod.engine;
import tod.math.Constants;
import tod.math.Position;
import tod.math.Sized;
import tod.objects.Cell;
import tod.objects.Creep;
import tod.objects.GameState;
import tod.objects.Tower;

public class Renderer{
	GameState gs;
	Canvas canvas;
	byte[] output;
	int renderCount;

	public Renderer(GameState _gs){
		gs = _gs;
		output = new byte[65535];			//TODO: how much should be the size of the buffer?
		renderCount = 0;
		canvas = new Canvas(output);
	};

	public void renderGameState(GameState gs){
		if(gs.isNoBuildZone()){
			int rowPerTeam = (Constants.CANVAS_ROWS - Constants.NO_BUILD_ROW_COUNT) / 2;
			int noBuildBegin = (rowPerTeam * Constants.CANVAS_COLS) + 1;
			int noBuildEnd = noBuildBegin + Constants.NO_BUILD_ZONE_SIZE;

			Cell[] cells= new Cell[1];
			for(int i = noBuildBegin; i < noBuildEnd;i++){
				cells[0] = Constants.NO_BUILD_ZONE_CELL;
				canvas.placeCells(cells, new Sized(1,Position.idxToPos(i,Constants.CANVAS_COLS)));
			}
		}

		for(Tower t : gs.getTowers()){
			canvas.placeCells(t.getCells(), t.getrSized());
		}
		for(Creep c : gs.getCreeps()){
			canvas.placeCells(c.getCells(), c.getrSized());
		}
		//TODO: render other game objects
	
		canvas.render();
	}

	public byte[] getOutput(){
		return output;
	}
};

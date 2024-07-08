package tod.engine;

import tod.math.Constants;
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
		output = new byte[Constants.BOARD_SIZE+400];			//TODO: how much should be the size of the buffer?
		renderCount = 0;
		canvas = new Canvas(output);
	};

	public void renderGameState(){
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

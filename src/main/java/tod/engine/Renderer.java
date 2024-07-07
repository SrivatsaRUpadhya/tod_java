package tod.engine;

import tod.objects.GameState;
import tod.objects.Tower;

public class Renderer{
	GameState gs;
	Canvas canvas;
	byte[] output;
	int renderCount;

	public Renderer(GameState _gs){
		gs = _gs;
		output = new byte[200];			//TODO: how much should be the size of the buffer?
		renderCount = 0;
		canvas = new Canvas(output);
	};

	public void renderGameState(){
		for(Tower t : gs.getTowers()){
			canvas.placeCells(t.getCells(), t.getrSized());
		}
		//TODO: render other game objects
	
		canvas.render();
	}

	public byte[] getOutput(){
		return output;
	}
};

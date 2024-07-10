package tod;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

import tod.engine.Renderer;
import tod.math.Constants;
import tod.math.Vec2;
import tod.objects.Creep;
import tod.objects.GameState;
import tod.objects.Tower;

public class Sim{
	public static void main(String[] args){
		if(args.length < 3){
			System.out.println("Usage: java Sim <towerCount> <creepCount> <runCount>");
			System.exit(1);
		}

		int towerCount = Integer.parseInt(args[0]);
		int creepCount = Integer.parseInt(args[1]);
		int runCount = Integer.parseInt(args[2]);

		GameState gs = new GameState();
		Random r = new Random();
		for(int i = 0; i < towerCount; i++){
			while(true){
				int row = r.nextInt(Constants.CANVAS_ROWS) ;
				int col = r.nextInt(Constants.CANVAS_COLS) ;
				Vec2 pos = new Vec2(row,col);
				System.out.println("Trying to place tower at: " + pos.toPosition().to_string());
				if(gs.canPlaceTower(pos.toPosition())){
					Tower t = new Tower();
					t.setTowerPos(pos);
					gs.addTower(t);
					break;
				}
			}
		}
		for(int i = 0; i < creepCount; i++){
			while(true){
				int row = r.nextInt(Constants.CANVAS_ROWS) ;
				int col = r.nextInt(Constants.CANVAS_COLS) ;
				Vec2 pos = new Vec2(row,col);
				System.out.println("Trying to place creep at: " + pos.toPosition().to_string());
				//TODO: Change canPlaceTower to canPlaceCreep
				if(gs.canPlaceTower(pos.toPosition())){
					Creep c = new Creep(pos,1,1);
					c.createPath(gs.getBoard());
					gs.addCreep(c);
					break;
				}
			}
		}

		//TODO: run timer and update game state

		Renderer renderer = new Renderer(gs);
		PrintStream ps = new PrintStream(System.out);

		long start = System.currentTimeMillis();
		boolean firstRender = true;
		//int countToDisableNoBuild = runCount - 100;
		while(runCount != 0){
			//if(runCount == countToDisableNoBuild)
			//	gs.setNoBuildZone(false);
			while(System.currentTimeMillis() - start > 17){
				start = System.currentTimeMillis();
				if(firstRender){
					firstRender = false;
				}
				else{
					ArrayList<Creep> gameCreeps = gs.getCreeps();
					for(int i = 0; i < gameCreeps.size(); i++){
						Creep temp = gameCreeps.get(i);
						String prev = temp.getPos().toPosition().to_string();
						temp.update(gs);
						String after = temp.getPos().toPosition().to_string();
						//if(!prev.equals(after))
						//	System.out.println("Creep moved from: " + prev + " to: " + after);
						gameCreeps.set(i, temp);
					}
				}
				renderer.renderGameState(gs);
				byte[] output = renderer.getOutput();
				ps.write(output,0,output.length);
				runCount--;
			}
		}
	}
};

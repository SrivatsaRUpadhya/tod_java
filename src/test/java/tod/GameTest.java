package tod;
import tod.engine.*;
import tod.math.*;
import tod.objects.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

public class GameTest{
	@Test
	public void GameStateTest(){
		GameState gs = new GameState();
		PrintStream p = new PrintStream(System.out);
		byte [] buf = new byte[200];
		Tower t =new Tower();
		t.setTowerPos(new Vec2(1,1));
		gs.addTower(t);
		Tower t2 =new Tower();
		t2.setTowerPos(new Vec2(2,2));
		gs.addTower(t2);
		Tower t3 =new Tower();
		t3.setTowerPos(new Vec2(3,3));
		gs.addTower(t3);

		Renderer r = new Renderer(gs);
		r.renderGameState();

		//ArrayList<Cell> cells = new ArrayList<Cell>();
		//for(Tower T : gs.getTowers()){
		//	for(Cell c : T.getCells()){
		//		cells.add(c);
		//	}
		//}

		//assertEquals(cells.size(), 9);
		//assertTrue(t.getTowerPos().equals(new Vec2(1,1)));
		//assertTrue(t2.getTowerPos().equals(new Vec2(2,2)));
		//assertTrue(t3.getTowerPos().equals(new Vec2(3,3)));

		//for(Cell c : cells){
		//	p.println(c.text);
		//}

		//p.println("Creating framer");
		//Cell[] a = new Cell[cells.size()];
		//cells.toArray(a);
		//f.frame(a, buf);
		byte[] out = r.getOutput();
		p.write(out, 0, out.length);
	}	
}

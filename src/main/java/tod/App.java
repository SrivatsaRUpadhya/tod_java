package tod;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import tod.engine.Framer;
import tod.math.Vec2;
import tod.objects.Cell;
import tod.objects.GameState;
import tod.objects.Tower;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		GameState gs = new GameState();
		PrintStream p = new PrintStream(System.out);
		byte [] buf = new byte[100];
		Framer f = new Framer();
		Tower t =new Tower();
		t.setTowerPos(new Vec2(1,1));
		gs.addTower(t);
		Tower t2 =new Tower();
		t2.setTowerPos(new Vec2(2,2));
		gs.addTower(t2);
		Tower t3 =new Tower();
		t2.setTowerPos(new Vec2(3,3));
		gs.addTower(t3);

		ArrayList<Cell> cells = new ArrayList<Cell>();
		for(Tower T : gs.getTowers()){
			for(Cell c : T.getCells()){
				cells.add(c);
			}
		}

		for(Cell c : cells){
			p.println(c.text);
		}
		Cell[] a = new Cell[cells.size()];
		cells.toArray(a);
		p.println("Creating framer");
		f.frame(a, buf);
		p.write(buf, 0, buf.length);
    }
}

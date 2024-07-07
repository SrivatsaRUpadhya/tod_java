package tod;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.io.PrintWriter;

import tod.engine.Canvas;
import tod.engine.Framer;
import tod.objects.Cell;
import tod.objects.Tower;
import org.junit.Test;

public class CanvasTest{
	@Test
	public void CreateCanvas(){
		byte [] buf = new byte[100];
		Canvas c = new Canvas(buf);
		Tower t = new Tower();
		c.placeCells(t.getCells(),t.getrSized());
		Cell[] cells = c.getCells();
		assertEquals(cells[0].text,t.getCells()[0].text);
		assertEquals(cells[1].text,t.getCells()[1].text);
		assertEquals(cells[2].text,t.getCells()[2].text);
	}
}

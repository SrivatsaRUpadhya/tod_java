package tod;

import java.io.PrintStream;
import java.io.PrintWriter;

import tod.engine.Framer;
import tod.objects.Tower;
import org.junit.Test;

public class CanvasTest{
	@Test
	public void CreateCanvas(){
		PrintStream p = new PrintStream(System.out);
		byte [] buf = new byte[100];
		Framer f = new Framer();
		Tower t = new Tower();
		p.println("Creating framer");
		f.frame(t.getCells(), buf);
		p.write(buf, 0, buf.length);
	}
}

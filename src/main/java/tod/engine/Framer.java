package tod.engine;

import tod.math.*;
import tod.objects.*;

public class Framer{
	boolean isFirstRender = true;
	int size = 100;

	public int write(byte[] out, int _offset, byte[] buf){
		for(int i = 0;i < buf.length; i++){
			out[_offset++] = buf[i];
		}
		return _offset;
	}

	public int writeByte(byte[] out,int offset,byte c){
		out[offset++] = c;
		return offset;
	}

	public int frame(Cell[] f, byte[] out){
		//assert(f.length == size, "you must hand in a frame that matches rows and cols");

		int offset = 0;
		if (isFirstRender) {
			offset = write(out, offset, Constants.initialClear);
			isFirstRender = false;
		} else {
			offset = write(out, offset, Constants.newFrame);
		}

		int newLineCount = 0;

		for(int i = 0; i<f.length; i++){
			byte text = f[i].text;

			//if (!self.previous.equal(c.color)) {
			//	self.previous = c.color;
			//	offset = try writeAnsiColor(c.color, out, offset);
			//}

			offset = writeByte(out, offset, text);

			if (i % Constants.CANVAS_COLS == 0) {
				offset = write(out, offset, Constants.newline);
				newLineCount += 1;
			}
		}

		//assert(newLineCount == Constants.CANVAS_ROWS, "should have produced self.rows amount of rows, did not");
		return offset;
	}
};

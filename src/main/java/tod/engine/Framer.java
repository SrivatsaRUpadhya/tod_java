package tod.engine;
import tod.math.*;
import tod.objects.*;

public class Framer{
	Color currentColor = new Color(255,255,255);
	byte[] colorOut;
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

			if(!f[i].color.equals(currentColor)){
				setOutColor(f[i].color);
			}

			offset = write(out, offset,colorOut);
			offset = writeByte(out, offset, text);

			if (i % Constants.CANVAS_COLS == 0) {
				offset = write(out, offset, Constants.newline);
				newLineCount += 1;
			}
		}
		return offset;
	}

	public void setOutColor(Color objColor){
		currentColor = objColor;
		int len = Constants.foregroundColor.length + 12;
		byte[] colorHolder = new byte[len];
		int j = 0;
		for(j = 0; j < Constants.foregroundColor.length; j++){
			colorHolder[j] = Constants.foregroundColor[j];
		}
		char[] rgb = currentColor.getRGBArray();
		for(char c : rgb){
			colorHolder[j++] = (byte)c;
		}
		colorOut = colorHolder;
	}
}

package tod.engine;
import java.lang.StringBuilder;
import tod.math.*;

public class Canvas{
	char[] buffer;
	static char initialChar = '';
	static char[] topLeftFull;
	static char[] clear;
	static char[] newFrame;
	int rows;
	int cols;

	public Canvas(char[] _buf){
		char[] topLeftFull = {'␛', '[', '1', ';', '1', 'H'};
		char[] clear = {'␛', '[', '2', 'J'};
		char[] newFrame = { '␛', '[', ';', 'H', };
		StringBuilder sb = new StringBuilder(64);

		sb.append(topLeftFull);
		sb.append(clear);
		sb.append(newFrame);

		char[] foregroundColor = { '␛', '[', '3', '8', ';', '2', ';', };
		char[] newline = { '\r', '\n', };

		buffer = _buf;
		rows = Constants.CANVAS_ROWS;
		cols = Constants.CANVAS_COLS;
	}
};

package tod.objects;

public class Color{
	protected int r;
	protected int g;
	protected int b;

	public Color(int r,int g ,int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public char[] getRGBArray(){
		StringBuilder sb = new StringBuilder();
		String s;
		s = Integer.toString(r);
		sb.append(s);
		sb.append(';');

		s = Integer.toString(g);
		sb.append(s);
		sb.append(';');

		s = Integer.toString(b);
		sb.append(s);
		sb.append('m');
		return sb.toString().toCharArray();
	}

	public boolean equals(Color c){
		return (c.r == r && 
				c.g == g && 
				c.b == b
			   );
	}
}


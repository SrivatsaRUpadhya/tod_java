package tod.math;

public class Coord {
	Position pos;
	int team;

	String to_string(){
		String res = STR."choord(team = {\{this.team}} pos = {\{pos.to_string()}})";
		return res;
	}

	Coord(char[] msg){
		try{
		char teamNumber = msg[0];
		if (teamNumber != '1' && teamNumber != '2') {
			throw new Exception("Team must be 1 or 2");
		}
		Position _pos = new Position(msg.toString().substring(1));
		if (pos == null) {
			throw new Exception("Coords not created");
		}
		this.pos = _pos;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
};

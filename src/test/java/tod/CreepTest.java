package tod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tod.math.Constants;
import tod.objects.Creep;

public class CreepTest{
	@Test
	public void CreepPathTest(){
		Creep creep = new Creep(Constants.ZERO_VEC2, 1, 1);
		boolean[] testBoard = {
			true, false, true,
			true, false, true,
			true, true, true,
		};
		int[] seen= {
			-1, -1, -1,
			-1, -1, -1,
			-1, -1, -1,
		};
		int finalPos = creep.walk(0,0,seen,testBoard,3);
		assertEquals(8,finalPos);
		int[] out = new int[4];
		creep.path(seen,finalPos,out);
		int[] expectedPath = {3,6,7,8};
		for(int i = 0; i < expectedPath.length;i++)
			assertEquals(expectedPath[i],out[i]);
	}
}

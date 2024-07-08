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
		creep.getPath(seen,finalPos);
		int[] expectedPath = {3,6,7,8};
		int[] out = creep.getCreepCurrentPath();
		for(int i = 0; i < expectedPath.length;i++)
			assertEquals(expectedPath[i],out[i]);

		// use following test with CANVAS_COLS constant set to 3
		//boolean[] emptyBoard = {
		//	true, true, true,
		//	true, true, true,
		//	true, true, true,
		//};
		//
		//creep.createPath(emptyBoard);
		//int[] expectedPath1 = {1,2};
		//int[] curPath = creep.getCreepCurrentPath();
		//for(int i = 0; i < expectedPath1.length;i++)
		//	assertEquals(expectedPath1[i],curPath[i]);
	}
}

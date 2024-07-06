package tod;

import tod.objects.Tower;
import org.junit.Test;

import tod.math.*;

import static org.junit.Assert.assertTrue;

public class TowerTest{
	@Test
	public void CreateTowerTest(){
		Tower tower = new Tower();
		assertTrue(tower.getTowerPos().equals(Constants.ZERO_VEC2));
	}
	
}

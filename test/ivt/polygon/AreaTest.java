package ivt.polygon;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

public class AreaTest {
	
	@Test
	public void square() {
		Point[] vertices = new Point[] {
			new Point(0, 0), new Point(100, 0), new Point(100, 100), new Point(0, 100), 
		};
		
		Assert.assertEquals(10000, Model.area(vertices));
		
	}
	
	@Test
	public void triangle() {
		Point[] vertices = new Point[] {
			new Point(0, 0), new Point(100, 0), new Point(100, 100) 
		};
		
		Assert.assertEquals(5000, Model.area(vertices));
		
	}
	
}

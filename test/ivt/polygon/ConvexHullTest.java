package ivt.polygon;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

public class ConvexHullTest {
	
	@Test
	public void convexHull() {
		Point[] points = new Point[] {
			new Point(0, 0), new Point(0, 100), new Point(100, 100), new Point(50, 50), new Point(45, 45),
			new Point(100, 0)
		};
		
		// clockwise order
		Point[] expected = new Point[] {
			new Point(0, 0), new Point(100, 0), new Point(100, 100), new Point(0, 100), 
		};
		
		Assert.assertArrayEquals(expected, ConvexHull.convexHull(points));
	}
	
}

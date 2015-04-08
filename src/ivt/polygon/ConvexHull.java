package ivt.polygon;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Convex hull algorithm implementation
 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Geometry/Convex_hull/Monotone_chain
 * 
 */
public class ConvexHull {
	
	static long cross(Point O, Point A, Point B) {
		return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
	}

	/**
	 * Convex hull algorithm
	 * algorithm described here:
	 * http://en.wikibooks.org/wiki/Algorithm_Implementation/Geometry/Convex_hull/Monotone_chain
	 * @param P list of points in random order
	 * @return convex hull in clockwise order
	 */
	public static Point[] convexHull(Point[] P) {
		
		if (P.length > 1) {
			int n = P.length, k = 0;
			Point[] H = new Point[2 * n];
 
			Arrays.sort(P, new Comparator<Point>() {

				@Override
				public int compare(Point self, Point p) {
					if (self.x == p.x) {
						return self.y - p.y;
					} else {
						return self.x - p.x;
					}
				}
				
			});
 
			// Build lower hull
			for (int i = 0; i < n; ++i) {
				while (k >= 2 && cross(H[k - 2], H[k - 1], P[i]) <= 0)
					k--;
				H[k++] = P[i];
			}
 
			// Build upper hull
			for (int i = n - 2, t = k + 1; i >= 0; i--) {
				while (k >= t && cross(H[k - 2], H[k - 1], P[i]) <= 0)
					k--;
				H[k++] = P[i];
			}
			if (k > 1) {
				// remove non-hull vertices after k; remove k - 1 which is a duplicate
				H = Arrays.copyOfRange(H, 0, k - 1);
			}
			return H;
		} else if (P.length <= 1) {
			return P;
		} else{
			return null;
		}
	}
	
}

package ivt.polygon;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model from MVC pattern
 * 
 * model is list of points + stroke width + color
 * contains most business logic like area calculation + keeping model state
 *
 */
public class Model {

	MainView view;

	List<Point> points = new ArrayList<>();
	
	Color color = Color.BLACK;
	
	int strokeWidth = 1;

	/**
	 * @param point point to add to the model + repaint view
	 */
	public void addPoint(Point point) {
		points.add(point);
		view.repaint();
	}

	/**
	 * @return points list of model
	 */
	public List<Point> getPoints() {
		return points;
	}

	/**
	 * removes last point from model
	 * forces view repaint
	 */
	public void removeLastPoint() {
		if (!points.isEmpty())
			points.remove(points.size() - 1);
		view.repaint();
	}
	
	/**
	 * @return convex hull of points of the model
	 */
	public Point[] convexHull() {
		return ConvexHull.convexHull(points.toArray(new Point[0]));
	}

	/**
	 * @return area of convexHull polygon of this model
	 */
	public int area() {
		return area(convexHull());
	}
	
	/**
	 * algorithm used http://www.wikihow.com/Calculate-the-Area-of-a-Polygon
	 * @param vertices array of vertices of polygon in clockwise or counterclockwise order
	 * @return area of polygon
	 */
	public static int area(Point[] vertices) {
		
		if (vertices.length < 3)
			return 0;
		
		System.out.println("vertices:" + Arrays.toString(vertices));
		
		
		int sum1 = 0;
		for (int i = 0; i < vertices.length - 1; ++i) {
			sum1 += vertices[i].x * vertices[i + 1].y;
		}
		sum1 += vertices[vertices.length - 1].x * vertices[0].y;
		System.out.println("sum1:" + sum1);
		
		int sum2 = 0;
		for (int i = 0; i < vertices.length - 1; ++i) {
			sum2 += vertices[i].y * vertices[i + 1].x;
		}
		sum2 += vertices[vertices.length - 1].y * vertices[0].x;
		System.out.println("sum1:" + sum2);

		int area = Math.abs((sum1 - sum2) / 2);
		
		return area;
	}

	/**
	 * @param color color setter + refresh view
	 */
	public void setColor(Color color) {
		this.color = color;
		view.repaint();
	}

	/**
	 * @param width width setter + refresh view
	 */
	public void setStrokeWidth(int width) {
		this.strokeWidth = width;
		view.repaint();
	}
	
	/**
	 * @param view view setter
	 */
	public void setView(MainView view) {
		this.view = view;
	}

}
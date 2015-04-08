package ivt.polygon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * main view
 * window shows polygon, reacts to user input
 * on doubleclick shows area of polygon  
 */
public class MainView extends JPanel {

	Model model;
	Controller controller;

	/**
	 * constructor
	 * sets backround to white
	 * adds mouse event handlers (user clicks handler)
	 */
	public MainView() {
		this.setBackground(Color.WHITE);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// rightclick check
				if (e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("right click");
					controller.removeLastFromModel();
					return;
				}
				
				// doubleclick check
				if (e.getClickCount() == 2) {
					System.out.println("double click");
					
					JOptionPane.showMessageDialog(MainView.this, "Area of polygon is " + model.area() + " square pixels");
					
					return;
				}

				System.out.println("single click");
				Point point = e.getPoint();
				controller.addPointToModel(point);
			}
		});

	}
	
	/**
	 * main view logic, repaints view, taking data fro model
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Point[] convexHull = model.convexHull();

		System.out.println(Arrays.toString(convexHull));
		
		System.out.println("area:" + Model.area(convexHull));
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(model.color);
		
		g2.setStroke(new BasicStroke(model.strokeWidth));
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// paint polygon
		for (int i = 1; i < convexHull.length; ++i) {
			Point a = convexHull[i-1];
			Point b = convexHull[i];
			g.drawLine(a.x, a.y, b.x, b.y);
		}
		
		// paint all points that were not into convex hull
		List<Point> convexHullList = Arrays.asList(convexHull);
		for (Point p : model.getPoints()) {
			if (convexHullList.contains(p)) {
				continue;
			}
			g.fillOval(p.x, p.y, 4, 4);
		}
		
		if (convexHull.length < 2)
			return;

		// last polygon segment
		Point a = convexHull[convexHull.length - 1];
		Point b = convexHull[0];
		g.drawLine(a.x, a.y, b.x, b.y);
		
		g.drawString("Area: " + model.area() + "px", 30, 30);

	}

	/**
	 * model setter
	 * @param model
	 */
	public void setModel(Model model) {
		this.model = model;
	}
	
	/**
	 * controller setter
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

}

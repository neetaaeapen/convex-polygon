package ivt.polygon;

import java.awt.Color;
import java.awt.Point;

/**
 * Controller class according to MVC pattern
 * has access to model, modifies model
 */
public class Controller {

	Model model;

	/**
	 * add @param point to model through controller
	 */
	public void addPointToModel(Point point) {
		model.addPoint(point);
	}

	/**
	 * remove point from model through controller
	 */
	public void removeLastFromModel() {
		model.removeLastPoint();
	}
	
	/**
	 * change color in model through controller
	 */
	public void changeColor(Color newColor) {
		model.setColor(newColor);
	}
	
	/**
	 * change stroke width through controller
	 * @param value
	 */
	public void changeStrokeWidth(int value) {
		model.setStrokeWidth(value);
	}

	/**
	 * @param model model setter for model access
	 */
	public void setModel(Model model) {
		this.model = model;
	}

}
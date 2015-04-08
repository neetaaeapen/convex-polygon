package ivt.polygon;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * main launcher class
 */
public class Main {

	/**
	 * main class
	 * links model view and controller together
	 * opens windows
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws UnsupportedLookAndFeelException
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		MainView view = new MainView();
		Model model = new Model();
		Controller controller = new Controller();
		
		view.setController(controller);
		model.setView(view);
		controller.setModel(model);
		view.setModel(model);

		JFrame mainWindow = new JFrame();
		mainWindow.setTitle("Convex Polygon");
		mainWindow.setSize(640, 480);
		mainWindow.add(view);
		mainWindow.setVisible(true);
		
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SettingsJFrame settings = new SettingsJFrame();
        settings.setController(controller);
        settings.setVisible(true);
        settings.setTitle("Settings");

	}

}

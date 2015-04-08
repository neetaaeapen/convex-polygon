/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivt.polygon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * settings window of program (color picker + stroke width picker + menu) 
 */
public class SettingsJFrame extends javax.swing.JFrame {

	/**
	 * constructor with handlers
	 */
    public SettingsJFrame() {
        initComponents();
        initHandlers();
    }

    protected javax.swing.JColorChooser colorPicker;
    protected javax.swing.JLabel labelStrokeSize;
    protected javax.swing.JMenu menu;
    protected javax.swing.JMenuBar menuBar;
    protected javax.swing.JMenuItem quitMenuItem;
    protected javax.swing.JMenuItem aboutMenuItem;
    protected javax.swing.JSlider slider;
    
    Controller controller;
    
    /**
     * inits controller handlers for color change
     * subscribes for changes on view
     */
    void initHandlers() {
    	colorPicker.getSelectionModel().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("color changed");
				controller.changeColor(colorPicker.getColor());
			}
		});
    	
    	slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("slider changed");
				controller.changeStrokeWidth(slider.getValue());
			}
		});
    	
    	quitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
    	
    	aboutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(SettingsJFrame.this, 
						"Finding convex hull and area of convex polygon.\n"
						+ "Manual: Leftclick adds a point to a model.\n"
						+ "Rightclick removes last point.\n"
						+ "Doubleclick finishes the polygon.\n"
						+ "You may pick color and stroke width in a separate window\n"
						+ "Timofey Forsov");
			}
		});
    	
    }

    /**
     * simple components init
     */
    private void initComponents() {

        colorPicker = new javax.swing.JColorChooser();
        labelStrokeSize = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        quitMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelStrokeSize.setText("Please choose stroke size:");

        slider.setMajorTickSpacing(1);
        slider.setMaximum(10);
        slider.setMinimum(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setValue(1);

        menu.setText("File");

        quitMenuItem.setText("Quit");
        menu.add(quitMenuItem);

        aboutMenuItem.setText("About");
        menu.add(aboutMenuItem);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStrokeSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStrokeSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }
    
    /**
     * controller setter
     * @param controller
     */
    public void setController(Controller controller) {
		this.controller = controller;
	}

}

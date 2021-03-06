package nl.parkingsimulator.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nl.parkingsimulator.logic.AbstractModel;
import nl.parkingsimulator.logic.CarParkModel;
import nl.parkingsimulator.logic.Settings;

/**
 * In this class a JFrame is made with several input fields to update
 * settings of the simulation.
 * 
 * @author Thom van Dijk
 */
public class SettingsController extends AbstractController implements ActionListener {
	private JLabel weekDayArrivalsLabel;
	private JTextField weekDayArrivalsField;
	
	private JLabel weekendArrivalsLabel;
    private JTextField weekendArrivalsField;
    
    private JLabel weekDayPassArrivalsLabel;
    private JTextField weekDayPassArrivalsField;
    
    private JLabel weekendPassArrivalsLabel;
    private JTextField weekendPassArrivalsField;

    private JLabel weekDayReservedLabel;
    private JTextField weekDayReservedField;
                         
    private JLabel weekendReservedLabel;
    private JTextField weekendReservedField;

    private JLabel weekDayBadParkersLabel;
    private JTextField weekDayBadParkersField;

    private JLabel weekendBadParkersLabel;
    private JTextField weekendBadParkersField;

    private JLabel setPricePerHourLabel;
    private JTextField setPricePerHourField;
    
    private JLabel setPricePassHolderLabel;
    private JTextField setPricePassHolderField;

    private JLabel setParkingFloorsLabel;
    private JTextField setParkingFloorsField;

    private JLabel setParkingRowsLabel;
    private JTextField setParkingRowsField;

    private JLabel setParkingPlacesPerRowLabel;
    private JTextField setParkingPlacesPerRowField;

    private JLabel setAmountPassRowsLabel;
    private JTextField setAmountPassRowsField;

    private JButton updateButton;

    private CarParkModel model;
    
    /**
     * Inside the constructor a JFrame is made witch contains all the buttons and text fields.
     * 
     * @param model 		The CarParkModel used to get the settings and given to AbstractController.
     * @param dimensions 	The dimensions to be assigned to the JFrame.
     * @param position		The position to be assigned to the JFrame.
     */
    public SettingsController(AbstractModel model, Dimension dimensions, Point position) {
        super(model);
        this.model = (CarParkModel)model;
        
        /**
         * Since we will probably never change this setting it is not implemented in the Settings class.
         */
        int scrollSpeed = 16;
        
        /**
         * Here we create the JFrame witch holds everything.
         */
        JFrame frame = new JFrame(this.model.getSettings().getSettingsControllerName());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setPreferredSize(dimensions);
        frame.setLocation(position);
        frame.setResizable(true);

        /**
         * Create the labels, text fields and buttons.
         */
        weekDayArrivalsLabel = new JLabel("Doordeweekse bezoekers");
        weekDayArrivalsField = new JTextField();
        weekDayArrivalsField.setText("100");
        
        weekendArrivalsLabel = new JLabel("Weekend bezoekers");
        weekendArrivalsField = new JTextField();
        weekendArrivalsField.setText("200");
        
        weekDayPassArrivalsLabel = new JLabel("Pashouders doordeweeks");
        weekDayPassArrivalsField = new JTextField();
        weekDayPassArrivalsField.setText("50");
        
        weekendPassArrivalsLabel = new JLabel("Pashouders weekend");
        weekendPassArrivalsField = new JTextField();
        weekendPassArrivalsField.setText("5");
        
        weekDayReservedLabel = new JLabel("Reserveringen doordeweeks");
        weekDayReservedField = new JTextField();
        weekDayReservedField.setText("25");
        
        weekendReservedLabel = new JLabel("Reserveringen weekend");
        weekendReservedField = new JTextField();
        weekendReservedField.setText("35");

        weekDayBadParkersLabel = new JLabel("Dubbel geparkeerd wekelijks");
        weekDayBadParkersField = new JTextField();
        weekDayBadParkersField.setText("20");

        weekendBadParkersLabel = new JLabel("Dubbel geparkeerd weekend");
        weekendBadParkersField = new JTextField();
        weekendBadParkersField.setText("20");

        setPricePerHourLabel = new JLabel("Prijs per uur");         
        setPricePerHourField = new JTextField();
        setPricePerHourField.setText("1,50");
        
        setPricePassHolderLabel = new JLabel("Prijs per abonnementhouder");        
		setPricePassHolderField = new JTextField();
		setPricePassHolderField.setText("60,00");

        if(this.model != null) {
            Settings settings = this.model.getSettings();
            setParkingFloorsLabel= new JLabel("Aantal verdiepingen");
            setParkingFloorsField = new JTextField();
            setParkingFloorsField.setText(String.valueOf(settings.getParkingFloors()));

            setParkingRowsLabel= new JLabel("Aantal rijen:");
            setParkingRowsField = new JTextField();;
            setParkingRowsField.setText(String.valueOf(settings.getParkingRows()));

            setParkingPlacesPerRowLabel = new JLabel("Aantal plek per rij:");
            setParkingPlacesPerRowField = new JTextField();
            setParkingPlacesPerRowField.setText(String.valueOf(settings.getParkingPlacesPerRow()));

            setAmountPassRowsLabel  = new JLabel("Aantal rijen pas plekken:");
            setAmountPassRowsField = new JTextField();
            setAmountPassRowsField.setText(String.valueOf(settings.getParkingPassRows()));
        }
 
        /**
         * Finally create the update button witch will update all settings from the input fields.
         */
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        updateButton.setToolTipText("klik om de waardes door te voeren.");
        
        /**
         * Create a JPanel container where we add all elements.
         */
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        int offset = 5;
        int groupOffset = 20;

        /**
         * Add vertical spacing between the elements with: Box.createRigidArea(new Dimension(0, offset))
         */
        container.add(weekDayArrivalsLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekDayArrivalsField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        
        container.add(weekendArrivalsLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekendArrivalsField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        
        container.add(weekDayPassArrivalsLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekDayPassArrivalsField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        
        container.add(weekendPassArrivalsLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekendPassArrivalsField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        
        container.add(weekDayReservedLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekDayReservedField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        
        container.add(weekendReservedLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekendReservedField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));

        container.add(weekDayBadParkersLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekDayBadParkersField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));

        container.add(weekendBadParkersLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(weekendBadParkersField);
        container.add(Box.createRigidArea(new Dimension(0, groupOffset)));

        container.add(setPricePerHourLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(setPricePerHourField);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        
        container.add(setPricePassHolderLabel);
        container.add(Box.createRigidArea(new Dimension(0, offset)));
        container.add(setPricePassHolderField);
        container.add(Box.createRigidArea(new Dimension(0, groupOffset)));

        if(this.model != null) {
            container.add(setParkingFloorsLabel);
            container.add(Box.createRigidArea(new Dimension(0, offset)));
            container.add(setParkingFloorsField);
            container.add(Box.createRigidArea(new Dimension(0, offset)));

            container.add(setParkingRowsLabel);
            container.add(Box.createRigidArea(new Dimension(0, offset)));
            container.add(setParkingRowsField);
            container.add(Box.createRigidArea(new Dimension(0, offset)));

            container.add(setParkingPlacesPerRowLabel);
            container.add(Box.createRigidArea(new Dimension(0, offset)));
            container.add(setParkingPlacesPerRowField);
            container.add(Box.createRigidArea(new Dimension(0, offset)));

            container.add(setAmountPassRowsLabel);
            container.add(Box.createRigidArea(new Dimension(0, offset)));
            container.add(setAmountPassRowsField);
            container.add(Box.createRigidArea(new Dimension(0, groupOffset)));
        }

        container.add(updateButton);
        
        /**
         * This will center all elements nicely. Also it prevents some overflow.
         */
        weekDayArrivalsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekDayArrivalsField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        weekendArrivalsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekendArrivalsField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        weekDayPassArrivalsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekDayPassArrivalsField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        weekendPassArrivalsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekendPassArrivalsField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        weekDayReservedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekDayReservedField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        weekendReservedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekendReservedField.setAlignmentX(Component.CENTER_ALIGNMENT);

        weekDayBadParkersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekDayBadParkersField.setAlignmentX(Component.CENTER_ALIGNMENT);

        weekendBadParkersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weekendBadParkersField.setAlignmentX(Component.CENTER_ALIGNMENT);

        setPricePerHourLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setPricePerHourField.setAlignmentX(Component.CENTER_ALIGNMENT);

		setPricePassHolderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		setPricePassHolderField.setAlignmentX(Component.CENTER_ALIGNMENT);

        setParkingFloorsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setParkingFloorsField.setAlignmentX(Component.CENTER_ALIGNMENT);

        setParkingRowsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setParkingRowsField.setAlignmentX(Component.CENTER_ALIGNMENT);

        setParkingPlacesPerRowLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setParkingPlacesPerRowField.setAlignmentX(Component.CENTER_ALIGNMENT);

        setAmountPassRowsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        setAmountPassRowsField.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        /**
         * Here we make all elements as big as possible so when the screen scales they scale with it.
         */
        int maxButtonWidth = Short.MAX_VALUE;
        int maxButtonHeight = Short.MAX_VALUE;

        weekDayArrivalsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekDayArrivalsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        
        weekendArrivalsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekendArrivalsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        
        weekDayPassArrivalsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekDayPassArrivalsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        
        weekendPassArrivalsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekendPassArrivalsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

        weekDayReservedLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekDayReservedField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
                            
        weekendReservedLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekendReservedField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

        weekDayBadParkersLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekDayBadParkersField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

        weekendBadParkersLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        weekendBadParkersField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        
        setPricePerHourLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        setPricePerHourField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
                                
        setPricePassHolderLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        setPricePassHolderField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

        if(this.model != null) {
            setParkingFloorsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
            setParkingFloorsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

            setParkingRowsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
            setParkingRowsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

            setParkingPlacesPerRowLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
            setParkingPlacesPerRowField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

            setAmountPassRowsLabel.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
            setAmountPassRowsField.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));
        }

        updateButton.setMaximumSize(new Dimension(maxButtonWidth, maxButtonHeight));

        /**
         * Add the container to a scroll pane.
         */
        JScrollPane scrollPane = new JScrollPane(container, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(scrollSpeed);
        
        /**
         * Add the scrollPane to the JFrame.
         */
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * An actionlistener function, triggered when a button is hit.
     * Here we change some graph related values inside the GraphLineView class.
     * 
     * @param e The event that has been fired
     */
    public void actionPerformed(ActionEvent e) {
    	/**
    	 * Update the values in settings.
    	 */
    	if(e.getSource() == updateButton) {
    	    Settings settings = this.model.getSettings();
            settings.setWeekDayArrivals(parseIntValue(weekDayArrivalsField));
            settings.setWeekendArrivals(parseIntValue(weekendArrivalsField));
            settings.setWeekDayPassArrivals(parseIntValue(weekDayPassArrivalsField));
            settings.setWeekendPassArrivals(parseIntValue(weekendPassArrivalsField));
            settings.setWeekDayReserved(parseIntValue(weekDayReservedField));
            settings.setWeekendReserved(parseIntValue(weekendReservedField));
            settings.setWeekDayBadParkers(parseIntValue(weekDayBadParkersField));
            settings.setWeekendBadParkers(parseIntValue(weekendBadParkersField));
            settings.setPricePerHour(parseFloatValue(setPricePerHourField));
            settings.setPricePerPassHolder(parseFloatValue(setPricePassHolderField));
            settings.setParkingFloors(parseIntValue(setParkingFloorsField));
            settings.setParkingRows(parseIntValue(setParkingRowsField));
            settings.setParkingPlacesPerRow(parseIntValue(setParkingPlacesPerRowField));
            settings.setParkingPassRows(parseIntValue(setAmountPassRowsField));
            this.model.setSettings(settings);
            this.model.resetSimulation();
        }
    }

    /**
     * Parses the value of an input field to an integer.
     * 
     * @param input The input field we need to read our integers from.
     */
    private int parseIntValue(JTextField input) throws NumberFormatException {
        return Integer.parseInt(input.getText());
    }
    
    /**
     * Parses the value of an input field to a float.
     * 
     * @param input The input field we need to read our float values from.
     */
    private float parseFloatValue(JTextField input) throws NumberFormatException {
    	// Because we use a comma in The Netherlands for money values it needs to be replaced.
    	String str = input.getText().replace(',', '.'); 
        return Float.parseFloat(str);
    }
}

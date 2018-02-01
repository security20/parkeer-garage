package nl.parkingsimulator.main;

import javax.swing.*;

import nl.parkingsimulator.controller.*;
import nl.parkingsimulator.logic.*;
import nl.parkingsimulator.view.*;

import java.awt.*;

public class MVCMain {
	private Settings settings;
    private AbstractModel model;
    private JFrame screen;
    
    private AbstractView carParkView;
    private AbstractView textView;
    private AbstractView timeView;
    private AbstractView reservationView;
    private AbstractView graphLineView;
    private PieChartView pieChartView;

    private AbstractController tickController;
    private AbstractController pieChartController;
    private GraphLineController graphLineController;
    private SettingsController settingsController;
    private AbstractController reservationController;

    public MVCMain() {
        settings = new Settings();
        model = new CarParkModel(settings);
        
        /**
         * Creating the main screen...
         */
        JFrame.setDefaultLookAndFeelDecorated(settings.getDefaultLookAndFeel());
        screen = new JFrame(settings.getScreenName());
        screen.setSize(settings.getScreenDimension());
        screen.setResizable(settings.getScreenIsResizable());
        screen.setLayout(null);
        screen.setLocation(settings.getScreenPosition());
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // JFrame.DISPOSE_ON_CLOSE
        screen.setVisible(true);
        
        carParkView = new CarParkView(model, settings.getCarParkViewDimensions());
        textView = new TextView(model);
        timeView = new TimeView(model, settings.getTimeViewDimensions());
        reservationView = new ReservationView(model);
        graphLineView = new GraphLineView(model);
        pieChartView = new PieChartView(model);
        
        tickController = new TickController(model);
        pieChartController = new PieChartController(model);
        graphLineController = new GraphLineController(model, settings.getGraphLineControllerDimensions(), settings.getGraphLineControllerPosition(), (GraphLineView) graphLineView);

        /**
         * Add elements to the main screen.
         */
        addNewElement(carParkView, settings.getCarParkViewPosition(), settings.getCarParkViewDimensions());
        addNewElement(textView, settings.getTextViewPosition(), settings.getTextViewDimensions());
        addNewElement(timeView, settings.getTimeViewPosition(), settings.getTimeViewDimensions());

        /**
         * Prevents drawing glitch, should be looked into!
         */
        timeView.setOpaque(false);
        textView.setOpaque(false);

        CarParkModel carModel = (CarParkModel)model;
        carModel.notifyViews();

        /**
         * Creating separate windows here...
         */
        JFrame controllerFrame = windowBuilder(settings.getTickControllerName(), settings.getTickControllerDimensions(), settings.getTickControllerPosition());
        controllerFrame.add(tickController);

        //JFrame reservationsFrame = windowBuilder(settings.getReservationsName(), settings.getReservationsDimensions(), settings.getReservationsPosition());
        //reservationController = new ReservationsController(model, reservationsFrame.getContentPane().getSize());
        //reservationsFrame.add(reservationController);

        JFrame settingsFrame = windowBuilder(settings.getSettingsControllerName(), settings.getSettingsControllerDimensions(), settings.getSettingsControllerPosition());
        //When giving the content pane size directly to the constructor of the settings controller the content inside the JFrame will have the correct dimensions.
        settingsController = new SettingsController(model, settingsFrame.getContentPane().getSize());
        settingsFrame.add(settingsController);

        //Frame histogramFrame = windowBuilder(settings.getHistogramName(), settings.getHistogramDimensions(), settings.getHistogramPosition()); this is adding an additional panel unnecessary
        HistogramView histogrampanel;
        histogrampanel = new HistogramView(model);
        histogrampanel.setBounds(0, 0, 200, 200);
    }

    private void addNewElement(JPanel view, Point pos, Dimension dimension) {
        view.setBounds(pos.x, pos.y, dimension.width, dimension.height);
        screen.getContentPane().add(view);
    }

    /**
     * Creates a frame to be used for the viewers and controllers
     *
     * @param title the title for the frame
     * @param dimension the dimension of the frame
     * @param location the location of the frame i the screen
     * @return the frame that has been made
     */
    private JFrame windowBuilder(String title, Dimension dimension, Point location) {
        JFrame.setDefaultLookAndFeelDecorated(settings.getDefaultLookAndFeel());
        JFrame frame = new JFrame(title);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.GRAY);
        frame.setSize(dimension);
        frame.setVisible(true);
        frame.setLocation(location);

        return frame;
    }
}

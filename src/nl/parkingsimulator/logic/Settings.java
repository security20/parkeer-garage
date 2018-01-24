/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.parkingsimulator.logic;

import java.awt.Dimension;
import java.awt.Point;

/**
 * This class contains all variables needed in more than 
 * one place or variables which are changed during runtime.
 * 
 * @author Thom van Dijk
 */
public class Settings {
    /**
     *  Variables for CarParkModel.
     */
    private int parkingFloors = 3;
    private int parkingRows = 6;
    private int parkingPlacesPerRow = 30;
    
    private int tickPause = 100;
    private int amountOfTicks = 1000;
    
    private int weekDayArrivals= 100; // average number of arriving cars per hour
    private int weekendArrivals = 200; // average number of arriving cars per hour
    private int weekDayPassArrivals= 50; // average number of arriving cars per hour
    private int weekendPassArrivals = 5; // average number of arriving cars per hour
 
    private int enterSpeed = 3; // number of cars that can enter per minute
    private int paymentSpeed = 7; // number of cars that can pay per minute
    private int exitSpeed = 5; // number of cars that can leave per minute
    
    /**
     *  Settings of the main screen.
     */
    private Dimension screenDimension = new Dimension(1200, 800);
    private boolean screenIsResizable = false;
    private String screenName = "Parkeer Simulator";

    /**
     *  Default position and size values for the screens.
     */
    private Point pieChartPosition = new Point(0, 0);
    private Dimension pieChartDimensions = new Dimension(200, 350);
    private String pieChartName = "Taart Grafiek";

    private Point tickControllerPosition = new Point(1200, 0);
    private Dimension tickControllerDimensions = new Dimension(300, 300);
    private String tickControllerName = "Start";

    private Point graphLinePosition = new Point(10, 460);
    private Dimension graphLineDimensions = new Dimension(700, 500);
    private String graphLineName = "Grafiek";

    private Point reservationsPosition = new Point(1200, 305);
    private Dimension reservationsDimensions = new Dimension(300, 300);
    private String reservationsName = "Resarveringen";

    private Point carParkViewPosition = new Point(0, 50);
    private Dimension carParkViewDimensions = new Dimension(1000, 400);

    private Point textViewPosition = new Point(50, 0);
    private Dimension textViewDimensions = new Dimension(300, 100);

    private Point timeViewPosition = new Point(400, 0);
    private Dimension timeViewDimensions = new Dimension(200, 50);
    
    /**
     *  Getters for CarParkModel.
     */
    public int getParkingFloors() { return parkingFloors; }
    public int getParkingRows() { return parkingRows; }
    public int getParkingPlacesPerRow() { return parkingPlacesPerRow; }
    
    public int getTickPause() { return tickPause; }
    public int getAmountOfTicks() { return amountOfTicks; }
    
    public int getWeekDayArrivals() { return weekDayArrivals; } // average number of arriving cars per hour
    public int getWeekendArrivals() { return weekendArrivals; } // average number of arriving cars per hour
    public int getWeekDayPassArrivals() { return weekDayPassArrivals; } // average number of arriving cars per hour
    public int getWeekendPassArrivals() { return weekendPassArrivals; } // average number of arriving cars per hour
               
    public int getEnterSpeed() { return enterSpeed; } // number of cars that can enter per minute
    public int getPaymentSpeed() { return paymentSpeed; } // number of cars that can pay per minute
    public int getExitSpeed() { return exitSpeed; } // number of cars that can leave per minute
    
    /**
     *  Getters for main screen.
     */
    public Dimension getScreenDimension() { return screenDimension; }
    public boolean getScreenIsResizable() { return screenIsResizable; }
    public String getScreenName() { return screenName; }
    
    /**
     *  Getters for sub screens.
     */
    public Point getPieChartPosition() { return pieChartPosition; };
    public Dimension getPieChartDimensions() { return pieChartDimensions; };
    public String getPieChartName() { return pieChartName; };

    public Point getTickControllerPosition() { return tickControllerPosition; };
    public Dimension getTickControllerDimensions() { return tickControllerDimensions; };
    public String getTickControllerName() { return tickControllerName; };

    public Point getGraphLinePosition() { return graphLinePosition; };
    public Dimension getGraphLineDimensions() { return graphLineDimensions; };
    public String getGraphLineName() { return graphLineName; };

    public String getReservationsName() { return reservationsName; };
    public Dimension getReservationsDimensions() { return reservationsDimensions; };
    public Point getReservationsPosition() { return reservationsPosition; };

    public Point getCarParkViewPosition() { return carParkViewPosition; };
    public Dimension getCarParkViewDimensions() { return carParkViewDimensions; };

    public Point getTextViewPosition() { return textViewPosition; };
    public Dimension getTextViewDimensions() { return textViewDimensions; };

    public Point getTimeViewPosition() { return timeViewPosition; };
    public Dimension getTimeViewDimensions() { return timeViewDimensions; };
}


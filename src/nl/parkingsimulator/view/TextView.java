package nl.parkingsimulator.view;

import nl.parkingsimulator.logic.AbstractModel;
import nl.parkingsimulator.logic.CarParkModel;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Locale;
/**
 * Textview creates labels showing how many cars are missed, which event is happening, 
 * how many money there is earned and how many money you still get.
 * 
 * @author Jeroen Westers
 * @author Thom van Dijk (repositioning of labels and removed hardcoded values)
 */
public class TextView extends AbstractView {

    private JLabel informationLabel;
    private JLabel totalRevenueLabel;
    private JLabel notPayedRevenueLabel;
    private JLabel missedCars;
    private JLabel currentEvent;

    /**
     * Constructor for objects of class TextCiew
     * @param model The model where to data comes from
     */
    public TextView(AbstractModel model) {
        super(model);

        setSize(getPreferredSize());
        setLayout(null);

        informationLabel = new JLabel();
        missedCars = new JLabel();
        totalRevenueLabel = new JLabel();
        notPayedRevenueLabel = new JLabel();
        currentEvent = new JLabel();
        
        int borderTop = 20;
        int borderLeft = 25;
        int offset = 15;
        int textHeight = 15;

        informationLabel.setFont(new Font(informationLabel.getFont().getFontName(), Font.PLAIN, 15));
        informationLabel.setBounds(borderLeft, borderTop, 100, textHeight);
        missedCars.setBounds(borderLeft, borderTop + offset, 200, textHeight);
        totalRevenueLabel.setBounds(borderLeft, borderTop + (offset * 2), 200, textHeight);
        notPayedRevenueLabel.setBounds(borderLeft, borderTop + (offset * 3), 200, textHeight);
        currentEvent.setBounds(borderLeft, borderTop + (offset * 4), 200, textHeight);

        add(informationLabel);
        add(missedCars);
        add(totalRevenueLabel);
        add(notPayedRevenueLabel);
        add(currentEvent);

        informationLabel.setText("Informatie:");
    }

    /**
     * Overridden. Tells to update the labels and updates the view
     */
    @Override
    public void updateView() {

        CarParkModel model = (CarParkModel) getModel();
        if(model != null){
            missedCars.setText("Gemiste auto's: " + model.getMissedCarsMinute()); // get missed cars

            totalRevenueLabel.setText("Opbrengst vandaag: " + NumberFormat.getCurrencyInstance(new Locale("nl", "NL"))
        .format(model.getRevenue())); // show revenue

            notPayedRevenueLabel.setText("Nog te betalen: " + NumberFormat.getCurrencyInstance(new Locale("nl", "NL"))
        .format(model.getRevenueNotPaid())); // show not payed revenue

            currentEvent.setText("Huidige event: " + model.getEventTitle()); // Set current event
        }

        super.updateView();
    }

    /**
     * Overridden. Tell the GUI manager how big we would like to be.
     */
    public Dimension getPreferredSize() {
        return new Dimension(400, 220);
    }

    /**
     * Overridden. Draws all the elements on the screen
     * @param g The graphics to draw on
     */
    @Override
    public void paintComponent(Graphics g) {

    }

    /**
     * Converts the given amount to money format
     * @param money The number we need to convert.
     * @return The formatted money string
     */
    private String formatMoney(double money){
        return String.format("%.2f", money); // format the giving amount to money format
    }
}
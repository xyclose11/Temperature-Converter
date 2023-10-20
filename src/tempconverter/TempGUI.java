/*
    Harris Gustafson
    TempConverter.java
    10/17/2023
    Simple Java temperature converter. Can convert to and from the following:
    - Celcius
    - Farenheight
    - Kelvin

 */

package tempconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO:
/*
    - Limit Testing
    - Modern UI
    - Progress Bar
    - Input Validation
    - See if Enums are applicable and better here
    - Add more features?



 */

public class TempGUI {
    private JPanel TempCGUI;
    private JTextField inputTxt;
    private JButton Submit;
    private JTextField resultsTxt;
    public JRadioButton fromCelcius;
    private JRadioButton fromFarenheight;
    private JRadioButton fromKelvin;
    private JButton Clear;
    private JLabel InputType;
    private JLabel OutputType;
    private JRadioButton toCelcius;
    private JRadioButton toFarenheight;
    private JRadioButton toKelvin;
    private JLabel userInputLabel;
    private JLabel fLabel;
    private Double userInput;
    private final Double kelvinValue = 273.15;


    public TempGUI() {
        Submit.addActionListener(new btnClicked(Submit.getText()));
        inputTxt.addActionListener(new btnClicked(inputTxt.getText()));
        Clear.addActionListener(new clrBtn());


        fromCelcius.setSelected(true);
        toCelcius.setSelected(true);


    }



    private class rdBtnClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTxt.setText("Test");
        }
    }

    private class clrBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            resultsTxt.setText("");
        }
    }

    public class btnClicked implements ActionListener {
        private String value;

        public btnClicked(String value) {
            this.value = value;
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Double.parseDouble(inputTxt.getText());
                if (fromCelcius.isSelected() == true) {
                    if (toKelvin.isSelected() == true) {
                        resultsTxt.setText("" + (userInputFunction()+ kelvinValue));
                    } else if (toFarenheight.isSelected() ==  true) {
                        resultsTxt.setText("" + (userInputFunction() * 1.8 + 32) );
                    } else {
                        resultsTxt.setText("" + (userInputFunction()));
                    }

                } else if (fromFarenheight.isSelected() == true) {
                    if (toKelvin.isSelected() == true) {
                        resultsTxt.setText("" + ((userInputFunction() - 32) / 1.8 + kelvinValue));
                    } else if (toCelcius.isSelected()) {
                        resultsTxt.setText("" + (userInputFunction() - 32) / 1.8);
                    } else {
                        resultsTxt.setText("" + (userInputFunction()));
                    }

                } else if (fromKelvin.isSelected() == true) {
                    if (toCelcius.isSelected() == true) {
                        resultsTxt.setText("" + (userInputFunction() - kelvinValue));
                    } else if (toFarenheight.isSelected() == true) {
                        resultsTxt.setText("" + (userInputFunction() - kelvinValue) * 1.8 + 32);
                    } else {
                        resultsTxt.setText("" + (userInputFunction()));
                    }

                }
            }

            catch (NumberFormatException r) {
                resultsTxt.setText("INPUT MUST BE A NUMBER");
            }


        }

        public double userInputFunction() {
            value = inputTxt.getText();
            userInput = Double.parseDouble(value);
            return userInput;
        }


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setContentPane(new TempGUI().TempCGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncomeTaxCalculatorGUI {

    private JPanel panel;
    private JTextField txtMonthlySalary;
    private JTextField txtEstimatedAnnualSalary;
    private JTextField txtMonthlyIncomeTax;
    private JButton btnCompute;
    private JButton btnClear;


    public IncomeTaxCalculatorGUI() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double monthlySalary = Double.parseDouble(txtMonthlySalary.getText());
                    double monthlyIncomeTax = computeTax(monthlySalary);
                    double estimatedAnnualSalary = monthlySalary * 12;
                    String estimatedAnnualSalaryFinal = String.format("%,.2f", estimatedAnnualSalary);
                    String monthlyIncomeTaxFinal = String.format("%,.2f", monthlyIncomeTax);
                    txtMonthlyIncomeTax.setText("P" + monthlyIncomeTaxFinal);
                    txtEstimatedAnnualSalary.setText("P" + estimatedAnnualSalaryFinal);
                }
                catch(RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, "You have entered an invalid input. Please try again.");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMonthlySalary.setText("");
                txtMonthlyIncomeTax.setText("");
                txtEstimatedAnnualSalary.setText("");
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Income Tax Calculator");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 80);
        frame.setContentPane(new IncomeTaxCalculatorGUI().panel);

        frame.setTitle("Income Tax Calculator - Neil Rendell Reglos");
        frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);




    }


    public static double computeTax(double monthlySalary)
    {
        final int TWELVE_MONTHS;
        final int TWO_HUNDRED_FIFTY;
        final int FOUR_HUNDRED;
        final int EIGHT_HUNDRED;
        final int MIL_TWO;
        final int MIL_EIGHT;
        final int THIRTY_THOU;
        final int ONE_THIRTY_THOU;
        final int FOUR_NINETY_THOU;
        final int TWO_MIL_FOUR_HUNDRED_TEN;
        final double TWENTY;
        final double TWENTY_FIVE;
        final double THIRTY;
        final double THIRTY_TWO;
        final double THIRTY_FIVE;
        final int ZERO;
        double annualSalary;
        double rate;
        double monthlyIncomeTax;


        TWO_HUNDRED_FIFTY = 250000;
        FOUR_HUNDRED = 400000;
        EIGHT_HUNDRED = 800000;
        MIL_TWO = 2000000;
        MIL_EIGHT = 8000000;
        THIRTY_THOU = 30000;
        ONE_THIRTY_THOU = 130000;
        FOUR_NINETY_THOU = 490000;
        TWO_MIL_FOUR_HUNDRED_TEN = 2410000;
        TWELVE_MONTHS = 12;
        TWENTY = 0.2;
        TWENTY_FIVE = 0.25;
        THIRTY = 0.3;
        THIRTY_TWO = 0.32;
        THIRTY_FIVE = 0.35;
        ZERO = 0;



        annualSalary = monthlySalary * TWELVE_MONTHS;
        if (annualSalary > TWO_HUNDRED_FIFTY && annualSalary <= FOUR_HUNDRED)
        {
            rate = (annualSalary - TWO_HUNDRED_FIFTY) * TWENTY;
            monthlyIncomeTax = rate / TWELVE_MONTHS;
        }
        else if (annualSalary > FOUR_HUNDRED && annualSalary <= EIGHT_HUNDRED)
        {
            rate = THIRTY_THOU + ((annualSalary - FOUR_HUNDRED) * TWENTY_FIVE);
            monthlyIncomeTax = rate / TWELVE_MONTHS;
        }
        else if (annualSalary > EIGHT_HUNDRED && annualSalary <= MIL_TWO)
        {
            rate = ONE_THIRTY_THOU + ((annualSalary - EIGHT_HUNDRED) * THIRTY);
            monthlyIncomeTax = rate / TWELVE_MONTHS;
        }
        else if (annualSalary > MIL_TWO && annualSalary <= MIL_EIGHT)
        {
            rate = FOUR_NINETY_THOU + ((annualSalary - MIL_TWO) * THIRTY_TWO);
            monthlyIncomeTax = rate / TWELVE_MONTHS;
        }
        else if (annualSalary > MIL_EIGHT)
        {
            rate = TWO_MIL_FOUR_HUNDRED_TEN + ((annualSalary - MIL_EIGHT) * THIRTY_FIVE);
            monthlyIncomeTax = rate / TWELVE_MONTHS;
        }
        else
        {
            rate = annualSalary  * ZERO;
            monthlyIncomeTax = rate / TWELVE_MONTHS;
        }
        return monthlyIncomeTax;

    }
}

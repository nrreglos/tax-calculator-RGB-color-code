import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RGBGUI {
    private JTextField txtRed;
    private JTextField txtGreen;
    private JTextField txtBlue;
    private JButton btnColorFind;
    private JButton btnClear;
    private JButton btnColor;
    private JLabel lblColor;
    private JLabel lblRed;
    private JLabel lblGreen;
    private JLabel lblBlue;
    private JLabel lblTitle;
    private JPanel panel;


    public RGBGUI() {
        btnColorFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                int red = Integer.parseInt(txtRed.getText());
                int green = Integer.parseInt(txtGreen.getText());
                int blue = Integer.parseInt(txtBlue.getText());
                int colorAssign = colorSystem(red, green, blue);
                if (colorAssign == 1)
                {
                    btnColor.setBackground(Color.black);
                }
                else if (colorAssign == 2)
                {
                    btnColor.setBackground(Color.blue);
                }
                else if (colorAssign == 3)
                {
                    btnColor.setBackground(Color.green);
                }
                else if (colorAssign == 4)
                {
                    btnColor.setBackground(Color.cyan);
                }
                else if (colorAssign == 5)
                {
                    btnColor.setBackground(Color.red);
                }
                else if (colorAssign == 6)
                {
                    btnColor.setBackground(Color.magenta);
                }
                else if (colorAssign == 7)
                {
                    btnColor.setBackground(Color.yellow);
                }
                else if (colorAssign == 8)
                {
                    btnColor.setBackground(Color.white);
                }
                else if (colorAssign == 0)
                {
                   JOptionPane.showMessageDialog(null, "You have entered an invalid input.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You have entered an invalid input.");
                }

            }
                catch (RuntimeException ex)
                {
                    JOptionPane.showMessageDialog(null, "You have entered an invalid input.");
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtRed.setText("");
                txtGreen.setText("");
                txtBlue.setText("");
                btnColor.setBackground(null);
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("RGB COLOR IDENTIFIER");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 80);
        frame.setContentPane(new RGBGUI().panel);

        frame.setTitle("RGB COLOR IDENTIFIER - Neil Rendell Reglos");
        frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);




    }
    public static int colorSystem(int red, int green, int blue)
    {

        final int ZERO;
        final int TWO_FIFTY_FIVE;
        ZERO = 0;
        TWO_FIFTY_FIVE = 255;
        int colorNum;


        if (red == ZERO && green == ZERO && blue == ZERO){
            colorNum = 1;

        }
        else if (red == ZERO && green == ZERO && blue == TWO_FIFTY_FIVE){
            colorNum = 2;

        }
        else if (red == ZERO && green == TWO_FIFTY_FIVE && blue == ZERO){
            colorNum = 3;

        }
        else if (red == ZERO && green == TWO_FIFTY_FIVE && blue == TWO_FIFTY_FIVE){
            colorNum = 4;

        }
        else if (red == TWO_FIFTY_FIVE && green == ZERO && blue == ZERO){
            colorNum = 5;

        }
        else if (red == TWO_FIFTY_FIVE && green == ZERO && blue == TWO_FIFTY_FIVE){
            colorNum = 6;

        }
        else if (red == TWO_FIFTY_FIVE && green == TWO_FIFTY_FIVE && blue == ZERO){
            colorNum = 7;

        }
        else if (red == TWO_FIFTY_FIVE && green == TWO_FIFTY_FIVE && blue == TWO_FIFTY_FIVE){
            colorNum = 8;

        }
        else
        {
            colorNum = 0;
        }
        return colorNum;
    }
}

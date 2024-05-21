// Kyle Petersen
// 05/20/2024
// CSC372 CTA2

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {

        // declare and initialize a BankAccoun
        BankAccount account = new BankAccount(100);

        // Create Java Swing components
        JFrame frame = new JFrame("Bank App");
        JPanel panel = new JPanel();
        JLabel balanceLabel = new JLabel("Your current balance is: $" + account.getBalance());
        JTextField amountField = new JTextField(10);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JLabel label = new JLabel("Enter amount: ");
        
        // Set panel layout
        panel.setLayout(new GridLayout(3, 2));
        panel.add(label);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);


        // Listeners
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                balanceLabel.setText("Your current balance is: $" + account.getBalance());
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                balanceLabel.setText("Your current balance is: $" + account.getBalance());
            }
        });

        
        // Set frame properties
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
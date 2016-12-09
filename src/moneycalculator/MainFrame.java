package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDialog;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MainFrame extends JFrame{
    
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    
    public MainFrame(){
        this.setTitle("Money Calculator");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.add(toolbar(),BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private Component moneyDialog() {
        SwingMoneyDialog moneyDialog = new SwingMoneyDialog();
        this.moneyDialog = moneyDialog;
        return moneyDialog;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay moneyDisplay = new SwingMoneyDisplay();
        this.moneyDisplay = moneyDisplay;
        return moneyDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }

    private Component calculateButton() {
        JButton button = new JButton("Calculate");
        return button;
    }

    
    
    
}

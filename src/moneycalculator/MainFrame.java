package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDialog;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MainFrame extends JFrame{
    
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    
    public MainFrame(){
        setTitle("Money Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(moneyDialog(), BorderLayout.NORTH);
        add(moneyDisplay());
        add(toolbar(),BorderLayout.SOUTH);
        setVisible(true);
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
        JButton button = new JButton("Calculate");
        return button;
    }

    
    
    
}

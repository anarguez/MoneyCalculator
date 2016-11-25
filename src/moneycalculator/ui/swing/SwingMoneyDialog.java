package moneycalculator.ui.swing;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{

    private String amount = "100";
    private Currency currency;

    public SwingMoneyDialog() {
        setLayout(new FlowLayout());
        add(amount());
        add(currency());
    
    }
     
    @Override
    public Money get() {
        return new Money(Double.parseDouble(amount),currency);
    }

    private Component amount() {
        JTextField field = new JTextField(amount);
        field.setColumns(10);
        field.getDocument().addDocumentListener(amountChanged());
        return field;
    }

    private Component currency() {
        JComboBox<Currency> combo = new JComboBox<>(currencies());
        combo.addItemListener(currencyChanged());
        return combo;
    }
    
    private Currency[] currencies(){
        return new Currency[]{
            new Currency("USD","DÓLAR AMERICANO","$"),
            new Currency("GBP","LIBRA ESTERLINA","$"),
            new Currency("CAD","DÓLAR CANADIENSE","$"),
        };    
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED) return;
                currency = (Currency) e.getItem();
            }
        };
    }

    private DocumentListener amountChanged() {
        return new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateAmount(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateAmount(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateAmount(e);
            }

            private void updateAmount(DocumentEvent e) {
                try {
                    amount = e.getDocument().getText(0, e.getDocument().getLength());
                } catch (BadLocationException ex) {
                }
            }
        };
    }
    
}

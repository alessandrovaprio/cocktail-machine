package cocktail.machine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmButtonListener implements ActionListener  {

    Receipt[] receipts;
    boolean confirm;
    JFrame frame;
    ConfirmButtonListener(Receipt[] receipts, boolean confirm, JFrame frame) {
        this.confirm = confirm;
        this.receipts = receipts;
        this.frame = frame;

    }
    public void actionPerformed(ActionEvent e){
        if (confirm ) {
            DB db = new DB();
            if ( receipts[0].cockatils.size() > 0 ) {
            	if (db.InsertReceiptAndOrders(receipts[0])) {
                    System.out.println("order "+ receipts[0].getOrderNumber());
                    JOptionPane.showMessageDialog(frame, " Your order number is: "+receipts[0].getOrderNumber() + "\n Can you take it at Bar when your number is called. \n Thank YOU.");
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Something went wrong, please contact the bar! ");
                }
            } else {
            	JOptionPane.showMessageDialog(frame, "Yuor order is empty! \nplease select one drink at least. ");
            }
            
        } else {
            JOptionPane.showMessageDialog(frame, "Yuor order is canceled! ");
        }
        receipts[0].removeAllCocktails();
       //total[0] += cocktail.cost();

        //receipts[0] = receipts[0].;
        //System.out.println("evvia "+ receipts[0].cockatils.toString() +"  "+ receipts[0].total);
    }  
}
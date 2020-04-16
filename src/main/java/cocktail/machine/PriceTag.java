package cocktail.machine;

import javax.swing.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class PriceTag  implements Observer {

    private Receipt receipt = null;
    private JTextField field = null;
    private JTextArea list = null;
    public PriceTag ( Receipt receipt, JTextField field,  JTextArea list) {
        this.receipt = receipt;
        this.field = field;
        this.list = list;
    }
    @Override
    public void update(Observable observable, Object o) {
        if ( observable == receipt ) {
            System.out.println("updateddddd" + receipt.total );
            field.setText(receipt.total+" $");
            list.setText("");
            String text = list.getText() == null ? "" : list.getText();
            if ( String.join("\n",receipt.cockatils.toString()).isEmpty() ) {
                text = "";
                list.setText(text);
            } else {

                for (Cocktail cocktails : receipt.cockatils) {
                    list.append(cocktails.getDescription()+"\n");
                }
                //list.setText("<html>"+text + "<br>" + String.join(",",receipt.cockatils.toString())+"</html>");
            }
            System.out.println("updateddddd "+String.join(",",receipt.cockatils.toString()) );

        } else {
            System.out.println("updateddddd nothing" );
        }

    }
}

package cocktail.machine;
import java.awt.event.*;  

public class CocktailButtonListener implements ActionListener  {
    Cocktail cocktail;
    Receipt[] receipts;
    CocktailButtonListener(Cocktail c, Receipt[] receipts) {
        this.cocktail = c;
        this.receipts = receipts;
    }
    public void actionPerformed(ActionEvent e){  
       //total[0] += cocktail.cost();
        receipts[0].addCocktail(cocktail);
        //receipts[0].notifyUpdate(receipts[0].total);
        //receipts[0].totalPriceChanged();
        //receipts[0] = receipts[0].;
        System.out.println("evvia "+ receipts[0].cockatils.toString() +"  "+ receipts[0].total);
    }  
}
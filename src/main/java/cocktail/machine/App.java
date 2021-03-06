/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cocktail.machine;

import java.util.List;
import javax.swing.*;

import java.awt.*;


public class App {
    
    public static Receipt[] receipts = {new Receipt()};
    
    public static void main(String[] args) {
    	

    DB db = new DB();
    List<CocktailClass> cocktailsList = db.getAllCocktails();
    List<Cocktail> list = null;
    int rows = (cocktailsList.size() / 2) +1;
    JFrame frame = showWindow(600);
    showButton(frame, cocktailsList, rows,2);
    frame.setVisible(true);
        //list.add(cocktail);
       // System.out.println(cocktail.getDescription() + " "+ cocktail.cost() + " " + cocktail.getIngredients());
        //frame.setVisible(true);

    }

    public static JFrame showWindow(int dimension) {
        JFrame frame = new JFrame("Cocktail MAchine - Select a Drink");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(dimension,dimension);
        GridBagLayout layout = new GridBagLayout();
        //GridLayout layout = new GridLayout(rows,cols, 5, 5);
        frame.setLayout(layout);
        return frame;
    }
    private static void showButton(JFrame frame, List<CocktailClass> cocktailsList, int rows, int cols) {

       
        GridBagConstraints gbc = new GridBagConstraints();
 
        // Put constraints on different buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 2;
        
        // frame.add(new JButton("Button1"), gbc);
 
        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // panel.add(new JButton("Button 2"), gbc);
 
        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.gridwidth = 2;
        // panel.add(new JButton("Button 3"), abc);

        int r=0,col =0;
        for ( CocktailClass c : cocktailsList) {
            AbstractFactory factory = FactoryProducer.getFactory(c.isAlchoolic);
            Cocktail cocktail = factory.getCocktail(c.name, c);
            if (cocktail != null) {
                gbc.gridx = 0;
                gbc.gridy = col;
                gbc.gridwidth = 3;
                JButton button = new JButton("<html>"+cocktail.getDescription()+"<br><br><hr> Ingredients: "+cocktail.getIngredients()+"</html>");
                button.setHorizontalAlignment(SwingConstants.LEFT);
                Insets mt = new Insets(2, 2, 2, 2);
                button.setMargin(mt);
                button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                System.out.println("button "+cocktail.getDescription());
                //frame.getContentPane().add(button); // Adds Button to content pane of frame
                frame.add(button, gbc);
                button.addActionListener(new CocktailButtonListener(cocktail, receipts));
                col++;
            }
            
        }
        //frame.add(Box.createVerticalStrut(20));
        /*gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        //gbc.ipadx =2;
        frame.add(new JLabel("Cost $"), gbc);
        */


        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        JTextArea listField = new JTextArea();
        listField.setEditable(false);
        frame.add(listField, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        JTextField field = new JTextField();
        field.setEditable(false);
        frame.add(field, gbc);



        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;

        JButton button = new JButton("Confirm");
        frame.add(button, gbc);
        button.addActionListener(new ConfirmButtonListener(receipts, true, frame));


        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;

        button = new JButton("Cancel");
        frame.add(button, gbc);
        button.addActionListener(new ConfirmButtonListener(receipts, false, frame));

        // frame.add(new Label("Administrator"));
        // JButton button = new JButton("Administrator");
        // frame.getContentPane().add(button);
        PriceTag pt = new PriceTag(receipts[0], field, listField);
        receipts[0].addObserver(pt);

        
    }

    /*@Override
    public void update(Cocktail cocktail, double amount) {
        System.out.println("updateddddd" + amount);
        *//*Receipt[] data = (Receipt[]) o;
        this.stockSymbol = data[0].;
        this.stockPrice = stockData.getStockPrice();*//*

    }*/



    // public void actionPerformed(ActionEvent e)
    // {
    //     Command command = (Command)e.getSource();
    //     command.execute();
    // }
}

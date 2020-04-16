package cocktail.machine;

public class AlchoolCocktail implements Cocktail {
    @Override
    public String getDescription() {
       return "AlchoolCocktail";
    }
    @Override
    public String getIngredients() {
       return "AlchoolCocktail ingredients";
    }
    @Override
    public double cost() {
       return 6.00;
    }
    @Override
    public int getId() {return 0;};
    @Override
    public boolean isAlchoolic() {
       return true;
    }
 }
package cocktail.machine;

public interface Cocktail {
     public String getDescription();
     public String getIngredients();
     public double cost();
     public boolean isAlchoolic();
     public int getId();
}
package cocktail.machine;

//import cocktail.machine.cocktal;

public class GinLemon extends CocktailClass implements Cocktail{
    public GinLemon(CocktailClass c) {
        super(c);
    }
    public String getDescription() {
        return name;
    }
    public String getIngredients() {
        return String.join(",",ingredients);
    }
    public double cost() {
        return cost;
    }
    public int getId() {return id;};

    public boolean isAlchoolic() {
        return isAlchoolic;
    }
}
package cocktail.machine;

public class Banshee extends CocktailClass implements Cocktail{
    public Banshee(CocktailClass c){
        super(c);
    }
    public String getDescription() {
        return name + " (Tropical Analchoolic)";
    }
    public String getIngredients() {
        return String.join(",",ingredients);
    }
    public double cost() {
        return cost;
    }
    public int getId() {return id;};
    public boolean isAlchoolic(){
        return isAlchoolic;
    }
}

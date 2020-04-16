package cocktail.machine;

public class ACE extends CocktailClass implements Cocktail{
    public ACE(CocktailClass c){
        super(c);
    }
    public String getDescription() {
        return name + " (Analchoolic)";
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

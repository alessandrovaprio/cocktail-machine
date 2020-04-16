package cocktail.machine;

public class CocktailClass {
    String name;
    double cost;
    boolean isAlchoolic;
    String[] ingredients;
    int id;
    
    public CocktailClass(){}
    public CocktailClass(String name, double cost, boolean alchoolic, String[] ingredients, int id){
        this.name = name;
        this.cost = cost;
        this.isAlchoolic = alchoolic;
        this.ingredients = ingredients;
        this.id = id;
    }
    public CocktailClass(CocktailClass c){
        this.name = c.name;
        this.cost = c.cost;
        this.isAlchoolic = c.isAlchoolic;
        this.ingredients = c.ingredients;
        this.id = c.id;
    }
}

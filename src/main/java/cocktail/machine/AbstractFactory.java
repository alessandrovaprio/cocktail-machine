package cocktail.machine;


public abstract class AbstractFactory {
    abstract Cocktail getCocktail(String cocktailType, CocktailClass c) ;
 }
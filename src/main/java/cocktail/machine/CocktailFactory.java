package cocktail.machine;

public class CocktailFactory extends AbstractFactory{
    @Override
    public Cocktail getCocktail(String cocktailType, CocktailClass c){
       String lowercase = c.name.toLowerCase();
       switch (lowercase) {
          case "cuba libre":
            return new CubaLibre(c);         
          case "mojito":
            return new Mojito(c);         
          case "spritz":
            return new Spritz(c);
          case "gin lemon":
            return new GinLemon(c);
          default:
            return null;
       }    
       
    }
}
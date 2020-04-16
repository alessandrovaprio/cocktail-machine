package cocktail.machine;

public class AnalcoholicCocktailFactory extends AbstractFactory{
    @Override
    public Cocktail getCocktail(String cocktailType, CocktailClass c){    
       if(cocktailType.equalsIgnoreCase("ace juice")){
          return new ACE(c);         
       }else if(cocktailType.equalsIgnoreCase("Banshee")){
          return new Banshee(c);
       }	 
       return null;
    }
}

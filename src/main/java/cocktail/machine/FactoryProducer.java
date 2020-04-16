package cocktail.machine;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean alchoolic){   
       if(alchoolic){
          return new CocktailFactory();         
       }else{
          return new AnalcoholicCocktailFactory();
       }
    }
 }
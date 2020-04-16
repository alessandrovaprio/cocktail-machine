package cocktail.machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceiptTest {

	@Test
	public void getCocktailList() {
		Receipt r = new Receipt();
		assertEquals(0, r.cockatils.size());
		CocktailClass cClass = new CocktailClass("name",1, true,null,0);
		Cocktail c = new CubaLibre(cClass);
		r.addCocktail(c);
		assertEquals(1, r.cockatils.size());
		
	}
	
	@Test
	public void setTotal() {
		Receipt r = new Receipt();
		CocktailClass cClass = new CocktailClass("name",1, true,null,0);
		Cocktail c = new CubaLibre(cClass);
		r.addCocktail(c);
		assertEquals(0, c.cost(),1);
		double tmp_cost = 0;
		tmp_cost += c.cost();
		r.setTotal(c.cost());
		assertNotEquals(0, r.total,1);
		assertEquals(c.cost(), r.total,1);
		r.setTotal(c.cost());
		tmp_cost += c.cost();
		assertEquals(tmp_cost, r.total,1);
		
	}

}

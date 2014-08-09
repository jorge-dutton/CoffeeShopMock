package jorge;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineTest {
	
	ICoffeeMachine coffeeMachine;
	
	@Mock
	IContainer coffeeContainer;
	@Mock
	IContainer waterContainer;
	
	@Before
	public void setUp() {
		this.coffeeMachine = new CoffeeMachine(this.coffeeContainer, this.waterContainer);
	}
	
	@After
	public void tearDown() {
		this.coffeeMachine = null;
		this.coffeeContainer = null;
		this.waterContainer = null;
	}
	
	@Test
	public void testMakeCoffee() throws NotEnoughException {
		when(this.coffeeContainer.getPortion(Portion.LARGE)).thenReturn(true);
		when(this.waterContainer.getPortion(Portion.LARGE)).thenReturn(true);
		
		assertFalse(this.coffeeMachine.makeCoffee(Portion.SMALL));
	}
	
	@Test
	public void testNotEnoughException() throws NotEnoughException {
		when(this.coffeeContainer.getPortion(Portion.SMALL)).thenReturn(false);
		when(this.waterContainer.getPortion(Portion.SMALL)).thenReturn(true);
		
		assertFalse(this.coffeeMachine.makeCoffee(Portion.SMALL));
	}
}

package jorge;

public class CoffeeShop {
	
	private CoffeeMachine gaggia;
	
	public CoffeeShop() {
		IContainer coffeeContainer = new CoffeeContainer(3);
		IContainer waterContainer = new WaterContainer(3);
		this.gaggia = new CoffeeMachine(coffeeContainer, waterContainer);
		try {
			makeSmallCoffee(Portion.SMALL);
			System.out.print("Here you have your coffee!!! " + this.gaggia.getCoffeeContainer().getCurrentVolume());
		} catch (NotEnoughException e) {
			System.err.print("Error making coffee " + e.getLocalizedMessage());
		}
	}
	
	private void makeSmallCoffee(Portion portion) throws NotEnoughException {
		this.gaggia.makeCoffee(portion);
	}
	
	public static void main(String[] args) {
		new CoffeeShop();
		
	}

}

package jorge;

public class CoffeeMachine implements ICoffeeMachine {
	
	private IContainer coffeeContainer;
	private IContainer waterContainer;
	
	public CoffeeMachine(IContainer coffeeContainer, IContainer waterContainer) {
		this.coffeeContainer = coffeeContainer;
		this.waterContainer = waterContainer;
	}

	public boolean makeCoffee(Portion portion) throws NotEnoughException {
		
		boolean isEnoughCoffee = this.coffeeContainer.getPortion(portion);
		boolean isEnoughWater = this.waterContainer.getPortion(portion);
		
		return isEnoughCoffee && isEnoughWater;
	}

	public IContainer getCoffeeContainer() {
		return this.coffeeContainer;
	}

	public IContainer getWaterContainer() {
		return this.waterContainer;
	}

}

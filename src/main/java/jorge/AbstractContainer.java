package jorge;

public abstract class AbstractContainer implements IContainer {
	
	private int containerTotalVolume;
	private int containerCurrentVolume;
	
	public AbstractContainer(int volume) {
		if (volume < 1)
			throw new IllegalArgumentException("Container volume must be greater than 0.");
		this.containerTotalVolume = volume;
		this.containerCurrentVolume = volume;
	}
	
	public boolean getPortion(Portion portion) throws NotEnoughException {
		int delta = this.containerCurrentVolume - portion.size();
		
		if (delta > -1) {
			this.containerCurrentVolume -= portion.size();
			return true;
		} else {
			throw new NotEnoughException("Refill the " + this.getClass().getName());
		}
	}

	public int getCurrentVolume() {
		return this.containerCurrentVolume;
	}

	public int getTotalVolume() {
		return this.containerTotalVolume;
	}

	public void refillContainer() {
		this.containerCurrentVolume = this.containerTotalVolume;
	}

}

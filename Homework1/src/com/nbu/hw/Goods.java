package com.nbu.hw;

public class Goods {

	String name;

	@Override
	public String toString() {
		return "Goods [name=" + name + "]";
	}

	public Goods() {
		super();
	}
	
	class Meat {
		
		boolean isFrozen;

		public Meat(boolean isFrozen) {
			this.isFrozen = isFrozen;
		}
		
		@Override
		public String toString() {
			return "Meat [isFrozen=" + isFrozen + "]";
		}
	}

	class Computer {

		boolean isPortable;
		
		public Computer(boolean isPortable) {
			this.isPortable = isPortable;
		}
		
		@Override
		public String toString() {
			return "Computer [isPortable=" + isPortable + "]";
		}
	}

	class Fuel {
		
		boolean isLiquid;
		
		public Fuel(boolean isLiquid) {
			this.isLiquid = isLiquid;
		}		
		
		@Override
		public String toString() {
			return "Fuel [isLiquid=" + isLiquid + "]";
		}
	}

}

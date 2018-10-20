package com.nbu.hw;

public class Goods {

	protected String name;
	protected GoodsType type;

	public Goods() {

	}

	public Goods(String name, GoodsType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public GoodsType getType() {
		return type;
	}

	class Meat extends Goods {

		boolean isFrozen;

		public Meat(boolean isFrozen) {
			this.isFrozen = isFrozen;
			this.name = "Meat";
			this.type = GoodsType.TempSensitive;
		}

		@Override
		public String toString() {
			return "Meat [name=" + name + ", type=" + type + ", isFrozen=" + isFrozen + "]";
		}
	}

	class Computer extends Goods {

		boolean isPortable;

		public Computer(boolean isPortable) {
			this.isPortable = isPortable;
			this.name = "Computer";
			this.type = GoodsType.Standart;
		}

		@Override
		public String toString() {
			return "Computer [name=" + name + ", type=" + type + ", isPortable=" + isPortable + "]";
		}
	}

	class Fuel extends Goods {

		boolean isLiquid;

		public Fuel(boolean isLiquid) {
			this.isLiquid = isLiquid;
			this.name = "Fuel";
			this.type = GoodsType.Hazardous;
		}

		@Override
		public String toString() {
			return "Fuel [name=" + name + ", type=" + type + ", isLiquid=" + isLiquid + "]";
		}
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", type=" + type + "]";
	}

}

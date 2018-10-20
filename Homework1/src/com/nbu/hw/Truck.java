package com.nbu.hw;

public class Truck<T extends Goods> {

	private TruckType type;
	private int capacity;
	private int currentLoad;
	private T goods;

	public Truck(TruckType type, int capacity, int currentLoad) {
		super();
		this.type = type;
		this.capacity = capacity;
		this.currentLoad = currentLoad;
	}

	public void load(T t, int load) throws LoadTooBigException, InvalidLoadRequestedException {
		if (!type.getGoodsType().equals(t.getType())){
			throw new InvalidLoadRequestedException("Truck can only load " + type.getGoodsType() +
					" and can't load " + t.getType());
		}
		if ((this.goods != null) && !(this.goods.equals(t))) {
			throw new InvalidLoadRequestedException("Truck is already loaded with " + goods.getClass().getSimpleName() +
					" and can't load " + t.getClass().getSimpleName());
		}
		this.goods = t;
		if (load + currentLoad > capacity) {
			throw new LoadTooBigException("Requested load will overfill the truck");
		} else {
			currentLoad += load;
		}
	}

	@Override
	public String toString() {
		return "Truck [type=" + type + ", capacity=" + capacity + ", currentLoad=" + currentLoad + ", goods=" + goods
				+ "]";
	}

}

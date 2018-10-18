package com.nbu.hw;

public class Truck<T> {

	private T goods;

	private int capacity;

	private int currentLoad;

	public void load(T goods, int load) throws LoadTooBigException, InvalidLoadRequestedException {
		if (load < 0) {
			throw new InvalidLoadRequestedException("Requested load capacity is invalid");
		}
		if (load + currentLoad > capacity) {
			throw new LoadTooBigException("Requested load will overfill the truck");
		} else {
			currentLoad += load;
			this.goods = goods;
		}
	}

	public Truck(int capacity) {
		super();
		this.capacity = capacity;
	}

	public T getGoods() {
		return goods;
	}

	@Override
	public String toString() {
		return "Truck [goods=" + goods + ", capacity=" + capacity + ", currentLoad=" + currentLoad + "]";
	}

}

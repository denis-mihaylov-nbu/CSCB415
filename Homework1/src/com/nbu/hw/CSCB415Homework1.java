package com.nbu.hw;

import com.nbu.hw.Goods.Computer;
import com.nbu.hw.Goods.Fuel;

public class CSCB415Homework1 {

	public static void main(String[] args) {

		Computer laptops = new Goods().new Computer(true);
		Goods bricks = new Goods("Bricks", GoodsType.Standart);
		Fuel gas = new Goods().new Fuel(true);
		
		
		Truck<Goods> truck = new Truck<Goods>(TruckType.DumpTruck, 5000, 0);

		try {
			truck.load(laptops, 2000);
			truck.load(bricks, 1000);
			truck.load(gas, 1000);
			truck.load(laptops, 1000);
			System.out.println("truck = " + truck);
		} catch (LoadTooBigException e) {
			e.printStackTrace(System.err);
		} catch (InvalidLoadRequestedException e) {
			e.printStackTrace(System.err);
		}
	}

}

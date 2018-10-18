package com.nbu.hw;

import com.nbu.hw.Goods.Computer;
import com.nbu.hw.Goods.Fuel;
import com.nbu.hw.Goods.Meat;

public class CSCB415Homework1 {

	public static void main(String[] args) {

		Goods g = new Goods();

		Truck<Computer> dumpTruck = new Truck<Computer>(20);
		Truck<Fuel> tanker = new Truck<Fuel>(20);
		Truck<Meat> refrigeratorTruck = new Truck<Meat>(20);
		
		Computer computer = g.new Computer(true);
		Fuel fuel = g.new Fuel(true);
		Meat meat = g.new Meat(true);

		try {
			dumpTruck.load(computer, 5);
			System.out.println("dumpTruck = " + dumpTruck);
		} catch (LoadTooBigException e) {
			e.printStackTrace(System.err);
		} catch (InvalidLoadRequestedException e) {
			e.printStackTrace(System.err);
		}

		try {
			tanker.load(fuel, 5);
			System.out.println("tanker = " + tanker);
		} catch (LoadTooBigException e) {
			e.printStackTrace(System.err);
		} catch (InvalidLoadRequestedException e) {
			e.printStackTrace(System.err);
		}

		try {
			refrigeratorTruck.load(meat, 2);
			System.out.println("refrigeratorTruck = " + refrigeratorTruck);
		} catch (LoadTooBigException e) {
			e.printStackTrace(System.err);
		} catch (InvalidLoadRequestedException e) {
			e.printStackTrace(System.err);
		}
	}

}

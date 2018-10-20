package com.nbu.hw;

public enum TruckType {

	DumpTruck(GoodsType.Standart), Tanker(GoodsType.Hazardous), RefrigeratorTruck(GoodsType.TempSensitive);

	private GoodsType goodsType;

	TruckType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

}

package com.troublord.Dao;

import java.util.List;
import java.util.Map;

import com.troublord.Entity.Shipment;
import com.troublord.Entity.ShipmentDetail;
import com.troublord.Entity.ShipmentProduct;

public interface ShipmentDAO {

	List<Shipment> getSheet();

	Map<Integer, ShipmentProduct> getProductMap();

	Map<Integer, String> getCustomerMap();

	void saveShipment(Shipment target);

	void saveDetail(ShipmentDetail sd);

}

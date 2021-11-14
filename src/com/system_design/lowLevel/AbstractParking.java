package com.system_design.lowLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public abstract class AbstractParking implements ParkingBase {

	public LinkedHashMap<Integer,HashMap<String,String>> vechicleParking;
	public int parkingCapacity = 0;
	
	@Override
	public void buildParkingSlot(int size) {
		vechicleParking = new LinkedHashMap<Integer, HashMap<String,String>>(size);
		parkingCapacity = size;
	}
	
	@Override
	public void parkVechicle(String regNo, String color) {
		int slotNumber = getSlotNumber();
		if(slotNumber <= parkingCapacity) {
			HashMap<String, String> detail = new HashMap<String, String>();
			detail.put("regNo", regNo);
			detail.put("color", color);
			vechicleParking.put(slotNumber, detail);
		}else System.out.println("The Praking Lot is full");
	}

	public int getSlotNumber() {
		int availableSlot = 0;
		if(vechicleParking.isEmpty()) return 1;
		else {
			for(int slot : vechicleParking.keySet()){
				availableSlot++;
				if(vechicleParking.get(slot).isEmpty()) return availableSlot;
			}
		}
		return ++availableSlot;
	}

	public void getParkingDetails(){
		System.out.println(
			"Slot No    Registration No  "+"  Color");
		for (Entry<Integer, HashMap<String, String>> car : vechicleParking.entrySet()) {
			if(!car.getValue().isEmpty())
				System.out.println("   "+car.getKey()+"        "+car.getValue().get("regNo")
					+"      "+car.getValue().get("color"));
		}
	}
	
	@Override
	public void leaveVechicle(int slotNumber) {
		if (!(slotNumber > 0 && slotNumber <= parkingCapacity))
			System.out.println("Invalid Parking Slot number");
		else if(vechicleParking.containsKey(slotNumber))
			vechicleParking.put(slotNumber, new HashMap<String, String>());
		else System.out.println("No Vechicle Parked");
	}

	@Override
	public List<String> getCarRegsNoOfVechicles(String color) {
		List<String> regNos = new ArrayList<>();
		for (Entry<Integer, HashMap<String, String>> car : vechicleParking.entrySet()) {
			if(car.getValue().get("color").equals(color)) regNos.add(car.getValue().get("regNo"));
		}
		return regNos;
	}

	@Override
	public List<Integer> getSoltNosOfVechicles(String color) {
		List<Integer> regNos = new ArrayList<>();
		for (Entry<Integer, HashMap<String, String>> car : vechicleParking.entrySet()) {
			if(car.getValue().get("color").equals(color)) regNos.add(car.getKey());
		}
		return regNos;
	}

	@Override
	public Integer getSoltNoOfVechicle(String regNo) {
		for (Entry<Integer, HashMap<String, String>> car : vechicleParking.entrySet()) {
			if(car.getValue().get("regNo").equals(regNo)) return car.getKey();
		}
		return null;
	}

	@Override
	public HashMap<String, Integer> getParkingSlotDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}

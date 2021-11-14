package com.system_design.lowLevel;

import java.util.HashMap;
import java.util.List;

public interface ParkingBase {

	public void buildParkingSlot(int size);
	
	public void parkVechicle(String regNo, String color);
	
	public void getParkingDetails();
	
	public void leaveVechicle(int slotNumber);
	
	public List<String> getCarRegsNoOfVechicles(String color);
	
	public List<Integer> getSoltNosOfVechicles(String color);
	
	public Integer getSoltNoOfVechicle(String regNo);
	
	public HashMap<String,Integer> getParkingSlotDetails();
	
	public int getSlotNumber();
	
}

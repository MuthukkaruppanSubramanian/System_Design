package com.system_design.lowLevel;

import java.util.HashMap;
import java.util.Scanner;

public class CarParking extends AbstractParking{
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the Details:");
//		String command = sc.nextLine();
//		System.out.println("Details Given: "+command);
		CarParking park = new CarParking();
		park.buildParkingSlot(5);
		park.parkVechicle("TN-02-N-5338","White");
		park.parkVechicle("TN-03-N-2335","White");
		park.parkVechicle("TN-42-N-2567","Grey");
		park.parkVechicle("TN-47-N-5555","Grey");
		park.parkVechicle("TN-25-N-7896","Green");
		//park.getParkingDetails();
		park.leaveVechicle(0);
		park.leaveVechicle(4);
		//park.getParkingDetails();
		park.parkVechicle("TN-15-N-7436","Green");
		park.parkVechicle("TN-15-N-7476","Green");
		//park.getParkingDetails();
		System.out.println(park.getCarRegsNoOfVechicles("Green"));
		System.out.println(park.getSoltNoOfVechicle("TN-25-N-7896"));
		System.out.println(park.getSoltNosOfVechicles("Green"));
		System.out.println(park.getSoltNoOfVechicle("TN-25-N-7891"));
	}
}

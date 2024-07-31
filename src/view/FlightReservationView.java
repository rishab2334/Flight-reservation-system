package view;

import java.util.Scanner;

import controller.FlightReservationAdminController;
import controller.FlightReservationAdminControllerInterface;
import controller.FlightReservationControllerController;
import controller.FlightReservationControllerInterface;
import controller.FlightReservationCustomerController;
import controller.FlightReservationCustomerControllerInterface;

public class FlightReservationView {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss="y";
		while(ss.equals("y")) {
			System.out.println("******************Main Menu******************");
			System.out.println("Press 1 to Signin");
			System.out.println("Press 2 to SignUp");
			
			System.out.println("Enter your choice");
			int c=sc.nextInt();
			
			FlightReservationControllerInterface flightreservationcontroller=new FlightReservationControllerController();
			
			
			switch(c) {
			case 1 : String result=flightreservationcontroller.SignInFlightController();
					boolean flag=true;
					while(flag) {
						if(result.equals("admin")) {
							System.out.println("****************Admin Main Menu*********************");
							System.out.println("press 1 to Add flight Details");
							System.out.println("press 2 to Delete flight Details");
							System.out.println("press 3 to View flight Details");
							System.out.println("press 4 to Change flight Details");
							System.out.println("press 5 to Add Schedule Details");
							System.out.println("press 6 to Delete Schedule Details");
							System.out.println("press 7 to View Schedule Details");
							System.out.println("press 8 to Change Schedule Details");
							System.out.println("press 9 to Add route Details");
							System.out.println("press 10 to Delete route Details");
							System.out.println("press 11 to view route Details");
							System.out.println("press 12 to Change route Details");
							System.out.println("press 13 to view Passengers Details");
							System.out.println("press 14 to Change password");
							System.out.println("press 15 to Logout");
							
							System.out.println("enter your choice");
							int adminchoice=sc.nextInt();
							
							FlightReservationAdminControllerInterface flightadmincontroller=new FlightReservationAdminController();
							switch(adminchoice) {
							case 1:flightadmincontroller.addFlightDetails();
								break;
							case 2:flightadmincontroller.deleteFlightDetails();
								break;
							case 3:flightadmincontroller.viewFlightDetails();
								break;
							case 4:flightadmincontroller.changeFlightDetails();
								break;
							case 5:flightadmincontroller.addScheduleDetails();
								break;
							case 6:flightadmincontroller.deleteScheduleDetails();
								break;
							case 7:flightadmincontroller.viewScheduleDetails();
								break;
							case 8:flightadmincontroller.changeScheduleDetails();
								break;
							case 9:flightadmincontroller.addRouteDetails();
								break;
							case 10:flightadmincontroller.deleteRouteDetails();
								break;
							case 11:flightadmincontroller.viewRouteDetails();
								break;
							case 12:flightadmincontroller.changeRouteDetails();
								break;
							case 13:flightadmincontroller.viewPassengersDetails();
								break;
							case 14:flightadmincontroller.changePassword();
								break;
							case 15:
								flag=false;
								flightadmincontroller.logout();
								break;
								
								default: System.out.println("Invalid number");
							}
							
						}
						else if(result.equals("customer")) {
								System.out.println("****************Customer Main Menu******************");
								System.out.println("press 1 to register to FRS");
								System.out.println("press 2 to view flight");
								System.out.println("press 3 to view Schedule");
								System.out.println("press 4 to reserve ticket");
								System.out.println("press 5 to view ticket");
								System.out.println("press 6 to print ticket");
								System.out.println("press 7 to  cancel ticket");
								System.out.println("press 8 to change password");
								System.out.println("press 9 to logout");
								
								System.out.println("enter your choice");
								int adminchoice=sc.nextInt();
								
								FlightReservationCustomerControllerInterface flightcustcontroller=new FlightReservationCustomerController();
								switch(adminchoice) {
								case 1:flightcustcontroller.registerToFRS();
									break;
								case 2:flightcustcontroller.viewFlight();
									break;
								case 3:flightcustcontroller.viewSchedule();
									break;
								case 4:flightcustcontroller.reserveTicket();
									break;
								case 5:flightcustcontroller.viewTicket();
									break;
								case 6:flightcustcontroller.printTicket();
									break;
								case 7:flightcustcontroller.cancelTicket();
									break;
								case 8:flightcustcontroller.changePassword();
									break;
								case 9:
									flag=false;
									flightcustcontroller.logout();
									break;
										default: System.out.println("Invalid number");
								}
								
							}
							else {
								System.out.println("Invalid id and password, login again");
							}
						}
						break;
			case 2:flightreservationcontroller.SignUpFlightController();
			break;
			default: System.out.println("wrong choice");
			}
			
		}
		System.out.println("to continue press y");
		ss=sc.next();
	}

}

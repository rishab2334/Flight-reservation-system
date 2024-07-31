	package controller;

import java.util.Scanner;


import entity.CredentialsBean;
import entity.FlightBean;
import entity.PassengerBean;
import entity.RouteBean;
import entity.ScheduleBean;
import service.FlightReservationAdminService;
import service.FlightReservationAdminServiceInterface;
import service.FlightReservationService;
import service.FlightReservationServiceInterface;
public class FlightReservationAdminController implements FlightReservationAdminControllerInterface {

	@Override
	public void addFlightDetails() {
		Scanner sc= new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		
		
		System.out.println("Enter flightID");
		String flightID=sc.next();
		
		System.out.println("Enter flight name");
		String flightName=sc.next();
		
		System.out.println("Enter seating capacity");
		String seatingCapacity=sc.next();
		
		System.out.println("Enter Reservation capacity");
		String reservationCapacity=sc.next();
		
		
		FlightBean flightBean=new FlightBean();
		flightBean.setFlightID(flightID);
		flightBean.setFlightName(flightName);
		flightBean.setSeatingCapacity(seatingCapacity);
		flightBean.setReservationCapacity(reservationCapacity);
		
		String result = flightreservationadminservice.addFlightDetails(flightBean);
		if(result!=null) {
			System.out.println("Flight details added successfully");
			
		}
		else {
			System.out.println("Could not added successfully");
		}
	}

	@Override
	public void deleteFlightDetails() {
		Scanner sc= new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter flight ID");
		String flightID=sc.next();
		int result=flightreservationadminservice.deleteFlight(flightID);
		if(result>0){
			System.out.println("Flight details deleted successfully");
			
			
		}
		else {
			System.out.println("could not delete details");
		}
		
	}

	@Override
	public void viewFlightDetails() {
		Scanner sc=new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter flight ID ");
		String flightID=sc.next();
		FlightBean result =flightreservationadminservice.viewFlightDetails(flightID);
		if(result!=null) {
			System.out.println("Flight details is below");
			System.out.println("Flight name is "+result.getFlightName());
			System.out.println("Flight seating capacity is "+result.getSeatingCapacity());
			System.out.println("Flight reservation capacity is "+result.getReservationCapacity());
			
		}
		
	}

	@Override
	public void changeFlightDetails() {
		Scanner sc = new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter flight ID ");
		String flightID=sc.next();
		FlightBean result=flightreservationadminservice.viewFlightDetails(flightID);
		if(result!=null) {
			System.out.println("Flight old details is below");
			System.out.println("Flight name is "+result.getFlightName());
			System.out.println("Flight seating capacity is "+result.getSeatingCapacity());
			System.out.println("Flight reservation capacity is "+result.getReservationCapacity());
			
		}
		System.out.println("Enter new Flight name");
		String flightname=sc.next();
		
		System.out.println("Enter new seating capacity");
		String seatingcapacity=sc.next();
		
		System.out.println("Enter new reservation capacity");
		String reservationcapacity=sc.next();
		
		FlightBean flightbean=new FlightBean();
		flightbean.setFlightID(flightID);
		flightbean.setFlightName(flightname);
		flightbean.setSeatingCapacity(seatingcapacity);
		flightbean.setReservationCapacity(reservationcapacity);
		boolean result1=flightreservationadminservice.changeFlightDetails(flightbean);
		if(result1) {
			System.out.println("Flight details updated successfully");
			
		}
		else {
			System.out.println("Flight details could not updated successfully");
			
		}
		
		
		
	}

	@Override
	public void addScheduleDetails() {
		Scanner sc= new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		
		
		System.out.println("Enter scheduleID");
		String scheduleID=sc.next();
		
		System.out.println("Enter flightID");
		String flightID=sc.next();
		
		System.out.println("Enter RouteID");
		String routeID=sc.next();
		
		System.out.println("Enter travel duration");
		String travelDuration=sc.next();
		
		System.out.println("Enter AvailableDays");
		String availableDays=sc.next();
		
		System.out.println("Enter Departure time");
		String departureTime=sc.next();
		
		
		ScheduleBean scheduleBean=new ScheduleBean();
		scheduleBean.setScheduleID(scheduleID);
		scheduleBean.setFlightID(flightID);
		scheduleBean.setRouteID(routeID);
		scheduleBean.setTravelDuration(travelDuration);
		scheduleBean.setAvailableDays(availableDays);
		scheduleBean.setDepartureTime(departureTime);
		
		
		
		String result = flightreservationadminservice.addScheduleDetails(scheduleBean);
		if(result!=null) {
			System.out.println("Schedule details added successfully");
			
		}
		else {
			System.out.println("Could not added successfully");
		}
		
	}

	@Override
	public void deleteScheduleDetails() {
		Scanner sc= new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter schedule ID");
		String scheduleID=sc.next();
		int result=flightreservationadminservice.deleteScheduleDetails(scheduleID);
		if(result>0){
			System.out.println("Schedule details deleted successfully");
			
			
		}
		else {
			System.out.println("could not delete details");
		}
		
	}

	@Override
	public void viewScheduleDetails() {
		Scanner sc=new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter schedule ID ");
		String scheduleID=sc.next();
		ScheduleBean result =flightreservationadminservice.viewScheduleDetails(scheduleID);
		if(result!=null) {
			System.out.println("Flight details is below");
			System.out.println("Flight ID is "+result.getFlightID());
			System.out.println("Route ID is "+result.getRouteID());
			System.out.println("Travel duration is "+result.getTravelDuration());
			System.out.println("Available days are "+result.getAvailableDays());
			System.out.println("Departure time is "+result.getDepartureTime());
			
			
			
		}
		
	}

	@Override
	public void changeScheduleDetails() {
		
		Scanner sc = new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter Schedule ID ");
		String scheduleID=sc.next();
		ScheduleBean result=flightreservationadminservice.viewScheduleDetails(scheduleID);
		if(result!=null) {
			System.out.println("Flight old Schedule details is below");
			System.out.println("Flight ID is "+result.getFlightID());
			System.out.println("Route ID is "+result.getRouteID());
			System.out.println("Travel duration is "+result.getTravelDuration());
			System.out.println("Available days are "+result.getAvailableDays());
			System.out.println("Departure time is "+result.getDepartureTime());
		}
		
		System.out.println("Enter new Flight ID");
		String flightID=sc.next();
		
		System.out.println("Enter new Route ID");
		String routeID=sc.next();
		
		System.out.println("Enter new travel duration");
		String travelDuration=sc.next();
		
		System.out.println("Enter new Available days");
		String availableDays=sc.next();
		
		System.out.println("Enter new Departure time");
		String departureTime=sc.next();
		
		ScheduleBean schedulebean=new ScheduleBean();
		schedulebean.setScheduleID(scheduleID);
		schedulebean.setFlightID(flightID);
		schedulebean.setRouteID(routeID);
		schedulebean.setTravelDuration(travelDuration);
		schedulebean.setAvailableDays(availableDays);
		schedulebean.setDepartureTime(departureTime);
		boolean result1=flightreservationadminservice.changeScheduleDetails(schedulebean);
		if(result1) {
			System.out.println("Flight details updated successfully");
			
		}
		else {
			System.out.println("Flight details could not updated successfully");
			
		}
		
			
	}

	@Override
	public void addRouteDetails() {
		Scanner sc= new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		
		
		System.out.println("Enter routeID");
		String routeID=sc.next();
		
		System.out.println("Enter source");
		String source=sc.next();
		
		System.out.println("Enter Destination");
		String destinstion=sc.next();
		
		System.out.println("Enter Distance");
		String distance=sc.next();
		
		System.out.println("Enter Fare");
		String fare=sc.next();
		
		
		RouteBean routeBean=new RouteBean();
		routeBean.setRouteID(routeID);
		routeBean.setSource(source);
		routeBean.setDestination(destinstion);
		routeBean.setDistance(distance);
		routeBean.setFare(fare);
		
		String result = flightreservationadminservice.addRouteDetails(routeBean);
		if(result!=null) {
			System.out.println("Route details added successfully");
			
		}
		else {
			System.out.println("Could not added successfully");
		}
		
	}

	@Override
	public void deleteRouteDetails() {
		Scanner sc= new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter route ID");
		String routeID=sc.next();
		int result=flightreservationadminservice.deleteRouteDetails(routeID);
		if(result>0){
			System.out.println("Route details deleted successfully");
			
			
		}
		else {
			System.out.println("could not delete details");
		}
		
	}

	@Override
	public void viewRouteDetails() {
		Scanner sc=new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter Route ID ");
		String routeID=sc.next();
		RouteBean result =flightreservationadminservice.viewRouteDetails(routeID);
		if(result!=null) {
			System.out.println("Route details is below");
			System.out.println("Route ID is "+result.getRouteID());
			System.out.println("Source is "+result.getSource());
			System.out.println("Destination is "+result.getDestination());
			System.out.println("Distance is "+result.getDistance());
			System.out.println("Fare is "+result.getFare());
			
			
			
		}
		
		
	}

	@Override
	public void changeRouteDetails() {
		Scanner sc = new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter Route ID ");
		String routeID=sc.next();
		RouteBean result=flightreservationadminservice.viewRouteDetails(routeID);
		if(result!=null) {
			System.out.println("Flight old Schedule details is below");
			System.out.println("Route ID is "+result.getRouteID());
			System.out.println("Source is "+result.getSource());
			System.out.println("Destination is "+result.getDestination());
			System.out.println("Distance is "+result.getDistance());
			System.out.println("Fare is "+result.getFare());
			
		}
		
		System.out.println("Enter new Source");
		String source=sc.next();
		
		System.out.println("Enter new Destination");
		String destination=sc.next();
		
		System.out.println("Enter new Distance");
		String distance=sc.next();
		
		System.out.println("Enter new fare");
		String fare=sc.next();
		
		
		RouteBean routebean=new RouteBean();
		routebean.setRouteID(routeID);
		routebean.setSource(source);
		routebean.setDestination(destination);
		routebean.setDistance(distance);
		routebean.setFare(fare);
		
		boolean result1=flightreservationadminservice.changeRouteDetails(routebean);
		if(result1) {
			System.out.println("Route details updated successfully");
			
		}
		else {
			System.out.println("Route details could not updated successfully");
			
		}
		
	}

	@Override
	public void viewPassengersDetails() {
		Scanner sc=new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter ReservationID ");
		String reservationID=sc.next();
		PassengerBean result =flightreservationadminservice.viewPassengersDetails(reservationID);
		if(result!=null) {
			System.out.println("Reservation details is below");
			System.out.println("Reservation ID is "+result.getReservationID());
			System.out.println("Name is "+result.getName());
			System.out.println("Gender is "+result.getGender());
			System.out.println("Age is "+result.getAge());
			System.out.println("Seatno. is "+result.getSeatNo());
			
			
			
		}
		
		
		
	}

	@Override
	public void changePassword() {
		Scanner sc = new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter UserID ");
		String userID=sc.next();
		CredentialsBean result=flightreservationadminservice.viewCredentialsDetails(userID);
		if(result!=null) {
			System.out.println("User old Password is below");
			System.out.println("Password is "+result.getPassword());
			
			
		}
		
		System.out.println("Enter new Password");
		String password=sc.next();
		
		
		CredentialsBean credentialsbean=new CredentialsBean();
		credentialsbean.setUserID(userID);
		credentialsbean.setPassword(password);
		
		
		boolean result1=flightreservationadminservice.changePassword(credentialsbean);
		if(result1) {
			System.out.println("Password updated successfully");
			
		}
		else {
			System.out.println("Password could not updated successfully");
			
		}
		
		
	}

	@Override
	public void logout() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your userID");
		String userID=sc.next();
		FlightReservationServiceInterface flightreservationservice =new FlightReservationService();
		boolean b=flightreservationservice.logout(userID);
		if(b) {
			System.out.println("logout successful");
			System.exit(0);
		}
		else {
			System.out.println("logout unsuccessful");
		}
		
	}
	
	
	public void viewCredentialsDetails() {
		Scanner sc=new Scanner(System.in);
		FlightReservationAdminServiceInterface flightreservationadminservice =new FlightReservationAdminService();
		System.out.println("please enter User ID ");
		String userID=sc.next();
		CredentialsBean result =flightreservationadminservice.viewCredentialsDetails(userID);
		if(result!=null) {
			System.out.println("Credentials details is below");
			System.out.println("User id is "+result.getUserID());
			System.out.println("Password is "+result.getPassword());
			System.out.println("User type is "+result.getUserType());
			
			
			
			
		}
		
		
	}
	
	

}

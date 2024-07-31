package controller;

import java.util.Scanner;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.ProfileBean;
import entity.ReservationBean;
import entity.ScheduleBean;
import service.FlightReservationAdminService;
import service.FlightReservationAdminServiceInterface;
import service.FlightReservationCustomerService;
import service.FlightReservationCustomerServiceInterface;
import service.FlightReservationService;
import service.FlightReservationServiceInterface;

public class FlightReservationCustomerController implements FlightReservationCustomerControllerInterface {

	@Override
	public void registerToFRS() {
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightCustomerService=new FlightReservationCustomerService();
		System.out.println("please enter user id");
		String userID=sc.next();
		System.out.println("please enter user firstName");
		String firstName=sc.next();
		System.out.println("please enter user lastName");
		String lastName=sc.next();
		System.out.println("please enter user dateOfBirth");
		String dateOfBirth=sc.next();
		System.out.println("please enter user gender");
		String gender=sc.next();
		System.out.println("please enter user street");
		String street=sc.next();
		System.out.println("please enter user location");
		String location=sc.next();
		System.out.println("please enter user city");
		String city=sc.next();
		System.out.println("please enter user state");
		String state=sc.next();
		System.out.println("please enter user pincode");
		String pincode=sc.next();
		System.out.println("please enter user mobileNo");
		String mobileNo=sc.next();
		System.out.println("please enter user emailID");
		String emailID=sc.next();
		System.out.println("please enter user password");
		String password=sc.next();
		
		
		
		ProfileBean profileBean=new ProfileBean();
		profileBean.setCity(city);
		profileBean.setDateOfBirth(dateOfBirth);
		profileBean.setEmailID(emailID);
		profileBean.setFirstName(firstName);
		profileBean.setGender(gender);
		profileBean.setLastName(lastName);
		profileBean.setLocation(location);
		profileBean.setMobileNo(mobileNo);
		profileBean.setPassword(password);
		profileBean.setPincode(pincode);
		profileBean.setPincode(pincode);
		profileBean.setState(state);
		profileBean.setStreet(street);
		profileBean.setUserID(userID);
		
		String result=flightCustomerService.register(profileBean);
		if(result.equals("SUCCESS")) {
			System.out.println("registration successful");
		}
		else {
			System.out.println("could not register");
		}
		
		
		
	}

		
	

	@Override
	public void viewFlight() {
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter flight ID ");
		String flightID=sc.next();
		FlightBean result =flightreservationCustomerservice.viewCustomerFlightDetails(flightID);
		if(result!=null) {
			System.out.println("Flight details is below");
			System.out.println("Flight name is "+result.getFlightName());
			System.out.println("Flight seating capacity is "+result.getSeatingCapacity());
			System.out.println("Flight reservation capacity is "+result.getReservationCapacity());
			
		}
		
	}

	@Override
	public void viewSchedule() {
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter schedule ID ");
		String scheduleID=sc.next();
		ScheduleBean result =flightreservationCustomerservice.viewCustomerFlightScheduleDetails(scheduleID);
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
	public void reserveTicket() {
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("Enter Reservation id:");
		String reservationID=sc.next();
		System.out.println("Enter user id:");
		String userID=sc.next();
		System.out.println("Enter schedule id:");
		String scheduleID=sc.next();
		System.out.println("Enter reservation type:");
		String reservationType=sc.next();
		System.out.println("Enter booking date:");
		String bookingDate=sc.next();
		System.out.println("Enter journey date:");
		String journeyDate=sc.next();
		System.out.println("Enter No of seats:");
		String noOfSeats=sc.next();
		System.out.println("Enter total fare:");
		String totalFare=sc.next();
		System.out.println("Enter booking status:");
		String bookingStatus=sc.next();
		 ReservationBean reservationBean =new ReservationBean();
		 reservationBean.setReservationID(reservationID);
		 reservationBean.setUserID(userID);
		 reservationBean.setScheduleID(scheduleID);
		 reservationBean.setReservationType(reservationType);
		 reservationBean.setBookingDate(bookingDate);
		 reservationBean.setJourneyDate(journeyDate);
		 reservationBean.setNoOfSeats(noOfSeats);
		 reservationBean.setTotalFare(totalFare);
		 reservationBean.setBookingStatus(bookingStatus);
		String result=flightreservationCustomerservice.customerReserveTicket(reservationBean);
		System.out.println(result);
		
	}

	@Override
	public void viewTicket() {
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter the reservation id");
		String reservationID=sc.next();
		 ReservationBean rbean= flightreservationCustomerservice.viewTicketDetails(reservationID);
		 
		 if(rbean!=null) {
			 System.out.println("your reservation detail is below");
			 System.out.println("Boarding ReservationID is "+rbean.getReservationID());
			 System.out.println("Booking UserID is "+rbean.getUserID());
			 System.out.println("Drop ScheduleID is "+rbean.getScheduleID());
			 System.out.println("Total Reservation Type is "+rbean.getReservationType());
			 System.out.println("Booking Date is "+rbean.getBookingDate());
			 System.out.println("Journey Date is "+rbean.getJourneyDate());
			 System.out.println("No. of seats are "+rbean.getNoOfSeats());
			 System.out.println("Total fare is  "+rbean.getTotalFare());
			 System.out.println("Booking Status is "+rbean.getBookingStatus());

		 }
		 else {
			 System.out.println("you do not have any flight right now");
		 }
		

		
	}

	

	@Override
	public void printTicket() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter the reservation id");
		String reservationID=sc.next();
		 ReservationBean rbean= flightreservationCustomerservice.viewTicketDetails(reservationID);
		 
		 if(rbean!=null) {
			 System.out.println("your reservation detail is below");
			 System.out.println("Boarding ReservationID is "+rbean.getReservationID());
			 System.out.println("Booking UserID is "+rbean.getUserID());
			 System.out.println("Drop ScheduleID is "+rbean.getScheduleID());
			 System.out.println("Total Reservation Type is "+rbean.getReservationType());
			 System.out.println("Booking Date is "+rbean.getBookingDate());
			 System.out.println("Journey Date is "+rbean.getJourneyDate());
			 System.out.println("No. of seats are "+rbean.getNoOfSeats());
			 System.out.println("Total fare is  "+rbean.getTotalFare());
			 System.out.println("Booking Status is "+rbean.getBookingStatus());

		 }
		 else {
			 System.out.println("you do not have any flight right now");
		 }
		

		
		
	}

	@Override
	public void cancelTicket() {
		Scanner sc=new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter user id ");
		String userID=sc.next();
		System.out.println("please enter reservation id ");
		String reservationID=sc.next();
		boolean b=flightreservationCustomerservice.cancelTicket(userID, reservationID);
		if(b) {
			System.out.println("your booking got cancled");
		}
		else {
			System.out.println("could not cancle booking");
		}
		
	}
	

	@Override
	public void changePassword() {
		Scanner sc = new Scanner(System.in);
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter UserID ");
		String userID=sc.next();
		CredentialsBean result=flightreservationCustomerservice.viewCredentialsDetails(userID);
		if(result!=null) {
			System.out.println("User old Password is below");
			System.out.println("Password is "+result.getPassword());
			
			
		}
		
		System.out.println("Enter new Password");
		String password=sc.next();
		
		
		CredentialsBean credentialsbean=new CredentialsBean();
		credentialsbean.setUserID(userID);
		credentialsbean.setPassword(password);
		
		
		boolean result1=flightreservationCustomerservice.changePassword(credentialsbean);
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
		FlightReservationCustomerServiceInterface flightreservationCustomerservice =new FlightReservationCustomerService();
		System.out.println("please enter User ID ");
		String userID=sc.next();
		CredentialsBean result =flightreservationCustomerservice.viewCredentialsDetails(userID);
		if(result!=null) {
			System.out.println("Credentials details is below");
			System.out.println("User id is "+result.getUserID());
			System.out.println("Password is "+result.getPassword());
			System.out.println("User type is "+result.getUserType());
			
			
			
			
		}
		

	}}

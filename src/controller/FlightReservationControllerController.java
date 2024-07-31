package controller;

import java.util.Scanner;

import entity.CredentialsBean;
import entity.ProfileBean;
import service.FlightReservationService;
import service.FlightReservationServiceInterface;

public class FlightReservationControllerController implements FlightReservationControllerInterface {

	@Override
	public String SignInFlightController() {
		FlightReservationServiceInterface flightService=new FlightReservationService();
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter user id");
		String userID=sc.next();
		System.out.println("please enter user password");
		String password=sc.next();
		
		CredentialsBean credentialsBean=new CredentialsBean();
		credentialsBean.setUserID(userID);
		credentialsBean.setPassword(password);
		
		String result=flightService.login(credentialsBean);
		return result;
	}

	@Override
	public void SignUpFlightController() {
		Scanner sc=new Scanner(System.in);
		FlightReservationServiceInterface flightService=new FlightReservationService();
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
		
		String result=flightService.register(profileBean);
		if(result.equals("SUCCESS")) {
			System.out.println("registration successful");
		}
		else {
			System.out.println("could not register");
		}
		
		
		
	}

}

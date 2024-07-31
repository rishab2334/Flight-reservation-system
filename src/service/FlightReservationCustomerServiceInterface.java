package service;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.ProfileBean;
import entity.ReservationBean;
import entity.ScheduleBean;

public interface FlightReservationCustomerServiceInterface {

	String register(ProfileBean profileBean);

	FlightBean viewCustomerFlightDetails(String flightID);

	ScheduleBean viewCustomerFlightScheduleDetails(String scheduleID);

	String customerReserveTicket(ReservationBean reservationBean);

	ReservationBean viewTicketDetails(String reservationID);

	boolean cancelTicket(String userID, String reservationID);

	CredentialsBean viewCredentialsDetails(String userID);

	boolean changePassword(CredentialsBean credentialsbean);

}

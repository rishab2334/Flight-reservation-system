package dao;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.ProfileBean;
import entity.ReservationBean;
import entity.ScheduleBean;

public interface FlightReservationCustomerDAOInterface {

	String registerCustomerDAO(ProfileBean profileBean);

	FlightBean viewCustomerFlightDetailsDAO(String flightID);

	ScheduleBean viewCustomerFlightScheduleDetailsDAO(String scheduleID);

	String reserveTicketDAO(ReservationBean reservationBean);

	ReservationBean viewBookingDetailsdao(String reservationID);

	boolean cancelBookingDAO(String userID, String reservationID);

	CredentialsBean viewCredentialsDetailsCustomerDAO(String userID);

	boolean changePasswordDAO(CredentialsBean credentialsbean);

}

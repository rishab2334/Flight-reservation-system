package service;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.PassengerBean;
import entity.RouteBean;
import entity.ScheduleBean;

public interface FlightReservationAdminServiceInterface {

	String addFlightDetails(FlightBean flightBean);

	int deleteFlight(String flightID);

	FlightBean viewFlightDetails(String flightID);

	boolean changeFlightDetails(FlightBean flightbean);

	String addScheduleDetails(ScheduleBean scheduleBean);

	int deleteScheduleDetails(String scheduleID);

	ScheduleBean viewScheduleDetails(String scheduleID);

	boolean changeScheduleDetails(ScheduleBean schedulebean);

	String addRouteDetails(RouteBean routeBean);

	int deleteRouteDetails(String routeID);

	RouteBean viewRouteDetails(String routeID);

	boolean changeRouteDetails(RouteBean routebean);

	PassengerBean viewPassengersDetails(String reservationID);

	
	boolean changePassword(CredentialsBean credentialsbean);

	CredentialsBean viewCredentialsDetails(String userID);



}
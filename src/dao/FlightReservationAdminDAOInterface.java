package dao;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.PassengerBean;
import entity.RouteBean;
import entity.ScheduleBean;

public interface FlightReservationAdminDAOInterface {

	String addFlightDetailsDAO(FlightBean flightBean);

	int deleteFlightDAO(String flightID);

	FlightBean viewFlightDetailsDAO(String flightID);

	boolean changeFlightDetailsDAO(FlightBean flightbean);

	String addScheduleDetailsDAO(ScheduleBean scheduleBean);

	int deleteScheduleDetailsDAO(String scheduleID);

	ScheduleBean viewScheduleDetailsDAO(String scheduleID);

	boolean changeScheduleDetailsDAO(ScheduleBean schedulebean);

	String addRouteDetailsDAO(RouteBean routeBean);

	int deleteRouteDetailsDAO(String routeID);

	RouteBean viewRouteDetailsDAO(String routeID);

	boolean changeRouteDetailsDAO(RouteBean routebean);

	PassengerBean viewPassengerDetailsDAO(String reservationID);

	

	boolean changePasswordDAO(CredentialsBean credentialsbean);

	CredentialsBean viewCredentialsDetailsDAO(String userID);

}

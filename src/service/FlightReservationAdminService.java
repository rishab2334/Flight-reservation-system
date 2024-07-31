package service;

import dao.FlightReservationAdminDAO;
import dao.FlightReservationAdminDAOInterface;
import entity.CredentialsBean;
import entity.FlightBean;
import entity.PassengerBean;
import entity.RouteBean;
import entity.ScheduleBean;

public class FlightReservationAdminService implements FlightReservationAdminServiceInterface {

	@Override
	public String addFlightDetails(FlightBean flightBean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		
		return flightreservationDao.addFlightDetailsDAO(flightBean) ;
	}

	@Override
	public int deleteFlight(String flightID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.deleteFlightDAO(flightID);
		
	}

	@Override
	public FlightBean viewFlightDetails(String flightID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.viewFlightDetailsDAO(flightID);
	}

	@Override
	public boolean changeFlightDetails(FlightBean flightbean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.changeFlightDetailsDAO(flightbean) ;
	}


	@Override
	public String addScheduleDetails(ScheduleBean scheduleBean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		
		return flightreservationDao.addScheduleDetailsDAO(scheduleBean) ;
	
	}

	@Override
	public int deleteScheduleDetails(String scheduleID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.deleteScheduleDetailsDAO(scheduleID);
		
		
	}

	@Override
	public ScheduleBean viewScheduleDetails(String scheduleID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.viewScheduleDetailsDAO(scheduleID);
	
		
	}

	@Override
	public boolean changeScheduleDetails(ScheduleBean schedulebean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.changeScheduleDetailsDAO(schedulebean) ;
	
		
	}

	@Override
	public String addRouteDetails(RouteBean routeBean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		
		return flightreservationDao.addRouteDetailsDAO(routeBean) ;
		
	}

	@Override
	public int deleteRouteDetails(String routeID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.deleteRouteDetailsDAO(routeID);
		
	}

	@Override
	public RouteBean viewRouteDetails(String routeID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.viewRouteDetailsDAO(routeID);
		
	}

	@Override
	public boolean changeRouteDetails(RouteBean routebean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.changeRouteDetailsDAO(routebean) ;
	
		
		
	}

	@Override
	public PassengerBean viewPassengersDetails(String reservationID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.viewPassengerDetailsDAO(reservationID);
		
	}

	

	@Override
	public boolean changePassword(CredentialsBean credentialsbean) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.changePasswordDAO(credentialsbean) ;
	
	}

	@Override
	public CredentialsBean viewCredentialsDetails(String userID) {
		FlightReservationAdminDAOInterface flightreservationDao=new FlightReservationAdminDAO();
		return flightreservationDao.viewCredentialsDetailsDAO(userID);
		
	}

	

}

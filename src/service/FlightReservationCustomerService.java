package service;

import dao.FlightReservationAdminDAO;
import dao.FlightReservationAdminDAOInterface;
import dao.FlightReservationCustomerDAO;
import dao.FlightReservationCustomerDAOInterface;
import dao.FlightReservationDAO;
import dao.FlightReservationDAOInterface;
import entity.CredentialsBean;
import entity.FlightBean;
import entity.ProfileBean;
import entity.ReservationBean;
import entity.ScheduleBean;

public class FlightReservationCustomerService implements FlightReservationCustomerServiceInterface {

	@Override
	public String register(ProfileBean profileBean) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao = new FlightReservationCustomerDAO();
		return  flightreservationCustomerDao.registerCustomerDAO(profileBean);
		
	}

	@Override
	public FlightBean viewCustomerFlightDetails(String flightID) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.viewCustomerFlightDetailsDAO(flightID);
		
	}

	@Override
	public ScheduleBean viewCustomerFlightScheduleDetails(String scheduleID) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.viewCustomerFlightScheduleDetailsDAO(scheduleID);
	
	}

	@Override
	public String customerReserveTicket(ReservationBean reservationBean) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.reserveTicketDAO( reservationBean) ;
	}

	@Override
	public ReservationBean viewTicketDetails(String reservationID) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.viewBookingDetailsdao(reservationID);
	}

	@Override
	public boolean cancelTicket(String userID, String reservationID) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.cancelBookingDAO( userID,  reservationID);
	}

	@Override
	public CredentialsBean viewCredentialsDetails(String userID) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.viewCredentialsDetailsCustomerDAO(userID);
		
	}

	@Override
	public boolean changePassword(CredentialsBean credentialsbean) {
		FlightReservationCustomerDAOInterface flightreservationCustomerDao=new FlightReservationCustomerDAO();
		return flightreservationCustomerDao.changePasswordDAO(credentialsbean) ;
	
	}

}

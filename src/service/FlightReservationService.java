package service;

import dao.FlightReservationDAO;
import dao.FlightReservationDAOInterface;
import entity.CredentialsBean;
import entity.ProfileBean;

public class FlightReservationService implements FlightReservationServiceInterface {

	@Override
	public String login(CredentialsBean credentialsBean) {
		FlightReservationDAOInterface flightreservationDao = new FlightReservationDAO();
		return flightreservationDao.loginDAO(credentialsBean);
	}

	@Override
	public String register(ProfileBean profileBean) {
		FlightReservationDAOInterface flightreservationDao = new FlightReservationDAO();
		return  flightreservationDao.registerDAO(profileBean);
		
	}
	
	public boolean logout(String userId)
	{
		FlightReservationDAOInterface flightreservationDao = new FlightReservationDAO();
		return flightreservationDao.logoutDAO(userId);
		
	}
	
	public String changePassword(CredentialsBean credentialBean, String newPassword) {
		FlightReservationDAOInterface flightreservationDao = new FlightReservationDAO();
		return flightreservationDao.changePasswordDAO(credentialBean, newPassword);
	}
	
	

}

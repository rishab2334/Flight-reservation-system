package dao;

import entity.CredentialsBean;
import entity.ProfileBean;

public interface FlightReservationDAOInterface {

	String loginDAO(CredentialsBean credentialsBean);

	String registerDAO(ProfileBean profileBean);

	

	String changePasswordDAO(CredentialsBean credentialBean, String newPassword);

	boolean logoutDAO(String userId);

}

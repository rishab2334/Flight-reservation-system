package service;

import entity.CredentialsBean;
import entity.ProfileBean;

public interface FlightReservationServiceInterface {

	String login(CredentialsBean credentialsBean);

	String register(ProfileBean profileBean);

	boolean logout(String userID);

}

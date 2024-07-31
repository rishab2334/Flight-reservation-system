package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.ProfileBean;
import entity.ReservationBean;
import entity.ScheduleBean;
import util.DatabaseConnection;

public class FlightReservationCustomerDAO implements FlightReservationCustomerDAOInterface {

	@Override
	public String registerCustomerDAO(ProfileBean profileBean) {
		String i=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			
			PreparedStatement ps1=con.prepareStatement("insert into frs_tbl_user_credentials values(?,?,?,?)");
			ps1.setString(1, profileBean.getUserID());
			ps1.setString(2, profileBean.getPassword());
			ps1.setString(3, "customer");
			ps1.setInt(4, 0);
			
			int i2=ps1.executeUpdate();
			
			if(i2>0) {
				PreparedStatement ps=con.prepareStatement("insert into frs_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)" );
				ps.setString(1,profileBean.getUserID());
				ps.setString(2, profileBean.getFirstName());
				ps.setString(3, profileBean.getLastName());
				ps.setString(4, profileBean.getDateOfBirth());
				ps.setString(5, profileBean.getGender());
				
				ps.setString(6, profileBean.getStreet());
				ps.setString(7, profileBean.getLocation());
				ps.setString(8, profileBean.getCity());
				ps.setString(9, profileBean.getState());
				ps.setString(10, profileBean.getPincode());
				ps.setString(11, profileBean.getMobileNo());
				ps.setString(12, profileBean.getEmailID());
				
				int i1=ps.executeUpdate();
				if(i1>0) {
					i="SUCCESS";
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	@Override
	public FlightBean viewCustomerFlightDetailsDAO(String flightID) {
		FlightBean iu1=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from frs_tbl_flight where flightID=?" );
			ps.setString(1, flightID);
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				iu1=new FlightBean();
				iu1.setFlightID(i.getString(1));
				iu1.setFlightName(i.getString(2));
				iu1.setReservationCapacity(i.getString(3));
				iu1.setSeatingCapacity(i.getString(4));
			}
		}
		catch(SQLException | ClassNotFoundException  e) {
			System.out.println(e);
		}
		return iu1;
	}

	@Override
	public ScheduleBean viewCustomerFlightScheduleDetailsDAO(String scheduleID) {
		ScheduleBean iu1=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from frs_tbl_Schedule where ScheduleID=?" );
			ps.setString(1, scheduleID);
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				iu1=new ScheduleBean();
				iu1.setScheduleID(i.getString(1));
				iu1.setFlightID(i.getString(2));
				iu1.setRouteID(i.getString(3));
				iu1.setTravelDuration(i.getString(4));
				iu1.setAvailableDays(i.getString(3));
				iu1.setDepartureTime(i.getString(4));
			}
		}
		catch(SQLException | ClassNotFoundException  e) {
			System.out.println(e);
		}
		return iu1;
	}
	
	
	
	
	
	
	

	@Override
	public String reserveTicketDAO(ReservationBean reservationBean) {
		String i1=null;
		try {
			Connection con=DatabaseConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("insert into frs_tbl_Reservation values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1, reservationBean.getReservationID());
		ps.setString(2, reservationBean.getUserID());
		ps.setString(3, reservationBean.getScheduleID());
		ps.setString(4, reservationBean.getReservationType());
		ps.setString(5, reservationBean.getBookingDate());
		ps.setString(6, reservationBean.getJourneyDate());
		ps.setString(7, reservationBean.getNoOfSeats());
		
		ps.setString(8, reservationBean.getTotalFare());
		ps.setString(9, reservationBean.getBookingStatus());
		
		int i=ps.executeUpdate(); 
		if(i>0) {
			i1="SUCCESS";
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i1;
		
	}

	@Override
	public ReservationBean viewBookingDetailsdao(String reservationID) {
		ReservationBean i=null;
		try {
			Connection con=DatabaseConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from frs_tbl_Reservation where reservationID=?");
		ps.setString(1, reservationID);
		
		ResultSet res=ps.executeQuery(); 
		if(res.next()) {
			i=new ReservationBean();
			i.setReservationID(res.getString(1));
			i.setUserID(res.getString(2));
			i.setScheduleID(res.getString(3));
			i.setReservationType(res.getString(4));
			i.setBookingDate(res.getString(5));
			i.setJourneyDate(res.getString(6));
			i.setNoOfSeats(res.getString(7));
			i.setTotalFare(res.getString(8));
			i.setBookingStatus(res.getString(9));
	
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean cancelBookingDAO(String userID, String reservationID) {
		int i=0;
		boolean b=false;
		try {
		Connection con=DatabaseConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from frs_tbl_Reservation where reservationID=?");
		ps.setString(1,reservationID);
		
		i=ps.executeUpdate(); 
		if(i>0)
		b=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public CredentialsBean viewCredentialsDetailsCustomerDAO(String userID) {
		CredentialsBean iu1=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from frs_tbl_user_Credentials where userID=?" );
			ps.setString(1, userID);
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				iu1=new CredentialsBean();
				iu1.setUserID(i.getString(1));
				iu1.setPassword(i.getString(2));
				iu1.setUserType(i.getString(3));
				
			}
		}
		catch(SQLException | ClassNotFoundException  e) {
			System.out.println(e);
		}
		return iu1;
	}

	@Override
	public boolean changePasswordDAO(CredentialsBean credentialsbean) {
		boolean i=false;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update frs_tbl_user_credentials set password=? where userId=?");
			ps.setString(2,credentialsbean.getUserID());
			ps.setString(1,credentialsbean.getPassword());
			
			
			int i1=ps.executeUpdate();
			if(i1>0) {
				i=true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return i;
	}
	}

	



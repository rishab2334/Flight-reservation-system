package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.CredentialsBean;
import entity.FlightBean;
import entity.PassengerBean;
import entity.RouteBean;
import entity.ScheduleBean;
import util.DatabaseConnection;

public class FlightReservationAdminDAO implements FlightReservationAdminDAOInterface {

	@Override
	public String addFlightDetailsDAO(FlightBean flightBean) {
		String i=null;
		try {
			Connection con =DatabaseConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into frs_tbl_flight values (?,?,?,?)");
			ps.setString(1, flightBean.getFlightID());
			ps.setString(2, flightBean.getFlightName());
			ps.setString(3, flightBean.getSeatingCapacity());
			ps.setString(4, flightBean.getReservationCapacity());
			
			int i1=ps.executeUpdate();
			if(i1>0) {
				i="SUCCESS";
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteFlightDAO(String flightID) {
		int i=0;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from frs_tbl_flight where flightid=?");
			ps.setString(1, flightID);
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public FlightBean viewFlightDetailsDAO(String flightID) {
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
				iu1.setReservationCapacity(i.getString(4));
				iu1.setSeatingCapacity(i.getString(3));
			}
		}
		catch(SQLException | ClassNotFoundException  e) {
			System.out.println(e);
		}
		return iu1;
	}

	@Override
	public boolean changeFlightDetailsDAO(FlightBean flightbean) {
		boolean i=false;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update frs_tbl_flight set flightname=?,seatingcapacity=?,reservationcapacity=? where flightid=?");
			ps.setString(1,flightbean.getFlightName());
			ps.setString(2, flightbean.getSeatingCapacity());
			ps.setString(3, flightbean.getReservationCapacity());
			ps.setString(4,flightbean.getFlightID());
			
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

	@Override
	public String addScheduleDetailsDAO(ScheduleBean scheduleBean) {
		String i=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into FRS_TBL_Schedule values(?,?,?,?,?,?)");
			ps.setString(1, scheduleBean.getScheduleID());
			ps.setString(2, scheduleBean.getFlightID());
			ps.setString(3, scheduleBean.getRouteID());
			ps.setString(4, scheduleBean.getTravelDuration());
			ps.setString(5, scheduleBean.getAvailableDays());
			ps.setString(6, scheduleBean.getDepartureTime());
			
			
			int i1=ps.executeUpdate();
			if(i1>0) {
				i="SUCCESS";
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteScheduleDetailsDAO(String scheduleID) {
		int i=0;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from FRS_TBL_Schedule  where scheduleid=?");
			ps.setString(1,scheduleID );
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	
	}

	@Override
	public ScheduleBean viewScheduleDetailsDAO(String scheduleID) {
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
	public boolean changeScheduleDetailsDAO(ScheduleBean schedulebean) {
		
		boolean i=false;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update frs_tbl_Schedule set Flightid=?,Routeid=?,Travelduration=?,Availabledays=?,Departuretime=? where ScheduleId=?");
			ps.setString(1,schedulebean.getFlightID());
			ps.setString(2, schedulebean.getRouteID());
			ps.setString(3, schedulebean.getTravelDuration());
			ps.setString(4,schedulebean.getAvailableDays());
			ps.setString(5,schedulebean.getDepartureTime());
			ps.setString(6,schedulebean.getScheduleID());
			
			
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

	@Override
	public String addRouteDetailsDAO(RouteBean routeBean) {
		String i=null;
		try {
			Connection con =DatabaseConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into frs_tbl_route values (?,?,?,?,?)");
			ps.setString(1, routeBean.getRouteID());
			ps.setString(2, routeBean.getSource());
			ps.setString(3, routeBean.getDestination());
			ps.setString(4, routeBean.getDistance());
			ps.setString(5, routeBean.getFare());
			
			int i1=ps.executeUpdate();
			if(i1>0) {
				i="SUCCESS";
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}

	@Override
	public int deleteRouteDetailsDAO(String routeID) {
		int i=0;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from frs_tbl_route where routeid=?");
			ps.setString(1, routeID);
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public RouteBean viewRouteDetailsDAO(String routeID) {
		RouteBean iu1=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from frs_tbl_Route where RouteID=?" );
			ps.setString(1,routeID );
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				iu1=new RouteBean();
				iu1.setRouteID(i.getString(1));
				iu1.setSource(i.getString(2));
				iu1.setDestination(i.getString(3));
				iu1.setDistance(i.getString(4));
				iu1.setFare(i.getString(5));
				
			}
		}
		catch(SQLException | ClassNotFoundException  e) {
			System.out.println(e);
		}
		return iu1;
		
		
	}

	@Override
	public boolean changeRouteDetailsDAO(RouteBean routebean) {
		
		boolean i=false;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update frs_tbl_Route set Source=?,Destination=?,Distance=?,Fair=? where RouteId=?");
			ps.setString(1,routebean.getSource());
			ps.setString(2, routebean.getDestination());
			ps.setString(3, routebean.getDistance());
			ps.setString(4,routebean.getFare());
			ps.setString(5,routebean.getRouteID());
			
			
			
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

	@Override
	public PassengerBean viewPassengerDetailsDAO(String reservationID) {
		PassengerBean iu1=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from frs_tbl_Passenger where reservationID=?" );
			ps.setString(1,reservationID );
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				iu1=new PassengerBean();
				iu1.setReservationID(i.getString(1));
				iu1.setName(i.getString(2));
				iu1.setGender(i.getString(3));
				iu1.setAge(i.getString(4));
				iu1.setSeatNo(i.getString(5));
				
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
			ps.setString(1,credentialsbean.getPassword());
			ps.setString(2, credentialsbean.getUserID());
			
			
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

	@Override
	public CredentialsBean viewCredentialsDetailsDAO(String userID) {
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
	
	

}

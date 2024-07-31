package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.CredentialsBean;
import entity.ProfileBean;
import util.DatabaseConnection;

public class FlightReservationDAO implements FlightReservationDAOInterface {

	@Override
	public String loginDAO(CredentialsBean credentialsBean) {
		String i=null;
		try {
			Connection con=DatabaseConnection.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select * from frs_tbl_user_credentials where userid=? and password=?");
			ps.setString(1, credentialsBean.getUserID());
			ps.setString(2, credentialsBean.getPassword());
			
			ResultSet res =ps.executeQuery();
			if(res.next()) {
				i=res.getString("userType");
				PreparedStatement ps1=con.prepareStatement("update frs_tbl_user_credentials set loginstatus=? where userid=? ");
				ps1.setInt(1,1);
				ps1.setString(2, credentialsBean.getUserID());
				
				
				int i1=ps1.executeUpdate();
			}
			
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		return i;
	}

	@Override
	public String registerDAO(ProfileBean profileBean) {
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
	public String changePasswordDAO(CredentialsBean credentialBean, String newPassword) {
		String i=null;
		try {
			Connection con=DatabaseConnection.getConnection();
            
			
			PreparedStatement ps=con.prepareStatement("update frs_tbl_user_credentials set password=? where userid=?");
			ps.setString(1, newPassword);
			ps.setString(2, credentialBean.getUserID());
			
			int i1=ps.executeUpdate();
			if(i1>0) {
				i="SUCCESS"
;
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean logoutDAO(String userId) {
		boolean i=false;
		try {
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("update frs_tbl_user_credentials set loginstatus=? where userid=?");
			ps.setInt(1, 0);
			ps.setString(2, userId);
			
			
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

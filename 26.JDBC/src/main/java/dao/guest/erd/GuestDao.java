package dao.guest.erd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;
import dao.guest.Guest;
import dao.guest.GuestSQL;

public class GuestDao {
	/*
	 * Connection 생성, 해제 객체
	 */
	private DataSource dataSource;
	public GuestDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Guest guest) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int update(Guest guest) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		pstmt.setInt(6, guest.getGuestNo());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public int delete(int guestNo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, guestNo);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	public Guest findByGuestNo(int guestNo) throws Exception {
		Guest findGuest = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_FIND_BY_NO);
		pstmt.setInt(1, guestNo);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			findGuest = new Guest(rs.getInt("GUEST_NO"), 
								  rs.getString("GUEST_NAME"), 
								  rs.getDate("GUEST_DATE"), 
								  rs.getString("GUEST_EMAIL"), 
								  rs.getString("GUEST_HOMEPAGE"), 
								  rs.getString("GUEST_TITLE"), 
								  rs.getString("GUEST_CONTENT"));
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findGuest;
	}
	
	public List<Guest> findAll() throws Exception {
		List<Guest> guestList = new ArrayList<>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_FIND_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			guestList.add(new Guest(rs.getInt("GUEST_NO"), 
									rs.getString("GUEST_NAME"), 
									rs.getDate("GUEST_DATE"), 
									rs.getString("GUEST_EMAIL"), 
									rs.getString("GUEST_HOMEPAGE"), 
									rs.getString("GUEST_TITLE"), 
									rs.getString("GUEST_CONTENT")));
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return guestList;
	}
	
}

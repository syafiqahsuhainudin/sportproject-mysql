package com.sport.manager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import  java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sport.model.EquipmentBean;
import com.sport.model.BookingBean;
import com.sport.model.UserBean;





public class BookingManager {
	
public boolean addTask(BookingBean bookingBean) {
	
// get new connection
ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();
boolean insertStatus = false;
try {
	
	
// prepare a statement object
String sql = "insert into booking(quantity,date,statusbook,equip_id,userid) "+ "values (?, ?, ?, ?, ?)";



PreparedStatement ps = con.prepareStatement(sql);


// set parameters
ps.setInt(1, bookingBean.getQuantity());
ps.setString(2, bookingBean.getDate());
ps.setString(3, bookingBean.getStatusbook());
ps.setInt(4, bookingBean.getEquipmentBean().getEquip_id());
ps.setInt(5, bookingBean.getUserBean().getUserid());

// execute query
int res = ps.executeUpdate();

// if one record changed, that means insert is successful
if (res == 1)
insertStatus = true;
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
return insertStatus;
}

public ArrayList<BookingBean> fetchAllTasks(UserBean userBean){
	
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	
	ArrayList<BookingBean> books=new ArrayList<BookingBean>();
	
	try {
		
		String sql = "select t.booking_id, t.quantity, t.date, t.statusbook,t.userid, t.equip_id, p.equip_name from booking t join equipment p on t.equip_id=p.equip_id where userid=? and task_status=0";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		 // set parameter of the sql
		ps.setInt(1, userBean.getUserid());
		
		// execute
		ResultSet rs = ps.executeQuery();
		
		// get all records
		while (rs.next()) {
		int bid = rs.getInt(1);
		int qt = rs.getInt(2);
		String dt = rs.getString(3);
		String st = rs.getString(4);
		
		int eid = rs.getInt(5);
		String eqn = rs.getString(6);
		 eqn = setEquip_namesB(rs.getString("equip_name"));
	
		// create bean and add to array list
		EquipmentBean eb = new EquipmentBean(eid, eqn);
		BookingBean bb = new BookingBean(bid, qt, dt,st, eb, userBean);
		books.add(bb);	
			} // end while
		} // end try
		catch (Exception e) {
		e.printStackTrace();
		} finally {
		try {
		con.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return books;
		}

private String setEquip_namesB(String string) {
	// TODO Auto-generated method stub
	return null;
}

public BookingBean getTask(int booking_id) {
	
	// get new connection
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	
	try {
	// prepare a statement object
	String sql = "select t.booking_id, t.quantity, t.date,t.statusbook ,t.equip_id,t.userid, p.equip_name from booking t inner join equipment p on t.equip_id=p.equip_id where booking_id=?";
	PreparedStatement ps = con.prepareStatement(sql);
	
	// set parameter of the sql
	ps.setInt(1, booking_id);
	
	
	// execute
	ResultSet rs = ps.executeQuery();
	
	
	// get record
	if (rs.next()) {
		int bid = rs.getInt("booking_id");
		int qt = rs.getInt("quantity");
		String dt = rs.getString("date");
		String st = rs.getString("statusbook");
		int uid = rs.getInt("userid");
	
		int eid = rs.getInt("equip_id");
		String eqn = rs.getString("equip_name");
		
	
	
	
	// create bean and add to array list
	BookingBean bb = new BookingBean();
	 bb.setBooking_id(bid);
	bb.setQuantity(qt);
	bb.setDate(dt);
	bb.setStatusbook(st);
	UserBean ub =new UserBean(uid,null,null, null, null, null);
	bb.setUserBean(ub);
	EquipmentBean eb = new EquipmentBean(eid, eqn);
	bb.setEquipmentBean(eb);
	return bb;
	} // end while
	} // end try
	
	
	catch (Exception e) {
	e.printStackTrace();
	} finally {
	try {
	con.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return null; // failed
	}
	
/**
* Update the task info based on the taskId
* @param taskBean - bean with the latest info
* @return true if successfully update, false if not
*/
public boolean updateTask(BookingBean bookingBean) {
	
// get new connection
ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();
boolean updateStatus = false;

try {
// prepare a statement object
String sql = "update booking set quantity=?, date=?,statusbook=?, "+ "equip_id=?,userid=? where booking_id=?";
PreparedStatement ps = con.prepareStatement(sql);

// set parameters
ps.setInt(1, bookingBean.getQuantity());
ps.setString(2,  bookingBean.getDate());
ps.setString(3,  bookingBean.getStatusbook());
ps.setInt(4,  bookingBean.getEquipmentBean().getEquip_id());
ps.setInt(5,  bookingBean.getUserBean().getUserid());
ps.setInt(6, bookingBean.getBooking_id());

// execute query
int res = ps.executeUpdate();

// if one record changed, that means update is successful
if (res == 1)
updateStatus = true;
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
return updateStatus;
}

public boolean deleteTask(int booking_id) {
	
	
	// get new connection
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	boolean delStatus = false;
	try {
	
		
		// prepare a statement object
	String sql = "delete from booking where booking_id=?";
	PreparedStatement ps = con.prepareStatement(sql);
	
	
	// set parameters
	ps.setInt(1, booking_id);
	
	
	// execute query
	int res = ps.executeUpdate();
	
	// if one record changed, that means update is successful
	if (res == 1)
	delStatus = true;
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	try {
	con.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return delStatus;
	}
public static List<BookingBean> getAllBooking() {
    List<BookingBean> bookings = new ArrayList<BookingBean>();
    try {
    	// get new connection
    	ConnectionManager cm = new ConnectionManager();
    	Connection con = cm.getConnection();
    	Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from booking join equipment on(booking.equip_id = equipment.equip_id) join student on(booking.userid=student.userid) order by booking.booking_id");
        
        while (rs.next()) {
            BookingBean booking = new BookingBean();
            booking.setMatric_no(rs.getString("no_matric"));
            booking.setBooking_id(rs.getInt("booking_id"));
            booking.setDate(rs.getString("date"));
            booking.setQuantity(rs.getInt("quantity"));
            booking.setEquip_quan(rs.getInt("equip_quantity"));
            booking.setStatusbook(rs.getString("statusbook"));
            booking.setEquip_namesB(rs.getString("equip_name"));
            booking.setEquip_id(rs.getInt("equip_id"));
            booking.setUserid(rs.getInt("userid"));
            bookings.add(booking);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return bookings;
}
public boolean updateBooking(BookingBean bookingBean) {
	
	// get new connection
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	boolean updateStatus1 = false;

	try {
	// prepare a statement object
	String sql = "update booking set quantity=?, date=?,statusbook=?, "+ "equip_id=? where booking_id=?";
	PreparedStatement ps = con.prepareStatement(sql);

	// set parameters
	ps.setInt(1, bookingBean.getQuantity());
	ps.setString(2,  bookingBean.getDate());
	ps.setString(3,  bookingBean.getStatusbook());
	ps.setInt(4,  bookingBean.getEquipmentBean().getEquip_id());

	ps.setInt(5, bookingBean.getBooking_id());

	// execute query
	int res = ps.executeUpdate();

	// if one record changed, that means update is successful
	if (res == 1)
	updateStatus1 = true;
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	try {
	con.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return updateStatus1;
	}


}


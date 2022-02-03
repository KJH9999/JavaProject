package com.java.ex.gui.login;
import com.java.ex.db.user.UserDAO;
import com.java.ex.gui.manager.Manager;
import com.java.ex.gui.staff.Staff;

public class Select_M_S{
	
	String a = "staff";
	
	Select_M_S(String m_id) {
		
		if(UserDAO.selectMS(m_id).equals(a)) {
			Staff stafff = new Staff(m_id);
		}
		else {
			Manager managerr = new Manager(m_id);
		} 

	}

}

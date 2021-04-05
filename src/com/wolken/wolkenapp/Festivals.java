package com.wolken.wolkenapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Festivals {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			//Class.forName("com.wolken.wolkenapp.Festivals");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Password@1234567890");
			st=con.createStatement();
			/*st.execute("insert into festivals values(3,'sankarthi',2)");
			st.execute("insert into festivals values(4,'Navaratri',9)");*/
			ResultSet rs=st.executeQuery("select * from festivals");
			while(rs.next()) {
				int festivalId=rs.getInt("festival_id");
				String name =rs.getString("festival_name");
				int  no =rs.getInt("no_of_days");
				System.out.println(festivalId+" "+name+" "+no);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

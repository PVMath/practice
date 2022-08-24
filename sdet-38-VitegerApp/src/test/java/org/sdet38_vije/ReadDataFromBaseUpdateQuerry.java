package org.sdet38_vije;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromBaseUpdateQuerry {
	public static void main(String[] args) throws SQLException {
		Driver driver= new Driver();
		Connection con = null;
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer",  "root",  "root");
		Statement statement = con.createStatement();
		String query = "select * from customer;";
		String expdata = "prashant";
		ResultSet result = statement.executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			String actData = result.getString(2);
			if(actData.equalsIgnoreCase(expdata)) {
				System.out.println(actData);
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("data present");

		}else {
			System.out.println("data not present");

		}


	}
}

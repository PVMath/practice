package org.sdet38_vije;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromBaseExecuteQuerry {
	public static void main(String[] args) throws SQLException {
		Driver driver= new Driver();
		Connection con=null;
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");
		Statement statement = con.createStatement();
		String query= "insert into customer values(1,'prashant','math','bagl');";
		int result = statement.executeUpdate(query);

		System.out.println(result);
		if(result==1) {
			System.out.println("data added");

		}else {
			System.out.println("data not added");
			con.close();
			System.out.println("connection closed");
		}
	}
}

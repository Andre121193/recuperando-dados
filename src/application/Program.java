package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();

			st = (Statement) conn.createStatement();

			rs = st.executeQuery("select * from department");

			while (rs.next()) {
				System.out.println(rs.getInt("ID") + ", " + rs.getString("Name"));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}

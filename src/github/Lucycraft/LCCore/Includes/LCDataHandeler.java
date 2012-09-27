package github.Lucycraft.LCCore.Includes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class LCDataHandeler {
	
	public static enum connectionType {mysql, flatfile};
	private static connectionType conType = connectionType.mysql;
	private static String DB_IP = "localhost";
	private static int DB_Port = 3306;
	private static String DB_DatabaseName = "Lucycraft_TestEnviroment";
	private static String DB_Username = "root";
	private static String DB_Password = "<password>";
	
	/**
	 * if you want to use an custom database type for some reason,
	 * you can use this one. I highly recommend not to do this.
	 * @param query - your query
	 * @param contype - connection type
	 */
	public static ArrayList<ArrayList<Object>> getData(String query, connectionType contype){
		boolean succeded = false;
		ArrayList<ArrayList<Object>> resultSet = null;
		
		switch (conType){
		case mysql:
			Connection conn = null;
			PreparedStatement QuerryStatement = null;
			 try { 
				 conn = DriverManager.getConnection("jdbc:mysql://"+DB_IP+":"+DB_Port+"/"+ DB_DatabaseName, DB_Username, DB_Password);
				 QuerryStatement = conn.prepareStatement(query);
				 QuerryStatement.execute();
				 resultSet = Results2Array(QuerryStatement.getResultSet());
				 QuerryStatement.close();
				 conn.close();
				 succeded = true;					
			 } catch (SQLException e) {
				  LCLogger.error(e.getMessage());
			 }			 
			// if not succeded getting the data, go to next connection method 
			if (succeded == false) {
				LCLogger.error("Could not connect to database, switching to flatfile");
			} else {
				break;
			}
		case flatfile:
			
			break;	
		}
		return resultSet;
	}
	public static ArrayList<ArrayList<Object>> getData(String querry){		
		// if using default connection type
		return getData(querry, conType);		
	}
	private static ArrayList<ArrayList<Object>> Results2Array(ResultSet rs) throws SQLException {
	    ResultSetMetaData metaData = rs.getMetaData();
	    int columns = metaData.getColumnCount();

	    ArrayList<ArrayList<Object>> al = new ArrayList<ArrayList<Object>>();

	    while (rs.next()) {
	        ArrayList<Object> record = new ArrayList<Object>();

	        for (int i = 1; i <= columns; i++) {
	            Object value = rs.getObject(i);
	            record.add(value);
	        }
	        al.add(record);
	    }
	    return al;
	}
}

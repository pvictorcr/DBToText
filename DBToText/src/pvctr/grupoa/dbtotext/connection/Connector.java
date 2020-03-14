package pvctr.grupoa.dbtotext.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Connector {

	private Connection con = null;
	private Statement stm = null;
	
	private String url = "jdbc:firebirdsql:192.168.0.43/3050:C:/converter/AC_JMT.fdb";
	private String user = "sysdba";
	private String password = "masterkey";

	public Connector() {
		
		try {

			Class.forName("org.firebirdsql.jdbc.FBDriver");
			con = DriverManager.getConnection(url, user , password);
			stm = con.createStatement();
			//ResultSet rs = stm.executeQuery("select cast('NOW' as timestamp) from rdb$database");
			//ResultSet rs = stm.executeQuery("select * from EPG");

			//ResultSetMetaData rsmd = rs.getMetaData();
			//System.out.println(rsmd.getColumnCount());

		} catch (Exception e) {
			System.out.println("N�o foi poss�vel conectar ao banco: " + e.getMessage());
			System.out.println(e);
		}

	}
	
	public ResultSet getTable(String tableName) {
		
		ResultSet rs = null;
		
		try {

			Class.forName("org.firebirdsql.jdbc.FBDriver");
			con = DriverManager.getConnection(url, user , password);
			stm = con.createStatement();
			rs = stm.executeQuery("select first 100 * from " + tableName);
			rs.next();
			
			System.out.println();

		} catch (Exception e) {
			System.out.println("N�o foi poss�vel conectar ao banco: " + e.getMessage());
			System.out.println(e);
		}
		
		return rs;
	}
}

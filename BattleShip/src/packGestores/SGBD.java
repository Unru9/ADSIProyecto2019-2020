package packGestores;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SGBD {
	
	private static SGBD mySGBD;
	private Connection myConn;
	private Statement myStmt;
	
	private SGBD() {
		try {
			conectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  SGBD getSGBD() {
		if (mySGBD==null)mySGBD=new SGBD();
		return mySGBD;
	}
	
public void conectar() throws SQLException, ClassNotFoundException { 	
		Class.forName("org.sqlite.JDBC");
		myConn = DriverManager.getConnection("jdbc:sqlite:battleship.sqlite");

		if(myConn.isClosed() == false)
		{
			System.out.println("Database connection successful!\n");
			myStmt = myConn.createStatement();
		}
		else
		{
			System.out.println("Error de conexion con la base de datos");
		}
	}

	public void cerrarConexion() throws SQLException {
		
		if (myStmt != null) {
			myStmt.close();
		}
	}

	/*
	 Consultas SELECT
	*/
	public ResultSet execSQLSelect(String pSentencia) throws SQLException {
		
		ResultSet myRs =  myStmt.executeQuery(pSentencia);
		return myRs;
	}

	/*
	Consultas UPDATE, INSERT Y DELETE
	*/
	public void execSQL(String pSentencia) throws SQLException {
	
		 myStmt.executeUpdate(pSentencia);
	}
	
	public void addToTransaction(String pSentencia) {
		try {
			myStmt.addBatch(pSentencia);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ejecutarTransaccion() throws SQLException {
		myStmt.executeBatch();
	}
	
}

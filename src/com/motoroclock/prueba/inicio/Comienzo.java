package com.motoroclock.prueba.inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Comienzo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("hola");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conexion = DriverManager.getConnection("jdbc:odbc:prueba");
            Statement st = conexion.createStatement();

            ResultSet rs = st.executeQuery("select * from clientes");
            while ( rs.next() )
            {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
            }

        

	}

}

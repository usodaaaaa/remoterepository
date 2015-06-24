package sqldemo;

import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;

import javax.rmi.CORBA.Util;

import sql.Procedure2;
import sql.Procedure1;

public class Test {

	public static void main(String[] args) throws SQLException {
		Procedure1 mova =	new Procedure1();
		Procedure2 mova2=new Procedure2();
//		System.out.println( mova.selectm_room("AÆU") );
		java.util.Date c=new java.util.Date();
//		mova.createlist(new java.sql.Date(c.getTime()),1,"AÆU");
//		mova.createmovie(new java.sql.Date(c.getTime()), 1,"AÆU");
		mova2.createmovie(new java.sql.Date(c.getTime()), 1,"BÆU");
	}

}

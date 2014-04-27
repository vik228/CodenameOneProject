package com.servlet.dbFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class initParams1
 */
public class initParams2 extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Item1 = "empty";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		processRequest (req, res);
	}
	public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		processRequest (req, res);
	}
	protected void processRequest (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out = res.getWriter();
		Item1 = req.getParameter("arg1");
		
		//out.print(Item1);
		//String pr ="select gram_panchayat_code from iwmp_gram_panchayat where gram_panchayat_name ='"+Item1+"'";
		//out.println (pr);
		String dbUrl = "jdbc:postgresql://localhost:5432/iwmp_prd";
		String dbClass = "org.postgresql.Driver";
		String pr ="select gram_panchayat_code from iwmp_gram_panchayat where gram_panchayat_name ='"+Item1+"'";
		try
		{
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "postgres","vikas008");
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(pr);
			r.next();
			int cd = r.getInt("gram_panchayat_code");
			String pr1 ="select village_name,village_code from iwmp_village where gram_panchayat_code='"+cd+"'";
			Statement s1 =con.createStatement();
			ResultSet r1 = s1.executeQuery(pr1);
			String panchayat= "";
			while(r1.next())
			{
				 panchayat += r1.getString("village_name");
				 panchayat += "->";
				 panchayat += r1.getString("village_code");
				 panchayat += ':' ;
		    }
			out.print(panchayat);
		}
		catch (ClassNotFoundException e)
		{
			throw new ServletException ("jdbc driver not found ", e);
		}
		catch (SQLException e)
		{
			throw new ServletException ("data could not be loaded ", e);
		}
		
	
		
	}

}
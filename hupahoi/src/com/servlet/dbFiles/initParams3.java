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
public class initParams3 extends HttpServlet 
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
		Item1 = Item1.trim();
		String dbUrl = "jdbc:postgresql://localhost:5432/iwmp_prd";
		String dbClass = "org.postgresql.Driver";
		String qur="select head_code from iwmp_m_heads WHERE head_desc ='"+Item1+"'";
		//System.out.println (qur);
		try
		{
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "postgres","vikas008");
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(qur);
			r.next();
			int cd = r.getInt("head_code");
			String qu =	"SELECT activity_code,  activity_desc, status from iwmp_m_activity where head_code='"+cd+"'";
			Statement s1 =con.createStatement();
			ResultSet r1 = s1.executeQuery(qu);
			String status= "";
			while(r1.next())
			{
				 status += r1.getString("activity_desc");
				 status += "->";
				 status +=r1.getString("activity_code");
				 status += ':' ;
		         				 
		    }
			out.print(status);
					
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
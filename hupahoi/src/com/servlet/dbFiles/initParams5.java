package com.servlet.dbFiles;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
@SuppressWarnings("serial")
public class initParams5 extends HttpServlet 
{
	String uname = "empty";
	//String pass = "empty";
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
		String Uid=req.getParameter("arg1");
	    uname = req.getParameter("arg2");
        String img_name = req.getParameter("arg3");
        String latd = req.getParameter("arg4");
        String latm = req.getParameter("arg5");
        String lats = req.getParameter("arg6");
        String logd = req.getParameter("arg7");
        String logm = req.getParameter("arg8");
        String logs = req.getParameter("arg9");
        String dbUrl = "jdbc:postgresql://localhost:5432/iwmp_prd";
		String dbClass = "org.postgresql.Driver";
		String sql = "INSERT INTO iwmp_project_image_detail(id,file_name,latitude_degrees,latitude_minutes, latitude_seconds, longitude_degrees, longitude_minutes, longitude_seconds,last_updated_by) VALUES ('"+Uid+"','"+ img_name +"','"+latd+"','"+latm+"','"+lats+"','"+logd+"','"+logm+"','"+logs+"','"+uname+"')";
		
		try 
		{
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "postgres","vikas008");
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			out.print("saved");
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
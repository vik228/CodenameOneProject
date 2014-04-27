package com.servlet.dbFiles;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
public class initParams4 extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String uname = "empty";
	String pass = "empty";
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
		uname = req.getParameter("arg1");
        String state_cd = req.getParameter("arg2");
        String district_cd = req.getParameter("arg3");
        String block_cd = req.getParameter("arg4");
        String gp_cd = req.getParameter("arg5");
        String village_cd = req.getParameter("arg6");
        String project_cd = req.getParameter("arg7");
        String head_cd = req.getParameter("arg8");
        String activity_cd = req.getParameter("arg9");
        String allocation = req.getParameter("arg10");
        String expend = req.getParameter("arg11");
      	String dbUrl = "jdbc:postgresql://localhost:5432/iwmp_prd";
		String dbClass = "org.postgresql.Driver";
		String sql = "INSERT INTO iwmp_project_activity_detail (id,st_code, dist_code, project_cd, block_code, gram_panchayat_code, village_code, head_code, activity_code, total_allocation, expenditure,last_updated_by) VALUES ('37','"+ state_cd +"','"+district_cd+"','"+project_cd+"','"+block_cd+"','"+gp_cd+"','"+village_cd+"','"+head_cd+"','"+activity_cd+"','"+allocation+"','"+expend+"','"+uname+"')";
		
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
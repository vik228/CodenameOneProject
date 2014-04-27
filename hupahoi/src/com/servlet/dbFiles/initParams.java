package com.servlet.dbFiles;
import java.io.*;
import com.servlet.encrypt.MD5Encrypt;
import javax.servlet.*;
import javax.servlet.http.*;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class initParams extends HttpServlet 
{
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
		pass = req.getParameter("arg2");
		String md5_pass = MD5Encrypt.encrypt(pass);
		String dbUrl = "jdbc:postgresql://localhost:5432/iwmp_prd";
		String dbClass = "org.postgresql.Driver";
		String sql = "SELECT reg_id, user_name,encrypted_pass FROM iwmp_user_reg WHERE user_id=?";
		try 
		{
			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "postgres","vikas008");
			PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,uname);
			ResultSet rs = ps.executeQuery();
			int size = 0;
			while(rs.next())
				size++;
			if (size == 0)
				out.print("no");
			else
			{
				rs.first();
				String a = rs.getString("encrypted_pass");
				//out.println(a);
				String id = rs.getString("reg_id");
				//out.println(id); 
				String name = rs.getString("user_name");
				//out.println (a);
				//out.println (md5_pass);
				if (md5_pass.equals(a))
				{
					out.print( name + ';');
					String qry = "select third.project_cd,proj_name, third.st_code,(select st_name from iwmp_state where st_code=third.st_code) as state_name,third.dist_code,(select dist_name from iwmp_district where  st_code=third.st_code and dist_code=third.dist_code) as dist_name,block_code,(select block_name from iwmp_block where  st_code=third.st_code and dist_code=third.dist_code and block_code=fourth.block_code )  as block_name ,gram_panchayat_code,(select gram_panchayat_name from iwmp_gram_panchayat where st_code=third.st_code and dist_code=third.dist_code and block_code=fourth.block_code and gram_panchayat_code = fourth.gram_panchayat_code)as gram_panchayat_name,village_code, (select village_name from iwmp_village where st_code=third.st_code and dist_code=third.dist_code and block_code=fourth.block_code and gram_panchayat_code = fourth.gram_panchayat_code and village_code= fourth.village_code)as village_name from(select project_cd,block_code,gram_panchayat_code,village_code from iwmp_proj_loc_dtl ) as fourth ,(select st_code,dist_code ,project_cd,proj_name  from(select project_cd,proj_name,state_cd,district_cd from  iwmp_m_project) as second ,(select distinct st_code,dist_code from iwmp_user_map where reg_id in (select reg_id from  iwmp_user_reg where user_id='"+uname+"'))as first where second.state_cd=first.st_code and second.district_cd=first.dist_code) as third where third.project_cd = fourth.project_cd ORDER BY proj_name";
					Statement s = con.createStatement();
					ResultSet r = s.executeQuery(qry);
					String projectn  = "";
					String state = "";
					int sc= 0;
					String district = "";
					int dc=0;
					String block= "";
					
					Set<String> setp=new TreeSet<String>();
					Set<String> setpc = new TreeSet<String>();
					Set <String> setb= new TreeSet<String> ();
					Set<String> setbc=new TreeSet<String>();
					Set <String> setg= new TreeSet<String> ();
					Set<String> setgc=new TreeSet<String>();
					Set <String> setv= new TreeSet<String> ();
					Set<String> setvc=new TreeSet<String>();
					while (r.next())
					{
							
						String p= r.getString("proj_name");
						setp.add(p);
						String pc=r.getString("project_cd");
						setpc.add(pc);
					    state = r.getString("state_name");
					    sc=r.getInt("st_code");
					    district = r.getString("dist_name");
					    dc= r.getInt("dist_code");
					    String b = r.getString("block_name");
					    setb.add(b);
					    String bc = r.getString("block_code");
					    setbc.add(bc);					     
				   	 
					    
					}
					Iterator itpc= setpc.iterator();
					Iterator itbc= setbc.iterator();
					Iterator it3= setp.iterator();
					Iterator  it = setb.iterator();
				
					
					while(it3.hasNext() && itpc.hasNext())
					{
						projectn +=(String)it3.next();
						projectn += "->";
						projectn += (String)itpc.next();
						projectn += ":" ;
					}
					while (it.hasNext() && itbc.hasNext())
					{
						block += (String)it.next();
						block += "->";
						block += (String)itbc.next();
						block += ":";
					}
					out.print( projectn + ";");
					out.print( state + "->"+sc +";");
					out.print( district +"->"+dc+ ";");
					out.print( block + ";");
				
				String query="select head_code,head_desc from iwmp_m_heads WHERE plan_type='P'";
				Statement s1 = con.createStatement();
				ResultSet r1 = s1.executeQuery(query);
				String hcode  = ""; 
				String description= "";
				while (r1.next())
				{
					hcode +=r1.getString("head_desc");
					hcode += "->" ;
					hcode +=r1.getString("head_code");
					hcode += ":";			
				}
				 out.print( hcode + "; ");
					out.print(id +"; ");
	
		}

				else
					out.print("no");
					
	}


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
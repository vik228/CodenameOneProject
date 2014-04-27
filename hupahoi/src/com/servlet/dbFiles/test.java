package com.servlet.dbFiles;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		List<FileItem> items = null;
		File repository = new File ("/root/Desktop");
		DiskFileItemFactory factory = new DiskFileItemFactory(1024, repository);
		ServletContext servletContext = this.getServletConfig().getServletContext();
		//File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		System.out.println (repository);
		((DiskFileItemFactory) factory).setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try 
		{
			items = upload.parseRequest(req);
		} 
		catch (FileUploadException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> iter = items.iterator();
		FileItem fi = null;
		String name = null;
		String fName = null;
		while (iter.hasNext()) 
		{
		   FileItem item = iter.next();
		   if (item.isFormField())
		   {
			   name = item.getString();
			   //System.out.print(name);
		   }
		   else
		   {
			   fi = item;
			   fName = item.getName();
			   //System.out.print(fName);
		   }
		}
		File f1 = new File ("/root/Desktop/new/" +name+ "_" + fName);
		try 
		{
			fi.write(f1);
		} 
		catch (Exception e) 
		{
			  e.printStackTrace();
		}


	}

}
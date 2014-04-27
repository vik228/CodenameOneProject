package userclasses;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;

import generated.StateMachineBase;
import com.codename1.ui.*; 
import com.codename1.ui.events.*;
import com.codename1.ui.list.DefaultListModel;
import com.pass.encrypt.MD5Encrypt;
public class StateMachine extends StateMachineBase 
{
	String uname = "empty";
	String pass = "empty";
	String res;
	String st_name;
	String selItm1;
	String selItm2;
	String selItm3;
	SortedMap<String, String> mp_project;
	SortedMap<String, String> mp_block;
	SortedMap<String, String> mp_village;
	SortedMap<String, String> mp_gp;
	SortedMap<String, String> mp_head;
	SortedMap<String, String> mp_activity;
	String st_code, d_code;
	String allocation,expend,imgName;
	String lati="";
	String dir="";
	String longi="";
	String logdegree="";
	String logmin="";
	String logsec="";
	String latdegree="";
	String latmin="";
	String latsec="";
	String date1;
	String Uid;
	String img;
	ArrayList<String> al1, al2;
	Form f,f1;
	public StateMachine(String resFile) 
	{
		super(resFile);
	}
	 protected void initVars() {}
	 private ArrayList<String> cal(String z)
	 {
		 ArrayList<String> ret_val = new ArrayList<String>();
	     int idx4 = 0;
		 int idx5 = 0;
		 idx4 = z.indexOf(':', idx5);
		 while (idx4 > -1 && idx4 < z.length())
		 {
			ret_val.add(z.substring(idx5, idx4));
			idx5 = idx4+1;
			idx4 = z.indexOf(':', idx5);
		 }
		 return ret_val;
	  
	 }
	 private SortedMap <String, String> fillMap (ArrayList<String> a1)
	 {
		 SortedMap <String, String> temp = new TreeMap<String, String>();
		 for (int i = 0; i < a1.size(); i++)
		 {
			 String block = a1.get(i);
	 		 int id3 = block.indexOf("->", 0);
	 		 String s1 = block.substring(id3+2, block.length());
	 		 String s2 = block.substring(0, id3);
	 		 temp.put(s2, s1);
		 }
		 return temp;
	 }
	 protected void onMain_ButtonAction(Component c, ActionEvent event) 
	 {
		 	res = "empty";
	    	super.onMain_ButtonAction(c, event);
	    	callServlet cs = new callServlet ();
	    	ArrayList<String> al = new ArrayList<String>();
	    	al.add(uname);
	    	al.add(pass);
	    	InfiniteProgress inf = new InfiniteProgress();            
	        Dialog progress = inf.showInifiniteBlocking(); 
	    	cs.call(al, 0, progress);
	    	Display.getInstance().invokeAndBlock(cs);
	    	progress.dispose();
	    	res = cs.getResponse();
	    	//System.out.println (res);
	    	if (!res.equals("no"))
	    	{
	    		System.out.println("aa rha h");
	    		//Dialog.show("hii", res, "ok", null);
	    		ArrayList <String> val = new ArrayList<String>();
	        	int j = 0;
	        	int idx = 0;
	        	int idx1 = 0;
	        	try
	        	{
	        		idx = res.indexOf(';', idx1);
	        		while (idx > -1)
	        		{
	        			val.add(res.substring(idx1, idx));
	        			idx1 = idx + 1;
	        			idx = res.indexOf(';', idx1);
	        		}
	        		f = showForm ("welcome", null);
	        		super.findLabel3(f).setText(val.get(0));
	        		String state = val.get(2);
	        		int id = state.indexOf("->", 0);
	        		st_code = state.substring(id+2, state.length());
	        		super.findLabel2(f).setText(state.substring(0, id));
	        		String district = val.get(3);
	        		int id1 = district.indexOf("->", 0);
	        		Uid =val.get(6);
	        		d_code = district.substring(id1+2, district.length());
	        		super.findLabel15(f).setText(district.substring(0, id1));
	        		ArrayList<String> store = new ArrayList<String>();
	        		store = cal (val.get(1));
	        		mp_project = new TreeMap<String, String>();
	        		mp_project = fillMap (store);
	        		for (Map.Entry <String, String> entry : mp_project.entrySet())
	        		{
	        			super.findComboBox3(f).addItem(entry.getKey());
	        		}
	        		store.clear();
	        		store = cal (val.get(4));
	        		mp_block = new TreeMap <String, String>();
	        		mp_block = fillMap (store);
	        		for (Map.Entry <String, String> entry : mp_block.entrySet())
	        		{
	        			super.findComboBox(f).addItem(entry.getKey());
	        		}

	        	    store.clear();
	        	    store=cal(val.get(5));
	        	    mp_head = new TreeMap <String, String>();
	        		mp_head = fillMap (store);
	        		for (Map.Entry <String, String> entry : mp_head.entrySet())
	        		{
	        			super.findComboBox4(f).addItem(entry.getKey());
	        		}
	        	    store.clear();
	        	    
	        }
	        catch (StringIndexOutOfBoundsException ex)
	        {
	        		     System.out.println ("Exception caught " + idx1 + ' ' + idx + ' ' + j);
	        }
	    }
	    else
	    {
	    	Dialog.show("hii", "username/password does not match", "Refill Please", null);	
	    }
	    	
	    	
	 }
	 protected void onMain_TextFieldAction(Component c, ActionEvent event) 
	 {
		 super.onMain_TextFieldAction(c, event);
	     uname = findTextField().getText();
	    
	 }
	 protected void onMain_TextField1Action(Component c, ActionEvent event) 
	 {
		 super.onMain_TextField1Action(c, event);
	     pass = findTextField1().getText();
	     @SuppressWarnings("unused")
		String md5_pass = MD5Encrypt.encrypt(pass);   
	 }

    protected void onWelcome_ComboBoxAction(Component c, ActionEvent event) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onWelcome_ComboBoxAction(c, event);
        selItm1 = (String) findComboBox(f).getSelectedItem();
        if (!selItm1.equals("select"))
        {
        	ArrayList <String> a = new ArrayList<String>();
        	a.add(selItm1);
        	InfiniteProgress inf = new InfiniteProgress();            
        	Dialog progress = inf.showInifiniteBlocking();
        	callServlet cs = new callServlet();
        	cs.call(a, 1, progress);
        	Display.getInstance().invokeAndBlock(cs);
        	progress.dispose();
        	String ret_str = cs.getResponse();
        	findComboBox1(f).setModel(new DefaultListModel(new String[]{"select"}));
        	ArrayList <String> a1 = new ArrayList<String>();
        	a1 = cal (ret_str);
    		//store = cal (val.get(4));
    		mp_gp = new TreeMap <String, String>();
    		mp_gp = fillMap (a1);
    		for (Map.Entry <String, String> entry : mp_gp.entrySet())
    		{
    			super.findComboBox1(f).addItem(entry.getKey());
    			//System.out.println (entry.getKey() + "->" + entry.getValue());
    		}

        }
        //f.repaint();
        
        
    
    }

    protected boolean initListModelComboBox(List cmp) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.initListModelComboBox(cmp);
        cmp.setModel(new DefaultListModel(new String[] {"select"}));
        return true;
    }

    protected void onWelcome_ComboBox1Action(Component c, ActionEvent event) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onWelcome_ComboBox1Action(c, event);
        selItm2 = (String) findComboBox1(f).getSelectedItem();
        if (!selItm2.equals("select"))
        {
        	ArrayList <String> a = new ArrayList<String>();
        	a.add(selItm2);
        	InfiniteProgress inf = new InfiniteProgress();            
        	Dialog progress = inf.showInifiniteBlocking(); 
        	callServlet cs = new callServlet();
        	cs.call(a, 2, progress);
        	Display.getInstance().invokeAndBlock(cs);
        	progress.dispose();
        	String ret_str =  cs.getResponse();
        	findComboBox2(f).setModel(new DefaultListModel(new String[]{"select"}));
        	ArrayList <String> a1 = new ArrayList<String>();
        	a1 = cal (ret_str);
        	mp_village = new TreeMap <String, String>();
        	mp_village = fillMap (a1);
    		for (Map.Entry <String, String> entry : mp_village.entrySet())
    		{
    			super.findComboBox2(f).addItem(entry.getKey());
    			//System.out.println (entry.getKey() + "->" + entry.getValue());
    		}
        }	
    
    }

    protected boolean initListModelComboBox1(List cmp) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.initListModelComboBox1(cmp);
        cmp.setModel(new DefaultListModel(new String[] {"Select"}));
        return true;
    }

    protected void onWelcome_ComboBox4Action(Component c, ActionEvent event) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onWelcome_ComboBox4Action(c, event);
        selItm3 = (String)findComboBox4(f).getSelectedItem();
        System.out.println (selItm3);
        if (!selItm3.equals("select"))
        {
        	ArrayList <String> a = new ArrayList<String>();
        	a.add(selItm3);
        	InfiniteProgress inf = new InfiniteProgress();            
        	Dialog progress = inf.showInifiniteBlocking(); 
        	callServlet cs = new callServlet();
        	cs.call(a, 3, progress);
        	Display.getInstance().invokeAndBlock(cs);
        	progress.dispose();
        	String ret_str = cs.getResponse();
        	findComboBox5(f).setModel(new DefaultListModel(new String[]{"select"}));
        	//System.out.println (ret_str);
        	al1 = cal (ret_str);
        	mp_activity = new TreeMap <String, String>();
        	mp_activity = fillMap (al1);
    		for (Map.Entry <String, String> entry : mp_activity.entrySet())
    		{
    			super.findComboBox5(f).addItem(entry.getKey());
    			System.out.println (entry.getKey() + "->" + entry.getValue());
    		}
    	}
    
    }

    protected boolean initListModelComboBox4(List cmp) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.initListModelComboBox4(cmp);
        cmp.setModel(new DefaultListModel(new String[] {"select"}));
        return true;
    }

    protected void onWelcome_TextField8Action(Component c, ActionEvent event) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onWelcome_TextField8Action(c, event);
        allocation = findTextField8(f).getText();
    }

    protected void onWelcome_TextField9Action(Component c, ActionEvent event) 
    {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onWelcome_TextField9Action(c, event);
        expend = findTextField9(f).getText();
    }



    protected void onWelcome_SaveAction(Component c, ActionEvent event) 
    {
        super.onWelcome_SaveAction(c, event);
        String select_vill =(String) findComboBox2(f).getSelectedItem();
        String select_project =(String) findComboBox3(f).getSelectedItem();
        String select_act=(String) findComboBox5(f).getSelectedItem();
        ArrayList<String> save_item = new ArrayList<String>();
        save_item.add(uname);
        save_item.add(st_code);
        save_item.add(d_code);
        save_item.add(mp_block.get(selItm1));
        save_item.add(mp_gp.get(selItm2));
        save_item.add(mp_village.get(select_vill));
        save_item.add(mp_project.get(select_project));
        save_item.add(mp_head.get(selItm3));
        save_item.add(mp_activity.get(select_act));
        save_item.add(allocation);
        save_item.add(expend);
        save_item.add(Uid);
        InfiniteProgress inf = new InfiniteProgress();            
    	Dialog progress = inf.showInifiniteBlocking(); 
    	callServlet cs = new callServlet();
    	cs.call(save_item, 4, progress);
    	Display.getInstance().invokeAndBlock(cs);
    	progress.dispose();
    	String ret_str =  cs.getResponse();
    	if (ret_str.equals("saved"))
    	{
    		Dialog.show("hii", "The info has been inserted successfully", "okk", null);
    		f1 = super.showForm("Capture",null);
    	}
    	
       
        
    }

    protected boolean initListModelComboBox3(List cmp) 
    {
        super.initListModelComboBox3(cmp);
        cmp.setModel(new DefaultListModel(new String[] {"select"}));
        return true;

    }

 

    protected void onCapture_CaptureImageAction(Component c, ActionEvent event) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onCapture_CaptureImageAction(c, event);
        GpsConnection gs = new GpsConnection();
        ArrayList <String> ret_val = gs.getLocation();
    	//String img = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
       		super.findLongitude().setText(ret_val.get(4));
       		super.findDlongi().setText(ret_val.get(1));
       		super.findMlongi().setText(ret_val.get(2));
       		super.findSlongi().setText(ret_val.get(3));
       		super.findLatitude().setText(ret_val.get(0));
       		super.findDlati().setText(ret_val.get(5));
       		super.findMlati().setText(ret_val.get(6));
       		super.findSlati().setText(ret_val.get(7));
       		
       		
       		
       		lati=ret_val.get(0);
       		longi=ret_val.get(1);
       	  //  dir=ret_val.get(2);
       		logdegree=ret_val.get(2);
       		logmin=ret_val.get(3);
       		logsec=ret_val.get(4);
       		latdegree=ret_val.get(5);
       		latmin=ret_val.get(6);
       		latsec=ret_val.get(7);
       		//System.out.println(lati+ ""+ longi+ ""+logdegree+""+logmin+""+logsec+""+latdegree+""+latmin+""+latsec+""+dir);
    	img = Capture.capturePhoto(200, 200);
        try
        {
        	if (img != null)
        	{
        		Image i = Image.createImage(img);
        		super.findLabel().setIcon(i); 
        		c.getComponentForm().revalidate();
        		System.out.println(i);
        	
        	}
        	else
        	{
        		super.findLabel().setText("The App is not working...");
        	}
        		
        }   
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
    
    }
    
    


    protected void onCapture_TextFieldAction(Component c, ActionEvent event) {
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onCapture_TextFieldAction(c, event);
        imgName = findTextField(f1).getText();
       
    }
    protected void onCapture_ExitAction(Component c, ActionEvent event){
        // If the resource file changes the names of components this call will break notifying you that you should fix the code
        super.onCapture_ExitAction(c, event);
        //System.exit(0);
        ArrayList<String> img_details = new ArrayList<String>();
        img_details.add(Uid);
        img_details.add(uname);
        img_details.add(imgName);
        img_details.add(latdegree);
        img_details.add(latmin);
        img_details.add(latsec);
        img_details.add(logdegree);
        img_details.add(logmin);
        img_details.add(logsec);
        InfiniteProgress inf = new InfiniteProgress();            
    	Dialog progress = inf.showInifiniteBlocking(); 
    	callServlet cs = new callServlet();
    	cs.call(img_details, 5, progress);
    	Display.getInstance().invokeAndBlock(cs);
    	progress.dispose();
    	String ret_str =  cs.getResponse();
    	InfiniteProgress inf1 = new InfiniteProgress();            
		Dialog progress1 = inf1.showInifiniteBlocking(); 
		MultipartRequest request = new MultipartRequest();

		request.setUrl("http://localhost:8080/hupahoi/test");
		try {
			request.addData(imgName + ".jpg", img, "image/jpeg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.addArgument("name", uname);
		request.setDisposeOnCompletion(progress);
		NetworkManager.getInstance().addToQueue(request);
    	if (ret_str.equals("saved"))
    	{
    		Dialog.show("hii", "The image has been inserted successfully", "okk", null);
    		Dialog.show("Thankyou", "have a nice day!!!", "okk", null);
    		
    		 System.exit(0);
    	}

        
    }
}

package userclasses;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;

public class DataStore implements Externalizable  {
	private String x;
	public String getx(){
		return x;
	}
	public void setx(String x){
		this.x=x;
	}
	public int getversion(){
		return 1;
	}
	public void externalize(DataOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		Util.writeUTF(x, out);
		
	}
	public String getObjectId() {
		// TODO Auto-generated method stub
		return "DataStore";
		
	}
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void internalize(int version, DataInputStream in) throws IOException {
		// TODO A		uto-generated method stub
		Util.readUTF(in);
	}

}

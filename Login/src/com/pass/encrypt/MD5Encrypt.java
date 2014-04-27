package com.pass.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt { 
	public static String encrypt(String s)
{
    String sb = null;
    try
    { 
            MessageDigest md = MessageDigest.getInstance("MD5");
// use toh tell the algo to b used 4 msgdigesting                
            md.update(s.getBytes(),0,s.length());
            sb = new BigInteger(1, md.digest()).toString(16);
            //bigInteger is a class to hold maximum size of valus
                  // here 1 tells sign of the line is positive md.digest returns Byte array
// tostring is 4 converting byte to string in hexa               
    }
    catch (NoSuchAlgorithmException e)
    {
            e.printStackTrace();
    }
    return sb;
}


}

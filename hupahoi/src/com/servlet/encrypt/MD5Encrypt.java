package com.servlet.encrypt;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Encrypt
{
        public static String encrypt(String s)
        {
                String sb = null;
                try
                { 
                        MessageDigest md = MessageDigest.getInstance("MD5");               
                        md.update(s.getBytes(),0,s.length());
                        sb = new BigInteger(1, md.digest()).toString(16);              
                }
                catch (NoSuchAlgorithmException e)
                {
                        e.printStackTrace();
                }
                return sb;
        }
 
}
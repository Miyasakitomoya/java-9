package java9��;


import java.net.InetAddress; 
import java.net.UnknownHostException; 
  
public class Test01 { 
 public static void main(String[] args) throws UnknownHostException { 
 InetAddress addr=null; 
 String ip=""; 
 String address="";
 try{ 
  addr = InetAddress.getLocalHost(); 
  ip = addr.getHostAddress().toString(); //��û���IP���� 
  address = addr.getHostName().toString(); //��û�������
  System.out.println(ip + "|" + address); 
 }catch(Exception e){ 
  e.printStackTrace(); 
 } 
} 
}
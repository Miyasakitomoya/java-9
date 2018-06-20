package java9级;


import java.net.InetAddress; 
import java.net.UnknownHostException; 
  
public class Test01 { 
 public static void main(String[] args) throws UnknownHostException { 
 InetAddress addr=null; 
 String ip=""; 
 String address="";
 try{ 
  addr = InetAddress.getLocalHost(); 
  ip = addr.getHostAddress().toString(); //获得机器IP　　 
  address = addr.getHostName().toString(); //获得机器名称
  System.out.println(ip + "|" + address); 
 }catch(Exception e){ 
  e.printStackTrace(); 
 } 
} 
}
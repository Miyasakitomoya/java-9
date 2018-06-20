package java9��;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * ����ip�õ�������
 */

public class J289 {
	public String translate_ip(String ip) {
		String host=null;
		try {   
            String[] ip_split = ip.split("[.]");
            byte[] by=new byte[4];
            for(int i=0;i<by.length;i++) {
            	by[i]=(byte)(Integer.parseInt(ip_split[i])&0xff);
            }
            InetAddress inetAddr=InetAddress.getByAddress(by); //����InetAddress����  
            host=inetAddr.getHostName();  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }
		return host; 
	}
	public static void main(String[] args) {
		J289 x=new J289();
		String b=x.translate_ip("172.18.34.38");
		System.out.println(b);
	}
}
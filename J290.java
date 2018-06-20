package java9¼¶;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class J290{
	public void analyze(){
		 
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("ipdata.properties");   
		 
		          Properties p = new Properties();   
		          try {   
		           p.load(inputStream);   
		          } catch (IOException e1) {   
		           e1.printStackTrace();   
		          }   
		        System.out.println("ip:"+p.getProperty("ip")+",port:"+p.getProperty("port")); 
		 
		}
}
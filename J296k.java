package java9级;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
 
public class J296k {
 public static void main(String[] args) throws IOException {
 
  System.out.println("接收端启动......");
 
  // 建立UDP的Socket服务
  DatagramSocket ds = new DatagramSocket(8888);
  byte[] buf = new byte[1024];
  DatagramPacket dp = new DatagramPacket(buf, buf.length);
  while(true) {
   // 创建数据包
  
 
   // 使用接收方法将数据存储到数据包中
   ds.receive(dp); // 该方法为阻塞式的方法
 
   // 通过数据包对象的方法解析这些数据，例如：地址、端口、数据内容等
   String ip = dp.getAddress().getHostAddress();
 
   int port = dp.getPort();
   String text = new String(dp.getData(), 0, dp.getLength());
   System.out.println(ip + ":" + port + ":" + text);
  }
 }
}

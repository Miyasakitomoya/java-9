package java9级;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
public class J287f {
 public static void main(String[] args) throws IOException {
 
  System.out.println("发送端启动......");
 
  // 创建UDP的Socket，使用DatagramSocket对象
  DatagramSocket ds = new DatagramSocket();
 
  BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
  String line = null;
  while ((line = bufr.readLine()) != null) {
   // 使用DatagramPacket将数据封装到该对象的包中
   byte[] buf = line.getBytes();
   DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.18.34.38"), 8888);
   // 通过UDP的Socket服务将数据包发送出去，使用send方法
   ds.send(dp);
   // 如果输入信息为over，则结束循环
   if ("over".equals(line))
    break;
  }
  // 关闭Socket服务
  ds.close();
 }
}
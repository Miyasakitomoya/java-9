package java9��;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
 
public class J296k {
 public static void main(String[] args) throws IOException {
 
  System.out.println("���ն�����......");
 
  // ����UDP��Socket����
  DatagramSocket ds = new DatagramSocket(8888);
  byte[] buf = new byte[1024];
  DatagramPacket dp = new DatagramPacket(buf, buf.length);
  while(true) {
   // �������ݰ�
  
 
   // ʹ�ý��շ��������ݴ洢�����ݰ���
   ds.receive(dp); // �÷���Ϊ����ʽ�ķ���
 
   // ͨ�����ݰ�����ķ���������Щ���ݣ����磺��ַ���˿ڡ��������ݵ�
   String ip = dp.getAddress().getHostAddress();
 
   int port = dp.getPort();
   String text = new String(dp.getData(), 0, dp.getLength());
   System.out.println(ip + ":" + port + ":" + text);
  }
 }
}

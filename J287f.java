package java9��;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
public class J287f {
 public static void main(String[] args) throws IOException {
 
  System.out.println("���Ͷ�����......");
 
  // ����UDP��Socket��ʹ��DatagramSocket����
  DatagramSocket ds = new DatagramSocket();
 
  BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
  String line = null;
  while ((line = bufr.readLine()) != null) {
   // ʹ��DatagramPacket�����ݷ�װ���ö���İ���
   byte[] buf = line.getBytes();
   DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("172.18.34.38"), 8888);
   // ͨ��UDP��Socket�������ݰ����ͳ�ȥ��ʹ��send����
   ds.send(dp);
   // ���������ϢΪover�������ѭ��
   if ("over".equals(line))
    break;
  }
  // �ر�Socket����
  ds.close();
 }
}
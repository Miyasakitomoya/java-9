package java9级;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class J306k {
Socket socket=null;
//以线程方式启动客户端
public J306k() throws Exception{
socket =new Socket("127.0.0.1",8888);
new Thread(new ReceiveThread()).start();
}
//send方法
public void send(String str) throws IOException{
DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
dos.writeUTF(str);
}
//关闭连接
public void disconnection() throws IOException{
if(socket!=null){
socket.close();
}
}
//内部类（多线程方式）
class ReceiveThread implements Runnable{


@Override
public void run() {
// TODO Auto-generated method stub
if(socket==null){
return ;
}
try {
DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
String str=dataInputStream.readUTF();
while(str!=null&&str.length()!=0){
System.out.println("别人说："+str);
str=dataInputStream.readUTF();
}
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

}
public static void main(String[] args) throws Exception {
BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
J306k chatClient=new J306k();

System.out.println("请输入：");
String str=bReader.readLine();
while(str!=null&&str.length()!=0){
chatClient.send(str);
System.out.println("请输入：");
str=bReader.readLine();
System.out.println("自己说："+str);
}
chatClient.disconnection();

}
}
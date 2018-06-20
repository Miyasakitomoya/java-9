package java9级;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class J306f {
private ServerSocket serverSocket=null;
//存客户端
private ArrayList<Clientconn> list=new ArrayList<Clientconn>();
//聊天室的服务端
public J306f(int port) throws IOException{
serverSocket=new ServerSocket(port);
}
//启动聊天服务器
public void startServer() throws Exception{
System.out.println("服务器启动");
while(true){
Socket socket=serverSocket.accept();
list.add(new Clientconn(socket));
System.out.println("一个新客户端上线"+socket.getInetAddress());
System.out.println("当前客户端人数"+list.size());
}
}
//内部类,管理客户端的连接，以多线程方式
class Clientconn implements Runnable{
Socket s=null;
public Clientconn(Socket s) {
this.s=s;
new Thread(this).start();
}
//发送消息的方法
public void send(String str) throws IOException{
DataOutputStream dos=new DataOutputStream(s.getOutputStream());
dos.writeUTF(str);
}
//关闭客户端连接的方法
public void dispose() throws IOException{
if(s!=null){
s.close();
}
list.remove(this);
System.out.println("一个客户端退出");
System.out.println("当前在线人数："+list.size());
}
@Override
public void run() {
//发送消息
try {
DataInputStream dis=new DataInputStream(s.getInputStream());
//先读消息进来
String str=dis.readUTF();
while(str!=null&&str.length()!=0){
System.out.println("客户端说："+str);
for(Clientconn cc:list){
if(this!=cc){
cc.send(str);
}
}
str = dis.readUTF();
}
this.dispose();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

}

public static void main(String[] args) throws Exception {
J306f chatservlet=new J306f(8888);
chatservlet.startServer();

}
}
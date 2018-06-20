package java9��;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class J306f {
private ServerSocket serverSocket=null;
//��ͻ���
private ArrayList<Clientconn> list=new ArrayList<Clientconn>();
//�����ҵķ����
public J306f(int port) throws IOException{
serverSocket=new ServerSocket(port);
}
//�������������
public void startServer() throws Exception{
System.out.println("����������");
while(true){
Socket socket=serverSocket.accept();
list.add(new Clientconn(socket));
System.out.println("һ���¿ͻ�������"+socket.getInetAddress());
System.out.println("��ǰ�ͻ�������"+list.size());
}
}
//�ڲ���,����ͻ��˵����ӣ��Զ��̷߳�ʽ
class Clientconn implements Runnable{
Socket s=null;
public Clientconn(Socket s) {
this.s=s;
new Thread(this).start();
}
//������Ϣ�ķ���
public void send(String str) throws IOException{
DataOutputStream dos=new DataOutputStream(s.getOutputStream());
dos.writeUTF(str);
}
//�رտͻ������ӵķ���
public void dispose() throws IOException{
if(s!=null){
s.close();
}
list.remove(this);
System.out.println("һ���ͻ����˳�");
System.out.println("��ǰ����������"+list.size());
}
@Override
public void run() {
//������Ϣ
try {
DataInputStream dis=new DataInputStream(s.getInputStream());
//�ȶ���Ϣ����
String str=dis.readUTF();
while(str!=null&&str.length()!=0){
System.out.println("�ͻ���˵��"+str);
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
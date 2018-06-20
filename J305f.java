package java9��;

import java.io.IOException;  
import java.io.OutputStream;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.ArrayList;  
  
public class J305f {  
    // ��ŷ���˽��յ��Ŀͻ����ࣨ���Խ��в������Ķ���  
    public ArrayList<ClientServer> clientServer;  
  
    public J305f() {  
        // TODO Auto-generated constructor stub  
        // ��ʼ������  
        clientServer = new ArrayList<ClientServer>();  
    }  
  
    public void initServer() {  
        try {  
            // ���������Ķ˿ں�  
            ServerSocket s = new ServerSocket(8888);  
            System.out.println("����������.....");  
            System.out.println("�ȴ��ͻ�������.......");  
            // ��server��������״̬���ȴ��ͻ����Ľ��룩���пͻ��������ϴ˶˿ڵ�server�ͻ��˾ͻ᷵��һ��socket���󣬷��������н���  
            // ���ϵ�ȥ���ܿͻ��˷��������󣬲������ܵ���socket�ŵ�������  
            while (true) {  
                Socket ss = s.accept();  
                clientServer.add(new ClientServer(ss));  
            }  
  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) {  
        J305f server = new J305f();  
        server.initServer();  
  
    }  
  
    /** 
     * �����࣬������socket�����з���˶Կͻ��˵Ĳ��� 
     *  
     * @author M_WBCG 
     *  
     */  
    class ClientServer {  
        Socket ss;  
  
        public ClientServer(Socket ss) {  
            // TODO Auto-generated constructor stub  
            this.ss = ss;  
            // socket�������������Ϊ�ֽ�����  
            OutputStream out;  
            try {  
                out = ss.getOutputStream();  
                String msg = "������˵���\n";  
                out.write(msg.getBytes());  
                // ������socket�ص������ص��ͻ�����δ���ܵ���Ϣ��ʱ���Ͽ�����  
                out.close();  
                ss.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}  

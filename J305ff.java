package java9��;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
public class J305ff {  
    public static void main(String[] args) {  
        Socket s;  
        try {  
            // �ͻ������ӷ���˵�IP��ַ�Ͷ˿ں�  
            s = new Socket("127.0.0.1", 8888);  
            System.out.println("���ӵ�������.....");  
            // ������������ֽ��������ٰ��ֽ��������ŵ�������������  
            InputStream in = s.getInputStream();  
            BufferedReader br = new BufferedReader(new InputStreamReader(in));  
            String msg = "";  
            msg = br.readLine();  
            System.out.println(msg);  
            //�رյ���  
            br.close();  
            in.close();  
            s.close();  
        } catch (UnknownHostException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
    }  
}  
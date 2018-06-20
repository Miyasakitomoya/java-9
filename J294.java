package java9��;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class J294 {
	 public static void main(String[] args){
	        try {
	            //����һ��URLʵ��
	            URL url = new URL("https://blog.csdn.net/csdndouniwan/article/details/52954661");

	            try {
	                //ͨ��URL��openStrean������ȡURL��������ʾ����Ը�ֽ�������
	                InputStream is = url.openStream();
	                InputStreamReader isr = new InputStreamReader(is,"utf-8");

	                //Ϊ�ַ���������ӻ���
	                BufferedReader br = new BufferedReader(isr);
	                String data = br.readLine();//��ȡ����

	                while (data!=null){//ѭ����ȡ����
	                    System.out.println(data);//�������
	                    data = br.readLine();
	                }
	                br.close();
	                isr.close();
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	    }
	}

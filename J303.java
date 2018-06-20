package java9��;

import java.io.File;  
import java.lang.reflect.Constructor;  
public class J303 {  
    public static void main(String[] args){  
        try {  
            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);  
            //���File���Constructor����  
            System.out.println("Create File Object with reflection.");  
  
            File file = constructor.newInstance("D:\\myfile.txt");  
            //ʹ�÷��䴴��File����ָ���˴�����·��Ϊ���棬����Ϊ��MyFile.txt��  
            System.out.println("Use File Object to create MyFile.txt on desktop.");  
            file.createNewFile();//�����µ��ļ�  
            System.out.println("File is create?"+file.exists());  
            //��֤�ļ��Ƿ񴴽��ɹ�  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
} 
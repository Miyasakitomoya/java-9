package java9��;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;  
  
public class J302 {  
  
    public static void main(String[] args) {  
  
        // java ʵ����1��ͨ��new����  
        System.out.println("++++++++++ͨ��Class New������ʽʵ����+++++++++++++");  
        User user1 = new User("Kong zi", "13800010001", "Greatwalk");  
        System.out.println(user1.toString());  
        System.out.println();  
          
        // java ʵ����2��ͨ��clone��ʽ  
        System.out.println("++++++++++ͨ�� clone������ʽʵ����+++++++++++++");  
        try {  
            User user2 = (User) user1.clone();  
            user2.setName("zhuang zi");  
            System.out.println(user2.toString());  
            System.out.println();  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
  
       
        //ͨ�����л����ж�������л��ͷ����л�  
        System.out.println("++++++++++ͨ�����л��ͷ����л����� ʵ����+++++++++++++");  
        try{  
              
            ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("E:/objectUser.txt"));   
             //���л�����   
             out.writeObject(user1);   //"Kong zi", "13800010001", "Greatwalk"  
             out.close();  
               
             //�����л�����   
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/objectUser.txt"));   
             User user4 = (User) in.readObject();   
             System.out.println("�����л�user��" + user4);   
             in.close();   
              
        }  
        catch(ClassNotFoundException e ){  
            e.printStackTrace();  
        }  
        catch(FileNotFoundException e ){  
            e.printStackTrace();  
        }  
        catch(IOException e ){  
            e.printStackTrace();  
        }  
    }  
  
}  
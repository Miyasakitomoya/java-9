package java9级;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;  
  
public class J302 {  
  
    public static void main(String[] args) {  
  
        // java 实例化1，通过new方法  
        System.out.println("++++++++++通过Class New（）方式实例化+++++++++++++");  
        User user1 = new User("Kong zi", "13800010001", "Greatwalk");  
        System.out.println(user1.toString());  
        System.out.println();  
          
        // java 实例化2，通过clone方式  
        System.out.println("++++++++++通过 clone（）方式实例化+++++++++++++");  
        try {  
            User user2 = (User) user1.clone();  
            user2.setName("zhuang zi");  
            System.out.println(user2.toString());  
            System.out.println();  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
  
       
        //通过序列化进行对象的序列化和反序列化  
        System.out.println("++++++++++通过序列化和反序列化进行 实例化+++++++++++++");  
        try{  
              
            ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("E:/objectUser.txt"));   
             //序列化对象   
             out.writeObject(user1);   //"Kong zi", "13800010001", "Greatwalk"  
             out.close();  
               
             //反序列化对象   
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/objectUser.txt"));   
             User user4 = (User) in.readObject();   
             System.out.println("反序列化user：" + user4);   
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
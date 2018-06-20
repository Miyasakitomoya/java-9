package java9级;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class J298 {  
    @SuppressWarnings("all")  
    public static void main(String[] args) throws Exception {  
        // 另一个com.sg.myReflection.bean包下的J290类  
        String path = "com.sg.myReflection.bean.J290";  
        try {  
            Class clazz = Class.forName(path);  
  
            // 获取类名  
            String strName01 = clazz.getName();// 获取完整类名com.sg.myReflection.bean.J290  
            String strName02 = clazz.getSimpleName();// 直接获取类名 J290  
  
            // 获取属性  
            Field[] field01 = clazz.getFields(); // 返回属性为public的字段  
            Field[] field02 = clazz.getDeclaredFields(); // 返回所有的属性  
            Field field03 = clazz.getDeclaredField("id"); // 获取属性为id的字段  
  
            // 获取普通方法  
            Method[] Method01 = clazz.getDeclaredMethods(); // 返回public方法  
            Method method = clazz.getDeclaredMethod("getId", null); // 返回getId这个方法，如果没有参数，就默认为null  
  
              
            // 获取构造方法  
            J290 u1 = (J290) clazz.newInstance(); // 获取无参的构造函数这里的前提的保证类中应该有无参的构造函数  
            // 获取参数为(int,String,int)的构造函数  
            Constructor c2 = clazz.getDeclaredConstructor(int.class, String.class, int.class);  
            // 通过有参构造函数创建对象  
            J290 u2 = (J290) c2.newInstance(1001, "小小", 18);  
  
              
            // 通过反射调用普通方法  
            J290 u3 = (J290) clazz.newInstance();  
            Method method03 = clazz.getDeclaredMethod("setId", int.class);  
            method.invoke(u3, 1002); // 把对象u3的id设置为1002  
  
              
              
            // 通过反射操作普通的属性  
            J290 u4 = (J290) clazz.newInstance();  
            Field f = clazz.getDeclaredField("name");  
            f.setAccessible(true); // 设置属性可以直接的进行访问  
            f.set(u4, "石头");  
  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  }
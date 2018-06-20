package java9��;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class J298 {  
    @SuppressWarnings("all")  
    public static void main(String[] args) throws Exception {  
        // ��һ��com.sg.myReflection.bean���µ�J290��  
        String path = "com.sg.myReflection.bean.J290";  
        try {  
            Class clazz = Class.forName(path);  
  
            // ��ȡ����  
            String strName01 = clazz.getName();// ��ȡ��������com.sg.myReflection.bean.J290  
            String strName02 = clazz.getSimpleName();// ֱ�ӻ�ȡ���� J290  
  
            // ��ȡ����  
            Field[] field01 = clazz.getFields(); // ��������Ϊpublic���ֶ�  
            Field[] field02 = clazz.getDeclaredFields(); // �������е�����  
            Field field03 = clazz.getDeclaredField("id"); // ��ȡ����Ϊid���ֶ�  
  
            // ��ȡ��ͨ����  
            Method[] Method01 = clazz.getDeclaredMethods(); // ����public����  
            Method method = clazz.getDeclaredMethod("getId", null); // ����getId������������û�в�������Ĭ��Ϊnull  
  
              
            // ��ȡ���췽��  
            J290 u1 = (J290) clazz.newInstance(); // ��ȡ�޲εĹ��캯�������ǰ��ı�֤����Ӧ�����޲εĹ��캯��  
            // ��ȡ����Ϊ(int,String,int)�Ĺ��캯��  
            Constructor c2 = clazz.getDeclaredConstructor(int.class, String.class, int.class);  
            // ͨ���вι��캯����������  
            J290 u2 = (J290) c2.newInstance(1001, "СС", 18);  
  
              
            // ͨ�����������ͨ����  
            J290 u3 = (J290) clazz.newInstance();  
            Method method03 = clazz.getDeclaredMethod("setId", int.class);  
            method.invoke(u3, 1002); // �Ѷ���u3��id����Ϊ1002  
  
              
              
            // ͨ�����������ͨ������  
            J290 u4 = (J290) clazz.newInstance();  
            Field f = clazz.getDeclaredField("name");  
            f.setAccessible(true); // �������Կ���ֱ�ӵĽ��з���  
            f.set(u4, "ʯͷ");  
  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  }
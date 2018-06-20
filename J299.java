package java9级;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class J299 {
    public static void main(String[] args) {
        printClassFields(new Integer(1));
        printClassConstructs(new String("ss"));
    }
    /**
     * 打印类的成员属性信息
     * @param obj
     */
    public static void printClassFields(Object obj){
        Class c=obj.getClass();
        System.out.println("类的名称："+c.getName());
        System.out.println("类的成员属性：");
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){
            Class fieldClass=field.getType();
            String fieldName=field.getName();
            String fieldType=fieldClass.getSimpleName();
            System.out.println(fieldType+" "+fieldName);
        }
    }
    /**
     * 打印类的构造方法
     * @param obj
     */
    public static void printClassConstructs(Object obj){
        Class c=obj.getClass();
        System.out.println("类的名称："+c.getName());
        System.out.println("类的构造方法：");
        Constructor[] constructors=c.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            Class[] paClass=constructor.getParameterTypes();
            String name=constructor.getName();
            int i=0;
            String params=new String();
            for(Class param : paClass){
                if(i==0){
                    params+=param.getSimpleName();
                }else{
                    params+=","+param.getSimpleName();
                }
                i++;
            }
            System.out.println(name+"("+params+"}");
        }
    }
}
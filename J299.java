package java9��;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class J299 {
    public static void main(String[] args) {
        printClassFields(new Integer(1));
        printClassConstructs(new String("ss"));
    }
    /**
     * ��ӡ��ĳ�Ա������Ϣ
     * @param obj
     */
    public static void printClassFields(Object obj){
        Class c=obj.getClass();
        System.out.println("������ƣ�"+c.getName());
        System.out.println("��ĳ�Ա���ԣ�");
        Field[] fields=c.getDeclaredFields();
        for(Field field:fields){
            Class fieldClass=field.getType();
            String fieldName=field.getName();
            String fieldType=fieldClass.getSimpleName();
            System.out.println(fieldType+" "+fieldName);
        }
    }
    /**
     * ��ӡ��Ĺ��췽��
     * @param obj
     */
    public static void printClassConstructs(Object obj){
        Class c=obj.getClass();
        System.out.println("������ƣ�"+c.getName());
        System.out.println("��Ĺ��췽����");
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
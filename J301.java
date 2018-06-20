package java9��;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.Properties;  

public class J301 {  
    //����һ������أ�ǰ���Ƕ�������������ʵ�ʶ���  
    private Map<String, Object> objectPool = new HashMap<> ();  
    //����һ����������ķ���  
    //�÷���ֻҪ����һ���ַ���������������Ը��ݸ���������Java����  
    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {  
        Class<?> clazz = Class.forName(clazzName);  
        return clazz.newInstance();  
    }  
    //�÷���ͨ���ļ�����ʼ�������  
    //������������ļ���������  
    public void initPool(String fileName) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {  
        FileInputStream fis = null;  
        try {  
            fis = new FileInputStream(fileName);  
            Properties props = new Properties();  
            props.load(fis);  
            for (String name : props.stringPropertyNames()) {  
                //ÿȡ��һ����ֵ�ԣ��͸�������ֵ��������  
                //ÿ����createObject�������󣬲���������ӵ��������  
                objectPool.put(name, createObject(props.getProperty(name)));  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } finally {  
            if (fis != null) {  
                fis.close();  
            }  
        }  
    }  
    public Object getObject(String name) {  
        return objectPool.get(name);  
    }  
  
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {  
        J301 opf = new J301();  
        opf.initPool("obj.txt");  
        System.out.println(opf.getObject("a"));  
        System.out.println(opf.getObject("b"));  
    }  
}  
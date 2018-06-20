package java9级;

import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.Properties;  

public class J301 {  
    //定义一个对象池，前面是对象名，后面是实际对象  
    private Map<String, Object> objectPool = new HashMap<> ();  
    //定义一个创建对象的方法  
    //该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象  
    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {  
        Class<?> clazz = Class.forName(clazzName);  
        return clazz.newInstance();  
    }  
    //该方法通过文件来初始化对象池  
    //它会根据配置文件创建对象  
    public void initPool(String fileName) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {  
        FileInputStream fis = null;  
        try {  
            fis = new FileInputStream(fileName);  
            Properties props = new Properties();  
            props.load(fis);  
            for (String name : props.stringPropertyNames()) {  
                //每取出一个键值对，就根据属性值创建对象  
                //每调用createObject创建对象，并将对象添加到对象池中  
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
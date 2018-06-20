package java9��;

import java.io.Serializable;  

public class User implements Cloneable,Serializable  {  
      
    //ʵ��Serializable���������  
    private static final long serialVersionUID = -1L;   
      
    //�û���  
    String  Name="";  
      
    //�û���ϵ��ʽ  
    String  Phone="";  
      
    //�û���˾  
    String  Company="";  
      
    /* 
     * default ������û�����������class.forname �ᱨ�� 
     */  
    public User( ) {  
  
        this.Name = "default";  
        this.Phone = "default";  
        this.Company = "default";  
    }  
      
    public User( String name,String phone, String company ) {  
        this.Name = name;   
        this.Phone = phone;  
        this.Company = company;  
    }  
      
    public String getName() {  
        return Name;  
    }  
    public void setName(String name) {  
        Name = name;  
    }  
    public String getPhone() {  
        return Phone;  
    }  
    public void setPhone(String phone) {  
        Phone = phone;  
    }  
    public String getCompany() {  
        return Company;  
    }  
    public void setCompany(String company) {  
        Company = company;  
    }  
      
    @Override  
     public Object clone() throws CloneNotSupportedException {  
      // TODO Auto-generated method stub  
      return super.clone();  
     }  
      
    public String  toString(){  
        return "Name:"+this.Name+", Phone:"+this.Phone+", Company:"+this.Company+";";  
          
    }  
      
  
}  
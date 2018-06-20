package java9级;

import java.io.Serializable;  

public class User implements Cloneable,Serializable  {  
      
    //实现Serializable，才有这个  
    private static final long serialVersionUID = -1L;   
      
    //用户名  
    String  Name="";  
      
    //用户联系方式  
    String  Phone="";  
      
    //用户公司  
    String  Company="";  
      
    /* 
     * default 方法，没有这个方法，class.forname 会报错 
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
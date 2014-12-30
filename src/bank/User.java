package bank;

import java.util.Arrays;



//用户信息
public class User {
private double money;
private int[] code;
private int[] passWord;
private String name;
public User(){
	money=0;
	code=new int[]{0,0,0,0,0,0,0,0};
	passWord=new int[]{0,0,0,0,0,0};
	name=new String("xxx");
	}
public User(double m,int c[],int p[],String n){
 money=m;
 code=c;
 passWord=p;
 name=n; 
  }
public void display(){
	System.out.print("姓名：");
	System.out.println(name);
	System.out.print("卡号：");
	System.out.println(Arrays.toString(code));
	System.out.print("密码：");
	System.out.println(Arrays.toString(passWord));
	System.out.print("余额：");
	System.out.println(money);
}
public double getMoney(){
	return money;
    }
public int[] getCode(){
	return code;
    }
public int[] getPassword(){
	return passWord; 
    }
public String getName(){
	return name;
	}
public void setName(String n){
	name=n;
	}
public void setCode(int c[]){
	code=c;
	}
public void setpassWord(int p[]){
	passWord=p;
	}
public void setMoney(double m){
	money=m;
	}
}


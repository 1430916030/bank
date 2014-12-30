package bank;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

//还可已添加语言选择系统
//把User类和Bank写两个
//选择英文系统时用英文版的两个累来定义对象
//银行系统
public class Bank 
{static TradeRecord record=new TradeRecord();
	Bank()
	{}
	
//取款系统	
@SuppressWarnings("resource")
boolean withDraw(User a)
{
	double num=0.0;
	System.out.print("请选择取款金额：");
	System.out.println("1.100 2.300 3.500 4.1000 5"
			+ ".1500 6.其他金额");
	Scanner b=new Scanner(System.in);
	int xuanze=b.nextInt();
	switch(xuanze)
	{
	case 1:num=100;
	break;
	case 2:num=300;
	break;
	case 3:num=500;
	break;
	case 4:num=1000;
	break;
	case 5:num=1500;
	break;
	case 6:System.out.print("取款金额(最大10000)：");
	       num=b.nextDouble();
	       break;
	default:break;
	}
	while(num>10000.0){
		System.out.print("金额过大,请重新输入：");
	       num=b.nextDouble();
	}
double money=a.getMoney();
if(num>money)
{
	System.out.println("余额不足,请重新选择");
	
	return false;
}
else{a.setMoney(money-num);
     record.setGetmoney(num);
	 System.out.println("现金准备中，请稍等……");
	 
	 return true;
}
}
	
//查询系统
void Find(User a)
{
String name=a.getName();
double money=a.getMoney();
System.out.println("用户："+name);
System.out.println("账户余额："+money);
}

//存款系统
@SuppressWarnings("resource")
void deposit(User a)
{
	boolean chaoe=false;
	double money=a.getMoney();
	System.out.println("请放入要存的钱：(少于10000)");
	Scanner b=new Scanner(System.in);
	double jine=b.nextDouble();
	if(jine>10000.0){
	chaoe=true;
     System.out.println("请取走多余的钱");
	}
if(chaoe==true)
{
	a.setMoney(10000.0+money);
record.setPutmoney(10000.0);
}
else
{
	a.setMoney(jine+money);
	record.setPutmoney(jine);
}

}

//退出处理
@SuppressWarnings("resource")
void quit()
{
	System.out.print("是否打印凭条？（y/n）");	
	Scanner a=new Scanner(System.in);
	String b=a.nextLine();
	if(b.equals("y"))
	{
		record.printPaper();
		}
	
}

public void hehe() throws UnsupportedEncodingException
{
        int n, m, sum = 0;
        System.out.println("输入字符串");
        Scanner a = new Scanner(System.in);
        String str = a.nextLine();
        System.out.println("输入需截取的字节数");
        m = a.nextInt();
        n = str.length();
        for (int i = 0; i < n; i++)
        {
                int charnum = (int) str.charAt(i);
                System.out.println(charnum);
                if (charnum >= 128)
                        sum += 2;
                else
                        sum += 1;
                if (sum > m)
                        break;
                System.out.print(str.charAt(i));
        }
        a.close();
}

//主程序
@SuppressWarnings("resource")
public static void main(String args[])
{System.out.println("说明：");
 System.out.println("可以输入的卡号有：12345670,12345671,12345672,12345673"
		+ ",12345674");
 System.out.println("对应的密码：065123,715123,762123,765323,765143");
  
	//初始化
    double m=9000;
    String n="吴克";
    User one[]=new User[5];
	for(int i=0;i<5;i++)
	{
    int c[]=new int[]{1,2,3,4,5,6,7,i};
    int p[]=new int[]{7,6,5,1,2,3};
    p[i]=i;
     switch(i)
     {
     case 1:n="龙傲天";
     break;
     case 2:n="王师傅";
     break;
     case 3:n="局座";
     break;
     case 4:n="瓜子哥";
     break;
     default:break;
    }
     one[i]=new User(m,c,p,n);
     if(m<12000)
    	 m=m+5000.0;
     else m=m/2.0;
    
	}
	//登录
	System.out.print("请输入卡号：");
	Scanner a=new Scanner(System.in);
	int code[]=new int[8];
	String str=a.nextLine();
	while(str.length()!=8)
	{
        System.out.print("卡号不对请重新输入：");
        str=a.nextLine();
	}
	for(int i=0;i<8;i++)
	{
		code[i]=str.charAt(i)-48;
	}
    Boolean flag=false;
    Boolean flag2=null;
    User use = null;
    while(flag==false)
    {
	for(int i=0;i<5;i++)
	{
	     flag2=true;
		 use=one[i];
	     int co[]=one[i].getCode();
	    
	     for(int j=0;j<8;j++)
	     {
	    	 if(co[j]!=code[j])
	    	 {
	    	  flag2=false;
	    	  break;
	    	 }
	     }
	     if(flag2==true)
    		 break;
	}
	if(flag2==true)
		  flag=true;
	   else
	{
	System.out.print("卡号不存在请重新输入：");
    str=a.nextLine();
    while(str.length()!=8)
    {
        System.out.print("卡号不对请重新输入：");
        str=a.nextLine();
	}
for(int i=0;i<8;i++)
{
	code[i]=str.charAt(i)-48;
}
}
    }
int passWord[]=new int[6];
    int wrong=0;
    flag=true;
    System.out.print("请输入6位密码：");
    str=a.nextLine();
    int remain=2;
    while(wrong<3)
    {
      while(str.length()!=6)
      {
    	  wrong++;
    	  if(wrong==3)break;
          System.out.print("密码错误，还有"+remain+"次机会:");
          str=a.nextLine();
          remain=remain-wrong;
  	}
      if(wrong==3)break;
      for(int i=0;i<6;i++)
      {
	  passWord[i]=str.charAt(i)-48;
    }
    int word[]=use.getPassword();
  	for(int i=0;i<6;i++)
  	{
    	if(word[i]!=passWord[i])
    	{
    	wrong++;
    	if(wrong==3)break;
        System.out.print("密码错误，还有"+remain+"次机会:");
        str=a.nextLine();
        flag=false;
        remain=remain-wrong;
        break;
        }
    }
  	if(flag==true)
  		break;
  	flag=true;
}   
if(wrong==3)
{
	System.out.print("吞卡");
 System.exit(0); 
}
//进入系统
Bank system=new Bank();
Boolean right=false;
int operate;
for(;;)
{
System.out.println("请选择操作：1.取款 2.余额查询 3.存款 4.退出");
operate=a.nextInt();
if(operate==1)
{
	while(right==false)
	{	
     right=system.withDraw(use);
}
	System.out.println("请取回现金");
	right=false;
}
if(operate==2)
{
	system.Find(use);
}
if(operate==3)
{
	String cun="y";
	
while(cun.equals("y"))
{
system.deposit(use);
System.out.print("是否继续存款（y/n）：");
Scanner b=new Scanner(System.in);
cun=b.nextLine();
}
}

if(operate==4)
{
	system.quit();
	break;
}
if(operate!=4&&operate!=3&&operate!=2&&operate!=1)
{
	System.out.print("没有该操作！");
	}
}

System.out.print("感谢您的使用!");

}
}

package bank;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

//�������������ѡ��ϵͳ
//��User���Bankд����
//ѡ��Ӣ��ϵͳʱ��Ӣ�İ�����������������
//����ϵͳ
public class Bank 
{static TradeRecord record=new TradeRecord();
	Bank()
	{}
	
//ȡ��ϵͳ	
@SuppressWarnings("resource")
boolean withDraw(User a)
{
	double num=0.0;
	System.out.print("��ѡ��ȡ���");
	System.out.println("1.100 2.300 3.500 4.1000 5"
			+ ".1500 6.�������");
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
	case 6:System.out.print("ȡ����(���10000)��");
	       num=b.nextDouble();
	       break;
	default:break;
	}
	while(num>10000.0){
		System.out.print("������,���������룺");
	       num=b.nextDouble();
	}
double money=a.getMoney();
if(num>money)
{
	System.out.println("����,������ѡ��");
	
	return false;
}
else{a.setMoney(money-num);
     record.setGetmoney(num);
	 System.out.println("�ֽ�׼���У����Եȡ���");
	 
	 return true;
}
}
	
//��ѯϵͳ
void Find(User a)
{
String name=a.getName();
double money=a.getMoney();
System.out.println("�û���"+name);
System.out.println("�˻���"+money);
}

//���ϵͳ
@SuppressWarnings("resource")
void deposit(User a)
{
	boolean chaoe=false;
	double money=a.getMoney();
	System.out.println("�����Ҫ���Ǯ��(����10000)");
	Scanner b=new Scanner(System.in);
	double jine=b.nextDouble();
	if(jine>10000.0){
	chaoe=true;
     System.out.println("��ȡ�߶����Ǯ");
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

//�˳�����
@SuppressWarnings("resource")
void quit()
{
	System.out.print("�Ƿ��ӡƾ������y/n��");	
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
        System.out.println("�����ַ���");
        Scanner a = new Scanner(System.in);
        String str = a.nextLine();
        System.out.println("�������ȡ���ֽ���");
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

//������
@SuppressWarnings("resource")
public static void main(String args[])
{System.out.println("˵����");
 System.out.println("��������Ŀ����У�12345670,12345671,12345672,12345673"
		+ ",12345674");
 System.out.println("��Ӧ�����룺065123,715123,762123,765323,765143");
  
	//��ʼ��
    double m=9000;
    String n="���";
    User one[]=new User[5];
	for(int i=0;i<5;i++)
	{
    int c[]=new int[]{1,2,3,4,5,6,7,i};
    int p[]=new int[]{7,6,5,1,2,3};
    p[i]=i;
     switch(i)
     {
     case 1:n="������";
     break;
     case 2:n="��ʦ��";
     break;
     case 3:n="����";
     break;
     case 4:n="���Ӹ�";
     break;
     default:break;
    }
     one[i]=new User(m,c,p,n);
     if(m<12000)
    	 m=m+5000.0;
     else m=m/2.0;
    
	}
	//��¼
	System.out.print("�����뿨�ţ�");
	Scanner a=new Scanner(System.in);
	int code[]=new int[8];
	String str=a.nextLine();
	while(str.length()!=8)
	{
        System.out.print("���Ų������������룺");
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
	System.out.print("���Ų��������������룺");
    str=a.nextLine();
    while(str.length()!=8)
    {
        System.out.print("���Ų������������룺");
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
    System.out.print("������6λ���룺");
    str=a.nextLine();
    int remain=2;
    while(wrong<3)
    {
      while(str.length()!=6)
      {
    	  wrong++;
    	  if(wrong==3)break;
          System.out.print("������󣬻���"+remain+"�λ���:");
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
        System.out.print("������󣬻���"+remain+"�λ���:");
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
	System.out.print("�̿�");
 System.exit(0); 
}
//����ϵͳ
Bank system=new Bank();
Boolean right=false;
int operate;
for(;;)
{
System.out.println("��ѡ�������1.ȡ�� 2.����ѯ 3.��� 4.�˳�");
operate=a.nextInt();
if(operate==1)
{
	while(right==false)
	{	
     right=system.withDraw(use);
}
	System.out.println("��ȡ���ֽ�");
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
System.out.print("�Ƿ������y/n����");
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
	System.out.print("û�иò�����");
	}
}

System.out.print("��л����ʹ��!");

}
}

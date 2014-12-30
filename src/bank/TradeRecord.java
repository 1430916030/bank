package bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeRecord {
private double getmoney;
private double putmoney;
private Date time;
private double moneyChange;
TradeRecord()
{
getmoney=0;
putmoney=0;
moneyChange=0;
}

public void displayDate()
{
 SimpleDateFormat bartDateFormat =new SimpleDateFormat("yyyy-MM-dd");        
 time= new Date();
 System.out.println(bartDateFormat.format(time));
}
public void setGetmoney(double getmoney)
{
	this.getmoney=this.getmoney+getmoney;
}
public void setPutmoney(double putmoney)
{
	this.putmoney=this.putmoney+putmoney;
}
public void setmoneyChange()
{
	moneyChange=putmoney-getmoney;
}
public double getGet()
{
	return getmoney;
	}
public double getPut()
{
	return putmoney;
	}
public double getChange()
{
	return moneyChange;
	}
public void printPaper()
{
 setmoneyChange();
 System.out.println("取款"+getmoney);	
 System.out.println("存款"+putmoney);
 System.out.println("余额变化"+moneyChange);	
 displayDate();
	}
}

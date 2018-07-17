package com.ct.vo;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.jdbc.SQL;

public class UtilDate {
	
	//8λ����ת���� 2018-04-15��ʽ�ַ���
	public String Date1(String s) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		return f.format(format.parse(s));
		
	}
	
	//���ڸ�ʽ�ַ���תΪ8λ����
	public String Date2(String s) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(f.parse(s));
		
	}
	//��ϵͳʱ��תΪ2018-04-15��ʽ�ַ���
	public String Date3(){
		Date date=new Date();
		SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
		return f.format(date);
	}
	
	public String Date4(String s) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd");
		return format.format(f.parse(s));
		
	}
	public String Date5(String s) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd");
		return f.format(format.parse(s));
		
	}
	//时间加一个月
	public String Date6(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(calendar.getTime());
	}
	//数字格式20180909加一个月
	public String Date7(String date) throws Exception{
		String s=new UtilDate().Date1(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(java.sql.Date.valueOf(s));
		calendar.add(Calendar.MONTH, 1);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(calendar.getTime());
	}
	

}

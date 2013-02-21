package com.yun.common;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class StatisticsInfo {
	private  int count=0;
	private  String Info="";
	private Date date=new Date();
	private  double value=0d;
	private Map values=new HashMap<Object, Object>();
	private String itemname="";
	private String itemno="";
	private String number="";
	private String percent="";
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemno() {
		return itemno;
	}
	public void setItemno(String itemno) {
		this.itemno = itemno;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public Map getValues() {
		return values;
	}
	public void setValues(Map values) {
		this.values = values;
	}
	private  Calendar cal=null;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getYearLast(int year)
	{	
		
		cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 30);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}
	public Date getYearFirst(int year)
	{
		cal=Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		return cal.getTime();
	}
	
	
	
	/**
	 * 
	 * 创建一个表头
	 *
	 * @return HSSF对象
	 */
	public HSSFWorkbook createHead(HSSFWorkbook wb,List<String> Columns)
	{

		int ColumnCount=Columns.size();
		HSSFSheet s=wb.getSheetAt(0);
		int MaxRow=s.getPhysicalNumberOfRows();
		HSSFRow row=s.createRow(MaxRow);
		int[] colLength=new int[Columns.size()];
		for(int i=0;i<colLength.length;i++)
		{	
			if(Columns.get(i)!=null)
			colLength[i]=Columns.get(i).length();
			else
				colLength[i]=0;
		}
		for(int i=0;i<ColumnCount;i++)
		{	
			if(colLength[i]!=0)
			s.setColumnWidth(i, colLength[i]*1300);
		}
		//生成一个样式
        HSSFCellStyle style=wb.createCellStyle();
        //设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       //生成一个字体
        HSSFFont font=wb.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short)16);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
       //把字体应用到当前的样式
        style.setFont(font);
        for(int i=0,j=Columns.size();i<j;i++)
		{
			HSSFCell cell= row.createCell(i);
			cell.setCellValue(Columns.get(i).toString());
			cell.setCellStyle(style);
		}
		return wb;
	}
	/**
	 * 
	 * 通过一个List创建一个HSSFRow 对象
	 * @param wb
	 * @param row
	 * @param list
	 */
	public void createRow(HSSFWorkbook wb,HSSFRow row,List list)
	{
		
		//创建样式 
		HSSFCellStyle style1=wb.createCellStyle();
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFCellStyle style2=wb.createCellStyle();
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style2.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		
		//创建Row and cell
		int Count=0;
		for(Object obj:list)
		{	
			if(obj==null)
			{
				HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_BLANK);
				cell.setCellStyle(style2);
				cell.setCellValue("");
			}
			else if(obj.getClass().equals(Integer.class))
			{
				int objvalue=Integer.valueOf(obj.toString());
				if(objvalue<=0)
				{	
					HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_BLANK);
					cell.setCellStyle(style1);

				}
				else
				{	
					HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_NUMERIC);
					cell.setCellStyle(style1);
					cell.setCellValue(Integer.valueOf(obj.toString()));
				}
			}
			else if(obj.getClass().equals(Double.class))
			{	
				double objvalue=Double.valueOf(obj.toString());
				if(objvalue<=0)
				{
					HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_BLANK);
					cell.setCellStyle(style1);
					
				}
				else
				{
					BigDecimal bg = new BigDecimal(Double.valueOf(obj.toString()));
			        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			        HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_NUMERIC);
					cell.setCellStyle(style1);
					cell.setCellValue(f1);
				}
				
			}
			else if(obj.getClass().equals(Date.class))
			{
				HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_STRING);
				cell.setCellStyle(style2);
				cell.setCellValue(obj.toString());
			}
			else
			{
				HSSFCell cell=row.createCell(Count,HSSFCell.CELL_TYPE_STRING);
				cell.setCellStyle(style1);
				cell.setCellValue(obj.toString());
			}
			Count++;
		}
	}
}

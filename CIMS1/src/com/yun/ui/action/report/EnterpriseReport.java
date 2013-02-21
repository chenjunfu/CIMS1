package com.yun.ui.action.report;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import sun.util.resources.CalendarData;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.EnterpriseProvider;
import com.yun.bll.culture.ProfessionProvider;
import com.yun.bll.culture.RegionsProvider;
import com.yun.common.StatisticsInfo;
import com.yun.entities.culture.EnterpriseInfo;
import com.yun.entities.culture.ProfessionInfo;
import com.yun.entities.culture.RegionsInfo;
import com.yun.entities.culture.collection.EnterpriseInfoCollection;
import com.yun.entities.culture.collection.ProfessionInfoCollection;
import com.yun.entities.culture.collection.RegionsInfoCollection;
import com.yun.ui.action.UserLook;
import com.yun.ui.action.chart.EnterpriseByRegion;
import com.yun.ui.action.chart.EnterpriseByType;

public class EnterpriseReport extends ActionSupport {
	EnterpriseInfoCollection EnterpriseList=null;
	double register=0;
	String dateshow="";
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	UserLook userlook=new UserLook(this.request,this.response);
	Date createtime1;
	Date createtime2;
	StatisticsInfo info=new StatisticsInfo();
	private InputStream inputStream;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 
	 * 下载文件的名字
	 * @return
	 */
	public String getDownloadFileName()
	{
		String downFileName=fileName;
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DAY_OF_MONTH);
		try{

			downFileName=new String(downFileName.getBytes(),"ISO8859-1");
			downFileName+="("+year+"-"+month+"-"+day+")";
		}
		catch(UnsupportedEncodingException  e)
		{
			e.printStackTrace();
		}
		return downFileName;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		userlook.seePageY("4");
	}
	public Date getCreatetime1() {
		return createtime1;
	}
	
	public void setCreatetime1(Date createtime1) {
		this.createtime1 = createtime1;
	}

	public Date getCreatetime2() {
		return createtime2;
	}

	public void setCreatetime2(Date createtime2) {
		this.createtime2 = createtime2;
	}

	public String getDateshow() {
		return dateshow;
	}

	public void setDateshow(String dateshow) {
		this.dateshow = dateshow;
	}

	public double getRegister() {
		return register;
	}

	public void setRegister(double register) {
		this.register = register;
	}

	public EnterpriseInfoCollection getEnterpriseList() {
		return EnterpriseList;
	}

	public void setEnterpriseList(EnterpriseInfoCollection enterpriseList) {
		EnterpriseList = enterpriseList;
	}


	
	//年度统计
	public String AnnualSummary()
	{	
		calcNewlyenterprise();
		return "AnnualSummary";
	}
	
	//年度统计导出Excel
	public String ExportAnnualSummary()
	{
	    calcNewlyenterprise();
		List<String> list=new ArrayList<String>();
		list.add("序号");
		list.add("企业名称");
		list.add("行业类型");
		list.add("创立时间");
		list.add("所属区域");
		list.add("注册资金");
		list.add("企业性质");
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet s=wb.createSheet("年度企业汇总");
		info.createHead(wb,list);
		int i=1;
		
		for(EnterpriseInfo enterprise: EnterpriseList)
		{	

			List datas=new ArrayList();
			datas.add(i);
			datas.add(enterprise.getEnterprisename());
			datas.add(enterprise.getObjProfessionInfoByBusinesstypeid().getBusinesstypename());
			datas.add(enterprise.getCreatetime());
			datas.add(enterprise.getObjRegionsInfoByRegionid().getRegionname());
			datas.add(enterprise.getRegistfund());
			datas.add(enterprise.getObjEnterpristQualityInfoByQualityid().getQualityname());
			HSSFRow row=s.createRow(i);
			info.createRow(wb, row, datas);
			i++;
		}
		HSSFRow row2=s.createRow(i);
		HSSFCell cell=row2.createCell(0);
		cell.setCellValue("合计");
		HSSFCell cell6=row2.createCell(5);
		cell6.setCellValue(register);
		ByteArrayOutputStream os = new ByteArrayOutputStream();  
		try {
			wb.write(os);
			inputStream = new ByteArrayInputStream(os.toByteArray()); 
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//ByteArrayInputStream is = new ByteArrayInputStream(workBook.getBytes());  	
		
		this.fileName="年度企业汇总";
		return "success";
	}
	/**
	 * 
	 * 年度新增统计
	 * @return
	 */
	public String newlyenterprise()
	{	
		
		calcNewlyenterprise();
		return "newlyenterprise";
	}
	
	/**
	 * 
	 * 导出年度新增统计Excel
	 * @return
	 */

	public String Exportnewlyenterprise()
	{	
		calcNewlyenterprise();
		List<String> list=new ArrayList<String>();
		list.add("序号");
		list.add("企业名称");
		list.add("行业类型");
		list.add("创立时间");
		list.add("所属区域");
		list.add("注册资金");
		list.add("企业性质");
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet s=wb.createSheet("年度新增企业汇总");
		info.createHead(wb,list);
		int i=1;
		
		for(EnterpriseInfo enterprise: EnterpriseList)
		{	
			
			List datas=new ArrayList();
			datas.add(i);
			datas.add(enterprise.getEnterprisename());
			datas.add(enterprise.getObjProfessionInfoByBusinesstypeid().getBusinesstypename());
			datas.add(enterprise.getCreatetime());
			datas.add(enterprise.getObjRegionsInfoByRegionid().getRegionname());
			datas.add(enterprise.getRegistfund());
			datas.add(enterprise.getObjEnterpristQualityInfoByQualityid().getQualityname());
			HSSFRow row=s.createRow(i);
			info.createRow(wb, row, datas);
			i++;
		}
		HSSFRow row2=s.createRow(i);
		HSSFCell cell=row2.createCell(0);
		cell.setCellValue("合计");
		HSSFCell cell6=row2.createCell(5);
		cell6.setCellValue(register);
		ByteArrayOutputStream os = new ByteArrayOutputStream();  
		try {
			wb.write(os);
			inputStream = new ByteArrayInputStream(os.toByteArray()); 
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//ByteArrayInputStream is = new ByteArrayInputStream(workBook.getBytes());  	
		
		this.fileName="年度新增企业汇总";
		return "success";
	}
	/**
	 * 计算年    度企业/年度新增统计        信息
	 */
	private void calcNewlyenterprise() {
		Calendar cal=Calendar.getInstance();
		if(createtime1==null)
		{
			createtime1=info.getYearFirst(cal.get(Calendar.YEAR));
		}
		if(createtime2==null)
		{		
			
			createtime2=new Date();
		}
		EnterpriseList=EnterpriseProvider.GetListPagerByCreatetime(createtime1, createtime2,1,EnterpriseProvider.CountBy());
		register=0d;
		for(EnterpriseInfo info:EnterpriseList)
		{	
			register+=info.getRegistfund();
		}
	}
	
	
	/**
	 * 
	 * 包含EnterpriseCollection 的 List
	 */
	
	private List<EnterpriseInfoCollection> EnterpriseListByType=new ArrayList<EnterpriseInfoCollection>();
	
	
	public List<EnterpriseInfoCollection> getEnterpriseListByType() {
		return EnterpriseListByType;
	}

	public void setEnterpriseListByType(
			List<EnterpriseInfoCollection> enterpriseListByType) {
		EnterpriseListByType = enterpriseListByType;
	}
	int enterprisetype=0;
	
	public int getEnterprisetype() {
		return enterprisetype;
	}

	public void setEnterprisetype(int enterprisetype) {
		this.enterprisetype = enterprisetype;
	}
	
	/**
	 * 按类型时间统计action Method
	 * @return
	 */
	public String enterpriseByType()
	{
		calcEnterpriseByType();
		return "EnterpriseByType";
	}
	public String ExportenterpriseByType()
	{	
		//执行计算得到数据 EnterpriseListByType （List）
		calcEnterpriseByType();
		//Excel标题
	    List<String> cols=new ArrayList<String>();
	    cols.add("序号");
	    cols.add("所属行业");
	    cols.add("企业名称");
	    cols.add("注册资金");
	    cols.add("就业人数");
	    cols.add("创立时间");
	    //创建Workbook
	    HSSFWorkbook wb=new HSSFWorkbook();
	    HSSFSheet s=wb.createSheet("按行业统计企业总量");
	    info.createHead(wb, cols);
	    
	    int rowcount=1;
	    int TypeCount=0;
	  
		//创建Excel内容
	    for(EnterpriseInfoCollection ec: EnterpriseListByType)
	    {	
	    	TypeCount++;
	    	int SingleCount=ec.size();
	    	for(EnterpriseInfo enterprise:ec)
	    	{	
	    		HSSFRow row=s.createRow(rowcount);
	    		List list=new ArrayList();
	    		list.add(TypeCount);
	    		list.add(enterprise.getObjProfessionInfoByBusinesstypeid().getBusinesstypename());
	    		list.add(enterprise.getEnterprisename());
	    		list.add(enterprise.getRegistfund());
	    		list.add(enterprise.getEmploynumber());
	    		list.add(enterprise.getCreatetime());
	    		info.createRow(wb, row, list);
	    		rowcount++;
	    	}
	    	int firstrow=rowcount-SingleCount;
	    	int lastrow=rowcount;
	    	s.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,0,0));
	    	s.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,1,1));
	    }
	   //创建表尾
	   HSSFRow row=s.createRow(rowcount);
	   HSSFCell cell= row.createCell(0);
	   cell.setCellValue("合计");

	   HSSFCell cell1= row.createCell(3);
	   cell1.setCellValue(register);

	   HSSFCell cell2= row.createCell(2);
	   cell2.setCellValue(Integer.valueOf(request.getAttribute("count").toString()));

	   HSSFCell cell3=row.createCell(4);
	   cell3.setCellValue(Integer.valueOf(request.getAttribute("peoplecount").toString()));

	   rowcount++;
	   //使用jfreechart 的action 类 得到他的 chart属性以插入Excel中
	   EnterpriseByType type=new EnterpriseByType();
	   type.setCreatetime1(createtime1);
	   type.setCreatetime2(createtime2);
	   
	   type.execute();
	   JFreeChart chart= type.getChart();
	   ByteArrayOutputStream out=new ByteArrayOutputStream();
	   try {
		ByteArrayOutputStream ImageOut = new ByteArrayOutputStream();
		ChartUtilities.writeChartAsPNG(ImageOut, chart,700,400);
		HSSFPatriarch patriarch=  s.createDrawingPatriarch();
		HSSFClientAnchor anchor= new HSSFClientAnchor(1,1,1023,255,(short)0,rowcount+1,(short)5,rowcount+20);
		anchor.setAnchorType(HSSFClientAnchor.MOVE_AND_RESIZE);
		int index= wb.addPicture(ImageOut.toByteArray(), HSSFPicture.PICTURE_TYPE_PNG);
		patriarch.createPicture(anchor, index); 
		//将Excel加入InputStream
		
		wb.write(out);
		inputStream=new ByteArrayInputStream(out.toByteArray());
		out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   this.fileName="按行业统计企业总量";
	   return "success";
	}
	
	/**
	 * 按类型时间统计
	 */
	private void calcEnterpriseByType() {
		int peoplecount=0;
		DrpInit();
		ProfessionInfoCollection ProfessionInfoColl=ProfessionProvider.getProfessionStatic();
		Calendar cal=Calendar.getInstance();
		if(createtime1==null)
		{
			
			createtime1=info.getYearFirst(cal.get(Calendar.YEAR));
		}
		if(createtime2==null)
		{	
			createtime2=new Date();
		}
		
		
		register=0d;
		if(enterprisetype==0)
		{
			for(ProfessionInfo p:ProfessionInfoColl)
			{	
				
				EnterpriseInfoCollection eic=EnterpriseProvider.GetListPagerByBusinesstypeidCreatetime(p.getBusinessdatabaseid(),createtime1,createtime2,1,EnterpriseProvider.CountBy());
				if(eic.size()==0)
				{	
					EnterpriseInfo temp=new EnterpriseInfo();
					temp.setBusinesstypeid(p.getBusinessdatabaseid());
					eic.add(temp);
				}
				EnterpriseListByType.add(eic);
				
			}
		}
		else
		{		
				EnterpriseInfoCollection eic=EnterpriseProvider.GetListPagerByBusinesstypeidCreatetime(enterprisetype,createtime1, createtime2, 1,EnterpriseProvider.CountBy());
				EnterpriseListByType.add(eic);
		}
		int count=0;
		for(EnterpriseInfoCollection ec:EnterpriseListByType)
		{
			for(EnterpriseInfo e:ec)
			{
				if(e.getDatabaseenterpriseid()!=0)
				{
					register+=e.getRegistfund();
					peoplecount+=Integer.valueOf(e.getEmploynumber());
					if(e.getDatabaseenterpriseid()!=0)
					count++;
				}
			}
		}
		this.request.setAttribute("count", count);
		this.request.setAttribute("peoplecount", peoplecount);
	}
	
	
	/**
	 * 区域ID
	 */
	int enterpriseregion=0;
	
	public int getEnterpriseregion() {
		return enterpriseregion;
	}

	public void setEnterpriseregion(int enterpriseregion) {
		this.enterpriseregion = enterpriseregion;
	}
	/**
	 * 按区域时间统计
	 */
	public String enterpriseByRegion()
	{	
		
		calcEnterpriseByRegion();
		return "EnterpriseByRegion";
	}
	/**
	 * 按区域时间统计并导出Excel
	 */
	public String ExportEnterpriseByRegion()
	{
		calcEnterpriseByRegion();
		List<String> cols=new ArrayList<String>();
	    cols.add("序号");
	    cols.add("所属区域");
	    cols.add("企业名称");
	    cols.add("注册资金");
	    cols.add("就业人数");
	    cols.add("创立时间");
	    HSSFWorkbook wb=new HSSFWorkbook();
	    HSSFSheet s=wb.createSheet("按地区统计企业总量");
	    info.createHead(wb, cols);
	    int rowcount=1;
	    int TypeCount=0;
		for(EnterpriseInfoCollection ec:EnterpriseListByType)
		{
			TypeCount++;
	    	int SingleCount=ec.size();
			for(EnterpriseInfo enterprise:ec)
			{	
				HSSFRow row=s.createRow(rowcount);
	    		List list=new ArrayList();
	    		list.add(TypeCount);
	    		list.add(enterprise.getObjRegionsInfoByRegionid().getRegionname());
	    		list.add(enterprise.getEnterprisename());
	    		list.add(enterprise.getRegistfund());
	    		list.add(enterprise.getEmploynumber());
	    		list.add(enterprise.getCreatetime());
	    		info.createRow(wb, row, list);
	    		rowcount++;
			}
			int firstrow=rowcount-SingleCount;
	    	int lastrow=rowcount;
	    	s.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,0,0));
	    	s.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,1,1));
		}
		 HSSFRow row=s.createRow(rowcount);
		   HSSFCell cell= row.createCell(0);
		   cell.setCellValue("合计");

		   HSSFCell cell1= row.createCell(3);
		   cell1.setCellValue(register);
		
		   HSSFCell cell2= row.createCell(2);
		   cell2.setCellValue(Integer.valueOf(request.getAttribute("count").toString()));

		   HSSFCell cell3=row.createCell(4);
		   cell3.setCellValue(Integer.valueOf(request.getAttribute("peoplecount").toString()));

		   ByteArrayOutputStream out=new ByteArrayOutputStream();
		   //使用jfreechart 的action 类 得到他的 chart属性以插入Excel中
		   EnterpriseByRegion type=new EnterpriseByRegion();
		   type.setCreatetime1(createtime1);
		   type.setCreatetime2(createtime2);
		   type.setRegionid(enterpriseregion);
		   type.execute();
		   JFreeChart chart= type.getChart();
		   try {
			   ByteArrayOutputStream ImageOut = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsPNG(ImageOut, chart,600,400);
				HSSFPatriarch patriarch=  s.createDrawingPatriarch();
				HSSFClientAnchor anchor= new HSSFClientAnchor(1,1,1023,255,(short)0,rowcount+1,(short)5,rowcount+20);
				anchor.setAnchorType(HSSFClientAnchor.MOVE_AND_RESIZE);
				int index= wb.addPicture(ImageOut.toByteArray(), HSSFPicture.PICTURE_TYPE_PNG);
				patriarch.createPicture(anchor, index); 
			wb.write(out);
			 inputStream=new ByteArrayInputStream(out.toByteArray());
			 out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   this.fileName="按地区统计企业总量";
		return "success";
	}
	
	/**
	 * 按区域时间统计
	 */
	private void calcEnterpriseByRegion() {
		int peoplecount=0;
		DrpInit();
		RegionsInfoCollection RegionInfoColl=RegionsProvider.getRegionsStatic();
		Calendar cal=Calendar.getInstance();
		if(createtime1==null)
		{
			createtime1=info.getYearFirst(cal.get(Calendar.YEAR));
		}
		if(createtime2==null)
		{	
			createtime2=new Date();
		}

		register=0;
		if(enterpriseregion==0)
		{
			for(RegionsInfo R:RegionInfoColl)
			{	
				
				EnterpriseInfoCollection eic=EnterpriseProvider.GetListPagerByCreatetimeRegionid(createtime1, createtime2,R.getRegiondatabaseid(), 1,EnterpriseProvider.CountBy());
				if(eic.size()==0)
				{	
					EnterpriseInfo temp=new EnterpriseInfo();
					temp.setRegionid(R.getRegiondatabaseid());
					eic.add(temp);
				}
				EnterpriseListByType.add(eic);
			
			}
		}
		else
		{		
				EnterpriseInfoCollection eic=EnterpriseProvider.GetListPagerByCreatetimeRegionid(createtime1, createtime2,enterpriseregion , 1, RegionsProvider.CountBy());
				EnterpriseListByType.add(eic);
		}
		int count=0;
		for(EnterpriseInfoCollection ec:EnterpriseListByType)
		{
			for(EnterpriseInfo e:ec)
			{	
				if(e.getDatabaseenterpriseid()!=0)
				{
					register+=e.getRegistfund();
					peoplecount+=Integer.valueOf(e.getEmploynumber());
					count++;
				}
			}
		}

		this.request.setAttribute("count", count);
		this.request.setAttribute("peoplecount", peoplecount);
	}
	/**
	 * 加载区域和类型
	 */
	private void DrpInit()
	{
		 ProfessionInfoCollection ProfessionColl = 
	     ProfessionProvider.getProfessionStatic();
		 StringBuilder sbBusinesstypeid = new StringBuilder(100);
		 for (ProfessionInfo objProfessionInfo : ProfessionColl) {
	     sbBusinesstypeid.append(String.format(
         "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
         Integer.valueOf(objProfessionInfo
        .getBusinessdatabaseid()), objProfessionInfo
        .getBusinesstypename() }));
     }
     this.request.setAttribute("BusinesstypeidEdit", sbBusinesstypeid.toString());
     this.request.setAttribute("BusinesstypeidList", sbBusinesstypeid.toString());
     
     
     RegionsInfoCollection RegionsColl = 
           RegionsProvider.getRegionsStatic();
        StringBuilder sbRegionid = new StringBuilder(100);
        for (RegionsInfo objRegionsInfo : RegionsColl) {
    	      sbRegionid.append(String.format(
    	       "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
    	      Integer.valueOf(objRegionsInfo
    	         .getRegiondatabaseid()), objRegionsInfo.getRegionname() }));
        }
    
    	    this.request.setAttribute("RegionidEdit", sbRegionid.toString());
    	    this.request.setAttribute("RegionidList", sbRegionid.toString());
	}

	
}

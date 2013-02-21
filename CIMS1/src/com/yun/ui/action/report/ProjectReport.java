package com.yun.ui.action.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;
import org.hibernate.stat.Statistics;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.yun.bll.culture.IndustryProjectProvider;
import com.yun.bll.culture.ProfessionProvider;
import com.yun.bll.culture.RegionsProvider;
import com.yun.common.StatisticsInfo;
import com.yun.entities.culture.IndustryProjectInfo;
import com.yun.entities.culture.ProfessionInfo;
import com.yun.entities.culture.RegionsInfo;
import com.yun.entities.culture.base.IndustryProjectInfoBase;
import com.yun.entities.culture.collection.IndustryProjectInfoCollection;
import com.yun.entities.culture.collection.ProfessionInfoCollection;
import com.yun.entities.culture.collection.RegionsInfoCollection;
import com.yun.ui.action.UserLook;
import com.yun.ui.action.chart.ProjectByRegion;

public class ProjectReport extends ActionSupport {
	private IndustryProjectInfoCollection coll=null;
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	private Calendar cal;
	private List ProjectList;;
	private int projecttype=0;
	
	private static final String PROJECTNEWLY="年度新增项目汇总表";
	private static final String PROJECTSTATSTICS="文化产业项目汇总表";
	private static final String PROJECTCOMPLETED="年度完成项目汇总表";
	private static final String PROJECTTOTALINVEST="年度项目投资总额统计分析表";
	private static final String PROJECTBYTYPE="年度项目行业统计及分析表";
	private static final String PROJECTBYREGION="年度项目地区统计及分析表";
	private InputStream inputStream;
	private String fileName;
	private boolean export;
	private DateFormat df=new SimpleDateFormat("yyyy年mm月dd日");

	
	public boolean isExport() {
		return export;
	}
	public void setExport(boolean export) {
		this.export = export;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
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
	
	
	UserLook userlook=new UserLook(this.request,this.response);
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		userlook.seePageY("9");
	}
	public int getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(int projecttype) {
		this.projecttype = projecttype;
	}

	public List getProjectList() {
		return ProjectList;
	}

	public void setProjectList(List projectList) {
		ProjectList = projectList;
	}
	private StatisticsInfo info;
	
	public StatisticsInfo getInfo() {
		return info;
	}

	public void setInfo(StatisticsInfo info) {
		this.info = info;
	}

	public IndustryProjectInfoCollection getColl() {
		return coll;
	}

	public void setColl(IndustryProjectInfoCollection coll) {
		this.coll = coll;
	}
	private int year=0;
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String Statistics()
	{	
		
		Drpinit();
		info=new StatisticsInfo();
		cal=Calendar.getInstance();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}

		coll=IndustryProjectProvider.GetListPagerByCreatetime(info.getYearLast(year),"",1,IndustryProjectProvider.GetListPagerByCreatetime(cal.getTime()));
		info.setCount(coll.size());
		double totalinvest=0d;
		double publicinvest=0d;
		double bankinvest=0d;
		double selfinvest=0d;
		double yearinvest=0d;
		double planinvest=0d;
		for(IndustryProjectInfo temp:coll)
		{
			totalinvest+=temp.getTotalinvest();
			publicinvest+=temp.getPublicinvest();
			bankinvest+=temp.getBankloan();
			selfinvest+=temp.getSelfinvest();
			yearinvest+=temp.getYearinvest();
			planinvest+=temp.getPlaninvest();
		}
		info.getValues().put("totalinvest", totalinvest);
		info.getValues().put("publicinvest", publicinvest);
		info.getValues().put("bankinvest", bankinvest);
		info.getValues().put("selfinvest", selfinvest);
		info.getValues().put("yearinvest", yearinvest);
		info.getValues().put("planinvest", planinvest);
		if(export)
		{
			//添加表头数据
			List cols=new ArrayList();
			cols.add("序号");
			cols.add("项目名称");
			cols.add("建设单位");
			cols.add("建设性质");
			cols.add("建设地点");
			cols.add(" 建设起止年限 ");
			cols.add("建设规模及主要内容");
			cols.add("总投资(万元)");
			cols.add("资金来源");
			cols.add("");
			cols.add("");
			int CurrentYear=cal.get(Calendar.YEAR);
			cols.add("截止"+(CurrentYear-1)+"年底累计完成投资");
			cols.add(CurrentYear+"年计划投资");
			cols.add("项目前期进展情况");
			cols.add("");
			cols.add("");
			cols.add("");
			cols.add("形象进度");
			cols.add("联系人");
			cols.add("联系电话");
			cols.add("备注");
			List cols2=new ArrayList(21);
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("政府投资");
			cols2.add("银行贷款");
			cols2.add("自筹");
			cols2.add("");
			cols2.add("");
			cols2.add("审批,核准,备案");
			cols2.add("环评批复");
			cols2.add("土地批准");
			cols2.add("规划选址");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			cols2.add("");
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(ProjectReport.PROJECTSTATSTICS);
			info.createHead(wb, cols);
			info.createHead(wb, cols2);
			int nullcount=0;
			//合并单元格
			for(int i=0,j=cols.size();i<j;i++)
			{
				if(!cols.get(i).equals("")&&cols2.get(i).equals(""))
				sheet.addMergedRegion(new CellRangeAddress(0,1,i,i));
				else if(!(cols.get(i).equals(""))&&!(cols2.get(i).equals("")))
				{	
					int k=i+1;
					for(;k<j;k++)
					{
						if(cols.get(k).equals(""))
						nullcount++;
						else
						break;
					}
					sheet.addMergedRegion(new CellRangeAddress(0,0,i,i+nullcount));
					nullcount=0;
				}
			}
			int rowcount=2;
		
			for(IndustryProjectInfo project :coll)
			{
				List datas=new ArrayList();
				datas.add(rowcount-1);
				datas.add(project.getProjectname());
				datas.add(project.getObjEnterpriseInfoByDatabaseenterpriseid().getEnterprisename());
				datas.add(project.getObjProjectQualityInfoByProquality().getProquliname());
				datas.add(project.getAddress());
				String cycle="";
				if(project.getCreatetime()!=null)
					cycle+=df.format(project.getCreatetime());
				if(project.getCompletetime()!=null)
					cycle+=" 至  "+df.format(project.getCompletetime());
				else
					cycle+=" 至今";
				datas.add(cycle);
				datas.add(project.getProcontent());
				datas.add(project.getTotalinvest());
				datas.add(project.getPublicinvest());
				datas.add(project.getBankloan());
				datas.add(project.getSelfinvest());
				datas.add(project.getYearinvest());
				datas.add(project.getPlaninvest());
				datas.add(project.getObjShbInfoByShb().getShbname());
				datas.add(project.getObjHuanpiInfoByHppf().getHuanpiname());
				datas.add(project.getObjTupiInfoByTdpz().getTupiname());
				datas.add(project.getObjProaddInfoByGhxz().getProaddname());
				datas.add(project.getRealprogress());
				datas.add(project.getLinkman());
				datas.add(project.getPhone());
				datas.add(project.getComment());
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount);
			HSSFCell cell1=row.createCell(0);
			cell1.setCellValue("合计");
			HSSFCell cell2=row.createCell(7);			
			cell2.setCellValue(totalinvest);
			HSSFCell cell3=row.createCell(8);
			cell3.setCellValue(publicinvest);
			HSSFCell cell4=row.createCell(9);
			cell4.setCellValue(bankinvest);
			HSSFCell cell5=row.createCell(10);
			cell5.setCellValue(selfinvest);
			HSSFCell cell6=row.createCell(11);
			cell6.setCellValue(selfinvest);
			HSSFCell cell7=row.createCell(12);
			cell7.setCellValue(selfinvest);
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=ProjectReport.PROJECTSTATSTICS;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "success";
		}
		return "statistics";
	}
	public String ProjectNewLy()
	{	
		Drpinit();
		cal=Calendar.getInstance();
		info=new StatisticsInfo();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}
		Date start=info.getYearFirst(year);
		Date end =info.getYearLast(year);
		coll=IndustryProjectProvider.GetListPagerByCreatetime(start, end,  1, IndustryProjectProvider.GetListPagerByCreatetime(start, end));
		info.setCount(coll.size());
	
		for(IndustryProjectInfo temp:coll)
		{
			info.setValue(info.getValue()+temp.getTotalinvest());
		}
		if(export)
		{	

			List cols=new ArrayList();
			cols.add("编号");
			cols.add("项目名称");
			cols.add("项目类型");
			cols.add("所属地区");
			cols.add("项目内容");
			cols.add("总投资	");
			cols.add("开始时间");
			cols.add("完成时间");
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet s=wb.createSheet(ProjectReport.PROJECTNEWLY);
			info.createHead(wb, cols);

			int rowcount=1;
			for(IndustryProjectInfo project :coll)
			{
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(project.getProjectname());
				datas.add(project.getObjProfessionInfoByIndustryid().getBusinesstypename());
				datas.add(project.getObjRegionsInfoByRegionid().getRegionname());
				datas.add(project.getProcontent());
				datas.add(project.getTotalinvest());
				datas.add(df.format(project.getCreatetime()));
				if(project.getCompletetime()!=null)
					datas.add(df.format(project.getCompletetime()));
				else
				datas.add("");
				HSSFRow row=s.createRow(rowcount);
				info.createRow(wb, row, datas);
				rowcount++;
			}
			HSSFRow row=s.createRow(rowcount++);
			HSSFCell cell=row.createCell(0);
			cell.setCellValue("合计");

			HSSFCell cell1=row.createCell(5);

			cell1.setCellValue(info.getValue());
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			
			try {
				wb.write(out);
				inputStream=new ByteArrayInputStream(out.toByteArray());
				out.close();
				this.fileName=PROJECTNEWLY;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
		return "projectnewly";
	}
	public String ProjectCompleted()
	{	
		Drpinit();
		cal=Calendar.getInstance();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}
		info=new StatisticsInfo();
		Date start=info.getYearFirst(year);
		Date end=info.getYearLast(year);
		
		coll=IndustryProjectProvider.GetListByCompletetime(end);
		info.setCount(coll.size());
		for(IndustryProjectInfo temp:coll)
		{
			info.setValue(info.getValue()+temp.getTotalinvest());
		}
		if(export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(ProjectReport.PROJECTCOMPLETED);
			List Columns=new ArrayList();
			Columns.add("序号");
			Columns.add("项目名称");
			Columns.add("项目类型");
			Columns.add("所属地区");
			Columns.add("项目内容");
			Columns.add("总投资");
			Columns.add("开始时间");
			Columns.add("开始时间");
			info.createHead(wb, Columns);
			int rowcount=1;
			for(IndustryProjectInfo project: coll)
			{
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(project.getProjectname());
				datas.add(project.getObjProfessionInfoByIndustryid().getBusinesstypename());
				datas.add(project.getObjRegionsInfoByRegionid().getRegionname());
				datas.add(project.getProcontent());
				datas.add(project.getTotalinvest());
				datas.add(df.format(project.getCreatetime()));
				if(project.getCompletetime()!=null)
				{
					datas.add(df.format(project.getCompletetime()));
				}
				else
				{
					datas.add("");
				}
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(5).setCellValue(info.getValue());
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=PROJECTCOMPLETED;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
			
		}
		return "projectcompleted";
	}
	
	//按时间计算总投资	
	public String ProjectTotalInvest()
	{
		Drpinit();
		cal=Calendar.getInstance();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}
		info=new StatisticsInfo();
		Date start=info.getYearFirst(year);
		Date end=info.getYearLast(year);
		coll=IndustryProjectProvider.GetListPager_lessthan_ByCreatetime(end,  1, IndustryProjectProvider.GetListPager_lessthan_ByCreatetime(end));
		info.getValues().put("count", coll.size());
		double total=0d;
		double plan=0d;
		double yearinvest=0d;
		double real=0d;
		for(IndustryProjectInfo temp:coll)
		{
			total+=temp.getTotalinvest();
			plan+=temp.getPlaninvest();
			real+=temp.getRealinvest();
			yearinvest+=(temp.getRealinvest()-temp.getYearinvest());
		}
		info.getValues().put("total", total);
		info.getValues().put("plan", plan);
		info.getValues().put("real", real);
		info.getValues().put("yearinvest", yearinvest);
		if(export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(PROJECTTOTALINVEST);
			List Columns=new ArrayList();
			Columns.add("序号");
			Columns.add("项目名称");
			Columns.add("开始时间");
			Columns.add("结束时间");
			Columns.add("计划总投资");
			Columns.add("今年计划投资");
			Columns.add("实际已完成投资");
			Columns.add("今年已完成投资");
			info.createHead(wb, Columns);
			int rowcount=1;
			for(IndustryProjectInfo project:coll)
			{
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(project.getObjEnterpriseInfoByDatabaseenterpriseid().getEnterprisename());
				datas.add(df.format(project.getCreatetime()));
				if(project.getCompletetime()!=null)
				{
					datas.add(df.format(project.getCompletetime()));
				}
				else
				{
					datas.add("");	
				}
				
				datas.add(project.getTotalinvest());
				datas.add(project.getPlaninvest());
				datas.add(project.getRealinvest());
				datas.add(project.getRealinvest()-project.getYearinvest());
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(4).setCellValue(total);
			row.createCell(5).setCellValue(plan);
			row.createCell(6).setCellValue(real);
			row.createCell(7).setCellValue(yearinvest);
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=PROJECTTOTALINVEST;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "success";
		}
		return "totalinvest";
	}
	public String ProjectByType()
	{
		Drpinit();
		cal=Calendar.getInstance();
		ProjectList=new ArrayList();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}
		info=new StatisticsInfo();
		Date start=info.getYearFirst(year);
		Date end=info.getYearLast(year);
		ProfessionInfoCollection professions= ProfessionProvider.getProfessionStatic();
		int projectcount=IndustryProjectProvider.CountBy();
		this.request.setAttribute("projectcount", projectcount);
		double plan=0d;
		double yearinvest=0d;
		if(projecttype==0)
		{
			for(ProfessionInfo p: professions)
			{
				coll=IndustryProjectProvider.GetListPagerByCreatetimeIndustryid( end, p.getBusinessdatabaseid(), "projectid", 1, IndustryProjectProvider.GetListPagerByCreatetimeIndustryid( end, p.getBusinessdatabaseid()));
				if(coll.size()==0)
				{	
					IndustryProjectInfo pro=new IndustryProjectInfo();
					pro.setIndustryid(p.getBusinessdatabaseid());
					coll.add(pro);
				}
				ProjectList.add(coll);
			}
		}
		else
		{	
			coll=IndustryProjectProvider.GetListPagerByCreatetimeIndustryid( end, projecttype, "projectid", 1, IndustryProjectProvider.GetListPagerByCreatetimeIndustryid( end, projecttype));
			ProjectList.add(coll);
		}
		for(int i=0;i<ProjectList.size();i++)
		{
			IndustryProjectInfoCollection temp =(IndustryProjectInfoCollection)ProjectList.get(i);
			for(IndustryProjectInfo temp1:temp)
			{
				plan+=temp1.getPlaninvest();
				yearinvest+=(temp1.getRealinvest()-temp1.getYearinvest());
				
			}
			
		}
	
		info.getValues().put("plan", plan);
		info.getValues().put("yearinvest", yearinvest);
		if(export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(PROJECTBYTYPE);
			List Columns=new ArrayList();
			Columns.add("序号");
			Columns.add("类别名称");
			Columns.add("项目编号");
			Columns.add("项目名称");
			Columns.add("开始时间");
			Columns.add("完成时间");
			Columns.add("计划投资");
			Columns.add("年度投资");
			Columns.add("比例");
			info.createHead(wb, Columns);
			int rowcount=1;
			int typecount=0;
			DecimalFormat decimalformat=(DecimalFormat)NumberFormat.getInstance();
			decimalformat.applyPattern("##.##%");
			for(int i=0,j=ProjectList.size();i<j;i++)
			{
				IndustryProjectInfoCollection temp =(IndustryProjectInfoCollection)ProjectList.get(i);
				typecount++;
				int typesize=temp.size();
				for(IndustryProjectInfo project:temp)
				{	
					List datas=new ArrayList();
					datas.add(typecount);
					datas.add(project.getObjProfessionInfoByIndustryid().getBusinesstypename());
					datas.add(project.getProjectid());
					datas.add(project.getProjectname());
					datas.add(df.format(project.getCreatetime()));
					if(project.getCompletetime()!=null)
					{
						datas.add(df.format(project.getCompletetime()));
					}
					else
					{
						datas.add("");
					}
					datas.add(project.getPlaninvest());
					datas.add(project.getRealinvest()-project.getYearinvest());
					datas.add(decimalformat.format(typesize/Double.valueOf(projectcount)));
					HSSFRow row=sheet.createRow(rowcount++);
					info.createRow(wb, row, datas);
				}
				int firstrow=rowcount-typesize;
		    	int lastrow=rowcount;
		    	sheet.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,0,0));
		    	sheet.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,1,1));
		    	sheet.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,8,8));
			}
			HSSFRow row =sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(6).setCellValue(plan);
			row.createCell(7).setCellValue(yearinvest);
			row.createCell(8).setCellValue("100%");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=PROJECTBYTYPE;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
		return "bytype";
	}
	private int projectregion=0;
	private Date end;
	private Date start;
	
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public int getProjectregion() {
		return projectregion;
	}

	public void setProjectregion(int projectregion) {
		this.projectregion = projectregion;
	}

	public String ProjectByRegion()
	{	
		Drpinit();
		cal=Calendar.getInstance();
		ProjectList=new ArrayList();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}
		info=new StatisticsInfo();
		start = info.getYearFirst(year);
		end = info.getYearLast(year);
		RegionsInfoCollection regions=RegionsProvider.getRegionsStatic();
		int projectcount=IndustryProjectProvider.CountBy();
		this.request.setAttribute("projectcount", projectcount);
		double plan=0d;
		double yearinvest=0d;
		if(projectregion==0)
		{
			for(RegionsInfo region: regions)
			{
				
				coll=IndustryProjectProvider.GetListPagerByCreatetimeRegionid( end, region.getRegiondatabaseid(), "projectid", 1, IndustryProjectProvider.GetListPagerByCreatetimeRegionid( end, region.getRegiondatabaseid()));
				if(coll.size()==0)
				{	
					IndustryProjectInfo pro=new IndustryProjectInfo();
					pro.setRegionid(region.getRegiondatabaseid());
					coll.add(pro);
				}
				ProjectList.add(coll);
			}
		}
		else
		{	
			coll=IndustryProjectProvider.GetListPagerByCreatetimeRegionid( end, projectregion, "projectid", 1, IndustryProjectProvider.GetListPagerByCreatetimeRegionid( end, projectregion));
			ProjectList.add(coll);
		}
		for(int i=0;i<ProjectList.size();i++)
		{
			IndustryProjectInfoCollection temp =(IndustryProjectInfoCollection)ProjectList.get(i);
			for(IndustryProjectInfo temp1:temp)
			{
				plan+=temp1.getPlaninvest();
				yearinvest+=(temp1.getRealinvest()-temp1.getYearinvest());
				
			}
			
		}
	
		info.getValues().put("plan", plan);
		info.getValues().put("yearinvest", yearinvest);
		if(export)
		{
			HSSFWorkbook wb =new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(PROJECTBYREGION);
			List list=new ArrayList();
			list.add("序号");
			list.add("地区名称");
			list.add("项目编号");
			list.add("项目名称");
			list.add("开始时间");
			list.add("完成时间");
			list.add("计划投资");
			list.add("年度投资");
			list.add("比例");
			info.createHead(wb, list);
			int rowcount=1;
			int typecount=0;
			DecimalFormat decimalformat=(DecimalFormat)NumberFormat.getInstance();
			decimalformat.applyPattern("##.##%");
			for(int i=0,j=ProjectList.size();i<j;i++)
			{
				IndustryProjectInfoCollection temp =(IndustryProjectInfoCollection)ProjectList.get(i);
				typecount++;
				int typesize=temp.size();
				for(IndustryProjectInfo project:temp)
				{	
					List datas=new ArrayList();
					datas.add(typecount);
					datas.add(project.getObjRegionsInfoByRegionid().getRegionname());
					datas.add(project.getProjectid());
					datas.add(project.getProjectname());
					datas.add(df.format(project.getCreatetime()));
					if(project.getCompletetime()!=null)
					{
						datas.add(df.format(project.getCompletetime()));
					}
					else
					{
						datas.add("");
					}
					datas.add(project.getPlaninvest());
					datas.add(project.getRealinvest()-project.getYearinvest());
					datas.add(decimalformat.format(typesize/Double.valueOf(projectcount)));
					HSSFRow row=sheet.createRow(rowcount++);
					info.createRow(wb, row, datas);
				}
				int firstrow=rowcount-typesize;
		    	int lastrow=rowcount;
		    	sheet.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,0,0));
		    	sheet.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,1,1));
		    	sheet.addMergedRegion(new CellRangeAddress(firstrow,lastrow-1,8,8));
			}
			HSSFRow row =sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(6).setCellValue(plan);
			row.createCell(7).setCellValue(yearinvest);
			row.createCell(8).setCellValue("100%");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			ProjectByRegion projectchart=new ProjectByRegion();
			projectchart.setCreatetime1(end);
			projectchart.execute();
			JFreeChart chart=projectchart.getChart();
			try {
				ByteArrayOutputStream ImageOut = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsPNG(ImageOut, chart,700,400);
				HSSFPatriarch patriarch=  sheet.createDrawingPatriarch();
				HSSFClientAnchor anchor= new HSSFClientAnchor(1,1,1023,255,(short)0,rowcount+1,(short)5,rowcount+20);
				anchor.setAnchorType(HSSFClientAnchor.MOVE_AND_RESIZE);
				int index= wb.addPicture(ImageOut.toByteArray(), HSSFPicture.PICTURE_TYPE_PNG);
				patriarch.createPicture(anchor, index); 
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=PROJECTBYREGION;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "success";
		}
		return "byregion";
	}
	
	//加载选项
	private void Drpinit()
	{
		cal= Calendar.getInstance();
		int currentYear=cal.get(Calendar.YEAR);
		cal.roll(Calendar.YEAR, -100);
		int startYear=cal.get(Calendar.YEAR);
		String YearSelect="";
		boolean falg=true;
		while(currentYear>=startYear)
		{	
			if(falg)
			{	
				falg=false;
				YearSelect+=String.format("<option value='%s' selected='selected'>%s</option>",new Object[]{currentYear,currentYear} );
			}
			else
			{
				YearSelect+=String.format("<option value='%s'>%s</option>",new Object[]{currentYear,currentYear} );
			}
			
			currentYear--;
		}
		StringBuilder sbStr=new StringBuilder();
	  ProfessionInfoCollection professions=ProfessionProvider.getProfessionStatic();
		for(ProfessionInfo info:professions)
		{
			sbStr.append(String.format("<option value=%s>%s</option>", new Object[]{info.getBusinessdatabaseid(),info.getBusinesstypename()}));
		}
		this.request.setAttribute("projecttypelist", sbStr.toString());
		this.request.setAttribute("YearSelect", YearSelect);
		RegionsInfoCollection regions=RegionsProvider.getRegionsStatic();
		 StringBuilder sbStr1= new StringBuilder();
		 for(RegionsInfo region:regions)
		 {
			 sbStr1.append(String.format("<option value=%s>%s</option>", new Object[]{region.getRegiondatabaseid(),region.getRegionname()}));
		 }
		 
		 this.request.setAttribute("projectregionlist", sbStr1.toString());
	}
	
	 
	
}

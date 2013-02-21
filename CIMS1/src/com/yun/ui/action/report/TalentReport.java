package com.yun.ui.action.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.AgeProvider;
import com.yun.bll.culture.EducationProvider;
import com.yun.bll.culture.PostProvider;
import com.yun.bll.culture.ProfessionProvider;
import com.yun.bll.culture.TalentProvider;
import com.yun.common.StatisticsInfo;
import com.yun.entities.culture.AgeInfo;
import com.yun.entities.culture.EducationInfo;
import com.yun.entities.culture.PostInfo;
import com.yun.entities.culture.ProfessionInfo;
import com.yun.entities.culture.TalentInfo;
import com.yun.entities.culture.base.ProfessionInfoBase.ProfessionColumnNameEnum;
import com.yun.entities.culture.collection.AgeInfoCollection;
import com.yun.entities.culture.collection.EducationInfoCollection;
import com.yun.entities.culture.collection.PostInfoCollection;
import com.yun.entities.culture.collection.ProfessionInfoCollection;
import com.yun.entities.culture.collection.TalentInfoCollection;
import com.yun.ui.action.UserLook;
import com.yun.ui.action.chart.TalentAge;

public class TalentReport extends ActionSupport{
	
	private TalentInfoCollection coll=null;
	private Calendar cal;
	private List talentList;
	private int talenttype=0;
	private int talenteducation=0;
	private int talentpost=0;
	private int talentage=0;
	private int year=0;
	private Date start;
	private Date end;
	private StatisticsInfo info=null;
	private List infos=null;
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	private UserLook userlook=new UserLook(this.request,this.response);
	private String fileName;
	private InputStream inputStream;
	private boolean Export=false;
	static private  final String TALENTNEWLY="年度新增文化人才统计";
	static private  final String TALENTBYTYPE="年度人才行业统计";
	static private  final String TALENTBYAGE="年度人才年龄分析";
	static private  final String TALENTBYENDUCATION="年度人才学历结构分析";
	static private  final String TALENTBYPOST="年度人才职称结构分析";
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public boolean isExport() {
		return Export;
	}
	public void setExport(boolean export) {
		Export = export;
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
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		userlook.seePageY("14");
	}
	public List getInfos() {
		return infos;
	}
	public void setInfos(List infos) {
		this.infos = infos;
	}
	public StatisticsInfo getInfo() {
		return info;
	}
	public void setInfo(StatisticsInfo info) {
		this.info = info;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public TalentInfoCollection getColl() {
		return coll;
	}
	public void setColl(TalentInfoCollection coll) {
		this.coll = coll;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public List getTalentList() {
		
		return talentList;
	}
	public void setTalentList(List talentList) {
		this.talentList = talentList;
	}
	public int getTalenttype() {
		return talenttype;
	}
	public void setTalenttype(int talenttype) {
		this.talenttype = talenttype;
	}
	public int getTalenteducation() {
		return talenteducation;
	}
	public void setTalenteducation(int talenteducation) {
		this.talenteducation = talenteducation;
	}
	public int getTalentpost() {
		return talentpost;
	}
	public void setTalentpost(int talentpost) {
		this.talentpost = talentpost;
	}
	public int getTalentage() {
		return talentage;
	}
	public void setTalentage(int talentage) {
		this.talentage = talentage;
	}
	
	
	
	//action Methods
	public String Talentnewly()
	{	
		initValues();
		coll=TalentProvider.GetListPagerByLogintime(end, 1, TalentProvider.GetListPagerByLogintime(end));
		if(Export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(TALENTNEWLY);
			List list =new ArrayList();
			list.add("序号");
			list.add("姓名");
			list.add("姓别");
			list.add("年龄");
			list.add("学历");
			list.add("专业");
			list.add("职称");
			info.createHead(wb, list);
			int rowcount=1;
			Calendar cal1=Calendar.getInstance();
			int currentYear=cal1.get(Calendar.YEAR);
			Calendar cal2=Calendar.getInstance();
			for(TalentInfo talent:coll)
			{
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(talent.getTalentname());
				datas.add(talent.getSexlabel());
				cal2.setTime(talent.getBirthday());
				datas.add(currentYear-cal2.get(Calendar.YEAR));
				datas.add(talent.getObjEducationInfoByEducationid().getEducationname());
				datas.add(talent.getObjMajorInfoByMajorid().getMajorname());
				datas.add(talent.getObjPostInfoByPosttitleid().getTitlename());
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=TALENTNEWLY;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
		return "talentnewly";
	}

	public String Talentbytype()
	{
		initValues();
		double sum=TalentProvider.CountBy();
		ProfessionInfoCollection professions=new ProfessionInfoCollection();
		if(talenttype==0)
		{
			professions=ProfessionProvider.getProfessionStatic();
		}
		else
		{
			professions=ProfessionProvider.GetListByBusinessdatabaseid(talenttype);
		}
		professions.sort(ProfessionColumnNameEnum.Businesstypeid,true);
		infos=new ArrayList();
		info=new StatisticsInfo();
		StringBuilder sbStr=new StringBuilder();
		int currentsum=0;
		for(ProfessionInfo profession:professions)
		{
			TalentInfoCollection talents =TalentProvider.GetListByTalentprofessionidLogintime(profession.getBusinessdatabaseid(), end);
			StatisticsInfo temp=new StatisticsInfo();
			temp.setCount(talents.size());
			temp.setItemname(profession.getBusinesstypename());
			temp.setPercent(new Integer((int)(new Double(temp.getCount()/sum)*100)).toString());
			currentsum+=temp.getCount();
			
			infos.add(temp);
		}
		professions=ProfessionProvider.getProfessionStatic();
		for(ProfessionInfo profession:professions)
		{
			sbStr.append(String.format("<option value=%s>%s</option>", new Object[]{profession.getBusinessdatabaseid(),profession.getBusinesstypename()}));
		}
		this.request.setAttribute("talenttypelist", sbStr.toString());
		info.setNumber(new Integer(currentsum).toString());
		if(Export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(TALENTBYTYPE);
			List list=new ArrayList();
			list.add("序号");
			list.add("行业类别");
			list.add("人数");
			list.add("比例");
			info.createHead(wb, list);
			int rowcount=1;
			for(int i=0;i<infos.size();i++)
			{
				StatisticsInfo temp=(StatisticsInfo)infos.get(i);
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(temp.getItemname());
				datas.add(temp.getCount());
				datas.add(temp.getPercent()+"%");
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(2).setCellValue(info.getNumber());
			row.createCell(3).setCellValue("100%");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=TALENTBYTYPE;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
		return "talentbytype";
	}
	public String Talentbyage()
	{	
		initValues();
		double sum=TalentProvider.CountBy();
		AgeInfoCollection ages=new AgeInfoCollection();
		if(talentage==0)
		{
			ages=AgeProvider.getAgeStatic();
		}
		else
		{
			ages=AgeProvider.GetListByAgedatabaseid(talentage);
		}
		info=new StatisticsInfo();
		infos=new ArrayList();
		StringBuilder sbStr=new StringBuilder();
		int currentsum=0;
		for(AgeInfo age:ages)
		{	

			String[] agevalue=age.getAgename().split("-");
			int talentcount=TalentProvider.CountByAgeRange(new Integer(agevalue[0]), new Integer(agevalue[1]),end);
			StatisticsInfo temp=new StatisticsInfo();
			temp.setCount(talentcount);
			temp.setItemname(age.getAgename());
			temp.setPercent(new Integer((int)(new Double(temp.getCount()/sum)*100)).toString());
			currentsum+=talentcount;
			infos.add(temp);
		}
		ages=AgeProvider.getAgeStatic();
		for(AgeInfo age:ages)
		{
			
			sbStr.append(String.format("<option value=%s>%s</option>", new Object[]{age.getAgedatabaseid(),age.getAgename()}));
		}
		this.request.setAttribute("agerangelist", sbStr.toString());
		info.setNumber(new Integer(currentsum).toString());
		if(Export)
		{	
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(TALENTBYAGE);
			List list=new ArrayList();
			list.add("序号");
			list.add("年龄断");
			list.add("人数");
			list.add("比例");
			info.createHead(wb, list);
			int rowcount=1;
			for(int i=0;i<infos.size();i++)
			{	
				StatisticsInfo temp=(StatisticsInfo)infos.get(i);
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(temp.getItemname());
				datas.add(temp.getCount());
				datas.add(temp.getPercent()+"%");
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(2).setCellValue(info.getNumber());
			row.createCell(3).setCellValue("100%");
			TalentAge talentagechart=new TalentAge();
			try {
				talentagechart.setEnd(end);
				talentagechart.execute();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JFreeChart chart=talentagechart.getChart();
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				ByteArrayOutputStream ImageOut = new ByteArrayOutputStream();
				ChartUtilities.writeChartAsPNG(ImageOut, chart,600,400);
				HSSFPatriarch patriarch=  sheet.createDrawingPatriarch();
				HSSFClientAnchor anchor= new HSSFClientAnchor(1,1,1023,255,(short)0,rowcount+1,(short)5,rowcount+20);
				anchor.setAnchorType(HSSFClientAnchor.MOVE_AND_RESIZE);
				int index= wb.addPicture(ImageOut.toByteArray(), HSSFPicture.PICTURE_TYPE_PNG);
				patriarch.createPicture(anchor, index); 
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=TALENTBYAGE;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return "success";
		}
		return "talentbyage";
	}
	public String Talentbyeducation()
	{	
		initValues();
		double sum=TalentProvider.CountBy();
		infos=new ArrayList();
		info=new StatisticsInfo();
		StringBuilder sbStr=new StringBuilder();
		EducationInfoCollection educations=new EducationInfoCollection();
		if(talenteducation==0)
		{
			 educations=EducationProvider.getEducationStatic();
		}
		else
		{
			educations=EducationProvider.GetListByEducationdatabaseid(talenteducation);
		}
		int currentsum=0;
		for(EducationInfo education:educations)
		{
			int talentcount=TalentProvider.GetListByEducationidLogintime(education.getEducationdatabaseid(), end).size();
			StatisticsInfo temp=new StatisticsInfo();
			temp.setCount(talentcount);
			temp.setItemname(education.getEducationname());
			temp.setPercent(new Integer((int)(new Double(temp.getCount()/sum)*100)).toString());
			currentsum+=talentcount;
			infos.add(temp);
		}
		educations=EducationProvider.getEducationStatic();
		for(EducationInfo education:educations)
		{
			sbStr.append(String.format("<option value=%s>%s</option>", new Object[]{education.getEducationdatabaseid(),education.getEducationname()}));
		}
		this.request.setAttribute("educationtypelist", sbStr.toString());
		info.setNumber(new Integer(currentsum).toString());
		if(Export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(TALENTBYENDUCATION);
			List list=new ArrayList();
			list.add("序号");
			list.add("学历");
			list.add("人数");
			list.add("比例");
			info.createHead(wb, list);
			int rowcount=1;
			for(int i=0;i<infos.size();i++)
			{	
				StatisticsInfo temp=(StatisticsInfo)infos.get(i);
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(temp.getItemname());
				datas.add(temp.getCount());
				datas.add(temp.getPercent()+"%");
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(2).setCellValue(info.getNumber());
			row.createCell(3).setCellValue("100%");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=TALENTBYENDUCATION;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
			
		}
		return "talentbyeducation";
	}
	public String Talentbypost()
	{	
		initValues();
		double sum=TalentProvider.CountBy();
		infos=new ArrayList();
		info=new StatisticsInfo();
		StringBuilder sbStr=new StringBuilder();
		PostInfoCollection posts=new PostInfoCollection();
		if(talentpost==0)
		{
			 posts=PostProvider.getPostStatic();
		}
		else
		{
			posts=PostProvider.GetListByTitledatabaseid(talentpost);
		}
		int currentsum=0;
		for(PostInfo post:posts)
		{
			int talentcount=TalentProvider.GetListByPosttitleidLogintime(post.getTitledatabaseid(), end).size();
			StatisticsInfo temp=new StatisticsInfo();
			temp.setCount(talentcount);
			temp.setItemname(post.getTitlename());
			temp.setPercent(new Integer((int)(new Double(temp.getCount()/sum)*100)).toString());
			currentsum+=talentcount;
			infos.add(temp);
		}
		posts=PostProvider.getPostStatic();
		for(PostInfo post:posts)
		{
			sbStr.append(String.format("<option value=%s>%s</option>", new Object[]{post.getTitledatabaseid(),post.getTitlename()}));
		}
		this.request.setAttribute("posttypelist", sbStr.toString());
		info.setNumber(new Integer(currentsum).toString());
		if(Export)
		{
			HSSFWorkbook wb=new HSSFWorkbook();
			HSSFSheet sheet=wb.createSheet(TALENTBYPOST);
			List list=new ArrayList();
			list.add("序号");
			list.add("职称");
			list.add("人数");
			list.add("比例");
			info.createHead(wb, list);
			int rowcount=1;
			for(int i=0;i<infos.size();i++)
			{	
				StatisticsInfo temp=(StatisticsInfo)infos.get(i);
				List datas=new ArrayList();
				datas.add(rowcount);
				datas.add(temp.getItemname());
				datas.add(temp.getCount());
				datas.add(temp.getPercent()+"%");
				HSSFRow row=sheet.createRow(rowcount++);
				info.createRow(wb, row, datas);
			}
			HSSFRow row=sheet.createRow(rowcount++);
			row.createCell(0).setCellValue("合计");
			row.createCell(2).setCellValue(info.getNumber());
			row.createCell(3).setCellValue("100%");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			try {
				wb.write(os);
				inputStream=new ByteArrayInputStream(os.toByteArray());
				os.close();
				this.fileName=TALENTBYPOST;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
		return "talentbypost";
	}
	private void initValues()
	{
		
		cal=Calendar.getInstance();
		info=new StatisticsInfo();
		if(year==0)
		{
			year=cal.get(Calendar.YEAR);
		}
		start=info.getYearFirst(year);
		end=info.getYearLast(year);
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
		this.request.setAttribute("YearSelect", YearSelect);	
	}
	
}

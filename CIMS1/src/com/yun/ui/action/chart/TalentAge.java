package com.yun.ui.action.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.activation.URLDataSource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.imageio.plugins.common.ImageUtil;
import com.yun.bll.culture.AgeProvider;
import com.yun.bll.culture.TalentProvider;
import com.yun.entities.culture.AgeInfo;

public class TalentAge 
{
	
	JFreeChart chart;
	HttpServletRequest request=ServletActionContext.getRequest();
	
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	Map<String,Double> statistics=new HashMap<String, Double>();
	
	public Map<String, Double> getStatistics() {
		return statistics;
	}
	public void setStatistics(Map<String, Double> statistics) {
		this.statistics = statistics;
	}
	private Date end=new Date();
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		getData();
		if(statistics.size()>0)
		{
			DefaultPieDataset ds =new DefaultPieDataset();
			Iterator<String> it= statistics.keySet().iterator();
			while(it.hasNext())
			{	
				String key=it.next();
				ds.setValue(key,statistics.get(key) );
			} 
			String titlename = "人才年龄统计";
			Font bigFont = new Font("宋体", Font.BOLD, 15);
			Font middleFont = new Font("黑体", Font.BOLD, 14);
			chart = ChartFactory.createPieChart(titlename, ds, true,
					false, false);
			
			PiePlot plot = (PiePlot) chart.getPlot();
			String path=this.request.getSession().getServletContext().getRealPath("\\img\\loginBGimg.jpg");
			File file=new File(path);
			BufferedImage image= ImageIO.read(file);
			
			plot.setBackgroundImage(image);
			chart.setBackgroundImage(image);
			plot.setLabelFont(middleFont);
			plot.setBackgroundAlpha(0.2f);
		    TextTitle title = new TextTitle("测试饼状图", new Font("宋体", Font.BOLD, 20));  
		        // 解决曲线图片标题中文乱码问题  
		        chart.setTitle(title);  
		        //通过JFreeChart 对象获得 plot：PiePlot！！  
		        PiePlot pieplot = (PiePlot)chart.getPlot();   
		        // 没有数据的时候显示的内容  
		        pieplot.setNoDataMessage("No data available");   
		        // 设置无数据时的信息显示颜色  
		        pieplot.setNoDataMessagePaint(Color.red);  

		    
		        //设置背景透明度  
		        pieplot.setBackgroundAlpha(0.9f);  
		        //设置前景透明度  
		        pieplot.setForegroundAlpha(0.6f);  
		        // 指定饼图轮廓线的颜色  
		        pieplot.setBaseSectionOutlinePaint(Color.white);  
		        pieplot.setBaseSectionPaint(Color.BLACK);  
		        // 指定显示的饼图上圆形(true)还椭圆形(false)  
		        pieplot.setCircular(true);  
		        //("{0}: ({1}，{2})")是生成的格式，  
		        //{0}表示数据名，{1}表示数据的值，{2}表示百分比。可以自定义。  
		        //而new DecimalFormat("0.00%")表示小数点后保留两位。  
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator(   
	                ("{0}({1}):{2}"), NumberFormat.getNumberInstance(),   
	                new DecimalFormat("0.00%")));   
			chart.setTitle(new TextTitle(titlename,bigFont));
		}
		return "suc";
	}
	public void getData()
	{	
		if(end==null)
		{
			end=new Date();
		}
		List<AgeInfo> AgeRanges=AgeProvider.GetListBy();
		for(AgeInfo a:AgeRanges) 
		{   
			String AgeRange=a.getAgename();
			String[] ages=AgeRange.split("-");
			double count= TalentProvider.CountByAgeRange(Integer.valueOf(ages[0]), Integer.valueOf(ages[1]),end);
			if(count>0)
			{	
				statistics.put(a.getAgename(), count);
			}
		}

	}
	
	
}

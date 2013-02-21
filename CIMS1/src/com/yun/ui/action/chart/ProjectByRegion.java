package com.yun.ui.action.chart;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import com.yun.bll.culture.EnterpriseProvider;
import com.yun.bll.culture.IndustryProjectProvider;
import com.yun.bll.culture.RegionsProvider;
import com.yun.entities.culture.RegionsInfo;
import com.yun.entities.culture.collection.RegionsInfoCollection;

public class ProjectByRegion {
	JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}
	HttpServletRequest request=ServletActionContext.getRequest();
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	private Date createtime1;
	
	public Date getCreatetime1() {
		return createtime1;
	}
	public void setCreatetime1(Date createtime1) {
		this.createtime1 = createtime1;
	}
	public String execute()
	{ 
		DefaultCategoryDataset dataset = getds();  
        chart = ChartFactory.createBarChart3D("按地区统计项目总量", // 图表标题  
                "", // 目录轴的显示标签  
                "个数", // 数值轴的显示标签  
                dataset, // 数据集  
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                true, // 是否显示图例(对于简单的柱状图必须是false)  
                false, // 是否生成工具  
                false // 是否生成URL链接  
                );  
          
        // 设置图显示标题  
        chart.setTitle(new TextTitle("按地区统计项目总量", new Font("黑体", Font.BOLD, 16)));  
        
        // 取得统一表的第一个图列  
        LegendTitle legend = chart.getLegend(0);  
        // 修改图例字体  
        legend.setItemFont(new Font("宋体", Font.BOLD, 14));  
        // 取得状图plot对象  
        CategoryPlot plot = (CategoryPlot) chart.getPlot();  
        // 设置柱状图各部分标签字体  
        CategoryAxis domainAxis = plot.getDomainAxis();  
        domainAxis.setLabelFont(new Font("隶书", Font.BOLD, 20));//X轴的标题文字字体  
        domainAxis.setTickLabelFont(new Font("隶书", Font.BOLD, 20));//X轴坐标上数值字体  
        NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();  
        rangeAxis.setLabelFont(new Font("隶书", Font.BOLD, 20));//y轴的标题文字字体  
        rangeAxis.setTickLabelFont(new Font("隶书", Font.BOLD, 20));// y轴坐标上数值字体  
        rangeAxis.setAutoTickUnitSelection(true);//数据轴的数据标签是否自动确定（默认为true） 
        rangeAxis.setLowerBound(0d); //数据轴上的显示最小值;
        rangeAxis.setStandardTickUnits( NumberAxis.createIntegerTickUnits());//数据轴的数据标签     
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); //X轴上的Lable让其45度倾斜  
        // 设置距离图片左端距离  
        domainAxis.setLowerMargin(0.02);  
        // 设置距离图片右端距离  
        domainAxis.setUpperMargin(0.02);  
        BarRenderer3D renderer = new BarRenderer3D() ;         
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()) ;         
        renderer.setBaseItemLabelsVisible(true) ;        
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT)) ;
        renderer.setItemLabelAnchorOffset(10D) ;
        renderer.setItemMargin(0.5);
        plot.setRenderer(renderer) ;
		String path=this.request.getSession().getServletContext().getRealPath("\\img\\loginBGimg.jpg");
		File file=new File(path);
		BufferedImage image=null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plot.setBackgroundImage(image);
		chart.setBackgroundImage(image);
		return "suc";
	}
	private DefaultCategoryDataset  getds()
	{	
		RegionsInfoCollection regions=RegionsProvider.GetListBy();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		for(RegionsInfo region:regions)
		{	
			dataset.addValue(IndustryProjectProvider.GetListPagerByCreatetimeRegionid(createtime1, region.getRegiondatabaseid()), region.getRegionname(), "");
		}
		return dataset;
	}
}

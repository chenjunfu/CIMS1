package com.yun.ui.action.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.EnterpriseProvider;
import com.yun.bll.culture.IndustryProjectProvider;
import com.yun.entities.culture.EnterpriseInfo;
import com.yun.entities.culture.IndustryProjectInfo;
import com.yun.entities.culture.collection.EnterpriseInfoCollection;
import com.yun.entities.culture.collection.IndustryProjectInfoCollection;

public class ValidateIndustryProject extends ActionSupport {
	private int projectid=0;
	private String projectname="";
	private int databaseprojectid=0;
	
	
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public int getDatabaseprojectid() {
		return databaseprojectid;
	}
	public void setDatabaseprojectid(int databaseprojectid) {
		this.databaseprojectid = databaseprojectid;
	}
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();

	public String ValidateNo() throws IOException
	{	
		PrintWriter out =response.getWriter();
		IndustryProjectInfoCollection ic=IndustryProjectProvider.GetListByProjectid(projectid);
		if(ic.size()>0)
		{
			IndustryProjectInfo project =ic.get(0);
			if(project.getDatabaseprojectid()!=databaseprojectid)
			{
				out.write("Message=0");
			}
			else
			{
				out.write("Message=1");
			}
		}
		else
		{
			out.write("Message=1");
		}
		return null;
	}
	public String ValidateName() throws IOException
	{
		PrintWriter out =response.getWriter();
		IndustryProjectInfoCollection ic=IndustryProjectProvider.GetListByProjectname(projectname);
		if(ic.size()>0)
		{
			IndustryProjectInfo project =ic.get(0);
			if(project.getDatabaseprojectid()!=databaseprojectid)
			{
				out.write("Message=0");
			}
			else
			{
				out.write("Message=1");
			}
		}
		else
		{
			out.write("Message=1");
		}
		return null;
	}
}

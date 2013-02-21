package com.yun.ui.action.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.EnterpriseProvider;
import com.yun.bll.culture.IndustryProjectProvider;
import com.yun.bll.culture.TalentProvider;
import com.yun.entities.culture.EnterpriseInfo;
import com.yun.entities.culture.IndustryProjectInfo;
import com.yun.entities.culture.TalentInfo;
import com.yun.entities.culture.collection.EnterpriseInfoCollection;
import com.yun.entities.culture.collection.IndustryProjectInfoCollection;
import com.yun.entities.culture.collection.TalentInfoCollection;

public class ValidateTalent extends ActionSupport {
	private int talentid=0;
	private String talentname="";
	private int databasetalentid=0;
	
	
	public int getTalentid() {
		return talentid;
	}
	public void setTalentid(int talentid) {
		this.talentid = talentid;
	}
	public String getTalentname() {
		return talentname;
	}
	public void setTalentname(String talentname) {
		this.talentname = talentname;
	}
	public int getDatabasetalentid() {
		return databasetalentid;
	}
	public void setDatabasetalentid(int databasetalentid) {
		this.databasetalentid = databasetalentid;
	}
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();

	public String ValidateNo() throws IOException
	{	
		PrintWriter out =response.getWriter();
		TalentInfoCollection tc=TalentProvider.GetListByTalentid(talentid);
		if(tc.size()>0)
		{		
			TalentInfo talent =tc.get(0);
			if(talent.getDatabasetalentid()!=databasetalentid)
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
		TalentInfoCollection tc=TalentProvider.GetListByTalentname(talentname);
		if(tc.size()>0)
		{
			TalentInfo talent =tc.get(0);
			if(talent.getDatabasetalentid()!=databasetalentid)
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

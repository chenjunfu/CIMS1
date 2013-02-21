package com.yun.ui.action.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.EnterpriseProvider;
import com.yun.entities.culture.EnterpriseInfo;
import com.yun.entities.culture.collection.EnterpriseInfoCollection;

public class ValidateEnterprise extends ActionSupport {
	private int enterpriseid=0;
	private String enterprisename="";
	private int databaseenterpriseid=0;
	private String enterprisecode="";
	private String partentcode="";
	
	
	 
	public String getEnterprisecode() {
		return enterprisecode;
	}
	public void setEnterprisecode(String enterprisecode) {
		this.enterprisecode = enterprisecode;
	}
	public String getPartentcode() {
		return partentcode;
	}
	public void setPartentcode(String partentcode) {
		this.partentcode = partentcode;
	}
	public int getDatabaseenterpriseid() {
		return databaseenterpriseid;
	}
	public void setDatabaseenterpriseid(int databaseenterpriseid) {
		this.databaseenterpriseid = databaseenterpriseid;
	}
	public int getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(int enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
	public String getEnterprisename() {
		return enterprisename;
	}
	public void setEnterprisename(String enterprisename) {
		this.enterprisename = enterprisename;
	}
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();

	public String ValidateNo() throws IOException
	{	
		PrintWriter out =response.getWriter();
		EnterpriseInfoCollection ec=EnterpriseProvider.GetListByEnterpriseid(this.enterpriseid);
		if(ec.size()>0)
		{
			EnterpriseInfo enterprise=ec.get(0);
			if(enterprise.getDatabaseenterpriseid()!=databaseenterpriseid)
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
		EnterpriseInfoCollection ec=EnterpriseProvider.GetListByEnterprisename(this.enterprisename);
		if(ec.size()>0)
		{
			EnterpriseInfo enterprise=ec.get(0);
			if(enterprise.getDatabaseenterpriseid()!=databaseenterpriseid)
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
	public String ValidateEnterpriseCode() throws IOException
	{
		PrintWriter out =response.getWriter();
		EnterpriseInfoCollection ec=EnterpriseProvider.GetListByEnterprisecode(this.enterprisecode);
		if(ec.size()>0)
		{
			EnterpriseInfo enterprise=ec.get(0);
			if(enterprise.getDatabaseenterpriseid()!=databaseenterpriseid)
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
	public String ValidatePartentCode() throws IOException
	{
		PrintWriter out =response.getWriter();
		EnterpriseInfoCollection ec=EnterpriseProvider.GetListByPartentcode(this.partentcode);
		if(ec.size()>0)
		{
			EnterpriseInfo enterprise=ec.get(0);
			if(enterprise.getDatabaseenterpriseid()!=databaseenterpriseid)
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

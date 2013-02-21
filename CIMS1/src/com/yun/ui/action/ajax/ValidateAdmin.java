package com.yun.ui.action.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.SystemAdminProvider;
import com.yun.entities.culture.SystemAdminInfo;
import com.yun.entities.culture.collection.SystemAdminInfoCollection;

public class ValidateAdmin extends ActionSupport {

	private int databaseadminid=0;
	private int adminid=0;
	private String workno="";
	private HttpServletRequest request;
	private HttpServletResponse response;
	

	public int getDatabaseadminid() {
		return databaseadminid;
	}
	public void setDatabaseadminid(int databaseadminid) {
		this.databaseadminid = databaseadminid;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getWorkno() {
		return workno;
	}
	public void setWorkno(String workno) {
		this.workno = workno;
	}
	public String ValidateAdminno() throws Exception {
		this.request=ServletActionContext.getRequest();
		this.response=ServletActionContext.getResponse();
		// TODO Auto-generated method stub
		SystemAdminInfoCollection ac=SystemAdminProvider.GetListByAdminid(adminid);
		if(ac.size()>0)
		{	
			SystemAdminInfo admin=ac.get(0);
			if(databaseadminid!=admin.getDatabaseadminid())
			{
				response.getWriter().write("message=0");
			}
			else
			{
				response.getWriter().write("message=1");
			}
		}
		else
		{
			response.getWriter().write("message=1");
		}
		return null;
	}
	public String ValidateAdminWorkno() throws Exception
	{
		this.request=ServletActionContext.getRequest();
		this.response=ServletActionContext.getResponse();
		// TODO Auto-generated method stub
		SystemAdminInfoCollection ac=SystemAdminProvider.GetListByWorkno(workno);
		if(ac.size()>0)
		{	
			SystemAdminInfo admin=ac.get(0);
			if(databaseadminid!=admin.getDatabaseadminid())
			{
				response.getWriter().write("message=0");
			}
			else
			{
				response.getWriter().write("message=1");
			}
		}
		else
		{
			response.getWriter().write("message=1");
		}
		return null;
	}
}

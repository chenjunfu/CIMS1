package com.yun.ui.action.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.SystemSectorProvider;
import com.yun.entities.culture.SystemSectorInfo;
import com.yun.entities.culture.collection.SystemSectorInfoCollection;

public class ValidateSector extends ActionSupport {
	
	private int sectordatabaseid=0;
	private int sectorid=0;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public int getSectordatabaseid() {
		return sectordatabaseid;
	}

	public void setSectordatabaseid(int sectordatabaseid) {
		this.sectordatabaseid = sectordatabaseid;
	}

	public int getSectorid() {
		return sectorid;
	}

	public void setSectorid(int sectorid) {
		this.sectorid = sectorid;
	}

	public String ValidateSectorId() throws Exception
	{	
		request=ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
		SystemSectorInfoCollection sc=SystemSectorProvider.GetListBySectorid(sectorid);
		if(sc.size()>0)
		{
			SystemSectorInfo secoter=sc.get(0);
			if(secoter.getSectordatabaseid()!=sectordatabaseid)
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
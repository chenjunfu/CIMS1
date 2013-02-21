package com.yun.ui.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.colorwinglib.*;
import com.yun.bll.culture.SystemRolesProvider;
import com.yun.bll.culture.SystemSectorProvider;

/**
 * 用户权限类
 *
 */
public class UserLook
{

	HttpServletRequest request;
	HttpServletResponse response;

	public UserLook(HttpServletRequest request, HttpServletResponse response)
	{
		this.request = request;
		this.response = response;
	}

	// [start] Methods
	// private Methods
	/**
	 * 是否使用Session存值
	 *
	 */
	private boolean isSession = true;

	/**
	 * 人员的权限
	 *
	 */
	private String getUserPurview()
	{
		// 实际使用时请修改这里的条件，返回用户登录的权限字段
		return getCompetence();
	}
	private String getRolesPurview()
	{
		return getRolecompetence();
	}
	/**
	 * 转道权限不足时页面(使用时请修改页面地址)
	 *
	 */
	private String strNoPurview = "/system/AdminLoginQXno.jsp";
	/**
	 * 转道退出页面(使用时请修改页面地址)
	 *
	 */
	private String strNoLogin = "/Admin/AdminLoginOut.jsp";

	// Methods
	// [end]
	// [start] 人员ID
	// 人员ID
    private int databaseadminid = 0; // 人员ID

	/**
	 * 人员ID
	 * @param value 人员ID
	 */
	public int getDatabaseadminid()
	{
			if (isSession)
			{
				databaseadminid = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("databaseadminid")));// 人员ID

			}
			else
			{
				databaseadminid = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("databaseadminid"))));// 人员ID

			}
		return databaseadminid;
	}

	/**
	 * 人员ID
	 */
	public void setDatabaseadminid(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("databaseadminid"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("databaseadminid"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		databaseadminid = value;
	}
	// [end]

	// [start] 人员编号
	// 人员编号
    private int adminid = 0; // 人员编号

	/**
	 * 人员编号
	 * @param value 人员编号
	 */
	public int getAdminid()
	{
			if (isSession)
			{
				adminid = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("adminid")));// 人员编号

			}
			else
			{
				adminid = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("adminid"))));// 人员编号

			}
		return adminid;
	}

	/**
	 * 人员编号
	 */
	public void setAdminid(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("adminid"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("adminid"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		adminid = value;
	}
	// [end]

	// [start] 帐号
	// 帐号
    private String adminname = ""; // 帐号

	/**
	 * 帐号
	 * @param value 帐号
	 */
	public String getAdminname()
	{
			if (isSession)
			{
				adminname = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("adminname")));// 帐号

			}
			else
			{
				adminname = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("adminname"))));// 帐号

			}
		return adminname;
	}

	/**
	 * 帐号
	 */
	public void setAdminname(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("adminname"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("adminname"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		adminname = value;
	}
	// [end]

	// [start] 密码
	// 密码
    private String adminpassword = ""; // 密码

	/**
	 * 密码
	 * @param value 密码
	 */
	public String getAdminpassword()
	{
			if (isSession)
			{
				adminpassword = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("adminpassword")));// 密码

			}
			else
			{
				adminpassword = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("adminpassword"))));// 密码

			}
		return adminpassword;
	}

	/**
	 * 密码
	 */
	public void setAdminpassword(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("adminpassword"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("adminpassword"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		adminpassword = value;
	}
	// [end]

	// [start] 性别：1-男、2-女
	// 性别：1-男、2-女
    private int sex = 0; // 性别：1-男、2-女

	/**
	 * 性别：1-男、2-女
	 * @param value 性别：1-男、2-女
	 */
	public int getSex()
	{
			if (isSession)
			{
				sex = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("sex")));// 性别：1-男、2-女

			}
			else
			{
				sex = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("sex"))));// 性别：1-男、2-女

			}
		return sex;
	}

	/**
	 * 性别：1-男、2-女
	 */
	public void setSex(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("sex"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("sex"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		sex = value;
	}
	// [end]

	// [start] 姓名
	// 姓名
    private String truename = ""; // 姓名

	/**
	 * 姓名
	 * @param value 姓名
	 */
	public String getTruename()
	{
			if (isSession)
			{
				truename = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("truename")));// 姓名

			}
			else
			{
				truename = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("truename"))));// 姓名

			}
		return truename;
	}

	/**
	 * 姓名
	 */
	public void setTruename(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("truename"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("truename"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		truename = value;
	}
	// [end]

	// [start] 工号
	// 工号
    private String workno = ""; // 工号

	/**
	 * 工号
	 * @param value 工号
	 */
	public String getWorkno()
	{
			if (isSession)
			{
				workno = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("workno")));// 工号

			}
			else
			{
				workno = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("workno"))));// 工号

			}
		return workno;
	}

	/**
	 * 工号
	 */
	public void setWorkno(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("workno"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("workno"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		workno = value;
	}
	// [end]

	// [start] 联系EMAIL
	// 联系EMAIL
    private String email = ""; // 联系EMAIL

	/**
	 * 联系EMAIL
	 * @param value 联系EMAIL
	 */
	public String getEmail()
	{
			if (isSession)
			{
				email = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("email")));// 联系EMAIL

			}
			else
			{
				email = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("email"))));// 联系EMAIL

			}
		return email;
	}

	/**
	 * 联系EMAIL
	 */
	public void setEmail(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("email"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("email"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		email = value;
	}
	// [end]

	// [start] 移动电话
	// 移动电话
    private String movephone = ""; // 移动电话

	/**
	 * 移动电话
	 * @param value 移动电话
	 */
	public String getMovephone()
	{
			if (isSession)
			{
				movephone = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("movephone")));// 移动电话

			}
			else
			{
				movephone = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("movephone"))));// 移动电话

			}
		return movephone;
	}

	/**
	 * 移动电话
	 */
	public void setMovephone(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("movephone"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("movephone"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		movephone = value;
	}
	// [end]

	// [start] 电话
	// 电话
    private String phone = ""; // 电话

	/**
	 * 电话
	 * @param value 电话
	 */
	public String getPhone()
	{
			if (isSession)
			{
				phone = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("phone")));// 电话

			}
			else
			{
				phone = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("phone"))));// 电话

			}
		return phone;
	}

	/**
	 * 电话
	 */
	public void setPhone(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("phone"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("phone"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		phone = value;
	}
	// [end]

	// [start] MSN
	// MSN
    private String msn = ""; // MSN

	/**
	 * MSN
	 * @param value MSN
	 */
	public String getMsn()
	{
			if (isSession)
			{
				msn = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("msn")));// MSN

			}
			else
			{
				msn = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("msn"))));// MSN

			}
		return msn;
	}

	/**
	 * MSN
	 */
	public void setMsn(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("msn"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("msn"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		msn = value;
	}
	// [end]
		
    private String rolecompetence ;
    
	public String getRolecompetence() {
		if (isSession)
		{
			rolecompetence = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("rolecompetence")));// 角色权限

		}
		else
		{
			rolecompetence = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("rolecompetence"))));// 角色权限

		}
		return rolecompetence;
	}

	public void setRolecompetence(String value) {
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("rolecompetence"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("rolecompetence"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		this.rolecompetence = value;
	}
	// [start] 角色编号
	// 角色编号
    private int rolesid = 0; // 角色编号

    
	/**
	 * 角色编号
	 * @param value 角色编号
	 */
	public int getRolesid()
	{
			if (isSession)
			{
				rolesid = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("rolesid")));// 角色编号

			}
			else
			{
				rolesid = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("rolesid"))));// 角色编号

			}
		return rolesid;
	}

	/**
	 * 角色编号
	 */
	public void setRolesid(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("rolesid"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("rolesid"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		rolesid = value;
	}
	// [end]

	// [start] 部门编号
	// 部门编号
    private int sectorid = 0; // 部门编号

	/**
	 * 部门编号
	 * @param value 部门编号
	 */
	public int getSectorid()
	{
			if (isSession)
			{
				sectorid = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("sectorid")));// 部门编号

			}
			else
			{
				sectorid = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("sectorid"))));// 部门编号

			}
		return sectorid;
	}

	/**
	 * 部门编号
	 */
	public void setSectorid(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("sectorid"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("sectorid"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		sectorid = value;
	}
	// [end]

	// [start] 人员描述
	// 人员描述
    private String description = ""; // 人员描述

	/**
	 * 人员描述
	 * @param value 人员描述
	 */
	public String getDescription()
	{
			if (isSession)
			{
				description = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("description")));// 人员描述

			}
			else
			{
				description = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("description"))));// 人员描述

			}
		return description;
	}

	/**
	 * 人员描述
	 */
	public void setDescription(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("description"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("description"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		description = value;
	}
	// [end]

	// [start] 通讯地址
	// 通讯地址
    private String address = ""; // 通讯地址

	/**
	 * 通讯地址
	 * @param value 通讯地址
	 */
	public String getAddress()
	{
			if (isSession)
			{
				address = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("address")));// 通讯地址

			}
			else
			{
				address = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("address"))));// 通讯地址

			}
		return address;
	}

	/**
	 * 通讯地址
	 */
	public void setAddress(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("address"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("address"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		address = value;
	}
	// [end]

	// [start] 限定IP
	// 限定IP
    private String limitIp = ""; // 限定IP

	/**
	 * 限定IP
	 * @param value 限定IP
	 */
	public String getLimitIp()
	{
			if (isSession)
			{
				limitIp = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("limitIp")));// 限定IP

			}
			else
			{
				limitIp = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("limitIp"))));// 限定IP

			}
		return limitIp;
	}

	/**
	 * 限定IP
	 */
	public void setLimitIp(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("limitIp"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("limitIp"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		limitIp = value;
	}
	// [end]

	// [start] 最后登录时间
	// 最后登录时间
    private Date lastLogintime = new Date(); // 最后登录时间

	/**
	 * 最后登录时间
	 * @param value 最后登录时间
	 */
	public Date getLastLogintime()
	{
			if (isSession)
			{
				lastLogintime = com.colorwinglib.Converts.StrToDate(request.getSession().getAttribute(getCookiesName("lastLogintime")));// 最后登录时间

			}
			else
			{
				lastLogintime = com.colorwinglib.Converts.StrToDate(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("lastLogintime"))));// 最后登录时间

			}
		return lastLogintime;
	}

	/**
	 * 最后登录时间
	 */
	public void setLastLogintime(Date value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("lastLogintime"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("lastLogintime"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		lastLogintime = value;
	}
	// [end]

	// [start] 最后登录IP
	// 最后登录IP
    private String lastLoginip = ""; // 最后登录IP

	/**
	 * 最后登录IP
	 * @param value 最后登录IP
	 */
	public String getLastLoginip()
	{
			if (isSession)
			{
				lastLoginip = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("lastLoginip")));// 最后登录IP

			}
			else
			{
				lastLoginip = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("lastLoginip"))));// 最后登录IP

			}
		return lastLoginip;
	}

	/**
	 * 最后登录IP
	 */
	public void setLastLoginip(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("lastLoginip"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("lastLoginip"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		lastLoginip = value;
	}
	// [end]

	// [start] 创建时间
	// 创建时间
    private Date createTime = new Date(); // 创建时间

	/**
	 * 创建时间
	 * @param value 创建时间
	 */
	public Date getCreateTime()
	{
			if (isSession)
			{
				createTime = com.colorwinglib.Converts.StrToDate(request.getSession().getAttribute(getCookiesName("createTime")));// 创建时间

			}
			else
			{
				createTime = com.colorwinglib.Converts.StrToDate(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("createTime"))));// 创建时间

			}
		return createTime;
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(Date value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("createTime"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("createTime"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		createTime = value;
	}
	// [end]

	// [start] 最后修改时间
	// 最后修改时间
    private Date lastModifytime = new Date(); // 最后修改时间

	/**
	 * 最后修改时间
	 * @param value 最后修改时间
	 */
	public Date getLastModifytime()
	{
			if (isSession)
			{
				lastModifytime = com.colorwinglib.Converts.StrToDate(request.getSession().getAttribute(getCookiesName("lastModifytime")));// 最后修改时间

			}
			else
			{
				lastModifytime = com.colorwinglib.Converts.StrToDate(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("lastModifytime"))));// 最后修改时间

			}
		return lastModifytime;
	}

	/**
	 * 最后修改时间
	 */
	public void setLastModifytime(Date value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("lastModifytime"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("lastModifytime"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		lastModifytime = value;
	}
	// [end]

	// [start] 启用标志：1-启用、2-未启用
	// 启用标志：1-启用、2-未启用
    private int isUse = 0; // 启用标志：1-启用、2-未启用

	/**
	 * 启用标志：1-启用、2-未启用
	 * @param value 启用标志：1-启用、2-未启用
	 */
	public int getIsUse()
	{
			if (isSession)
			{
				isUse = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("isUse")));// 启用标志：1-启用、2-未启用

			}
			else
			{
				isUse = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("isUse"))));// 启用标志：1-启用、2-未启用

			}
		return isUse;
	}

	/**
	 * 启用标志：1-启用、2-未启用
	 */
	public void setIsUse(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("isUse"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("isUse"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		isUse = value;
	}
	// [end]

	// [start] 是否删除：1-未删除、2-已删除
	// 是否删除：1-未删除、2-已删除
    private int isDel = 0; // 是否删除：1-未删除、2-已删除

	/**
	 * 是否删除：1-未删除、2-已删除
	 * @param value 是否删除：1-未删除、2-已删除
	 */
	public int getIsDel()
	{
			if (isSession)
			{
				isDel = com.colorwinglib.Converts.StrToInt(request.getSession().getAttribute(getCookiesName("isDel")));// 是否删除：1-未删除、2-已删除

			}
			else
			{
				isDel = com.colorwinglib.Converts.StrToInt(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("isDel"))));// 是否删除：1-未删除、2-已删除

			}
		return isDel;
	}

	/**
	 * 是否删除：1-未删除、2-已删除
	 */
	public void setIsDel(int value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("isDel"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("isDel"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		isDel = value;
	}
	// [end]

	// [start] 拥有权限
	// 拥有权限
    private String competence = ""; // 拥有权限

	/**
	 * 拥有权限
	 * @param value 拥有权限
	 */
	public String getCompetence()
	{		
			if (isSession)
			{
				competence = com.colorwinglib.Converts.objToStr(request.getSession().getAttribute(getCookiesName("competence")));// 拥有权限

			}
			else
			{
				competence = com.colorwinglib.Converts.objToStr(DecryptCookie(CookiesUtil.getCookie(request, getCookiesName("competence"))));// 拥有权限

			}
		return competence;
	}

	/**
	 * 拥有权限
	 */
	public void setCompetence(String value)
	{
		if (isSession)
		{
			request.getSession().setAttribute(getCookiesName("competence"), value);
		}
		else
		{
			CookiesUtil.setCookie(response, getCookiesName("competence"), StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(value)), getCookiesTime(), getDomain());
		}
		competence = value;
	}
	// [end]


	// Create
	/**
	 * 创建Cookie保存用户信息，登陆时使用
	 *
	 */
	public void Create()
	{
		if (isSession)
		{
		}
		else
		{
			setDatabaseadminid(getDatabaseadminid());//人员ID
			setAdminid(getAdminid());//人员编号
			setAdminname(getAdminname());//帐号
			setAdminpassword(getAdminpassword());//密码
			setSex(getSex());//性别：1-男、2-女
			setTruename(getTruename());//姓名
			setWorkno(getWorkno());//工号
			setEmail(getEmail());//联系EMAIL
			setMovephone(getMovephone());//移动电话
			setPhone(getPhone());//电话
			setMsn(getMsn());//MSN
			setRolesid(getRolesid());//角色编号
			setSectorid(getSectorid());//部门编号
			setDescription(getDescription());//人员描述
			setAddress(getAddress());//通讯地址
			setLimitIp(getLimitIp());//限定IP
			setLastLogintime(getLastLogintime());//最后登录时间
			setLastLoginip(getLastLoginip());//最后登录IP
			setCreateTime(getCreateTime());//创建时间
			setLastModifytime(getLastModifytime());//最后修改时间
			setIsUse(getIsUse());//启用标志：1-启用、2-未启用
			setIsDel(getIsDel());//是否删除：1-未删除、2-已删除
			setCompetence(getCompetence());//拥有权限
			setRolecompetence(SystemRolesProvider.GetSystemRolesInfoByDatabaserolesid(getRolesid()).getCompetenceid());
			
		}

	}

	// LoginOut
	/**
	 * 退出登陆
	 *
	 */
	public void LoginOut()
	{
		if (isSession)
		{
			request.getSession().removeAttribute(getCookiesName("databaseadminid"));// 人员ID
			request.getSession().removeAttribute(getCookiesName("adminid"));// 人员编号
			request.getSession().removeAttribute(getCookiesName("adminname"));// 帐号
			request.getSession().removeAttribute(getCookiesName("adminpassword"));// 密码
			request.getSession().removeAttribute(getCookiesName("sex"));// 性别：1-男、2-女
			request.getSession().removeAttribute(getCookiesName("truename"));// 姓名
			request.getSession().removeAttribute(getCookiesName("workno"));// 工号
			request.getSession().removeAttribute(getCookiesName("email"));// 联系EMAIL
			request.getSession().removeAttribute(getCookiesName("movephone"));// 移动电话
			request.getSession().removeAttribute(getCookiesName("phone"));// 电话
			request.getSession().removeAttribute(getCookiesName("msn"));// MSN
			request.getSession().removeAttribute(getCookiesName("rolesid"));// 角色编号
			request.getSession().removeAttribute(getCookiesName("sectorid"));// 部门编号
			request.getSession().removeAttribute(getCookiesName("description"));// 人员描述
			request.getSession().removeAttribute(getCookiesName("address"));// 通讯地址
			request.getSession().removeAttribute(getCookiesName("limitIp"));// 限定IP
			request.getSession().removeAttribute(getCookiesName("lastLogintime"));// 最后登录时间
			request.getSession().removeAttribute(getCookiesName("lastLoginip"));// 最后登录IP
			request.getSession().removeAttribute(getCookiesName("createTime"));// 创建时间
			request.getSession().removeAttribute(getCookiesName("lastModifytime"));// 最后修改时间
			request.getSession().removeAttribute(getCookiesName("isUse"));// 启用标志：1-启用、2-未启用
			request.getSession().removeAttribute(getCookiesName("isDel"));// 是否删除：1-未删除、2-已删除
			request.getSession().removeAttribute(getCookiesName("competence"));// 拥有权限
			request.getSession().removeAttribute(getCookiesName("rolecompetence"));
		}
		else
		{
			setDatabaseadminid(0);// 人员ID
			setAdminid(0);// 人员编号
			setAdminname("");// 帐号
			setAdminpassword("");// 密码
			setSex(0);// 性别：1-男、2-女
			setTruename("");// 姓名
			setWorkno("");// 工号
			setEmail("");// 联系EMAIL
			setMovephone("");// 移动电话
			setPhone("");// 电话
			setMsn("");// MSN
			setRolesid(0);// 角色编号
			setSectorid(0);// 部门编号
			setDescription("");// 人员描述
			setAddress("");// 通讯地址
			setLimitIp("");// 限定IP
			setLastLogintime(new Date());// 最后登录时间
			setLastLoginip("");// 最后登录IP
			setCreateTime(new Date());// 创建时间
			setLastModifytime(new Date());// 最后修改时间
			setIsUse(0);// 启用标志：1-启用、2-未启用
			setIsDel(0);// 是否删除：1-未删除、2-已删除
			setCompetence("");// 拥有权限
			setRolecompetence("");
		}
	}

	// [start] 加密Cookie
	// 加密Cookie
	/**
	 * 加密Cookie
	 *
	 * @param CookieValues需要加密的字符
	 *
	 */
	public String EncryptCookie(String CookieValues)
	{
		return Security.EncryptCookie(CookieValues);
	}
	// [end]

	// [start] 解密Cookie
	// 解密Cookie
	/**
	 * 解密Cookie
	 *
	 * @param CookieValues需要解密的字符
	 *
	 */
	public String DecryptCookie(String CookieValues)
	{
		return Security.DecryptCookie(StringFormat.UrlDecode(CookieValues));
	}
	// [end]

	// [start] 获取 Domain
	// Domain
	/**
	 * 获取 Domain
	 *
	 *
	 */
	private String getDomain()
	{
		return "";
	}
	// [end]

	// [start] 获取 CookiesName
	// CookiesName
	/**
	 * 获取 CookiesName
	 */
	private String getCookiesName(String cookiesName)
	{
		return String.format("%s%s", "AdminUserInfo", cookiesName);
	}
	// [end]

	// [start] 获取 Cookies过期时间
	// CookiesTime
	/**
	 * 获取 Cookies过期时间
	 */
	private int getCookiesTime()
	{
		return 20324;
	}
	// [end]

	// [start] isLogin 验证登录用户的基本权限，是否登陆
	// isLogin 验证登录用户的基本权限，是否登陆
	/**
	 * 验证登录用户的基本权限，是否登陆
	 */
	public boolean isLogin()
	{
		// 实际使用时请修改这里的条件，判断是否登录的
        if (getDatabaseadminid() != 0)
		{
			Create();
			return true;
		}
		else
		{
			return false;
		}
	}
	// [end]

	// [start] isLogin 验证登录用户的基本权限，是否登陆
	// isLoginRedirect 验证登录用户的基本权限，是否登陆
	/**
	 * 验证登录用户的基本权限，是否登陆，没有登录转到登录页面
	 *
	 * @param url登录页面
	 */
	public void isLoginRedirect()
	{
		isLoginRedirect(strNoLogin);
	}
	// [end]

	// [start] isLogin 验证登录用户的基本权限，是否登陆
	// isLoginRedirect 验证登录用户的基本权限，是否登陆
	/**
	 * 验证登录用户的基本权限，是否登陆，没有登录转到登录页面
	 *
	 * @param url登录页面
	 */
	public void isLoginRedirect(String url)
	{
		//这里修改为主键
        if (getDatabaseadminid() != 0)
		{
			Create();
		}
		else
		{
			String AbsoluteUri = request.getRequestURL().toString();
			if (request.getQueryString() != null)
				AbsoluteUri += "?" + request.getQueryString();
			try
			{
				// java.io.PrintWriter out = response.getWriter();
				// out.write("<script type='text/javascript'>window.location.href='/" + String.format(request.getContextPath() + "%s?url=%s", url, StringFormat.UrlEncode(AbsoluteUri)) + "'</script>");
				System.out.print("isLoginRedirect: ");
				System.out.println(String.format(request.getContextPath() + "%s?url=%s", url, StringFormat.UrlEncode(AbsoluteUri)));
				response.sendRedirect(String.format(request.getContextPath() + "%s?url=%s", url, StringFormat.UrlEncode(AbsoluteUri)));
				return;
			}
			catch (IOException e)
			{
				// e.printStackTrace();
			}

		}
	}
	// [end]

	// [start] seePageY 验证登录用户是否有访问本页面的权限
	// seePageY 验证登录用户是否有访问本页面的权限
	/**
	 * 验证登录用户是否有访问本页面的权限，只允许有 strPurview 权限的用户访问
	 *
	 * @param strPurview权限
	 */
	public void seePageY(String strPurview)
	{
		seePageY(strPurview, strNoPurview);
	}
	// [end]

	// [start] seePageY 验证登录用户是否有访问本页面的权限
	// seePageY 验证登录用户是否有访问本页面的权限
	/**
	 * 验证登录用户是否有访问本页面的权限，只允许有 strPurview 权限的用户访问
	 *
	 * @param strPurview权限
	 */
	public void seePageY(String strPurview, String url)
	{
		String[] strPurviewS = strPurview.split(",");
		String[] strUserPurviewS = getUserPurview().split(",");
		String[] strUserRolesPurviewS= getRolesPurview().split(",");
		int iPurview = 0;
		int RPurview=0;
		for (String s : strPurviewS)
		{
			if (s != null && s.length() > 0 && IsUserPurview(strUserPurviewS, s))
			{
				iPurview++;
			}
			
			if (s != null && s.length() > 0 && IsUserPurview(strUserRolesPurviewS, s))
			{
				RPurview++;
			}
		}
		
		if (iPurview == 0||RPurview==0)
		{
			try
			{
				// java.io.PrintWriter out = response.getWriter();
				// out.write("<script type='text/javascript'>window.location.href='" + request.getContextPath() + url + "'</script>");
				System.out.print("seePageY: ");
				System.out.println(request.getContextPath() + url);
				response.sendRedirect(request.getContextPath() + url);
				return;
			}
			catch (IOException e)
			{
				
				e.printStackTrace();
			}
		}
	}
	// [end]

	// [start] seePageN 验证登录用户是否有访问本页面的权限
	// seePageN 验证登录用户是否有访问本页面的权限
	/**
	 * 验证登录用户是否有访问本页面的权限，不允许有 strPurview 权限的用户访问
	 *
	 * @param strPurview权限
	 */
	public boolean seePageN(String strPurview)
	{
		return seePageN(strPurview, strNoPurview);
	}
	// [end]

	// [start] iseePageN 验证登录用户是否有访问本页面的权限
	// seePageN 验证登录用户是否有访问本页面的权限
	/**
	 * 验证登录用户是否有访问本页面的权限，不允许有 strPurview 权限的用户访问
	 *
	 * @param strPurview权限
	 */
	public boolean seePageN(String strPurview, String url)
	{
		String[] strPurviewS = strPurview.split(",");
		String[] strUserPurviewS = getUserPurview().split(",");
		String[] strUserRolesPurviewS= getRolesPurview().split(",");
		int iPurview = 0;
		int RPurview=0;
		for (String s : strPurviewS)
		{
			if (s != null && s.length() > 0 && IsUserPurview(strUserPurviewS, s))
			{
				iPurview++;
			}
			
			if (s != null && s.length() > 0 && IsUserPurview(strUserRolesPurviewS, s))
			{
				RPurview++;
			}
		}
		
		if (iPurview == 0||RPurview==0)
		{
			
				return false;
		
		}
		return true;
	}
	// [end]

	// [start] seeIsButton 验证登录用户是否有使用本功能的权限
	// seeIsButton 验证登录用户是否有使用本功能的权限
	/**
	 * 验证登录用户是否有使用本功能的权限
	 *
	 * @param strPurview权限
	 *
	 */
	public boolean seeIsButton(String strPurview)
	{	
		
		String[] strPurviewS = strPurview.split(",");
		
		String[] strUserPurviewS = getUserPurview().split(",");

		int iPurview = 0;
		for (String s : strPurviewS)
		{	
			
			if (s != null && s.length() > 0 && IsUserPurview(strUserPurviewS, s))
			{
				iPurview++;
			}
		}
		if (iPurview > 0)
		{
			return true;
		}
		else
		{	
			return false;
		}
	}
	// [end]

	// [start] IsUserPurview 验证数组中是否含有字符串
	// IsUserPurview 验证数组中是否含有字符串
	/**
	 * 验证数组中是否含有字符串
	 *
	 * @param strUserPurviewS数组
	 * @param strPurview要验证的字符串
	 *
	 */
	public boolean IsUserPurview(String[] strUserPurviewS, String strPurview)
	{
		for (String s : strUserPurviewS)
		{
			if (s.equals(strPurview))
			{
				return true;
			}
		}
		return false;
	}
	// [end]
	 public void setSectorname()
	 {
		 if(this.isSession)
		 {
			 this.request.getSession().setAttribute(getCookiesName("sectorname"), SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(getSectorid()).getSectorname());
		 }
		 else
		 {
			 CookiesUtil.setCookie(this.response, getCookiesName("sectorname"), StringFormat.UrlEncode(SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(getSectorid()).getSectorname()), getCookiesTime(), getDomain());
		 }
	 }
	

}

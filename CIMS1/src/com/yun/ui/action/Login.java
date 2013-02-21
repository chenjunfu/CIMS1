 package com.yun.ui.action;
 
import com.colorwinglib.Javascript;
import com.colorwinglib.Requests;
import com.colorwinglib.UrlFormat;
import com.yun.bll.culture.SystemAdminLogProvider;
import com.yun.bll.culture.SystemAdminProvider;
import com.yun.common.MyDate;
import com.yun.entities.culture.SystemAdminInfo;
import com.yun.entities.culture.SystemAdminLogInfo;
import com.yun.entities.culture.collection.SystemAdminInfoCollection;
import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
 
 public class Login
 {
	

	/**
	 * request请求对象
	 */
	javax.servlet.http.HttpServletRequest request = null;
	/**
	 * response响应对象
	 */
	javax.servlet.http.HttpServletResponse response = null;
	/**
	 * 向文本输出流打印对象的格式化表示形式。
	 */
	java.io.PrintWriter out = null;

	// 在此处放置初始化页的用户代码
	public String execute() throws Exception
	{
		//com.opensymphony.xwork2.ActionContext ctx = com.opensymphony.xwork2.ActionContext.getContext();

		this.request = ServletActionContext.getRequest();
		this.response = ServletActionContext.getResponse();

		String af = null;
		response.setCharacterEncoding("utf-8");// 设定使用utf-8编码显示
		this.out = response.getWriter();
		
		if (com.colorwinglib.Requests.GetInt(request, "loginout") == 1)
		{
			UserLook UserLook = new UserLook(request, response);
			UserLook.LoginOut();
			// 转到首页
			request.getRequestDispatcher("loginOut.jsp").forward(this.request, this.response);
			try
			{
				response.sendRedirect("loginOut.jsp");
				return null;
			}
			catch (IOException e)
			{
				 e.printStackTrace();
				
			}
		}

		String UserName = com.colorwinglib.Requests.GetString(request, "username", "");// 用户名 数据类型:string
		String PassWord = com.colorwinglib.Requests.GetString(request, "password", "");// 密码 数据类型:string
		if (UserName.length() > 0 && PassWord.length() > 0)
		{
			LoginIn(UserName, PassWord);
		}
		else
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, "请输入用户名密码。");
			request.setAttribute("pageJavaScripEnd", js);
		}
		request.setAttribute("UserName", UserName);//UserName
		request.setAttribute("PassWord", PassWord);//PassWord
		af = "login";
		return af;
	}

	// Login_in 登录用户
	/**
	 * 登录用户
	 * @param UserName 用户名
	 * @param PassWord 密码
	 */
	private void LoginIn(String UserName, String PassWord)
	{	
	
		if (UserName.length() == 0)
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, "用户名不能为空!");
			request.setAttribute("pageJavaScripEnd", js);
			return;
		}
		if (PassWord.length() == 0)
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, "密码不能为空!");
			request.setAttribute("pageJavaScripEnd", js);
			return;
		}
		if (PassWord.length() < 6)
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, "密码不能少于6位!");
			request.setAttribute("pageJavaScripEnd", js);
			return;
		}

		SystemAdminInfoCollection objSystemAdminInfo = com.yun.bll.culture.SystemAdminProvider.GetListPagerByAdminname(UserName,1,10);//实体类
	
		if (objSystemAdminInfo != null&&objSystemAdminInfo.size()!=0)
		{
			if (!objSystemAdminInfo.get(0).getAdminpassword().equals(PassWord))
			{
				
				String js = com.colorwinglib.Javascript.Alert(request, response, "用户名或密码错误!");
				request.setAttribute("pageJavaScripEnd", js);
				return;
			}
		    if(objSystemAdminInfo.get(0).getIsUse()!=1)
			{
				String js = com.colorwinglib.Javascript.Alert(request, response, "用户名已禁用!");
				request.setAttribute("pageJavaScripEnd", js);
				return;
			}
		    if(objSystemAdminInfo.get(0).getObjSystemRolesInfoByRolesid().getIsUse()!=1)
		    {
		    	String js = com.colorwinglib.Javascript.Alert(request, response, "用户名所在角色已禁用!");
				request.setAttribute("pageJavaScripEnd", js);
				return;
		    }
			ULogin(objSystemAdminInfo.get(0));

		}
		else	
		{		
			
			String js = com.colorwinglib.Javascript.Alert(request, response, "用户名不存在!");
			request.setAttribute("pageJavaScripEnd", js);

		}
	}
    

    // ULogin 保存用户信息
    private void ULogin(com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo)
    {

		UserLook UserLook = new UserLook(request, response);
		UserLook.setDatabaseadminid(objSystemAdminInfo.getDatabaseadminid());//人员ID
		UserLook.setAdminid(objSystemAdminInfo.getAdminid());//人员编号
		UserLook.setAdminname(objSystemAdminInfo.getAdminname());//帐号
		UserLook.setAdminpassword(objSystemAdminInfo.getAdminpassword());//密码
		UserLook.setSex(objSystemAdminInfo.getSex());//性别：1-男、2-女
		UserLook.setTruename(objSystemAdminInfo.getTruename());//姓名
		UserLook.setWorkno(objSystemAdminInfo.getWorkno());//工号
		UserLook.setEmail(objSystemAdminInfo.getEmail());//联系EMAIL
		UserLook.setMovephone(objSystemAdminInfo.getMovephone());//移动电话
		UserLook.setPhone(objSystemAdminInfo.getPhone());//电话
		UserLook.setMsn(objSystemAdminInfo.getMsn());//MSN
		UserLook.setRolesid(objSystemAdminInfo.getRolesid());//角色编号
		UserLook.setSectorid(objSystemAdminInfo.getSectorid());//部门编号
		UserLook.setSectorname();
		UserLook.setDescription(objSystemAdminInfo.getDescription());//人员描述
		UserLook.setAddress(objSystemAdminInfo.getAddress());//通讯地址
		UserLook.setLimitIp(objSystemAdminInfo.getLimitIp());//限定IP
		UserLook.setLastLogintime(objSystemAdminInfo.getLastLogintime());//最后登录时间
		UserLook.setLastLoginip(objSystemAdminInfo.getLastLoginip());//最后登录IP
		UserLook.setCreateTime(objSystemAdminInfo.getCreateTime());//创建时间
		UserLook.setLastModifytime(objSystemAdminInfo.getLastModifytime());//最后修改时间
		UserLook.setIsUse(objSystemAdminInfo.getIsUse());//启用标志：1-启用、2-未启用
		UserLook.setIsDel(objSystemAdminInfo.getIsDel());//是否删除：1-未删除、2-已删除
		UserLook.setCompetence(objSystemAdminInfo.getCompetence());//拥有权限
		UserLook.setRolecompetence(objSystemAdminInfo.getObjSystemRolesInfoByRolesid().getCompetenceid());
		objSystemAdminInfo.setLastLogintime(new Date());
		objSystemAdminInfo.setLastLoginip(com.colorwinglib.UrlFormat.GetUserIP(request));
		//objSystemAdminInfo.setLogins(objSystemAdminInfo.getLogins()+1);
		com.yun.bll.culture.SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);//实体类

		
		StringBuilder sbStrAdminLog = new StringBuilder(1024);
		sbStrAdminLog.append("管理员：");
		sbStrAdminLog.append(objSystemAdminInfo.getTruename());
		sbStrAdminLog.append(" 于 ");
		sbStrAdminLog.append(new MyDate());
		sbStrAdminLog.append("\n");
		sbStrAdminLog.append("登陆，登陆浏览器信息如下 ");
		sbStrAdminLog.append("\n");
		sbStrAdminLog.append(request.getHeader("User-Agent"));

		//int AdminLogID = 0;// 日志ID 数据类型:int
		String UserNameAdmin = objSystemAdminInfo.getAdminname();// 管理员名 数据类型:string
		int LogType = 1;// 日志类型 数据类型:int
		String LogContent = sbStrAdminLog.toString();// 详细内容 数据类型:string
		Date AddDate = new Date();// 操作时间 数据类型:DateTime
		String IP = com.colorwinglib.UrlFormat.GetUserIP(request);// 操作IP 数据类型:string
		
		
			//实体类
		SystemAdminLogInfo objAdminlogInfo=new SystemAdminLogInfo();
		objAdminlogInfo.setAdminname(UserNameAdmin);
		objAdminlogInfo.setType(LogType);
		objAdminlogInfo.setContent(LogContent);
		objAdminlogInfo.setAddtime(AddDate);
		objAdminlogInfo.setIp(IP);
		SystemAdminLogProvider.Insert(objAdminlogInfo);
		
		//操作IP  数据类型:String
       

        //通过认证，跳转到管理页
		try
		{
			response.sendRedirect("main.jsp");
		}
		catch (IOException e)
		{
			// e.printStackTrace();
		}
    }
    
  
	
}

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.Login
 * JD-Core Version:    0.6.0
 */
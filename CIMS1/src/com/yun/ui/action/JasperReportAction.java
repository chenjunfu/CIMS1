/*    */ package com.yun.ui.action;
/*    */ 
/*    */ import com.opensymphony.xwork2.ActionSupport;
/*    */ import com.yun.bll.culture.RegionsProvider;
/*    */ import com.yun.entities.culture.RegionsInfo;
/*    */ import com.yun.entities.culture.collection.RegionsInfoCollection;
/*    */ import java.util.List;
/*    */ 
/*    */ public class JasperReportAction extends ActionSupport
/*    */ {
/*    */   private List<RegionsInfo> list;
/*    */ 
/*    */   public List<RegionsInfo> getList()
/*    */   {
/* 14 */     RegionsInfoCollection RegionsColl = RegionsProvider.GetListBy();
/* 15 */     this.list = RegionsColl;
/* 16 */     return this.list;
/*    */   }
/*    */ 
/*    */   public void setList(List<RegionsInfo> list)
/*    */   {
/* 21 */     this.list = list;
/*    */   }
/*    */ 
/*    */   public String execute()
/*    */     throws Exception
/*    */   {
/* 28 */     return "success";
/*    */   }
/*    */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.JasperReportAction
 * JD-Core Version:    0.6.0
 */
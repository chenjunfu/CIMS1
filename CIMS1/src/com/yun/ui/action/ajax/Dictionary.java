/*      */ package com.yun.ui.action.ajax;
/*      */ 
/*      */ import com.colorwinglib.Requests;
/*      */ import com.colorwinglib.Validate;
/*      */ import com.yun.bll.culture.EducationProvider;
/*      */ import com.yun.bll.culture.EnterpristQualityProvider;
/*      */ import com.yun.bll.culture.IndustryTypeProvider;
/*      */ import com.yun.bll.culture.ProfessionProvider;
/*      */ import com.yun.bll.culture.RegionsProvider;
/*      */ import com.yun.entities.culture.EducationInfo;
/*      */ import com.yun.entities.culture.EnterpristQualityInfo;
/*      */ import com.yun.entities.culture.IndustryTypeInfo;
/*      */ import com.yun.entities.culture.ProfessionInfo;
/*      */ import com.yun.entities.culture.RegionsInfo;
/*      */ import java.io.PrintWriter;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import javax.servlet.http.HttpServletResponse;
/*      */ import org.apache.struts2.ServletActionContext;
/*      */ 
/*      */ public class Dictionary
/*      */ {
/*      */   private static final long serialVersionUID = 2011112515312606294L;
/*   21 */   public int pageSize = 10;
/*      */ 
/*   26 */   public String pageParameter = "page";
/*      */ 
/*   31 */   HttpServletRequest request = null;
/*      */ 
/*   35 */   HttpServletResponse response = null;
/*      */ 
/*   39 */   PrintWriter out = null;
/*      */  
/*      */   public void execute()
/*      */     throws Exception
/*      */   { 
			
/*   49 */     this.request = ServletActionContext.getRequest();
/*   50 */     this.response = ServletActionContext.getResponse();
/*      */ 
/*   52 */     this.response.setCharacterEncoding("utf-8");
/*   53 */     this.out = this.response.getWriter();
/*      */ 
/*   56 */     String pagetype = Requests.GetString(this.request, 
/*   57 */       "pagetype").toLowerCase();
/*      */ 
/*   59 */     if (pagetype.equals("insert"))
/*      */     {
/*   61 */       insert();
/*   62 */     } else if (pagetype.equals("update"))
/*   63 */       update();
/*   64 */     else if (pagetype.equals("delete"))
/*      */     {
/*   66 */       delete();
/*      */     }
/*   68 */     else ListShow();
/*      */   }
/*      */ 
/*      */   protected void ListShow()
/*      */   {
/*  556 */     throw new Error("无法解析的编译问题：\n\tcom.yun.bll.culture.AgeProvider 无法解析为类型\n\tcom.yun.entities.culture.collection.AgeInfoCollection 无法解析为类型\n\tcom.yun.bll.culture.AgeProvider 无法解析为类型\n\t没有为类型 AgeInfo 定义方法 getAgeid（）\n\t没有为类型 AgeInfo 定义方法 getAgename（）\n");
/*      */   }
/*      */ 
/*      */   public void delete()
/*      */   {
/*  594 */     String table = 
/*  595 */       Requests.GetString(this.request, "tableName");
/*      */ 
/*  597 */     if (table.equals("dialogIndustryType")) {
/*  598 */       int Businesstypeid = Requests.GetInt(this.request, 
/*  599 */         "ids", 0);
/*      */ 
/*  601 */       ProfessionProvider.DeleteByBusinessdatabaseid(Businesstypeid);
/*  602 */       ProfessionProvider.setProfessionStatic(null);
/*  603 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  605 */     else if (table.equals("dialogOwnership"))
/*      */     {
/*  607 */       int Qualityid = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  610 */       EnterpristQualityProvider.DeleteByQualitydatabaseid(Qualityid);
/*      */ 
/*  613 */       EnterpristQualityProvider.setEnterpristQualityStatic(null);
/*  614 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  616 */     else if (table.equals("dialogIndustrialProjects"))
/*      */     {
/*  618 */       int id = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  620 */       IndustryTypeProvider.DeleteByIndustrydatabaseid(id);
/*      */ 
/*  622 */       IndustryTypeProvider.setIndustryTypeStatic(null);
/*  623 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  625 */     else if (table.equals("dialogArea")) {
/*  626 */       int id = Requests.GetInt(this.request, "ids", 0);
/*  627 */       RegionsProvider.DeleteByRegiondatabaseid(id);
/*  628 */       RegionsProvider.setRegionsStatic(null);
/*  629 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  631 */     else if (table.equals("dialogEducation")) {
/*  632 */       int id = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  634 */       EducationProvider.DeleteByEducationdatabaseid(id);
/*  635 */       EducationProvider.setEducationStatic(null);
/*  636 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  638 */     else if (table.equals("dialogDegree")) {
/*  639 */       int id = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  641 */       EducationProvider.DeleteByEducationdatabaseid(id);
/*  642 */       EducationProvider.setEducationStatic(null);
/*  643 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  645 */     else if (table.equals("dialogProfessional")) {
/*  646 */       int id = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  649 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  651 */     else if (table.equals("dialogTalentSector")) {
/*  652 */       int id = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  655 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*  657 */     else if (table.equals("dialogAge")) {
/*  658 */       int id = Requests.GetInt(this.request, "ids", 0);
/*      */ 
/*  661 */       this.out.write("messageID = 1;message ='ɾ��ɹ�';");
/*      */     }
/*      */   }
/*      */ 
/*      */   public void update()
/*      */   {
/*  667 */     String table = Requests.GetString(this.request, "table");
/*      */ 
/*  669 */     if (table.equals("dialogIndustryType")) {
/*  670 */       int Businesstypeid = Requests.GetInt(this.request, 
/*  671 */         "businesstypeid", 0);
/*  672 */       if (Businesstypeid == 0) {
/*  673 */         this.out.write("messageID = 1;message ='��ѡ��Ҫ���µ����';");
/*  674 */         return;
/*      */       }
/*  676 */       String Businesstypename = Requests.GetString(
/*  677 */         this.request, "businesstypename", "");
/*      */ 
/*  680 */       ServerValidate(1);
/*      */ 
/*  685 */       ProfessionInfo objProfessionInfo = 
/*  686 */         ProfessionProvider.GetProfessionInfoByBusinessdatabaseid(Businesstypeid);
/*  687 */       objProfessionInfo.setBusinesstypeid(Businesstypeid);
/*      */ 
/*  689 */       objProfessionInfo.setBusinesstypename(Businesstypename);
/*      */ 
/*  693 */       ProfessionProvider.UpdateByBusinessdatabaseid(objProfessionInfo);
/*      */ 
/*  695 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*  696 */       ProfessionProvider.setProfessionStatic(null);
/*      */     }
/*  698 */     else if (table.equals("dialogOwnership")) {
/*  699 */       String Qualityid = Requests.GetString(this.request, 
/*  700 */         "qualityid", "");
/*  701 */       String Qualityname = Requests.GetString(this.request, 
/*  702 */         "qualityname", "");
				 int Qualitydatabaseid=Requests.GetInt(this.request, "qualitydatabaseid");	
/*      */ 
/*  705 */       ServerValidate(2);
/*      */ 
/*  709 */       EnterpristQualityInfo objEnterpristQualityInfo = 
/*  710 */         EnterpristQualityProvider.GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);
/*  711 */       objEnterpristQualityInfo.setQualityid(Qualityid);
/*  712 */       objEnterpristQualityInfo.setQualityname(Qualityname);
/*      */ 
/*  716 */       EnterpristQualityProvider.UpdateByQualitydatabaseid(objEnterpristQualityInfo);
/*  717 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */ 
/*  719 */       EnterpristQualityProvider.setEnterpristQualityStatic(null);
/*      */     }
/*  721 */     else if (table.equals("dialogIndustrialProjects")) {
/*  722 */       int Industryid = Requests.GetInt(this.request, "industryid", 0);
/*  723 */       String Industryname = Requests.GetString(this.request, "industryname", "");
/*      */ 
/*  726 */       ServerValidate(3);
/*      */ 
/*  730 */       IndustryTypeInfo objIndustryTypeInfo = IndustryTypeProvider.GetIndustryTypeInfoByIndustrydatabaseid(Industryid);
/*  731 */       objIndustryTypeInfo.setIndustryid(Industryid);
/*  732 */       objIndustryTypeInfo.setIndustryname(Industryname);
/*      */ 
/*  734 */       IndustryTypeProvider.UpdateByIndustrydatabaseid(objIndustryTypeInfo);
/*  735 */       IndustryTypeProvider.setIndustryTypeStatic(null);
/*  736 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*  738 */     else if (table.equals("dialogArea"))
/*      */     {
/*  740 */       int Regionid = Requests.GetInt(this.request, "regionid", 0);
/*  741 */       String Regionname = Requests.GetString(this.request, "regionname", "");
/*  742 */       int Partherregionsid = Requests.GetInt(this.request, "partherregionsid", 0);
/*  743 */       int Depth = Requests.GetInt(this.request, "depth", 0);
/*      */ 
/*  746 */       if (!ServerValidate(4))
/*      */       {
/*  748 */         return;
/*      */       }
/*  750 */       RegionsInfo objRegionsInfo = RegionsProvider.GetRegionsInfoByRegiondatabaseid(Regionid);
/*  751 */       objRegionsInfo.setRegionid(Regionid);
/*  752 */       objRegionsInfo.setRegionname(Regionname);
/*  753 */       objRegionsInfo.setPartherregionsid(Partherregionsid);
/*  754 */       objRegionsInfo.setDepth(Depth);
/*      */ 
/*  756 */       RegionsProvider.UpdateByRegiondatabaseid(objRegionsInfo);
/*  757 */       RegionsProvider.setRegionsStatic(null);
/*  758 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*  762 */     else if (table.equals("dialogEducation")) {
/*  763 */       int Educationid = Requests.GetInt(this.request, "educationid", 0);
/*  764 */       String Educationname = Requests.GetString(this.request, "educationname", "");
/*      */ 
/*  771 */       if (!ServerValidate(5))
/*      */       {
/*  773 */         return;
/*      */       }
/*      */ 
/*  776 */       EducationInfo objEducationInfo = EducationProvider.GetEducationInfoByEducationdatabaseid(Educationid);
/*  777 */       objEducationInfo.setEducationid(Educationid);
/*  778 */       objEducationInfo.setEducationname(Educationname);
/*      */ 
/*  780 */       EducationProvider.UpdateByEducationdatabaseid(objEducationInfo);
/*  781 */       EducationProvider.setEducationStatic(null);
/*  782 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*  785 */     else if (table.equals("dialogDegree")) {
/*  786 */       int Educationid = Requests.GetInt(this.request, "educationid", 0);
/*  787 */       String Educationname = Requests.GetString(this.request, "educationname", "");
/*      */ 
/*  790 */       if (!ServerValidate(6))
/*      */       {
/*  792 */         return;
/*      */       }
/*      */ 
/*  795 */       EducationInfo objEducationInfo = EducationProvider.GetEducationInfoByEducationdatabaseid(Educationid);
/*  796 */       objEducationInfo.setEducationid(Educationid);
/*  797 */       objEducationInfo.setEducationname(Educationname);
/*      */ 
/*  799 */       EducationProvider.UpdateByEducationdatabaseid(objEducationInfo);
/*  800 */       EducationProvider.setEducationStatic(null);
/*  801 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*  804 */     else if (table.equals("dialogProfessional"))
/*      */     {
/*  806 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*  809 */     else if (table.equals("dialogTalentSector"))
/*      */     {
/*  811 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*  814 */     else if (table.equals("dialogAge"))
/*      */     {
/*  816 */       this.out.write("messageID = 1;message ='���³ɹ�';");
/*      */     }
/*      */   }
/*      */ 
/*      */   public void insert()
/*      */   {
/*  822 */     String table = Requests.GetString(this.request, "table");
/*      */ 
/*  824 */     if (table.equals("dialogIndustryType"))
/*      */     {
/*  826 */       int Businesstypeid = Requests.GetInt(this.request, 
/*  827 */         "businesstypeid", 0);
/*  828 */       String Businesstypename = Requests.GetString(
/*  829 */         this.request, "businesstypename", "");
/*      */ 
/*  832 */       if (!ServerValidate(1)) {
/*  833 */         this.out.write("messageID = 1;message ='���ʧ��';");
/*  834 */         return;
/*      */       }
/*      */ 
/*  837 */       ProfessionInfo objProfessionInfo = new ProfessionInfo();
/*  838 */       objProfessionInfo.setBusinesstypeid(Businesstypeid);
/*      */ 
/*  840 */       objProfessionInfo.setBusinesstypename(Businesstypename);
/*      */ 
/*  843 */       ProfessionProvider.Insert(objProfessionInfo);
/*  844 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*  845 */       ProfessionProvider.setProfessionStatic(null);
/*      */     }
/*  847 */     else if (table.equals("dialogOwnership")) {
/*  848 */       int Qualitydatabaseid = Requests.GetInt(this.request, 
/*  849 */         "qualitydatabaseid", 0);
/*  850 */       String Qualityname = Requests.GetString(this.request, 
/*  851 */         "qualityname", "");
				 String Qualityid=Requests.GetString(this.request, "qualityid","");
/*      */ 
/*  854 */       if (!ServerValidate(2)) {
/*  855 */         this.out.write("messageID = 1;message ='���ʧ��';");
/*  856 */         return;
/*      */       }
/*      */ 
/*  859 */       EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo();
/*  860 */       objEnterpristQualityInfo.setQualitydatabaseid(Qualitydatabaseid);
				 objEnterpristQualityInfo.setQualityid(Qualityid);
/*  861 */       objEnterpristQualityInfo.setQualityname(Qualityname);
/*      */ 
/*  865 */       EnterpristQualityProvider.Insert(objEnterpristQualityInfo);
/*  866 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  868 */     else if (table.equals("dialogIndustrialProjects")) {
/*  869 */       int Industryid = Requests.GetInt(this.request, "industryid", 0);
/*  870 */       String Industryname = Requests.GetString(this.request, "industryname", "");
/*      */ 
/*  873 */       ServerValidate(3);
/*      */ 
/*  877 */       IndustryTypeInfo objIndustryTypeInfo = new IndustryTypeInfo();
/*  878 */       objIndustryTypeInfo.setIndustryid(Industryid);
/*  879 */       objIndustryTypeInfo.setIndustryname(Industryname);
/*      */ 
/*  881 */       IndustryTypeProvider.Insert(objIndustryTypeInfo);
/*  882 */       IndustryTypeProvider.setIndustryTypeStatic(null);
/*  883 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  885 */     else if (table.equals("dialogArea")) {
/*  886 */       int Regionid = Requests.GetInt(this.request, "regionid", 0);
/*  887 */       String Regionname = Requests.GetString(this.request, "regionname", "");
/*  888 */       int Partherregionsid = Requests.GetInt(this.request, "partherregionsid", 0);
/*  889 */       int Depth = Requests.GetInt(this.request, "depth", 0);
/*      */ 
/*  892 */       if (!ServerValidate(4))
/*      */       {
/*  894 */         return;
/*      */       }
/*      */ 
/*  897 */       RegionsInfo objRegionsInfo = new RegionsInfo();
/*  898 */       objRegionsInfo.setRegionid(Regionid);
/*  899 */       objRegionsInfo.setRegionname(Regionname);
/*  900 */       objRegionsInfo.setPartherregionsid(Partherregionsid);
/*  901 */       objRegionsInfo.setDepth(Depth);
/*      */ 
/*  903 */       RegionsProvider.Insert(objRegionsInfo);
/*  904 */       RegionsProvider.setRegionsStatic(null);
/*  905 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  909 */     else if (table.equals("dialogEducation")) {
/*  910 */       int Educationid = Requests.GetInt(this.request, "educationid", 0);
/*  911 */       String Educationname = Requests.GetString(this.request, "educationname", "");
/*      */ 
/*  918 */       if (!ServerValidate(5))
/*      */       {
/*  920 */         return;
/*      */       }
/*      */ 
/*  923 */       EducationInfo objEducationInfo = new EducationInfo();
/*  924 */       objEducationInfo.setEducationid(Educationid);
/*  925 */       objEducationInfo.setEducationname(Educationname);
/*      */ 
/*  927 */       EducationProvider.Insert(objEducationInfo);
/*  928 */       EducationProvider.setEducationStatic(null);
/*  929 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  932 */     else if (table.equals("dialogDegree")) {
/*  933 */       int Educationid = Requests.GetInt(this.request, "educationid", 0);
/*  934 */       String Educationname = Requests.GetString(this.request, "educationname", "");
/*      */ 
/*  937 */       if (!ServerValidate(6))
/*      */       {
/*  939 */         return;
/*      */       }
/*      */ 
/*  942 */       EducationInfo objEducationInfo = new EducationInfo();
/*  943 */       objEducationInfo.setEducationid(Educationid);
/*  944 */       objEducationInfo.setEducationname(Educationname);
/*      */ 
/*  946 */       EducationProvider.Insert(objEducationInfo);
/*  947 */       EducationProvider.setEducationStatic(null);
/*  948 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  951 */     else if (table.equals("dialogProfessional"))
/*      */     {
/*  953 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  956 */     else if (table.equals("dialogTalentSector"))
/*      */     {
/*  958 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*  961 */     else if (table.equals("dialogAge"))
/*      */     {
/*  963 */       this.out.write("messageID = 1;message ='��ӳɹ�';");
/*      */     }
/*      */   }
/*      */ 
/*      */   protected boolean ServerValidate(int tableid)
/*      */   {
/*  970 */     if (tableid == 1) {
/*  971 */       StringBuilder sbStr = new StringBuilder(1024);
/*  972 */       int i = 1;
/*      */ 
/*  974 */       if (
/*  975 */         Requests.GetString(this.request, "businesstypename").length() == 0) {
/*  976 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "��ҵ��ҵ�������" }));
/*  977 */         i++;
/*      */       }
/*      */ 
/*  980 */       if (Validate.getLength(
/*  980 */         Requests.GetString(this.request, "businesstypename")) > 50) {
/*  981 */         sbStr.append(String.format("%1$s.%2$s�ĳ��Ȳ��ܴ���50\n", new Object[] { Integer.valueOf(i), 
/*  982 */           "��ҵ��ҵ�������" }));
/*  983 */         i++;
/*      */       }
/*      */ 
/*  987 */       if (i - 1 > 0) {
/*  988 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/*  989 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/*  990 */         return false;
/*      */       }
/*  992 */       return true;
/*      */     }
/*  994 */     if (tableid == 2) {
/*  995 */       StringBuilder sbStr = new StringBuilder(1024);
/*  996 */       int i = 1;
/*      */ 
/*  998 */       if (Requests.GetString(this.request, "qualityname")
/*  999 */         .length() == 0) {
/* 1000 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "��ҵ�������" }));
/* 1001 */         i++;
/*      */       }
/*      */ 
/* 1004 */       if (Validate.getLength(
/* 1004 */         Requests.GetString(this.request, "qualityname")) > 50) {
/* 1005 */         sbStr
/* 1006 */           .append(String.format("%1$s.%2$s�ĳ��Ȳ��ܴ���50\n", new Object[] { Integer.valueOf(i), 
/* 1007 */           "��ҵ�������" }));
/* 1008 */         i++;
/*      */       }
/*      */ 
/* 1012 */       if (i - 1 > 0) {
/* 1013 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1014 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1015 */         return false;
/*      */       }
/* 1017 */       return true;
/*      */     }
/* 1019 */     if (tableid == 3) {
/* 1020 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1021 */       int i = 1;
/*      */ 
/* 1023 */       if (Requests.GetString(this.request, "industryname").length() == 0)
/*      */       {
/* 1025 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "��ҵ��Ŀ������" }));
/* 1026 */         i++;
/*      */       }
/* 1028 */       if (Validate.getLength(Requests.GetString(this.request, "industryname")) > 50)
/*      */       {
/* 1030 */         sbStr.append(String.format("%1$s.%2$s�ĳ��Ȳ��ܴ���50\n", new Object[] { Integer.valueOf(i), "��ҵ��Ŀ������" }));
/* 1031 */         i++;
/*      */       }
/*      */ 
/* 1035 */       if (i - 1 > 0)
/*      */       {
/* 1037 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1038 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1039 */         return false;
/*      */       }
/*      */ 
/* 1043 */       return true;
/*      */     }
/* 1045 */     if (tableid == 4) {
/* 1046 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1047 */       int i = 1;
/*      */ 
/* 1050 */       if (Requests.GetString(this.request, "regionname").length() == 0)
/*      */       {
/* 1052 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "RegionName" }));
/* 1053 */         i++;
/*      */       }
/* 1055 */       if (Validate.getLength(Requests.GetString(this.request, "regionname")) > 50)
/*      */       {
/* 1057 */         sbStr.append(String.format("%1$s.%2$s�ĳ��Ȳ��ܴ���50\n", new Object[] { Integer.valueOf(i), "RegionName" }));
/* 1058 */         i++;
/*      */       }
/*      */ 
/* 1062 */       if (Requests.GetString(this.request, "partherregionsid").length() == 0)
/*      */       {
/* 1064 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "PartherRegionsID" }));
/* 1065 */         i++;
/*      */       }
/*      */ 
/* 1068 */       if (!Validate.IsNumber(Requests.GetString(this.request, "partherregionsid")))
/*      */       {
/* 1070 */         sbStr.append(String.format("%1$s.���%2$sд���ˣ����޸�\n", new Object[] { Integer.valueOf(i), "PartherRegionsID" }));
/* 1071 */         i++;
/*      */       }
/*      */ 
/* 1075 */       if (Requests.GetString(this.request, "depth").length() == 0)
/*      */       {
/* 1077 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "Depth" }));
/* 1078 */         i++;
/*      */       }
/*      */ 
/* 1081 */       if (!Validate.IsNumber(Requests.GetString(this.request, "depth")))
/*      */       {
/* 1083 */         sbStr.append(String.format("%1$s.���%2$sд���ˣ����޸�\n", new Object[] { Integer.valueOf(i), "Depth" }));
/* 1084 */         i++;
/*      */       }
/*      */ 
/* 1088 */       if (i - 1 > 0)
/*      */       {
/* 1090 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1091 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1092 */         return false;
/*      */       }
/*      */ 
/* 1096 */       return true;
/*      */     }
/*      */ 
/* 1099 */     if (tableid == 5) {
/* 1100 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1101 */       int i = 1;
/*      */ 
/* 1103 */       if (Requests.GetString(this.request, "educationname").length() == 0)
/*      */       {
/* 1105 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "EducationName" }));
/* 1106 */         i++;
/*      */       }
/* 1108 */       if (Validate.getLength(Requests.GetString(this.request, "educationname")) > 50)
/*      */       {
/* 1110 */         sbStr.append(String.format("%1$s.%2$s�ĳ��Ȳ��ܴ���50\n", new Object[] { Integer.valueOf(i), "EducationName" }));
/* 1111 */         i++;
/*      */       }
/*      */ 
/* 1115 */       if (i - 1 > 0)
/*      */       {
/* 1117 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1118 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1119 */         return false;
/*      */       }
/*      */ 
/* 1123 */       return true;
/*      */     }
/*      */ 
/* 1126 */     if (tableid == 6) {
/* 1127 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1128 */       int i = 1;
/*      */ 
/* 1130 */       if (Requests.GetString(this.request, "educationname").length() == 0)
/*      */       {
/* 1132 */         sbStr.append(String.format("%1$s.%2$s����Ϊ��\n", new Object[] { Integer.valueOf(i), "EducationName" }));
/* 1133 */         i++;
/*      */       }
/* 1135 */       if (Validate.getLength(Requests.GetString(this.request, "educationname")) > 50)
/*      */       {
/* 1137 */         sbStr.append(String.format("%1$s.%2$s�ĳ��Ȳ��ܴ���50\n", new Object[] { Integer.valueOf(i), "EducationName" }));
/* 1138 */         i++;
/*      */       }
/*      */ 
/* 1141 */       if (i - 1 > 0)
/*      */       {
/* 1143 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1144 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1145 */         return false;
/*      */       }
/*      */ 
/* 1149 */       return true;
/*      */     }
/* 1151 */     if (tableid == 7) {
/* 1152 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1153 */       int i = 1;
/*      */ 
/* 1155 */       if (i - 1 > 0)
/*      */       {
/* 1157 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1158 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1159 */         return false;
/*      */       }
/*      */ 
/* 1163 */       return true;
/*      */     }
/* 1165 */     if (tableid == 8) {
/* 1166 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1167 */       int i = 1;
/*      */ 
/* 1169 */       if (i - 1 > 0)
/*      */       {
/* 1171 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1172 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1173 */         return false;
/*      */       }
/*      */ 
/* 1177 */       return true;
/*      */     }
/*      */ 
/* 1180 */     if (tableid == 9) {
/* 1181 */       StringBuilder sbStr = new StringBuilder(1024);
/* 1182 */       int i = 1;
/*      */ 
/* 1185 */       if (i - 1 > 0)
/*      */       {
/* 1187 */         sbStr.append("�ܹ���" + (i - 1) + "������");
/* 1188 */         this.out.write("messageID = 1;message ='" + sbStr.toString() + "';");
/* 1189 */         return false;
/*      */       }
/*      */ 
/* 1193 */       return true;
/*      */     }
/*      */ 
/* 1196 */     return false;
/*      */   }
/*      */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.ajax.Dictionary
 * JD-Core Version:    0.6.0
 */
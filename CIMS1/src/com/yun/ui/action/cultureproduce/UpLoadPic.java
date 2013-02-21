package com.yun.ui.action.cultureproduce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.colorwinglib.FileFormat;
import com.colorwinglib.ImageFormat;
import com.colorwinglib.Javascript;
import com.opensymphony.xwork2.ActionSupport;
import com.yun.bll.culture.ProjectpicProvider;
import com.yun.common.MyUtils;
import com.yun.configuration.WebConfig;
import com.yun.entities.culture.IndustryProjectInfo;
import com.yun.entities.culture.ProjectpicInfo;

public class UpLoadPic extends ActionSupport {
	
   static private final long  serialVersionUID=20121229111111111L;
   private File[] pic;
   private String[] picFileName;
   private String[] picContentType;
 
   private ProjectpicInfo ObjProjectInfo=new ProjectpicInfo();

public File[] getPic() {
	return pic;
}
public void setPic(File[] pic) {
	this.pic = pic;
}
public String[] getPicFileName() {
	return picFileName;
}
public void setPicFileName(String[] picFileName) {
	this.picFileName = picFileName;
}
public String[] getPicContentType() {
	return picContentType;
}
public void setPicContentType(String[] picContentType) {
	this.picContentType = picContentType;
}
   
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	int IndustryProjectDatabaseID=(Integer)request.getAttribute("IndustryProjectDatabaseID");
	System.out.println("******" +IndustryProjectDatabaseID);
	ObjProjectInfo.setDatabaseprojectid(IndustryProjectDatabaseID);
	 for(int i=0;i<pic.length;i++)
	 {  	
		
		 File fFile=pic[i];
		 String FileName=picFileName[i];
		 String ContentType=picContentType[i];
		 String hasFileName=UpFile(fFile,ContentType,FileName,FileName);	
		 ObjProjectInfo.setPic(hasFileName);
		 ProjectpicProvider.Insert(ObjProjectInfo);
	 }
	  return "SUCCESS";
	}
protected String UpFile(File fFile, String fileContentType, String fileName, String oldItemValue)
/*     */   {
/* 736 */     if (fFile != null)
/*     */     {
/* 739 */       SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/");
/* 740 */       String urlPath = "images/upfile/images/" + formatter.format(new Date());
/* 741 */       String filePath = this.request.getSession().getServletContext().getRealPath("/" + urlPath);
/*     */ 		
/* 743 */       String fileExtension = fileName.substring(fileName.indexOf("."));

/* 744 */       fileName = "";
/*     */       try
/*     */       {
/* 748 */         fileName = String.format("%1$s%2$s", new Object[] { urlPath, oldItemValue });
/*     */ 			
/* 751 */         long fSize = fFile.length();
/* 752 */         int maxFSize = 2048;
/* 753 */         if (fSize > maxFSize * 1024)
/*     */         {
/* 755 */           String js = Javascript.Alert(this.request, this.response, "文件太大，请选择小于" + maxFSize + "K的文件");
/* 756 */           this.request.setAttribute("pageJavaScripStar", js);
/* 757 */           return oldItemValue;
/*     */         }
/*     */ 
/* 761 */         fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)(Math.random() * 100000.0D);
/*     */ 
/* 764 */         FileFormat.CreateDirectory(filePath);
/*     */ 
/* 766 */         String oldfilePath = "";
/* 767 */         oldfilePath = this.request.getSession().getServletContext().getRealPath(String.format("/%1$s", new Object[] { oldItemValue }));
/* 768 */         FileFormat.DeleteFiles(oldfilePath);
/*     */ 
/* 771 */         String source = String.format("%1$s%4$s%2$s%3$s", new Object[] { filePath, fileName, fileExtension, WebConfig.getFileSeparator() });
/* 772 */         String minsorce=String.format("%1$s%4$s%2$smin%3$s", new Object[] { filePath, fileName, fileExtension, WebConfig.getFileSeparator() });
				  ImageMaxSave(fFile, source);
/*     */         ImageMinSave(source,minsorce);
/* 774 */         fileName = String.format("%1$s%2$s%3$s", new Object[] { urlPath, fileName, fileExtension });
				
/* 775 */         return fileName;
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 779 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 782 */     return oldItemValue;
/*     */   }
/*     */   private boolean ImageMaxSave(File fFile, String FilePath)
/*     */   {
/*     */     try
/*     */     {
/* 800 */       InputStream is = new FileInputStream(fFile);
/* 801 */       OutputStream os = new FileOutputStream(FilePath);
				
/* 802 */       byte[] buffer = new byte[8192];
/* 803 */       int count = 0;
/* 804 */       while ((count = is.read(buffer)) > 0)
/*     */       {
/* 806 */         os.write(buffer, 0, count);
/*     */       }
/* 808 */       os.close();
/* 809 */       is.close();
/* 810 */       return true;
/*     */     }
/*     */     catch (FileNotFoundException e)
/*     */     {
/* 814 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 818 */       e.printStackTrace();
/*     */     }
/* 820 */     return false;
/*     */   }
/*     */ 
/*     */   protected boolean ImageMinSave(String source, String FilePath)
/*     */   {
/* 836 */     int NewWidth = 200;
/* 837 */     int NewHeight = 200;
/*     */ 		
/* 840 */     return ImageFormat.GenerateThumbnail(source, NewWidth, NewHeight, FilePath);
/*     */   }
/*     */ 

}

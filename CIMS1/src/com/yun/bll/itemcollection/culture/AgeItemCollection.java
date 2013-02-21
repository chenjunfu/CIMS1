package com.yun.bll.itemcollection.culture;

import java.util.*;
import com.yun.bll.itemcollection.*;

/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 12:08:10
   功能说明: 表t_age 年龄段表的AgeItemCollection的类
   表说明:年龄段表
======================================================================*/

    /**
    * 表t_age的AgeItemCollection的类
	 */
public class AgeItemCollection
{
	public AgeItemCollection()
	{
		//
		// 
		//
	}

	 // [start] Agename 年龄段
	 // [start] Agename  年龄段
	 private static ItemInfoCollection _AgenameCollection = null;
	 /**
	 * Agename  年龄段 Collection
	 *
	 * @return Agename  年龄段 T_ParentTableCollection
	 */
	 public static ItemInfoCollection AgenameCollection()
	 {
	     if (_AgenameCollection == null)
	     {
	         ItemInfoCollection list = new ItemInfoCollection();
	         //年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
	         list.add(new ItemInfo("A", "1"));
	         list.add(new ItemInfo("B", "21"));
	         list.add(new ItemInfo("C", "31"));
	         list.add(new ItemInfo("D", "41"));
	         list.add(new ItemInfo("E", "51"));

	         _AgenameCollection = list;
	     }
	     return _AgenameCollection;
	 }
	 // [end]

	 // [start] AgenameText  年龄段
	 /**
	 * AgenameText   年龄段，默认不使用label标签
	 *
	 * @param Agename 年龄段
	 * @param isCSS 使用label标签+样式表
	 * @return 年龄段 描述
	 */
	 public static String AgenameText(String Agename)
	 {
	     return AgenameText(Agename, false);
	 }
	 // [end]

	 // [start] AgenameText  年龄段
	 /**
	 * AgenameText   年龄段，默认不使用label标签
	 *
	 * @param Agename 年龄段
	 * @param isCSS 使用label标签+样式表
	 * @return 年龄段 描述
	 */
	 public static String AgenameText(String Agename, boolean isCSS)
	 {

	     ItemInfoCollection list = AgenameCollection();

	     ItemInfo itemInfo = list.GetItemInfoByValue(Agename);
	     if (itemInfo != null)
	     {
	         if (isCSS)
	         {
				return String.format("<label class=\"Sort%1$s\">%2$s</label>",
						itemInfo.getValue(), itemInfo.getText());
	         }
	         else
	         {
	             return itemInfo.getText();
	         }
	     }
	     return "";
	 }
	 // [end]

	 // [start] AgenameOption标签
	 /**
	 * AgenameOption标签
	 * @return 年龄段 Option标签
	 */
	 public static String AgenameOption()
	 {
		StringBuilder sbStr = new StringBuilder(100);
		for (ItemInfo itemInfo : AgenameCollection())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
		}
		return sbStr.toString();
	 }
	 // [end]
	 // [end]

}

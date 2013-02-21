package com.yun.bll.itemcollection.culture;

import java.util.*;
import com.yun.bll.itemcollection.*;

/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 12:56:30
   功能说明: 表t_people 人员表的PeopleItemCollection的类
   表说明:人员表
======================================================================*/

    /**
    * 表t_people的PeopleItemCollection的类
	 */
public class PeopleItemCollection
{
	public PeopleItemCollection()
	{
		//
		// 
		//
	}

	 // [start] Sex 性别
	 // [start] Sex  性别
	 private static ItemInfoCollection _SexCollection = null;
	 /**
	 * Sex  性别 Collection
	 *
	 * @return Sex  性别 T_ParentTableCollection
	 */
	 public static ItemInfoCollection SexCollection()
	 {
	     if (_SexCollection == null)
	     {
	         ItemInfoCollection list = new ItemInfoCollection();
	         //性别：1-男、2-女
	         list.add(new ItemInfo("1", "男"));
	         list.add(new ItemInfo("2", "女"));

	         _SexCollection = list;
	     }
	     return _SexCollection;
	 }
	 // [end]

	 // [start] SexText  性别
	 /**
	 * SexText   性别，默认不使用label标签
	 *
	 * @param Sex 性别
	 * @param isCSS 使用label标签+样式表
	 * @return 性别 描述
	 */
	 public static String SexText(String Sex)
	 {
	     return SexText(Sex, false);
	 }
	 // [end]

	 // [start] SexText  性别
	 /**
	 * SexText   性别，默认不使用label标签
	 *
	 * @param Sex 性别
	 * @param isCSS 使用label标签+样式表
	 * @return 性别 描述
	 */
	 public static String SexText(String Sex, boolean isCSS)
	 {

	     ItemInfoCollection list = SexCollection();

	     ItemInfo itemInfo = list.GetItemInfoByValue(Sex);
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

	 // [start] SexOption标签
	 /**
	 * SexOption标签
	 * @return 性别 Option标签
	 */
	 public static String SexOption()
	 {
		StringBuilder sbStr = new StringBuilder(100);
		for (ItemInfo itemInfo : SexCollection())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
		}
		return sbStr.toString();
	 }
	 // [end]
	 // [end]

}

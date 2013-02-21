package com.yun.common;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class XmlSerializable
{
	// [start] 设置和获取 RowNo, 默认值:0
	// 设置和获取 RowNo,类型int 默认值:0 开始
	private int rowNo = 0;

	/**
	 * 获取 RowNo, 类型int 默认值:0
	 *
	 * @return RowNo, 类型int 默认值:0
	 */
	public int getRowNo()
	{
		return this.rowNo;
	}

	/**
	 * 设置 RowNo, 类型int 默认值:0
	 *
	 * @param sRowNo
	 *            RowNo, 类型int 默认值:0
	 */
	public void setRowNo(int sRowNo)
	{
		this.rowNo = sRowNo;
	}

	// 设置和获取 RowNo, 类型int 默认值:0 结束
	// [end]

	// [start] 设置和获取 行样式名, 默认值:""
	// 设置和获取 行样式名,类型String 默认值:"" 开始
	private String trClassName = "";

	/**
	 * 获取 行样式名, 类型String 默认值:""
	 *
	 * @return 行样式名, 类型String 默认值:""
	 */
	public String getTrClassName()
	{
		if (this.trClassName.length() == 0)
		{
			if (getRowNo() % 2 == 0)
			{
				this.trClassName = com.yun.configuration.WebConfig.TRCLASSNAME1;
			}
			else
			{
				this.trClassName = com.yun.configuration.WebConfig.TRCLASSNAME2;
			}
		}
		return this.trClassName;
	}

	/**
	 * 设置 行样式名, 类型String 默认值:""
	 *
	 * @param sTrClass
	 *            行样式名, 类型String 默认值:""
	 */
	public void setTrClassName(String sTrClassName)
	{
		this.trClassName = sTrClassName;
	}

	// 设置和获取 行样式名, 类型String 默认值:"" 结束
	// [end]

	/**
	 * 返回存储在实体类中的Xml表现形式
	 */
	public String toXml()
	{
		try
		{
			StringBuilder sbStr = new StringBuilder(1024);
			sbStr.append("<?xml version=\"1.0\"?>\n");
			toXmlSerial(sbStr, 0);
			return sbStr.toString();

		}
		catch (FileNotFoundException e)
		{
			// e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			// e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// e.printStackTrace();
		}
		catch (IOException e)
		{
			// e.printStackTrace();
		}
		return "";
	}

	/**
	 * 保存实体类到文件
	 *
	 * @param filename
	 *            文件名
	 */
	public void Save(String filename)
	{
		com.colorwinglib.FileFormat.CreateFiles(filename, toXml());
	}

	/**
	 * 返回XML文件
	 * @param sbStr
	 * @param num
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public void toXmlSerial(StringBuilder sbStr, int num) throws InvocationTargetException, IllegalAccessException, IOException
	{
		String head = "";
		for (int i = 0; i < num; i++)
		{
			head += " ";
		}
		String className = this.getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1);
		sbStr.append(String.format("%s<%s>\n", head, className));

		Method[] methods = this.getClass().getMethods();
		for (int i = 0; i < methods.length; i++)
		{
			Class[] paras = methods[i].getParameterTypes();
			String name = methods[i].getName();
			if (paras == null || paras.length == 0)
			{
				if ((name.substring(0, 3).equals("get")) && !name.equals("getClass"))
				{
					Object obj = methods[i].invoke(this, null);
					getMethodXmlSerial(sbStr, obj, methods[i], num);
				}
			}
		}
		sbStr.append(String.format("%s</%s>\n", head, className));
	}

	private void getMethodXmlSerial(StringBuilder sbStr, Object obj, Method method, int num) throws InvocationTargetException, IllegalAccessException, IOException
	{
		if (obj == null)
			return;
		String head = "";
		for (int i = 0; i <= num; i++)
		{
			head += "\t";
		}
		if (obj.getClass().isArray())
		{
			for (int i = 0; i < Array.getLength(obj); i++)
			{
				Object childobj = Array.get(obj, i);
				if (childobj instanceof XmlSerializable)
				{
					((XmlSerializable) childobj).toXmlSerial(sbStr, num + 1);
				}
				else
				{
					getMethodXmlSerial(sbStr, childobj, method, num);
				}
			}
		}
		else
		{
			String itemName = method.getName().substring(3);
			sbStr.append(String.format("%s<%s>%s</%s>\n", head, itemName, com.colorwinglib.StringFormat.HtmlEncode(obj), itemName));
		}

	}

	/**
	 * 保存实体类到二进制文件
	 *
	 * @param filename
	 *            文件名
	 */
	public void SaveToBinary(String filename)
	{
		try
		{
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(this);
			out.close();
		}
		catch (IOException e)
		{

		}
	}

}
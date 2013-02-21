package com.yun.common;

import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Message
{	
	
	/**
	 * E0000015:编号重复
	 */
	public static String E0000015 = "E0000015";
	
	/**
	 * F0000001:0001：系统异常。请和管理员联系。
	 */
	public static String F0000001 = "F0000001";

	/**
	 * F0000002:0002：没有本画面的操作权限。
	 */
	public static String F0000002 = "F0000002";

	/**
	 * F0000003:0010：ＤＢ连接出错。请和管理员联系。
	 */
	public static String F0000003 = "F0000003";

	/**
	 * F0000004: {text}処理が失敗しました。
	 */
	public static String F0000004 = "F0000004";

	/**
	 * E0000001: {label_name}是必须入力项目，请务必输入。
	 */
	public static String E0000001 = "E0000001";

	/**
	 * E0000002: {label_name}是非０的数字项目，请重新输入。
	 */
	public static String E0000002 = "E0000002";

	/**
	 * E0000003:请在{label_name}项目里输入{N}位以下的文字。
	 */
	public static String E0000003 = "E0000003";

	/**
	 * E0000004:请在{label_name}项目里输入{param1}～{param2}的整数。
	 */
	public static String E0000004 = "E0000004";

	/**
	 * E0000005: 请在{label_name}项目里输入{param1}～{param2}的实数数。
	 */
	public static String E0000005 = "E0000005";

	/**
	 * E0000006: 请在{label_name}项目里输入日期。
	 */
	public static String E0000006 = "E0000006";

	/**
	 * E0000007: 请在{label_name}项目里输入IP。
	 */
	public static String E0000007 = "E0000007";

	/**
	 * E0000008: 主键数据已存在。
	 */
	public static String E0000008 = "E0000008";
	/**
	 * E0000009: 用户名不能为空!
	 */
	public static String E0000009 = "E0000009";
	/**
	 * E0000010: 密码不能为空!
	 */
	public static String E0000010 = "E0000010";
	/**
	 * E0000011: 该用户已经登录!
	 */
	public static String E0000011 = "E0000011";
	/**
	 * E0000012: 用户名或密码错误!
	 */
	public static String E0000012 = "E0000012";
	/**
	 * E0000013: 密码两次输入不同!
	 */
	public static String E0000013 = "E0000013";
	/**
	 * E0000014: 您的{label_name}写错了，请修改
	 */
	public static String E0000014 = "E0000014";

	/**
	 * I0000001: {text}中不存在所检索的数据。
	 */
	public static String I0000001 = "I0000001";

	/**
	 * I0000002: 添加成功
	 */
	public static String I0000002 = "I0000002";

	/**
	 * I0000003: 数据更新成功
	 */
	public static String I0000003 = "I0000003";

	/**
	 * I0000004: 没有更新任何数据
	 */
	public static String I0000004 = "I0000004";

	/**
	 * I0000005: 您访问的数据不存在，请确定后在访问。
	 */
	public static String I0000005 = "I0000005";

	/**
	 * I0000006: 总共有{n}个错误
	 */
	public static String I0000006 = "I0000006";

	/**
	 * I0000007: 删除成功
	 */
	public static String I0000007 = "I0000007";

	/**
	 * I0000008: 删除失败
	 */
	public static String I0000008 = "I0000008";

	/**
	 * I0000009: 添加失败
	 */
	public static String I0000009 = "I0000009";
	/**
	 * I0000010: 上传图片不能为空
	 */
	public static String I0000010 = "I0000010";
	/**
	 * I0000011: 数据更新失败
	 */
	public static String I0000011 = "I0000011";
	/**
	 * I0000012: 数据更新失败
	 */
	public static String I0000012 = "I0000012";
	/**
	 * I0000013: 文件太大，请选择小于{maxFSize}K的文件
	 */
	public static String I0000013 = "I0000013";
	/**
	 * I0000014: 停用成功
	 */
	public static String I0000014 = "I0000014";
	/**
	 * I0000015: 启用成功
	 */
	public static String I0000015 = "I0000015";

	/**
	 * W0000001:入力データを破棄して、前画面へ戻ります、よろしいですか？
	 */
	public static String W0000001 = "W0000001";

	/**
	 * W0000002:変更データを廃棄して、前画面へ戻ります、よろしいですか？
	 */
	public static String W0000002 = "W0000002";

	/**
	 * ECOM0001:{param1}取得処理でエラーが発生しました。
	 */
	public static String ECOM0001 = "ECOM0001";

	/**
	 * ECOM0006:{sp}のストアドプロシジャの実行に失敗しました。戻り値:{ret}
	 */
	public static String ECOM0006 = "ECOM0006";

	/**
	 * ECOM0012: ログイン処理に失敗しました。
	 */
	public static String ECOM0012 = "ECOM0012";

	/**
	 * ECOM5000: {text}処理が失敗しました。
	 */
	public static String ECOM5000 = "ECOM5000";

	/**
	 * ECOM5001: 遷移元ページは{text}からの派生クラスである必要があります。
	 */
	public static String ECOM5001 = "ECOM5001";

	/**
	 * ECOM5002: 該当データが存在しません。
	 */
	public static String ECOM5002 = "ECOM5002";

	/**
	 * ECOM5011:システムエラーが発生しました。
	 */
	public static String ECOM5011 = "ECOM5011";

	/**
	 * ICOM0001: ログインID :{LoginId}
	 */
	public static String ICOM0001 = "ICOM0001";

	/**
	 * ICOM0011: ログイン処理に成功しました。
	 */
	public static String ICOM0011 = "ICOM0011";

	/**
	 * ICOM9001: {naiyou}
	 */
	public static String ICOM9001 = "ICOM9001";

	/**
	 * WCOM0002:{label_name}を入力してください。
	 */
	public static String WCOM0002 = "WCOM0002";

	/**
	 * WCOM0003:{label_name}はYYYYMM形式で入力してください。
	 */
	public static String WCOM0003 = "WCOM0003";

	/**
	 * WCOM0004:{label_name}はYYYYMMDD形式で入力してください。
	 */
	public static String WCOM0004 = "WCOM0004";

	/**
	 * WCOM0006:{label_name}の値は{param1}～{param2}の範囲で入力してください。
	 */
	public static String WCOM0006 = "WCOM0006";

	/**
	 * WCOM0007:{label_name}は小数点以下{n}桁以内で入力してください。
	 */
	public static String WCOM0007 = "WCOM0007";

	/**
	 * WCOM0008:{param1}に禁則文字（{param2}）は設定できません。
	 */
	public static String WCOM0008 = "WCOM0008";

	/**
	 * WCOM0009:{param1}は半角{size}字以内で入力してください。
	 */
	public static String WCOM0009 = "WCOM0009";

	/**
	 * WCOM0010:{param1}は全角{size}字以内で入力してください。
	 */
	public static String WCOM0010 = "WCOM0010";

	/**
	 * WCOM0010:{param1}は全角{size}字以内で入力してください。
	 */
	
	public static String GetMessage(String messageId)
	{
		return GetMessage(messageId, new java.util.HashMap());
	}

	private static Document doc = null;

	public static String GetMessage(String messageId, java.util.HashMap valueMap)
	{
		String retMessage = "";

		try
		{
			if (doc == null)
			{
				String configFile = "/MessageControl.xml";
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				java.net.URL url = classLoader.getResource(configFile);
				if (url == null)
				{
					configFile = "MessageControl.xml";
					url = classLoader.getResource(configFile);
				}
				java.io.File f = new java.io.File(url.getPath());
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				doc = builder.parse(f);
			}
			NodeList nl = doc.getElementsByTagName("Message");
			for (int i = 0; i < nl.getLength(); i++)
			{
				if (nl.item(i).getAttributes().getNamedItem("ID").getNodeValue().equals(messageId))
				{

					//NodeList nlDescription = doc.getElementsByTagName("Description");
					NodeList nlDescription = nl.item(i).getChildNodes();
					for (int z = 0; z < nlDescription.getLength(); z++)
					{
						if (nlDescription.item(z).getAttributes()!=null && nlDescription.item(z).getAttributes().getNamedItem("LANG").getNodeValue().equals("zh-cn"))
						{
							retMessage = nlDescription.item(z).getAttributes().getNamedItem("DESC").getNodeValue();
							break;
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		for (Iterator it = valueMap.keySet().iterator(); it.hasNext();)
		{
			String key = (String) it.next();
			String messagepara = "{" + key + "}";
			retMessage = retMessage.replace(messagepara, valueMap.get(key).toString());
		}

		return retMessage;
	}

}
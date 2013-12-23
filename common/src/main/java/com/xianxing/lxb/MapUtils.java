package com.xianxing.lxb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：Map相关的工具类. <br>
 * @author KevinZhang
 * 日期：Apr 23, 2013
 */
public class MapUtils
{
	/**
	 * 描述：根据参数动态生成Map对象. <br>
	 * @return {Map} {参数名称：参数值}
	 * @author KevinZhang
	 */
	public static Map<String, Object> AttrToMap(List<Object> args)
	{
		/*结果对象*/
		Map<String, Object> map = new HashMap<String, Object>();
		
		Object o = null;
		String key = null;
		for (int i = 0; i < args.size(); i++) 
		{
			o = args.get(i);
			key = "" + o;
			map.put(key, o);
		}
		
		return map;
	}
	
	public static void main(String args[])
	{
		List<Object> list = new ArrayList<Object>();
		list.add("zhangsan");
		list.add(10);
		
		AttrToMap(list);
	}

}

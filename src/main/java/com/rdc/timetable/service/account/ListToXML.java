package com.rdc.timetable.service.account;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * List转化成XML
 * @author Treey
 * @time 2012-5-29 下午04:19:51
 * 
 * 当前仅能转化Object嵌套一层在List里
 */
public class ListToXML {

//	private static Document document = null;
//	
//	public static <T> Document XML(List<T> list) {
//		document = DocumentHelper.createDocument();
//		return document;
//	}
	
	
	/**
	 * 
	 */
	public static <T> Document listToXML(List<T> list) throws Exception {
		Document document = DocumentHelper.createDocument();
		if(list.size() <= 0) {
			return null;
		} else {
			@SuppressWarnings("rawtypes")
			Class clazz = list.get(0).getClass();
			Field[] fields = clazz.getDeclaredFields();
			Element roots = document.addElement(clazz.getSimpleName().toLowerCase() + "s");
			for(int i=0; i<list.size(); i++) {
				Element root = roots.addElement(clazz.getSimpleName().toLowerCase());
				for(int j=0; j<fields.length; j++) {
					PropertyDescriptor pd = new PropertyDescriptor(
							fields[j].getName(), clazz);
					Method getMethod = pd.getReadMethod();// 获得get方法
					Object o = getMethod.invoke(list.get(i));// 执行get方法返回一个Object
					if(fields[j].getType().isPrimitive() || fields[j].getType().getName().equals("java.lang.String")) {
						Element e1 = root.addElement(fields[j].getName());
						e1.setText(o.toString());
					} else {
						objectToXML(o,root);
					}
				}
			}
		}
		System.out.println(document.asXML());
		return document;
	}
	
	public static void objectToXML(Object o,Element e) throws Exception {
		@SuppressWarnings("rawtypes")
		Class clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Element ObjectElement = e.addElement(clazz.getSimpleName().toLowerCase());
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
			PropertyDescriptor pd = new PropertyDescriptor(
					fields[i].getName(), clazz);
			Method getMethod = pd.getReadMethod();// 获得get方法
			Object o1 = getMethod.invoke(o);// 执行get方法返回一个Object
			System.out.println(o1);
			Element e2 = ObjectElement.addElement(fields[i].getName());
			e2.setText(o1.toString());
		}
	}
}

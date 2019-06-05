package com.lxtx.util;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * 系统类型工具类
 * @author jackson
 * @version 1.0 2016/05/13
 */
public class ClassUtil {
	
	/**
	 * 取得所有字段数组
	 * @param clazz 类型对象
	 * @return 所有字段数组
	 */
	public static Field[] getAllFields(Class<?> clazz) {
		
		// 声明属性字段数组
		Field[] fields = new Field[0];
		
		// 如果类对象不为空
		if (clazz != null) {
			
			// 取得所有字段数组
			Field[] declaredFields = clazz.getDeclaredFields();
			
			// 如果所有字段数组不为空
			if (ArrayUtils.isNotEmpty(declaredFields)) {
				
				// 将所有字段数组添加到属性字段列表中
				fields = ArrayUtils.addAll(fields, declaredFields);
			}
			
			// 取得类型对象的父类
			Class<?> superClass = clazz.getSuperclass();
			
			// 如果父类对象不为空
			if (superClass != null) {
				
				// 将父类对象的所有属性添加到属性字段列表中
				fields = ArrayUtils.addAll(fields, getAllFields(superClass));
			}
		}
		
		// 返回属性字段列表
		return fields;
	}
	
	/**
	 * 取得字段对象
	 * @param clazz 类型对象
	 * @param propertyName 属性名称
	 * @return 字段对象
	 */
	public static Field getField(Class<?> clazz, String propertyName) {
		
		// 声明字段对象
		Field field = null;
		
		// 如果类对象不为空
		if (clazz != null) {
		
			try {
				
				// 取得字段对象
				field = clazz.getDeclaredField(propertyName);
			} 
			// 发生异常
			catch (Exception e) {
				
				// 取得字段对象
				field = getField(clazz.getSuperclass(), propertyName);
			}
		}
		
		// 返回字段对象
		return field;
	}
}

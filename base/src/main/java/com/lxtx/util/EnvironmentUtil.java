package com.lxtx.util;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Locale;


/**
 * CAAC系统运行环境工具类
 * @author jackson
 * @version 1.0  2016年3月25日
 */
public class EnvironmentUtil {
	
	/**
	 * 取得资源输入流
	 * @param clazz 需要使用文件的类
	 * @param resource 资源名称
	 * @return 资源输入流
	 */
	public static InputStream getResourceAsStream(Class<?> clazz, String resource) {
		
		// 返回资源URL
		return clazz.getResourceAsStream(resource);
	}
	
	/**
	 * 取得资源输入流
	 * @param resource 资源名称
	 * @return 资源输入流
	 */
	public static InputStream getResourceAsStream(String resource) {
		
		// 返回资源URL
		return EnvironmentUtil.class.getResourceAsStream(resource);
	}
	
	/**
	 * 取得资源URL
	 * @param clazz 需要使用文件的类
	 * @param resource 资源名称
	 * @return 资源URL
	 */
	public static URL getResourceUrl(Class<?> clazz, String resource) {
		
		// 返回资源URL
		return clazz.getResource(resource);
	}
	
	/**
	 * 取得资源URL
	 * @param resource 资源名称
	 * @return 资源URL
	 */
	public static URL getResourceUrl(String resource) {
		
		// 返回资源URL
		return EnvironmentUtil.class.getResource(resource);
	}
	
	/**
	 * 取得文件的绝对路径
	 * @param clazz 需要使用文件的类
	 * @param path 文件的相对路径
	 * @return 文件的绝对路径
	 */
	public static String getAbsolutePath(Class<?> clazz, String path) {
		
		// 取得系统类根目录
		String absolutePath = clazz.getResource(path).getPath();
		// 返回目录或者文件绝对路径
		return absolutePath;
	}
	
	/**
	 * 取得文件的绝对路径
	 * @param path 文件的相对路径
	 * @return 文件的绝对路径
	 */
	public static String getAbsolutePath(String path) {
		
		// 取得系统类根目录
		String absolutePath = EnvironmentUtil.class.getResource(path).getPath();
		// 返回目录或者文件绝对路径
		return absolutePath;
	}
	
	/**
	 * 取得系统区域
	 * @return 系统区域
	 */
	public static Locale getSystemLocale() {
		
		// 声明区域信息
		Locale locale = Locale.getDefault();
		
		// 返回区域信息
		return locale;
	}
	
	/**
	 * 将区域字符表达式转换为区域对象
	 * @param expression 区域字符表达式
	 * @return 区域对象
	 */
	public static Locale convertExpression2Locale(String expression) {
		
		// 声明区域对象
		Locale locale = EnvironmentUtil.getSystemLocale();
		
		// 如果字符表达式不为空
		if (StringUtils.isNotBlank(expression)) {
			
			// 创建区域对象
			locale = new Locale(StringUtils.substringBefore(expression, "_"), StringUtils.substringAfter(expression, "_"));
		}
		
		// 返回区域对象
		return locale;
	}
	
	/**
	 * 将语言标签转换为区域对象
	 * @param languageTag 语言标签
	 * @return 区域对象
	 */
	public static Locale convertLanguageTag2Locale(String languageTag) {
		
		// 声明区域对象
		Locale locale = EnvironmentUtil.getSystemLocale();
		
		// 如果字符表达式不为空
		if (StringUtils.isNotBlank(languageTag)) {
			
			// 创建区域对象
			locale = new Locale(StringUtils.substringBefore(languageTag, "-"), StringUtils.substringAfter(languageTag, "-"));
		}
		
		// 返回区域对象
		return locale;
	}
	
	/**
	 * 将区域字符表达式转换为语言标签
	 * @param expression 区域字符表达式
	 * @return 语言标签
	 */
	public static String convertExpression2LanguageTag(String expression) {
		
		// 返回语言标签
		return StringUtils.replace(expression, "_", "-");
	}
	
	/**
	 * 将语言标签转换为区域字符表达式
	 * @param languageTag 语言标签
	 * @return 区域字符表达式
	 */
	public static String convertLanguageTag2Expression(String languageTag) {
		
		// 返回区域字符表达式
		return StringUtils.replace(languageTag, "-", "_");
	}
}

package com.lxtx.base.utils;

/**
 * 通用common 常量
 * @author jackson
 */
public class CommonConstants {
    /** 系统默认编码: "UTF-8" */
    public static final String DEFAULT_CHAR_CODEC = "UTF-8";

    /** 默认日期时间格式 */
    public static final String FORMAT_PATTERN_DEFAULT_DATE_TIME = "yyyy/MM/dd HH:mm";
    /** 默认日期格式 */
    public static final String FORMAT_PATTERN_DEFAULT_DATE = "yyyy/MM/dd";
    /** 默认时间格式 */
    public static final String FORMAT_PATTERN_DEFAULT_TIME = "HH:mm";
    /** 完整日期时间格式 */
    public static final String FORMAT_PATTERN_FULL_DATE_TIME = "yyyy/MM/dd HH:mm:ss.SSS";
    /** 完整时间格式 */
    public static final String FORMAT_PATTERN_FULL_TIME = "HH:mm:ss.SSS";

    /** 缓存名称: "dialog_title_cache" 对话框标题缓存 */
    public static final String CACHE_NAME_DIALOG_TITLE = "dialog_title_cache";
    /** 缓存名称: "item_dictionary_cache" 项目字典缓存 */
    public static final String CACHE_NAME_ITEM_DICTIONARY = "item_dictionary_cache";

    /** 文件大小: "1024" 1KB */
    public static final long CONTENT_SIZE_1KB = 1024L;
    /** 文件大小: "1048576" 1MB */
    public static final long CONTENT_SIZE_1MB = 1048576L;
    /** 文件大小: "1073741824" 1GB */
    public static final long CONTENT_SIZE_1GB = 1073741824L;
    /** 文件大小: "1099511627776" 1TB */
    public static final long CONTENT_SIZE_1TB = 1099511627776L;
    /** 文件大小: "1125899906842624" 1PB */
    public static final long CONTENT_SIZE_1PB = 1125899906842624L;

    /** 时间区间类型: "1" 秒 */
    public static final int PERIOD_TYPE_SECOND = 1;
    /** 时间区间类型: "2" 分钟 */
    public static final int PERIOD_TYPE_MINUTE = 2;
    /** 时间区间类型: "3" 小时 */
    public static final int PERIOD_TYPE_HOUR = 3;
    /** 时间区间类型: "4" 日 */
    public static final int PERIOD_TYPE_DAY = 4;
    /** 时间区间类型: "5" 星期 */
    public static final int PERIOD_TYPE_WEEK = 5;
    /** 时间区间类型: "6" 月份 */
    public static final int PERIOD_TYPE_MONTH = 6;
    /** 时间区间类型: "7" 季度 */
    public static final int PERIOD_TYPE_SEASON = 7;
    /** 时间区间类型: "8" 半年 */
    public static final int PERIOD_TYPE_HALF_YEAR = 8;
    /** 时间区间类型: "9" 年 */
    public static final int PERIOD_TYPE_YEAR = 9;

    /** 二维码文件默认宽度: "300" 300像素 */
    public static final int QR_CODE_WIDTH = 300;
    /** 二维码文件默认高度: "300" 300像素 */
    public static final int QR_CODE_HEIGHT = 300;

    /** 二维码亮部颜色: "0xFFFFFFFF" 白色 */
    public static final int QR_CODE_HIGH_LIGHT_COLOR = 0xFFFFFFFF;
    /** 二维码暗部颜色: "0xFF000000" 黑色 */
    public static final int QR_CODE_LOW_LIGHT_COLOR = 0xFF000000;
}

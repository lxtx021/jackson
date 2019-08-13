package com.jackson.springboot1.controller;

import com.alibaba.fastjson.JSONObject;
import com.jackson.springboot1.model.User;
import com.sun.istack.internal.Nullable;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicColorChooserUI;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
@RestController
public class TestController {

    @ApiOperation(value = "test3 ")
    @RequestMapping("/test3")
    public String test3(User user, HttpServletRequest request)throws Exception {
        //从Request中获取所有的参数key 和 value
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        //获取目标类的对象
        // java 反射获取object对象的属性
        Object target = user.getClass().newInstance();
        Field[] fields = target.getClass().getDeclaredFields();
        while (iterator.hasNext()){
            Map.Entry<String, String[]> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue()[0];
            for (Field field:fields){
                String name = field.getName();
                if (key.equals(name)){
                    field.setAccessible(true);
                    field.set(target,value);
                    break;
                }
            }
        }
        System.out.println("userInfo:{}"+JSONObject.toJSONString(target));
        return "Python";
    }


    @ApiOperation(value = "test4")
    @RequestMapping("/test4")
    public String test4(User user, HttpServletRequest request)throws Exception {
        //从Request中获取所有的参数key 和 value
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        //获取目标类的对象
        // java 反射获取object对象的属性
        Object target = user.getClass().newInstance();
        Field[] fields = target.getClass().getDeclaredFields();
        while (iterator.hasNext()){
            Map.Entry<String, String[]> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue()[0];
            /**
             * 为什么要说到内省机制呢？因为Spring在处理这件事的时候，最终也是靠它处理的。
             *
             * 简单来说，它是通过BeanWrapperImpl来处理的。关于BeanWrapperImpl有个很简单的使用方法：
             */
            setProperty(target,key,value);
        }
        System.out.println("userInfo:{}"+JSONObject.toJSONString(target));
        return "Python";
    }
//    https://www.jianshu.com/p/bf3537334e76
    /**
     * SysUser user = new SysUser();
     * BeanWrapper wrapper = new BeanWrapperImpl(user.getClass());
     *
     * wrapper.setPropertyValue("id","20001");
     * wrapper.setPropertyValue("name","Jack");
     *
     * Object instance = wrapper.getWrappedInstance();
     * System.out.println(instance);
     */
   /* private class BeanPropertyHandler extends BasicColorChooserUI.PropertyHandler {
        //属性描述符
        private final PropertyDescriptor pd;
        public void setValue(@Nullable Object value) throws Exception {
            //获取set方法
            Method writeMethod = this.pd.getWriteMethod();
            ReflectionUtils.makeAccessible(writeMethod);
            //设置
            writeMethod.invoke(BeanWrapperImpl.this.getWrappedInstance(), value);
        }
    }*/


    /**
     * 除了反射，Java还有一种内省机制可以完成这件事。我们可以获取目标类的属性描述符对象，然后拿到它的Method对象， 通过invoke来设置。
     * @param target
     * @param key
     * @param value
     */
    private void setProperty(Object target,String key,String value) {
        try {
            PropertyDescriptor propDesc = new PropertyDescriptor(key, target.getClass());
            Method method = propDesc.getWriteMethod();
            method.invoke(target, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

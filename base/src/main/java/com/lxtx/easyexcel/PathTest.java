package com.lxtx.easyexcel;

public class PathTest {
    /*1、利用System.getProperty()函数获取当前路径：
            System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径

    2、使用File提供的函数获取当前路径：
        File directory = new File("");//设定为当前文件夹
    try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exceptin e){}

    File.getCanonicalPath()和File.getAbsolutePath()大约只是对于new File(".")和new File("..")两种路径有所区别。

                # 对于getCanonicalPath()函数，“."就表示当前的文件夹，而”..“则表示当前文件夹的上一级文件夹
                # 对于getAbsolutePath()函数，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
    # 至于getPath()函数，得到的只是你在new File()时设定的路径

        比如当前的路径为 C:/test ：
        File directory = new File("abc");
    directory.getCanonicalPath(); //得到的是C:/test/abc
    directory.getAbsolutePath();    //得到的是C:/test/abc
    direcotry.getPath();                    //得到的是abc

        File directory = new File(".");
    directory.getCanonicalPath(); //得到的是C:/test
    directory.getAbsolutePath();    //得到的是C:/test/.
    direcotry.getPath();                    //得到的是.

        File directory = new File("..");
    directory.getCanonicalPath(); //得到的是C:/
    directory.getAbsolutePath();    //得到的是C:/test/..
    direcotry.getPath();                    //得到的是..


        另外：System.getProperty()中的字符串参数如下：
                System.getProperty()参数大全
    # java.version                                Java Runtime Environment version
    # java.vendor                                Java Runtime Environment vendor
    # java.vendor.url                           Java vendor URL
    # java.home                                Java installation directory
    # java.vm.specification.version   Java Virtual Machine specification version
    # java.vm.specification.vendor    Java Virtual Machine specification vendor
    # java.vm.specification.name      Java Virtual Machine specification name
    # java.vm.version                        Java Virtual Machine implementation version
    # java.vm.vendor                        Java Virtual Machine implementation vendor
    # java.vm.name                        Java Virtual Machine implementation name
    # java.specification.version        Java Runtime Environment specification version
    # java.specification.vendor         Java Runtime Environment specification vendor
    # java.specification.name           Java Runtime Environment specification name
    # java.class.version                    Java class format version number
    # java.class.path                      Java class path
    # java.library.path                 List of paths to search when loading libraries
    # java.io.tmpdir                       Default temp file path
    # java.compiler                       Name of JIT compiler to use
    # java.ext.dirs                       Path of extension directory or directories
    # os.name                              Operating system name
    # os.arch                                  Operating system architecture
    # os.version                       Operating system version
    # file.separator                         File separator ("/" on UNIX)
    # path.separator                  Path separator (":" on UNIX)
    # line.separator                       Line separator ("/n" on UNIX)
    # user.name                        User’s account name
    # user.home                              User’s home directory
    # user.dir                               User’s current working directory



    JAVA中获取路径:

            1.jsp中取得路径：

    以工程名为TEST为例：

            (1)得到包含工程名的当前页面全路径：request.getRequestURI()
    结果：/TEST/test.jsp
            (2)得到工程名：request.getContextPath()
    结果：/TEST
            (3)得到当前页面所在目录下全名称：request.getServletPath()
    结果：如果页面在jsp目录下 /TEST/jsp/test.jsp
            (4)得到页面所在服务器的全路径：application.getRealPath("页面.jsp")
    结果：D:/resin/webapps/TEST/test.jsp
            (5)得到页面所在服务器的绝对路径：absPath=new java.io.File(application.getRealPath(request.getRequestURI())).getParent();
    结果：D:/resin/webapps/TEST

    2.在类中取得路径：

                (1)类的绝对路径：Class.class.getClass().getResource("/").getPath()
        结果：/D:/TEST/WebRoot/WEB-INF/classes/pack/
                (2)得到工程的路径：System.getProperty("user.dir")
        结果：D:/TEST

    3.在Servlet中取得路径：

                (1)得到工程目录：request.getSession().getServletContext().getRealPath("") 参数可具体到包名。
        结果：E:/Tomcat/webapps/TEST
                (2)得到IE地址栏地址：request.getRequestURL()
        结果：http://localhost:8080/TEST/test
                (3)得到相对地址：request.getRequestURI()
        结果：/TEST/test*/
}

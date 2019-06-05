
单例模式即一个JVM内存中只存在一个类的对象实例







分类

1、懒汉式

类加载的时候就创建实例

2、饿汉式

使用的时候才创建实例



当然还有其他的生成单例的方式，双重校验锁，枚举和静态内部类，文中会有介绍



实践

懒汉式

1)线程不安全，不可用

public class Singleton {  

    private static Singleton instance;  

    private Singleton (){}  

  

    public static Singleton getInstance() {  

    if (instance == null) {  

        instance = new Singleton();  

    }  

    return instance;  

    }  

} 



2)线程安全，同步方法，效率低，不推荐

public class Singleton {  

    private static Singleton instance;  

    private Singleton (){}  

    public static synchronized Singleton getInstance() {  

    if (instance == null) {  

        instance = new Singleton();  

    }  

    return instance;  

    }  

} 



3)线程不安全，会产生多个实例，不可用

public class Singleton {

    private static Singleton singleton;

	private Singleton() {}



    public static Singleton getInstance() {

        if (singleton == null) {

            synchronized (Singleton.class) {

                singleton = new Singleton();

            }

        }

        return singleton;

    }

}



饿汉式，无线程安全问题，不能延迟加载，影响系统性能

4)

public class Singleton {  

    private static Singleton instance = new Singleton();  

    private Singleton (){}  

    public static Singleton getInstance() {  

		return instance;  

    }  

} 



5)

public class Singleton {  

    private static Singleton instance = null;  

    static {  

		instance = new Singleton();  

    }  

    private Singleton (){}  

    public static Singleton getInstance() {  

		return instance;  

    }  

}



6)双重校验锁，线程安全，推荐使用

public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {}



    public static Singleton getInstance() {

        if (singleton == null) {

            synchronized (Singleton.class) {

                if (singleton == null) {

                    singleton = new Singleton();

                }

            }

        }

        return singleton;

    }

} 



7)静态内部类，线程安全，主动调用时才实例化，延迟加载效率高，推荐使用

public class Singleton {  

    private static class SingletonHolder {  

		private static final Singleton INSTANCE = new Singleton();  

    }  

    private Singleton (){}  

    public static final Singleton getInstance() {  

		return SingletonHolder.INSTANCE;  

    }  

} 



8)枚举类型，无线程安全问题，避免反序列华创建新的实例，很少使用

public enum Singleton {  

    INSTANCE;  

    public void whateverMethod() {  

    }  

}



注意事项

1、考虑多线程问题

2、单例类构造方法要设置为private类型禁止外界new创建

private Singleton() {}

3、如果类可序列化，考虑反序列化生成多个实例问题，解决方案如下

private Object readResolve() throws ObjectStreamException {  

	// instead of the object we're on, return the class variable INSTANCE  

	return INSTANCE;  

}  



使用场景

1、工具类对象

2、系统中只能存在一个实例的类

3、创建频繁或又耗时耗资源且又经常用到的对象



下面是单例模式在JDK的应用



另外，spring容器中的实例默认是单例饿汉式类型的，即容器启动时就实例化bean到容器中，当然也可以设置懒汉式defalut-lazy-init="true"为延迟实例化，用到时再实例化。

https://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247483742&idx=1&sn=9429b26871f19e4dafd1bf0c7ec0520e&chksm=eb538468dc240d7e968486dbdb7fa440b365ac81a3d9920013781776b601754b1a0659b92b70&scene=21#wechat_redirect
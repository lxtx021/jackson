package com.lxtx.base.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 20 个案例教你在 Java 8 中如何处理日期和时间?
 * https://mp.weixin.qq.com/s/MLvta9sitEdktH5CfBJXMQ
 * http://www.54tianzhisheng.cn/2018/06/19/SimpleDateFormat/
 * @author sun
 */
public class DateTest2 {
    public static void main(String[] args) {

        demo2();
    }

    /**
     * 1、
     * Java 8 中的 LocalDate 用于表示当天日期。和 java.util.Date 不同，它只有日期，不包含时间。当你仅需要表示日期时就用这个类。
     * 上面的代码创建了当天的日期，不含时间信息。打印出的日期格式非常友好，不像老的 Date 类打印出一堆没有格式化的信息。
     */
    public static void demo1(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    /**
     * 示例 2、在 Java 8 中获取年、月、日信息
     * LocalDate 类提供了获取年、月、日的快捷方法，其实例还包含很多其它的日期属性。通过调用这些方法就可以很方便的得到需要的日期信息，不用像以前一样需要依赖 java.util.Calendar 类了
     * year = 2018, month = 6, day = 20
     */
    public static void demo2(){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        System.out.printf("year = %d, month = %d, day = %d", year, monthValue, dayOfMonth);
    }

    /**
     * 示例 3、在 Java 8 中处理特定日期
     * 在第一个例子里，我们通过静态工厂方法 now() 非常容易地创建了当天日期，你还可以调用另一个有用的工厂方法LocalDate.of() 创建任意日期，
     * 该方法需要传入年、月、日做参数，返回对应的 LocalDate 实例。这个方法的好处是没再犯老 API 的设计错误，比如年度起始于 1900，月份是从 0 开始等等。
     * 日期所见即所得，就像下面这个例子表示了 6 月 20 日，没有任何隐藏机关。
     */
    public static void demo3(){
        LocalDate date = LocalDate.of(2018, 06, 20);
        System.out.println(date);
    }

    /**
     * 示例 4、在 Java 8 中判断两个日期是否相等
     * 现实生活中有一类时间处理就是判断两个日期是否相等。你常常会检查今天是不是个特殊的日子，
     * 比如生日、纪念日或非交易日。这时就需要把指定的日期与某个特定日期做比较，
     * 例如判断这一天是否是假期。下面这个例子会帮助你用 Java 8 的方式去解决，
     * 你肯定已经想到了，LocalDate 重载了 equal 方法，请看下面的例子：
     */
    public static void demo4(){
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2018, 06, 20);
        if (date.equals(now)) {
            System.out.println("同一天");
        }
    }

    /**
     * 示例 5、在 Java 8 中检查像生日这种周期性事件
     * Java 中另一个日期时间的处理就是检查类似每月账单、结婚纪念日、EMI日或保险缴费日这些周期性事件。如果你在电子商务网站工作，
     * 那么一定会有一个模块用来在圣诞节、感恩节这种节日时向客户发送问候邮件。Java 中如何检查这些节日或其它周期性事件呢？
     * 答案就是 MonthDay 类。这个类组合了月份和日，去掉了年，这意味着你可以用它判断每年都会发生事件。
     * 和这个类相似的还有一个 YearMonth 类。这些类也都是不可变并且线程安全的值类型。下面我们通过 MonthDay 来检查周期性事件：
     */
    public static void demo5(){
        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2018, 06, 20);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(now);
        if (currentMonthDay.equals(birthday)) {
            System.out.println("Happy Birthday");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }
    }

    /**
     * 示例 6、在 Java 8 中获取当前时间
     * 与 Java 8 获取日期的例子很像，获取时间使用的是 LocalTime 类，
     * 一个只有时间没有日期的 LocalDate 近亲。可以调用静态工厂方法 now() 来获取当前时间。
     * 默认的格式是 hh:mm:ss:nnn。
     */
    public static void demo6(){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    /**
     * 示例 7、如何在现有的时间上增加小时
     * 通过增加小时、分、秒来计算将来的时间很常见。
     * Java 8 除了不变类型和线程安全的好处之外，还提供了更好的plusHours() 方法替换 add()，并且是兼容的。
     * 注意，这些方法返回一个全新的 LocalTime 实例，由于其不可变性，返回后一定要用变量赋值。
     * 可以看到，新的时间在当前时间 13:41:20.721 的基础上增加了 2 个小时。
     */
    public static void demo7(){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime localTime1 = localTime.plusHours(2);//增加2小时
        LocalTime localTime2 = localTime.minusHours(3);// 减少3小时
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    /**
     * 示例 8、如何计算一周后的日期
     * 和上个例子计算两小时以后的时间类似，这个例子会计算一周后的日期。
     * LocalDate 日期不包含时间信息，它的 plus()方法用来增加天、周、月，
     * ChronoUnit 类声明了这些时间单位。由于 LocalDate 也是不变类型，返回后一定要用变量赋值。
     *
     * 可以看到新日期离当天日期是 7 天，也就是一周。你可以用同样的方法增加 1 个月、1 年、1 小时、1 分钟甚至一个世纪，更多选项可以查看 Java 8 API 中的 ChronoUnit 类。
     *
     */
    public static void demo8(){
        LocalDate now = LocalDate.now();
        LocalDate plusDate = now.plus(1, ChronoUnit.WEEKS);
        System.out.println(now);
        System.out.println(plusDate);
    }

    /**
     *示例 9、计算一年前或一年后的日期
     * 继续上面的例子，上个例子中我们通过 LocalDate 的 plus() 方法增加天数、周数或月数，这个例子我们利用 minus() 方法计算一年前的日期。
     */
    public static void demo9(){
        LocalDate now = LocalDate.now();
        LocalDate minusDate = now.minus(1, ChronoUnit.YEARS);
        LocalDate plusDate1 = now.plus(1, ChronoUnit.YEARS);
        System.out.println(minusDate);
        System.out.println(plusDate1);
    }

    /**
     * 示例 10、使用 Java 8 的 Clock 时钟类
     * Java 8 增加了一个 Clock 时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。
     * 以前用到System.currentTimeInMillis() 和 TimeZone.getDefault() 的地方都可用 Clock 替换。
     *
     * SystemClock[Z]
     * SystemClock[Asia/Shanghai]
     */
    public static void demo10(){
        Clock clock = Clock.systemUTC();
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println(clock);
        System.out.println(clock1);
    }

    /**
     * 示例 11、如何用 Java 判断日期是早于还是晚于另一个日期
     * 另一个工作中常见的操作就是如何判断给定的一个日期是大于某天还是小于某天？
     * 在 Java 8 中，LocalDate 类有两类方法 isBefore() 和 isAfter() 用于比较日期。调用 isBefore() 方法时，如果给定日期小于当前日期则返回 true。
     */
    public static void demo11(){
        LocalDate now = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2018,6,20);
        if(tomorrow.isAfter(now)){
             System.out.println("Tomorrow comes after today");
         }
        LocalDate yesterday = now.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(now)){
             System.out.println("Yesterday is day before today");
        }
    }

    /**
     * 示例 12、在 Java 8 中处理时区
     * Java 8 不仅分离了日期和时间，也把时区分离出来了。
     * 现在有一系列单独的类如 ZoneId 来处理特定时区，ZoneDateTime 类来表示某时区下的时间。这在 Java 8 以前都是 GregorianCalendar 类来做的。
     */
    public static void demo12(){
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println(dateAndTimeInNewYork);
    }

    /**
     * 示例 13、如何表示信用卡到期这类固定日期，答案就在 YearMonth
     * 与 MonthDay 检查重复事件的例子相似，YearMonth 是另一个组合类，用于表示信用卡到期日、FD 到期日、期货期权到期日等。
     * 还可以用这个类得到 当月共有多少天，YearMonth 实例的 lengthOfMonth() 方法可以返回当月的天数，在判断 2 月有 28 天还是 29 天时非常有用。
     */
    public static void demo13(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    /**
     * 示例 14、如何在 Java 8 中检查闰年
     * LocalDate 类有一个很实用的方法 isLeapYear() 判断该实例是否是一个闰年。
     */
    public static void demo14(){

    }

    /**
     * 示例 15、计算两个日期之间的天数和月数
     * 有一个常见日期操作是计算两个日期之间的天数、周数或月数。在 Java 8 中可以用 java.time.Period 类来做计算。下面这个例子中，我们计算了当天和将来某一天之间的月数。
     */
    public static void demo15(){
        LocalDate now =LocalDate.now();
        LocalDate date = LocalDate.of(2019, Month.MARCH, 20);
        Period period = Period.between(now, date);
        System.out.println("离下个时间还有" + period.getMonths() + " 个月");
    }

    /**
     * 示例 16、包含时差信息的日期和时间
     * 在 Java 8 中，ZoneOffset 类用来表示时区，举例来说印度与 GMT 或 UTC 标准时区相差 +05:30，
     * 可以通过ZoneOffset.of() 静态方法来获取对应的时区。
     * 一旦得到了时差就可以通过传入 LocalDateTime 和 ZoneOffset 来创建一个 OffSetDateTime 对象。
     */
    public static void demo16(){
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14,19,30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    /**
     * 示例 17、在 Java 8 中获取当前的时间戳
     * 如果你还记得 Java 8 以前是如何获得当前时间戳，那么现在你终于解脱了。Instant 类有一个静态工厂方法 now() 会返回当前的时间戳，如下所示：
     * 2018-06-20T06:35:24.881Z
     * 时间戳信息里同时包含了日期和时间，这和 java.util.Date 很像。
     * 实际上 Instant 类确实等同于 Java 8 之前的 Date类，你可以使用 Date 类和 Instant 类各自的转换方法互相转换，
     * 例如：Date.from(Instant) 将 Instant 转换成java.util.Date，Date.toInstant() 则是将 Date 类转换成 Instant 类。
     */
    public static void demo17(){
        Instant timestamp = Instant.now();
        System.out.println(timestamp);
    }

    /**
     * 示例 18、在 Java 8 中如何使用预定义的格式化工具去解析或格式化日期
     * 在 Java 8 以前的世界里，日期和时间的格式化非常诡异，唯一的帮助类 SimpleDateFormat 也是非线程安全的，而且用作局部变量解析和格式化日期时显得很笨重。幸好线程局部变量能使它在多线程环境中变得可用，不过这都是过去时了。Java 8 引入了全新的日期时间格式工具，线程安全而且使用方便。它自带了一些常用的内置格式化工具。
     * 参见我上一篇文章： 《SimpleDateFormat 如何安全的使用？》
     */
    public static void demo18(){

    }

    /**
     * 示例 19、如何在 Java 中使用自定义格式化工具解析日期
     * 尽管内置格式化工具很好用，有时还是需要定义特定的日期格式。可以调用 DateTimeFormatter 的 ofPattern() 静态方法并传入任意格式返回其实例，格式中的字符和以前代表的一样，M 代表月，m 代表分。如果格式不规范会抛出 DateTimeParseException 异常，不过如果只是把 M 写成 m 这种逻辑错误是不会抛异常的。
     *
     * 参见我上一篇文章： 《SimpleDateFormat 如何安全的使用？》
     */
    public static void demo19(){

    }

    /**
     * 示例 20、在 Java 8 中如何把日期转换成字符串
     * 上两个主要是从字符串解析日期。现在我们反过来，把 LocalDateTime 日期实例转换成特定格式的字符串。
     * 这是迄今为止 Java 日期转字符串最为简单的方式了。下面的例子将返回一个代表日期的格式化字符串。
     * 和前面类似，还是需要创建 DateTimeFormatter 实例并传入格式，但这回调用的是 format() 方法，
     * 而非 parse() 方法。这个方法会把传入的日期转化成指定格式的字符串。
     */
    public static void demo20(){
        LocalDateTime arrivalDate  = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMdd yyyy  hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at :  %s %n", landing);
        }catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }

    /**
     * Java 8 日期时间 API 的重点
     * 通过这些例子，你肯定已经掌握了 Java 8 日期时间 API 的新知识点。现在来回顾一下这个优雅 API 的使用要点：
     *
     * 1）提供了 javax.time.ZoneId 获取时区。
     *
     * 2）提供了 LocalDate 和 LocalTime 类。
     *
     * 3）Java 8 的所有日期和时间 API 都是不可变类并且线程安全，而现有的 Date 和 Calendar API 中的 java.util.Date 和SimpleDateFormat 是非线程安全的。
     *
     * 4）主包是 java.time, 包含了表示日期、时间、时间间隔的一些类。里面有两个子包 java.time.format 用于格式化， java.time.temporal 用于更底层的操作。
     *
     * 5）时区代表了地球上某个区域内普遍使用的标准时间。每个时区都有一个代号，格式通常由区域/城市构成（Asia/Tokyo），在加上与格林威治或 UTC 的时差。例如：东京的时差是 +09:00。
     *
     * 6）OffsetDateTime 类实际上组合了 LocalDateTime 类和 ZoneOffset 类。用来表示包含和格林威治或 UTC 时差的完整日期（年、月、日）和时间（时、分、秒、纳秒）信息。
     *
     * 7）DateTimeFormatter 类用来格式化和解析时间。与 SimpleDateFormat 不同，这个类不可变并且线程安全，需要时可以给静态常量赋值。DateTimeFormatter 类提供了大量的内置格式化工具，同时也允许你自定义。在转换方面也提供了 parse() 将字符串解析成日期，如果解析出错会抛出 DateTimeParseException。DateTimeFormatter 类同时还有format() 用来格式化日期，如果出错会抛出 DateTimeException异常。
     *
     * 8）再补充一点，日期格式“MMM d yyyy”和“MMM dd yyyy”有一些微妙的不同，第一个格式可以解析“Jan 2 2014”和“Jan 14 2014”，而第二个在解析“Jan 2 2014”就会抛异常，因为第二个格式里要求日必须是两位的。如果想修正，你必须在日期只有个位数时在前面补零，就是说“Jan 2 2014”应该写成 “Jan 02 2014”。
     */
}

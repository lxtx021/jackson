package com.adcc.hkp.rabbit.mq;

public class RabbitMQConfig {
    public static String IP1 = "173.4.2.1";
    public static String IP2 = "173.4.2.3";
    //	public static String IP1 = "192.168.211.131";
//	public static String IP2 = "192.168.211.131";

    public static int WebPort = 15672;
    public static int ClientPort = 5672;
    //	public static String UserName = "U_HKP";
    // "guest";
//	public static String Password = "U_HKP";
// "123456";
    public static String UserName = "U_HKP";
    //"guest";
    public static String Password = "U_HKP";
    //"123456";

    //
    public static String Vhost = "ADSB_Host";
    public static String ExChange = "ADSB_TOPIC";
}

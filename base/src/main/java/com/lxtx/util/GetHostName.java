package com.lxtx.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 * @author 孙洪波
 * @version 1.0
 * @description:
 * @date 2020/12/24 9:45
 */
public class GetHostName {
    public static void main(String[] args) {

        try {
            // 中南ip  219.137.239.122
            // DDos IP
            InetAddress inetAddr =InetAddress.getByName("183.236.88.88");
            String canonical=inetAddr.getCanonicalHostName();
            String host=inetAddr.getHostName();
            try {
                String mac =getMACAddress("183.236.88.88");
                System.out.println("mac:"+mac);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("canonical:"+canonical+",host:"+host);
//            String hostName = Address.getHostName();
//            System.out.println(hostName);

            //获取固定网址的ip和域名
            InetAddress ia2 = InetAddress.getByName("219.137.239.122");
            System.out.println(ia2.toString());
            System.out.println(ia2.getHostName());//域名               127
            System.out.println(ia2.getHostAddress());//ip地址

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过IP地址获取MAC地址
     * @param ip String,127.0.0.1格式
     * @return mac String
     * @throws Exception
     */
    public static String getMACAddress(String ip) throws Exception {
        String line = "";
        String macAddress = "";
        final String MAC_ADDRESS_PREFIX = "MAC Address = ";
        final String LOOPBACK_ADDRESS = "127.0.0.1";
        //如果为127.0.0.1,则获取本地MAC地址。
        if (LOOPBACK_ADDRESS.equals(ip)) {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //貌似此方法需要JDK1.6。
            byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            //下面代码是把mac地址拼装成String
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                //mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            //把字符串所有小写字母改为大写成为正规的mac地址并返回
            macAddress = sb.toString().trim().toUpperCase();
            return macAddress;
        }
        //获取非本地IP的MAC地址
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (line != null) {
                    int index = line.indexOf(MAC_ADDRESS_PREFIX);
                    if (index != -1) {
                        macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }
}

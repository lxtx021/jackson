package com.lxtx.springboot.hadoop;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * Configuration conf=new Configuration（）；
 * 创建一个Configuration对象时，其构造方法会默认加载hadoop中的两个配置文件，分别是hdfs-site.xml以及core-site.xml，这两个文件中会有访问hdfs所需的参数值，主要是fs.default.name，指定了hdfs的地址，有了这个地址客户端就可以通过这个地址访问hdfs了。即可理解为configuration就是hadoop中的配置信息。
 * 可以通过Configuration.addResource(“xml的名字”);(前提这个xml放在当前jar包目录或者hadoop的配置的目录)来读取这个配置文件里面的内容
 */
@Configuration
@ConditionalOnProperty(name="hadoop.name-node")
//@Slf4j
public class HadoopConfig {

    @Value("${hadoop.name-node}")
    private String nameNode;

    @Bean("fileSystem")
    public FileSystem createFs(){
        //读取配置文件
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        //conf.set("fs.defalutFS", "hdfs://192.168.169.128:9000");
        conf.set("dfs.replication", "2");
        //指定访问hdfs的客户端身份
        //fs = FileSystem.get(new URI("hdfs://192.168.169.128:9000/"), conf, "root");
        // 文件系统
        FileSystem fs = null;
        // 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
        try {
            URI uri = new URI(nameNode.trim());
            fs = FileSystem.get(uri,conf);
        } catch (Exception e) {
            e.printStackTrace();
//            log.error("", e);
        }
        return  fs;
    }
}
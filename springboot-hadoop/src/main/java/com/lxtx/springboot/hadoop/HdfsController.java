package com.lxtx.springboot.hadoop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HdfsController {

    @Autowired
    private HadoopTemplate hadoopTemplate;

    /**
     * 将本地文件srcFile,上传到hdfs
     * @return
     */
    @RequestMapping("/upload")
    public String upload(){
//    public String upload(@RequestParam String srcFile){
        String srcFile="D://httputil.log";
        hadoopTemplate.uploadFile(srcFile);
        return "copy";
    }

    @RequestMapping("/delFile")
    public String del(@RequestParam String fileName){
        hadoopTemplate.delFile(fileName);
        return "delFile";
    }

    @RequestMapping("/download")
    public String download(@RequestParam String fileName,@RequestParam String savePath){
        hadoopTemplate.download(fileName,savePath);
        return "download";
    }

    @RequestMapping("/test")
    public String download(){
        String fileName = "httputil.log";
        String savePath = "D://httputil.log";
        hadoopTemplate.download(fileName,savePath);
        return "test";
    }
}
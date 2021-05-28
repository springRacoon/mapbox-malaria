package com.sanguo.utils;

import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * @program: mapboxDemo
 * @description:
 * @author: Saxon
 * @create: 2021-05-28 17:06
 */
public class ReadJsonUtil {

    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {

            File jsonFile = ResourceUtils.getFile("classpath:"+fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

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
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i = -1;
            while ((i = inputStream.read()) != -1) {
                baos.write(i);
            }
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

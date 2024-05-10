package com.ebay.manager.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class FileUtil {
    public static void checkFile(File file){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readFile(File file) throws Exception{
        String content = null;
        try (FileInputStream fis = new FileInputStream(file)){
            content = IOUtils.toString(fis);
        }

        return content;
    }

    public static void writeFile(String content, File file, boolean append) throws Exception{
        FileOutputStream fos = new FileOutputStream(file, append);
        try{
            IOUtils.write(content, fos);
        }finally {
            IOUtils.closeQuietly(fos);
        }
    }
}

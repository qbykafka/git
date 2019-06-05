package com.bin.mars.common;

import org.springframework.util.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public abstract class IOUtils {

    public static String toString(InputStream inputStream){
        Assert.notNull(inputStream,"inputStream is null");
        byte  b[] = new byte[1024];
        StringBuilder builder = new StringBuilder();
        try {
            for (int pos =0;pos != -1;pos = inputStream.read(b))
                builder.append(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  builder.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
       /* C:\Users\Administrator\Desktop\ZARA渠道配置更改.sql*/
        String s = toString(new FileInputStream("C:\\Users\\Administrator\\Desktop\\ZARA渠道配置更改.sql"));
        System.out.println(s);

    }
}

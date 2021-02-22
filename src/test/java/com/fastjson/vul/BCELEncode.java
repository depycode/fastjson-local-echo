package com.fastjson.vul;

import com.sun.org.apache.bcel.internal.classfile.Utility;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BCELEncode {

    public static String class2BCEL(String classFile) throws Exception{
        Path path = Paths.get(classFile);
        byte[] bytes = Files.readAllBytes(path);
        String result = Utility.encode(bytes,true);
        return result;
    }


    public static void decode(String str) throws Exception{
        byte[] s =  Utility.decode(str,true);
        FileOutputStream fos = new FileOutputStream("payload.class");
        fos.write(s);
        fos.close();
    }

    public static void main(String[] args) throws Exception {

        System.out.println(BCELEncode.class2BCEL(System.getProperty("user.dir")+"\\src\\test\\java\\com\\fastjson\\vul\\" +"SpringEcho.class"));

    }

}

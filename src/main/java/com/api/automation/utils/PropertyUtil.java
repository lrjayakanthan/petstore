package com.api.automation.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    static Properties props=new Properties();

    public static void loadProperies(String strFilePath) throws IOException {
        InputStream input = new FileInputStream(strFilePath);
        props.load(input);
    }

    public static String getProperty(String strKey){
        return props.getProperty(strKey);
    }

    public static Properties loadPropertyUsingFilePath(String strFilepath) throws IOException {
        Properties propsusingfp=new Properties();
        propsusingfp.load(new FileInputStream(strFilepath));
        return propsusingfp;
    }
    
    public static Properties getPropertiesObj(String strFilepath){
    	Properties propObj=new Properties();
        try{
        	propObj.load(new FileInputStream(strFilepath));
        }catch(IOException e){
        }
        return propObj;
    }
}

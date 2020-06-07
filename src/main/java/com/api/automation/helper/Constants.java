package com.api.automation.helper;

public class Constants {

    /*Common Properties*/
    public static String CONFIG_PROPERTY_FILE_PATH;
    
    /*API EndPoint and Service*/
    public static String END_POINT="endpoint";
    public static String PET_SERVICE="pet";
    public static String FIND_BY_STATUS_SERVICE="findByStatus";


    static {
        CONFIG_PROPERTY_FILE_PATH= "./config/dev/environment.properties";
    }

}

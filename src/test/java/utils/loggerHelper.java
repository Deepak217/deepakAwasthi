package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class loggerHelper {

    private static boolean root=false;

    public static Logger getLogger(Class cls)
    {
        if(root)
        {
            return Logger.getLogger(cls);
        }
        PropertyConfigurator.configure("log4j.properties");
        root =true;
        return Logger.getLogger(cls);
    }

    public static void main(String args[])
    {
   Logger   log=  loggerHelper.getLogger(loggerHelper.class);
        log.info("I am Test");
    }
}

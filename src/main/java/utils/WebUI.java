package utils;

import org.openqa.selenium.support.ui.Select;

public class WebUI {

    public static void sleep(long second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}

package com.souyidai.wfms.service;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * SeleniumQueryService
 *
 * @author qianchun
 * @date 2019/11/26
 **/
public class SeleniumQueryService {

    private Map<String, Object> getText() {
        Map<String, Object> data = new HashMap<>();


        return data;
    }

    public static void main(String[] args) {
        DesiredCapabilities aDesiredcap = DesiredCapabilities.chrome();
        aDesiredcap.setPlatform(Platform.LINUX);
        WebDriver driver = null;
        try {
            String remoteUrl = "http://127.0.0.1:4444/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setJavascriptEnabled(true);
            URL url = new URL(remoteUrl);
            driver = new RemoteWebDriver(url, capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://book.qidian.com/info/107580#Catalog");
            System.out.println(driver.findElement(By.className("catalog-content-wrap")).getText());
            Thread.sleep(3000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

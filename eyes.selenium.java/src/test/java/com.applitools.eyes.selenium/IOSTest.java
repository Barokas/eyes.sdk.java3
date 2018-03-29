package com.applitools.eyes.selenium;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.FileLogger;
import com.applitools.eyes.FixedCutProvider;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.fluent.Target;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
@Category(CI.class)
public class IOSTest {

    protected static BatchInfo batchInfo = new BatchInfo("Java3 Tests");

    @Parameterized.Parameter(0)
    public String deviceName;

    @Parameterized.Parameter(1)
    public String deviceOrientation;

    @Parameterized.Parameter(2)
    public String platformVersion;

    @Parameterized.Parameter(3)
    public boolean fully;

    @Parameterized.Parameters(name = "{0} {1} {2} fully: {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"iPhone X Simulator", "portrait", "11.0", false},
                {"iPhone X Simulator", "landscape", "11.0", false},
                {"iPhone 7 Simulator", "portrait", "11.0", false},
                {"iPhone 7 Simulator", "portrait", "10.0", false},
                {"iPhone 7 Simulator", "landscape", "11.0", false},
                {"iPhone 7 Simulator", "landscape", "10.0", false},
                {"iPhone 6 Plus Simulator", "portrait", "11.0", false},
                {"iPhone 6 Plus Simulator", "portrait", "10.0", false},
                {"iPhone 6 Plus Simulator", "landscape", "11.0", false},
                {"iPhone 6 Plus Simulator", "landscape", "10.0", false},
                {"iPhone X Simulator", "portrait", "11.0", true},
                {"iPhone X Simulator", "landscape", "11.0", true},
                {"iPhone 7 Simulator", "portrait", "11.0", true},
                {"iPhone 7 Simulator", "portrait", "10.0", true},
                {"iPhone 7 Simulator", "landscape", "11.0", true},
                {"iPhone 7 Simulator", "landscape", "10.0", true},
                {"iPhone 6 Plus Simulator", "portrait", "11.0", true},
                {"iPhone 6 Plus Simulator", "portrait", "10.0", true},
                {"iPhone 6 Plus Simulator", "landscape", "11.0", true},
                {"iPhone 6 Plus Simulator", "landscape", "10.0", true}
        });
    }

    @Test
    public void TestIOSSafariCrop() throws MalformedURLException {
        Eyes eyes = new Eyes();

        String batchId = System.getenv("APPLITOOLS_BATCH_ID");
        if (batchId != null) {
            batchInfo.setId(batchId);
        }
        eyes.setBatch(batchInfo);

        // This is your api key, make sure you use it in all your tests.
        DesiredCapabilities caps = DesiredCapabilities.iphone();

        caps.setCapability("appiumVersion", "1.7.2");
        //caps.setCapability("deviceName", "iPhone X Simulator");
        //caps.setCapability("deviceName", "iPhone 7 Simulator");
        caps.setCapability("deviceName", deviceName);
        //caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("deviceOrientation", deviceOrientation);
        //caps.setCapability("platformVersion", "11.0");
        //caps.setCapability("platformVersion", "10.0");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "Safari");

        caps.setCapability("username", System.getenv("SAUCE_USERNAME"));
        caps.setCapability("accesskey", System.getenv("SAUCE_ACCESS_KEY"));

        String sauceUrl = "http://ondemand.saucelabs.com/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(sauceUrl), caps);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //eyes.setLogHandler(new StdoutLogHandler(true));

        String testName = String.format("%s %s %s", deviceName, platformVersion, deviceOrientation);
        if (fully) {
            testName += " fully";
        }
        String logFilename = String.format("c:\\temp\\logs\\iostest_%s.log", testName);

        eyes.setLogHandler(new FileLogger(logFilename, false, true));
        //eyes.setImageCut(new FixedCutProvider(30, 12, 8, 5));
        //eyes.setForceFullPageScreenshot(true);
        eyes.setSaveDebugScreenshots(true);
        eyes.setDebugScreenshotsPath("C:\\temp\\logs");
        eyes.setDebugScreenshotsPrefix("iostest_" + testName);

        eyes.setStitchMode(StitchMode.SCROLL);

        try {
            driver.get("https://www.applitools.com/customers");
            //driver.get("https://www.radiologysolutions.bayer.com/aboutus/congresses/");

            // Start visual testing
            eyes.open(driver, "Eyes Selenium SDK - iOS Safari Cropping", testName);

            //eyes.check("Initial view", Target.window().fully(fully));
            //eyes.check("Initial view", Target.region(By.cssSelector(".page.unpadded")).fully(fully));
            eyes.check("Initial view", Target.region(By.cssSelector(".horizontal-page")).fully(fully));

            // End visual testing. Validate visual correctness.
            eyes.close();
        } finally {
            eyes.abortIfNotClosed();
            driver.quit();
        }
    }
}
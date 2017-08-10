package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.Region;
import com.applitools.eyes.fluent.ICheckSettings;
import org.openqa.selenium.By;

public class Target {

    public static SeleniumCheckSettings window()
    {
        return new SeleniumCheckSettings();
    }

    public static SeleniumCheckSettings region(Region region)
    {
        return new SeleniumCheckSettings(region);
    }

    public static SeleniumCheckSettings region(By by)
    {
        return new SeleniumCheckSettings(by);
    }

    public static SeleniumCheckSettings frame(By by)
    {
        SeleniumCheckSettings settings = new SeleniumCheckSettings();
        settings.frame(by);
        return settings;
    }

    public static SeleniumCheckSettings frame(String frameNameOrId)
    {
        SeleniumCheckSettings settings = new SeleniumCheckSettings();
        settings.frame(frameNameOrId);
        return settings;
    }

    public static SeleniumCheckSettings frame(int index)
    {
        SeleniumCheckSettings settings = new SeleniumCheckSettings();
        settings.frame(index);
        return settings;
    }
}

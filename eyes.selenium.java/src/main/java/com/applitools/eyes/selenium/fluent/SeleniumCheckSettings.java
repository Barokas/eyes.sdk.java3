package com.applitools.eyes.selenium.fluent;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.Region;
import com.applitools.eyes.fluent.CheckSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeleniumCheckSettings extends CheckSettings implements ISeleniumCheckTarget, Cloneable {

    private By targetSelector;
    private WebElement targetElement;
    private List<FrameLocator> frameChain = new ArrayList<>();
    private WebElement scrollRootElement;
    private By scrollRootSelector;

    SeleniumCheckSettings() {
    }

    SeleniumCheckSettings(Region region) {
        super(region);
    }

    SeleniumCheckSettings(By targetSelector) {
        this.targetSelector = targetSelector;
    }

    SeleniumCheckSettings(WebElement targetElement) {
        this.targetElement = targetElement;
    }

    @Override
    public By getTargetSelector() {
        return this.targetSelector;
    }

    @Override
    public WebElement getTargetElement() {
        return this.targetElement;
    }

    @Override
    public List<FrameLocator> getFrameChain() {
        return this.frameChain;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public SeleniumCheckSettings clone() {
        SeleniumCheckSettings clone = new SeleniumCheckSettings();
        super.populateClone(clone);
        clone.targetElement = this.targetElement;
        clone.targetSelector = this.targetSelector;
        clone.frameChain.addAll(this.frameChain);
        return clone;
    }

    public SeleniumCheckSettings frame(By by) {
        SeleniumCheckSettings clone = this.clone();
        FrameLocator fl = new FrameLocator();
        fl.setFrameSelector(by);
        clone.frameChain.add(fl);
        return clone;
    }

    public SeleniumCheckSettings frame(String frameNameOrId) {
        SeleniumCheckSettings clone = this.clone();
        FrameLocator fl = new FrameLocator();
        fl.setFrameNameOrId(frameNameOrId);
        clone.frameChain.add(fl);
        return clone;
    }

    public SeleniumCheckSettings frame(int index) {
        SeleniumCheckSettings clone = this.clone();
        FrameLocator fl = new FrameLocator();
        fl.setFrameIndex(index);
        clone.frameChain.add(fl);
        return clone;
    }

    public SeleniumCheckSettings frame(WebElement frameReference) {
        SeleniumCheckSettings clone = this.clone();
        FrameLocator fl = new FrameLocator();
        fl.setFrameReference(frameReference);
        clone.frameChain.add(fl);
        return clone;
    }

    public SeleniumCheckSettings region(Region region) {
        SeleniumCheckSettings clone = this.clone();
        clone.updateTargetRegion(region);
        return clone;
    }

    public SeleniumCheckSettings region(By by) {
        SeleniumCheckSettings clone = this.clone();
        clone.targetSelector = by;
        return clone;
    }

    public SeleniumCheckSettings ignore(By regionSelector, By... regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        clone.ignore_(new IgnoreRegionBySelector(regionSelector));
        for (By selector : regionSelectors) {
            clone.ignore_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings ignore(WebElement element, WebElement... elements) {
        SeleniumCheckSettings clone = this.clone();
        clone.ignore_(new IgnoreRegionByElement(element));
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.ignore_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings ignore(By[] regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        for (By selector : regionSelectors) {
            clone.ignore_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings ignore(WebElement[] elements) {
        SeleniumCheckSettings clone = this.clone();
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.ignore_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings layout(By regionSelector, By... regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        clone.layout_(new IgnoreRegionBySelector(regionSelector));
        for (By selector : regionSelectors) {
            clone.layout_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings layout(WebElement element, WebElement... elements) {
        SeleniumCheckSettings clone = this.clone();
        clone.layout_(new IgnoreRegionByElement(element));
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.layout_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings layout(By[] regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        for (By selector : regionSelectors) {
            clone.layout_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings layout(WebElement[] elements) {
        SeleniumCheckSettings clone = this.clone();
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.layout_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings strict(By regionSelector, By... regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        clone.strict_(new IgnoreRegionBySelector(regionSelector));
        for (By selector : regionSelectors) {
            clone.strict_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings strict(WebElement element, WebElement... elements) {
        SeleniumCheckSettings clone = this.clone();
        clone.strict_(new IgnoreRegionByElement(element));
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.strict_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings strict(By[] regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        for (By selector : regionSelectors) {
            clone.strict_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings strict(WebElement[] elements) {
        SeleniumCheckSettings clone = this.clone();
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.strict_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings content(By regionSelector, By... regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        clone.content_(new IgnoreRegionBySelector(regionSelector));
        for (By selector : regionSelectors) {
            clone.content_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings content(WebElement element, WebElement... elements) {
        SeleniumCheckSettings clone = this.clone();
        clone.content_(new IgnoreRegionByElement(element));
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.content_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings content(By[] regionSelectors) {
        SeleniumCheckSettings clone = this.clone();
        for (By selector : regionSelectors) {
            clone.content_(new IgnoreRegionBySelector(selector));
        }

        return clone;
    }

    public SeleniumCheckSettings content(WebElement[] elements) {
        SeleniumCheckSettings clone = this.clone();
        //TODO - FIXME - BUG - this is wrong in case of a cropped image!
        for (WebElement e : elements) {
            clone.content_(new IgnoreRegionByElement(e));
        }

        return clone;
    }

    public SeleniumCheckSettings floating(By regionSelector, int maxUpOffset, int maxDownOffset, int maxLeftOffset, int maxRightOffset) {
        SeleniumCheckSettings clone = this.clone();
        clone.floating(new FloatingRegionBySelector(regionSelector, maxUpOffset, maxDownOffset, maxLeftOffset, maxRightOffset));
        return clone;
    }

    public SeleniumCheckSettings floating(WebElement element, int maxUpOffset, int maxDownOffset, int maxLeftOffset, int maxRightOffset) {
        SeleniumCheckSettings clone = this.clone();
        clone.floating(new FloatingRegionByElement(element, maxUpOffset, maxDownOffset, maxLeftOffset, maxRightOffset));
        return clone;
    }

    public SeleniumCheckSettings scrollRootElement(By selector)
    {
        SeleniumCheckSettings clone = this.clone();
        if (frameChain.size() == 0)
        {
            clone.scrollRootSelector = selector;
        }
        else
        {
            frameChain.get(frameChain.size() - 1).setScrollRootSelector(selector);
        }
        return clone;
    }

    public SeleniumCheckSettings scrollRootElement(WebElement element)
    {
        SeleniumCheckSettings clone = this.clone();
        if (frameChain.size() == 0)
        {
            clone.scrollRootElement = element;
        }
        else
        {
            frameChain.get(frameChain.size()- 1).setScrollRootElement(element);
        }
        return clone;
    }

    @Override
    public SeleniumCheckSettings fully() {
        return (SeleniumCheckSettings) super.fully();
    }

    @Override
    public SeleniumCheckSettings fully(boolean fully) {
        return (SeleniumCheckSettings) super.fully(fully);
    }

    @Override
    public SeleniumCheckSettings withName(String name) {
        return (SeleniumCheckSettings) super.withName(name);
    }

    @Override
    public SeleniumCheckSettings ignoreCaret(boolean ignoreCaret) {
        return (SeleniumCheckSettings) super.ignoreCaret(ignoreCaret);
    }

    @Override
    public SeleniumCheckSettings ignoreCaret() {
        return (SeleniumCheckSettings) super.ignoreCaret();
    }

    @Override
    public SeleniumCheckSettings matchLevel(MatchLevel matchLevel) {
        return (SeleniumCheckSettings) super.matchLevel(matchLevel);
    }

    @Override
    public SeleniumCheckSettings content() {
        return (SeleniumCheckSettings) super.content();
    }

    @Override
    public SeleniumCheckSettings strict() {
        return (SeleniumCheckSettings) super.strict();
    }

    @Override
    public SeleniumCheckSettings layout() {
        return (SeleniumCheckSettings) super.layout();
    }

    @Override
    public SeleniumCheckSettings exact() {
        return (SeleniumCheckSettings) super.exact();
    }

    @Override
    public SeleniumCheckSettings timeout(int timeoutMilliseconds) {
        return (SeleniumCheckSettings) super.timeout(timeoutMilliseconds);
    }

    @Override
    public SeleniumCheckSettings ignore(Region region, Region... regions) {
        return (SeleniumCheckSettings) super.ignore(region, regions);
    }

    @Override
    public SeleniumCheckSettings ignore(Region[] regions) {
        return (SeleniumCheckSettings) super.ignore(regions);
    }

    @Override
    public SeleniumCheckSettings layout(Region region, Region... regions) {
        return (SeleniumCheckSettings) super.layout(region, regions);
    }

    @Override
    public SeleniumCheckSettings layout(Region[] regions) {
        return (SeleniumCheckSettings) super.layout(regions);
    }

    @Override
    public SeleniumCheckSettings strict(Region region, Region... regions) {
        return (SeleniumCheckSettings) super.strict(region, regions);
    }

    @Override
    public SeleniumCheckSettings strict(Region[] regions) {
        return (SeleniumCheckSettings) super.strict(regions);
    }

    @Override
    public SeleniumCheckSettings content(Region region, Region... regions) {
        return (SeleniumCheckSettings) super.content(region, regions);
    }

    @Override
    public SeleniumCheckSettings content(Region[] regions) {
        return (SeleniumCheckSettings) super.content(regions);
    }

    @Override
    public WebElement getScrollRootElement() {
        return scrollRootElement;
    }

    @Override
    public By getScrollRootSelector() {
        return scrollRootSelector;
    }
}

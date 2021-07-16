package uk.farnell.com.helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.farnell.com.stepdefs.Hook;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static uk.farnell.com.helpers.WebDriverFactory.currentDirectory;
import static uk.farnell.com.helpers.WebDriverFactory.pathOfScreenshot;

public class ScreenshotUtil {

  protected static final Logger log = LoggerFactory.getLogger(ScreenshotUtil.class);
  protected String screenshotsPath;
  Hook hook;
  public ScreenshotUtil(Hook hook) {
    this.hook = hook;
  }

  public void takeScreenshot() {

    try {
      File src = ((TakesScreenshot) hook.getDriver()).getScreenshotAs(OutputType.FILE);
      WebDriverFactory.loadProperties();
      screenshotsPath = currentDirectory + pathOfScreenshot + "/";
      File dir = new File(screenshotsPath);
      if (!dir.exists()) dir.mkdirs();

      FileUtils.copyFile(src, new File(screenshotsPath +  LocalDateTime.now().toString() + ".png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}

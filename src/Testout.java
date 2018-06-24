import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testout {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Janda\\Documents\\Selenium_Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement settings_button=driver.findElement(By.id("wpDesktop.DesktopIcon15.Grid.gContent.imImage"));
        settings_button.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement mail_contact_etc=driver.findElement(By.id("siMailContactsCalendars.Grid.tbText"));
        mail_contact_etc.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement maggie_brown_account=driver.findElement(By.id("lbAccounts.Grid.Border.ScrollViewer.Grid.Viewport.ScrollContentPresenter.OuterElement.InnerElement.ItemsPresenter.StackPanel.SettingsItemSubMenu.Grid.ContentPresenter.StackPanel.TextBlock"));
        maggie_brown_account.click();
        WebElement account=driver.findElement(By.id("siAccount"));
        //For some reason this account.click() call sometimes throws an "Unknown Error." Repeating the test usually works fine but I'd need to look into a better way to perform that step for real. It's too fragile right now
        account.click();
        WebElement advanced_settings=driver.findElement(By.id("siAdvanced"));
        advanced_settings.click();
        WebElement ssl_toggle=driver.findElement(By.id("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot"));
        new Actions(driver).moveToElement(ssl_toggle).moveByOffset(10, 0).click().build().perform();
        WebElement back_to_account=driver.findElement(By.id("btnAccount.grid.contentPresenter.TextBlock"));
        back_to_account.click();
        WebElement done_button=driver.findElement(By.id("btnDone.grid.contentPresenter.TextBlock"));
        done_button.click();
        WebElement wifi=driver.findElement(By.id("siWiFi.Grid.tbText"));
        wifi.click();
        WebElement corpnet_wifi=driver.findElement(By.id("SettingsItemNetwork.Grid.rectClickArea"));
        corpnet_wifi.click();
        WebElement wifi_password=driver.findElement(By.id("psbx"));
        wifi_password.sendKeys("@CorpNetWeRSecure!&");
        WebElement join_link=driver.findElement(By.id("btnJoin.grid.contentPresenter.TextBlock"));
        join_link.click();
        WebElement done_with_exam=driver.findElement(By.id("bDone"));
        done_with_exam.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String passing_text=driver.findElement(By.id("svResults")).getText();
        assert passing_text.contains("Your Score: 1 of 1 (100%)\n");
        driver.close();
    }
}

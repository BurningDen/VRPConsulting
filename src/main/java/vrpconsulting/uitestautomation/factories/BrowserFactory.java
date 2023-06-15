package vrpconsulting.uitestautomation.factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            //different required options to parameter of Driver
            //System.setProperty("webdriver.chrome.driver", "//src/main/resources/chromedriver");

            //helper for driver (help start test from different operating systems)
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            return new ChromeDriver(getOptions());
        }

        ChromeOptions getOptions(){
            //
            // any configurations
            //
            return new ChromeOptions();
        }
    },

    //and for other browsers

    FIREFOX {
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver();
        }
    },
    EDGE {
        @Override
        public WebDriver createDriver() {
            return new EdgeDriver();
        }
    };

    public abstract WebDriver createDriver();
}


package ru.cytty.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    final static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    static WebDriver driver;
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/application.properties";
    static Properties properties = new Properties();


    @BeforeAll
    static void beforeAll() throws IOException {
        properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
        logger.info("ПОДКЛЮЧАЕМ ХРОМДРАЙВЕР");
        logger.info("указываем путь к хромдрайверу: src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver"); // 1. указываем путь к хромдрайверу
        ChromeOptions options = new ChromeOptions();                                      // 2. создаем объект опций
        logger.info("настраиваем опции");                                                 // 3. настраиваем опции:
        options.getBrowserName();                                                             // - узнать имя браузера
        options.getBrowserVersion();                                                          // - узнать версию браузера
        logger.info("дизблейдим нотификации и поп-ап");
        options.addArguments("--disable-notification");                                       // - задизэйблить нотификации
        options.addArguments("--disable-popup-blocking");                                     // - задизэйблить вплывающие окна

        driver = new ChromeDriver(options);                                               // 4. создаем объект хромдрайвера (с опциями)
        logger.info("устанавливаем максимальное окно браузера");                                                                                  // 5. управляем действиями в хроме
        driver.manage().window().maximize();                                                   // - устанавливаем размер окна
        driver.get(properties.getProperty("base.url"));                                              // - указываем адрес для открытия страницы
    }

    @AfterAll
    static void afterAll() {
        logger.info("закрываем хром");
        driver.quit();                                                                      // закрыть хром

    }
}

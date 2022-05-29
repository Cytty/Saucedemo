package ru.cytty.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static ru.cytty.ScreenshotMaker.makeScreenshotOnFailure;

public abstract class BaseTest {
    final static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    @Getter
    static WebDriver driver;
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/application.properties";
    static Properties properties = new Properties();
    @Getter
    static String baseUrl;
    @Getter
    static String username;
    @Getter
    static String lockedUsername;
    @Getter
    static String problemUsername;
    @Getter
    static String performanceUsername;
    @Getter
    static String password;


    @BeforeAll
    static void beforeAll() throws IOException {

        driver = WebDriverManager.chromedriver().create();

        properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
        baseUrl = properties.getProperty("base.url");
        username = properties.getProperty("standard.username");
        password = properties.getProperty("standard.password");
        lockedUsername = properties.getProperty("locked.username");
        problemUsername = properties.getProperty("problem.username");
        performanceUsername = properties.getProperty("performance.username");


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

        driver = new ChromeDriver(options);                                                // 4. создаем объект хромдрайвера (с опциями)
        logger.info("устанавливаем таймаут");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                  // - устанавливаем тайминг на ожидание
        logger.info("устанавливаем максимальное окно браузера");                                                                                  // 5. управляем действиями в хроме
        driver.manage().window().maximize();                                                   // - устанавливаем размер окна
        driver.get(baseUrl);                                                                   // - указываем адрес для открытия страницы
    }

    @AfterEach
    void afterEach() throws IOException {
        logger.info("делаем скрин");
        Allure.addAttachment("Screenshot", new FileInputStream(makeScreenshotOnFailure(driver)));
        driver.manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
    }

    @AfterAll
    static void afterAll() {
        logger.info("закрываем хром");
        if (driver != null) {
            driver.quit();                                                                        // закрыть хром
        }
    }

}

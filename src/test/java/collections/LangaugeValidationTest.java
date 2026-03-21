package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LangaugeValidationTest {

	WebDriver driver;
	static String  country;
	static String language;

	public static void main(String[] args) {

		Map<String, String> countryURL = new HashMap<String, String>();
		countryURL.put("USA", "www.amazon.sa");
		countryURL.put("Germany", "www.amazon.de");
		countryURL.put("France", "www.amazon.fr");

		Map<String, String> countryLangauge = new HashMap<String, String>();
		countryLangauge.put("USA", "EN");
		countryLangauge.put("Germany", "DE");
		countryLangauge.put("France", "FR");

		List<String> countries = new ArrayList<String>(countryURL.keySet());
		List<String> languages = new ArrayList<String>(countryLangauge.keySet());

		for (int i = 0; i < countryURL.size(); i++) {
			
				country = countries.get(i);
				language = languages.get(i);
			
			
			
		}

	}


public void shareCode() throws InterruptedException {
	WebDriver driver = new ChromeDriver();

    // Country → URL
    Map<String,String> countryUrl = new HashMap<>();

    countryUrl.put("USA","https://www.amazon.com");
    countryUrl.put("Germany","https://www.amazon.de");
    countryUrl.put("France","https://www.amazon.fr");


    // Country → Expected Language
    Map<String,String> expectedLanguage = new HashMap<>();

    expectedLanguage.put("USA","EN");
    expectedLanguage.put("Germany","DE"); //EN
    expectedLanguage.put("France","FR"); //EN

    // Convert HashMap keys to List
    List<String> countries = new ArrayList<>(countryUrl.keySet());
    
    //[usa, germany,fr]
    // Normal for loop
    for(int i = 0; i < countries.size(); i++) {

        String country = countries.get(i);

        String url = countryUrl.get(country);

        driver.get(url);
        
        Thread.sleep(5000);  // wait for page to load

        String actualLanguage = driver.findElement(By.id("icp-nav-flyout")).getText();

        String expected = expectedLanguage.get(country);

        if(actualLanguage.contains(expected)) {

            System.out.println(country + " Language Test Passed");

        } else {

            System.out.println(country + " Language Test Failed");

        }
    }

    driver.quit();
}


}



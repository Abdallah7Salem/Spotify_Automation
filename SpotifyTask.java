package SpotifyAutomation;

import java.rmi.server.ExportException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
/* Package used for the click button */
import org.openqa.selenium.JavascriptExecutor;

/* Package used for locating the drop down */
import org.openqa.selenium.support.ui.Select;


public class SpotifyTask {
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String randomPattern = RandomPatternGenerator.generateRandomPattern();
	    String secureRandomPattern = SecureRandomPatternGenerator.generateSecureRandomPattern();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		
		SignUpToSpotify(driver, randomPattern, secureRandomPattern, js);
        LoginToSpotify(driver, randomPattern, secureRandomPattern, js);
        CreateSpotifyPlaylist(driver, js);
		
	}
	
	
	
	static void SignUpToSpotify(WebDriver driver, String randomPattern, String secureRandomPattern, JavascriptExecutor js) throws InterruptedException
	{
		
		/* Open the spotify website */
		driver.get("https://www.spotify.com/signup");
		driver.manage().window().maximize();
		
		/* Close the pop-up */
		driver.findElement(By.xpath("//button[@aria-label = 'Close']")).click();
		
		/* Enter the random email in the text box */
		WebElement EmailAddress =  driver.findElement(By.xpath("//input[@placeholder = 'name@domain.com']"));
		EmailAddress.sendKeys(randomPattern);
		
		/* Click the Next Button*/
		WebElement nextButton1 = driver.findElement(By.xpath("//button[@class='Button-sc-qlcn5g-0 VsdHm encore-text-body-medium-bold']"));
		js.executeScript("arguments[0].scrollIntoView(true);", nextButton1);
		// Add a small delay to ensure the element is fully visible
		Thread.sleep(500); 
		// Click the element
		nextButton1.click();
				
		/* Enter the random password in the text box */
	    WebElement password = driver.findElement(By.id("new-password"));
	    password.sendKeys(secureRandomPattern);
	    
	    Thread.sleep(1000);
	    
	    /* Click the Next Button */
	    WebElement nextButton2 = driver.findElement(By.xpath("//button[@class = 'Button-sc-qlcn5g-0 VsdHm encore-text-body-medium-bold']"));
	    js.executeScript("arguments[0].scrollIntoView(true);", nextButton2);
	    Thread.sleep(500);
	    nextButton2.click();
	    
	    /* Enter a user Name */
	    driver.findElement(By.xpath("//input[@name = 'displayName']")).sendKeys("Abdallah Qandil");

	    /* Enter the day and the year of birth */
	    driver.findElement(By.xpath("//input[@id = 'day']")).sendKeys("7");
	    driver.findElement(By.xpath("//input[@id = 'year']")).sendKeys("2001");
	    
	    /* Select the month from the dropdown */
	    // Locate the dropdown element
	    WebElement dropdownElement = driver.findElement(By.id("month"));
	    // Create a select object
	    Select dropdown = new Select(dropdownElement);
	    // Select a month by visible text
	    dropdown.selectByVisibleText("March");
	    
	    /* Select the gender */
	    driver.findElement(By.xpath("//label[@for = 'gender_option_male']")).click();
	    
	    /* Click the Next Button */
	    WebElement nextButton3 = driver.findElement(By.xpath("//button[@class = 'Button-sc-qlcn5g-0 VsdHm encore-text-body-medium-bold']"));
	    js.executeScript("arguments[0].scrollIntoView(true);", nextButton3);
	    Thread.sleep(500);
	    nextButton3.click();
	    
	    /* Accept the terms and conditions */
	    driver.findElement(By.xpath("//div[@class = 'sc-gwrIee cxkZuq']")).click();
	    driver.findElement(By.xpath("//span[@class = 'sc-kuTxxw fAzVmI']")).click();
	    
	    /* Click the Sign Up Button */
	    driver.findElement(By.xpath("//span[@class = 'ButtonInner-sc-14ud5tc-0 hvvTXU encore-bright-accent-set']")).click();

	}
	
	static void LoginToSpotify(WebDriver driver, String randomPattern, String secureRandomPattern, JavascriptExecutor js) throws InterruptedException
	{
		
		driver.get("https://spotify.com/login");
		driver.manage().window().maximize();
		
		/* Enter the email */
		driver.findElement(By.xpath("//input[@placeholder = 'Email or username']")).sendKeys(randomPattern);
		
		/* Enter the password */
		driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(secureRandomPattern);
		
		/* Click the login button */
		WebElement LogInButton = driver.findElement(By.xpath("//span[@class = 'ButtonInner-sc-14ud5tc-0 hvvTXU encore-bright-accent-set']"));
		js.executeScript("arguments[0].scrollIntoView(true);", LogInButton);
		Thread.sleep(500);
		LogInButton.click();
		
		/* Click spotify window */
		Thread.sleep(5000);
		WebElement SpotifyIcon = driver.findElement(By.xpath("//span[@class = 'mh-header-primary svelte-1gcdbl9']"));
		js.executeScript("arguments[0].scrollIntoView(true);", SpotifyIcon);
		Thread.sleep(500);
		SpotifyIcon.click();
		
	}
	
	static void CreateSpotifyPlaylist(WebDriver driver, JavascriptExecutor js) throws InterruptedException
	{
		Thread.sleep(5000);
		/* Write dummy data in search box just to show the plus icon */
		driver.findElement(By.xpath("//input[@class = 'Input-sc-1gbx9xe-0 jlbmaj e-9541-baseline e-9541-form-control encore-text-body-medium CVuGEUIxLkNKpMds8AFS R69APjfNV0o9tAbfrWZf']")).sendKeys("a");
		
		/* Click on the expand the library button */
		WebElement expandLibraryButton = driver.findElement(By.xpath("//div[@class = 'FTiXRW7kAldHmLaxVQ2N iYP0xuQiJCgi7gx1jUPJ']"));
		js.executeScript("arguments[0].scrollIntoView(true);", expandLibraryButton);
		Thread.sleep(500);
		expandLibraryButton.click();
		
		Thread.sleep(2500);
		
		/* Right click on the plus button to create the playlist */
		WebElement plusIcon = driver.findElement(By.xpath("//button[@class = 'AIlmv6h8bR5NY5R0VceT']"));
        Actions actions = new Actions(driver);
        actions.contextClick(plusIcon).perform();

		
		
		/* Click on the create a new playlist button */
		WebElement createPlaylistButton = driver.findElement(By.xpath("//button[@class = 'mWj8N7D_OlsbDgtQx5GW']"));
		js.executeScript("arguments[0].scrollIntoView(true);", createPlaylistButton);
		Thread.sleep(500);
		createPlaylistButton.click();
		
		/* Search for songs to add to the playlist */
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder = 'Search for songs or episodes']")).sendKeys("Law Kan Yerdik");
		// Click on the add to playlist button 
		Thread.sleep(1500);
		WebElement addToPlaylistButton1 = driver.findElement(By.xpath("//button[@data-testid = 'add-to-playlist-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", addToPlaylistButton1);
		Thread.sleep(500);
		addToPlaylistButton1.click();
		
		/* Search for songs to add to the playlist */
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder = 'Search for songs or episodes']")).clear();
		driver.findElement(By.xpath("//input[@placeholder = 'Search for songs or episodes']")).sendKeys("Aam El Tabeeb");
		// Click on the add to playlist button 
		Thread.sleep(1500);
		WebElement addToPlaylistButton2 = driver.findElement(By.xpath("//button[@data-testid = 'add-to-playlist-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", addToPlaylistButton2);
		Thread.sleep(500);
		addToPlaylistButton2.click();
		
		/* Play the playlist */
		WebElement playButton = driver.findElement(By.xpath("//button[@data-testid = 'play-button']"));
		js.executeScript("arguments[0].scrollIntoView(true);", playButton);
		Thread.sleep(500);
		playButton.click();
		
	}
	
	
}

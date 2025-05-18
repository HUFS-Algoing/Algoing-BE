package com.hufs.algoing.submitting.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmittingService {
    private WebDriver d;

    public SubmittingService() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--disable-popup-blocking");
        d = new ChromeDriver(options);
    }

    public void submit(Long problemId, String code, String language) throws InterruptedException{
        d.get("https://www.acmicpc.net/submit/" + problemId);
        Thread.sleep(1000);

        d.findElement(By.id("language_chosen")).click();
        List<WebElement> langs = d.findElements(By.cssSelector(".chosen-results li"));
        for (WebElement lang : langs) {
            if (lang.getText().equals(language)) {
                lang.click();
                break;
            }
        }

//        이 부분은 테스트 상 단순 텍스트상자를 이용한 것이므로, 실제 적용시 에디터에 맞게  조정해야함.
        WebElement codeMirror = d.findElement(By.className("CodeMirror-line"));
        codeMirror.click();
        Thread.sleep(2000);
        ((JavascriptExecutor) d).executeScript(
                "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",code
        );
        Thread.sleep(1000);

        d.findElement(By.id("submit_button")).click();
        Thread.sleep(1000);


    }
}

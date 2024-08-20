package com.DmartLabs.commonutils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class DriverFactory {


    /**
     *
     * @author hari
     *
     */
    public static WindowsDriver<WindowsElement> getDriver() throws Exception {
        if (QXClient.getWindowsDriver() == null) {

            initializeDriver();
        }
        return QXClient.getWindowsDriver();
    }


    private static void initializeDriver() throws Exception {
        JsonObject capabilities = loadCapabilities();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        for (String key : capabilities.keySet()) {
            JsonElement value = capabilities.get(key);
            desiredCapabilities.setCapability(key, value.getAsString());
        }

        WinDriverUtils.start();
        Thread.sleep(1000);


        // Initialize the driver
        WindowsDriver<WindowsElement> driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        Thread.sleep(500);
        QXClient.setWindowsDriver(driver);
    }

    private static JsonObject loadCapabilities() throws IOException {
        FileReader reader = new FileReader("./caps/capabilities.json");
        JsonElement jsonElement = JsonParser.parseReader(reader);

        return jsonElement.getAsJsonObject();
    }
}














public class MobileUtils {

    // Switch to WEBVIEW with retry
    public static void switchToWebView(AppiumDriver driver) {

        try {
            for (int i = 0; i < 5; i++) {

                for (String context : driver.getContextHandles()) {
                    System.out.println("Available context: " + context);

                    if (context.contains("WEBVIEW")) {
                        driver.context(context);
                        System.out.println("Switched to WEBVIEW");
                        return;
                    }
                }

                Thread.sleep(1000); // wait before retry
            }

            throw new RuntimeException("WEBVIEW context not found");

        } catch (Exception e) {
            throw new RuntimeException("Failed to switch to WEBVIEW: " + e.getMessage());
        }
    }

    // Switch back to Native App
    public static void switchToNative(AppiumDriver driver) {

        try {
            driver.context("NATIVE_APP");
            System.out.println("Switched to NATIVE_APP");
        } catch (Exception e) {
            throw new RuntimeException("Failed to switch to Native: " + e.getMessage());
        }
    }

    // Open Google App (Android / iOS)
    public static void openGoogleApp(AppiumDriver driver, String platform) {

        try {
            if (platform.equalsIgnoreCase("Android")) {
                driver.activateApp("com.google.android.googlequicksearchbox");
            } else {
                // On iOS, Google login may open Safari
                driver.activateApp("com.apple.mobilesafari");
            }

            System.out.println("Google app opened");

        } catch (Exception e) {
            throw new RuntimeException("Failed to open Google app: " + e.getMessage());
        }
    }

    // Open Settings App (Android / iOS)
    public static void openSettings(AppiumDriver driver, String platform) {

        try {
            if (platform.equalsIgnoreCase("Android")) {
                driver.activateApp("com.android.settings");
            } else {
                driver.activateApp("com.apple.Preferences");
            }

            System.out.println("Settings app opened");

        } catch (Exception e) {
            throw new RuntimeException("Failed to open Settings: " + e.getMessage());
        }
    }

    // Get Current Context (Debug helper)
    public static String getCurrentContext(AppiumDriver driver) {

        try {
            return driver.getContext();
        } catch (Exception e) {
            return "Unable to fetch context";
        }
    }

    // Print all contexts (Debugging)
    public static void printAllContexts(AppiumDriver driver) {

        try {
            for (String context : driver.getContextHandles()) {
                System.out.println("Context: " + context);
            }
        } catch (Exception e) {
            System.out.println("Failed to fetch contexts: " + e.getMessage());
        }
    }
}

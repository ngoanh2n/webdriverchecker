package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class MobileAppChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        if (!getCapability("app").isEmpty()) {
            return true;
        }
        if (execute(new IOSChecker())) {
            return getBrowserName().isEmpty();
        }
        if (execute(new AndroidChecker())) {
            String appPackage = getCapability("appPackage");
            return getBrowserName().isEmpty() || !appPackage.equals("com.android.chrome");
        }
        return false;
    }
}
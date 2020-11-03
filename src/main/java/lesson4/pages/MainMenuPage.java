package lesson4.pages;


public class MainMenuPage extends PageBase {
    private static final String LEFT_MENU = "//ul[@id='box-apps-menu']/li";

    public String getLeftMenu() {
        return LEFT_MENU;
    }
}

package christmas.domain;

import java.util.Arrays;
import java.util.List;

public class Menu {
    public static final MenuCategory APPETIZERS = new MenuCategory("애피타이저", Arrays.asList(
            new MenuItem("양송이수프", 6000),
            new MenuItem("타파스", 5500),
            new MenuItem("시저샐러드", 8000)
    ));

    public static final MenuCategory MAINS = new MenuCategory("메인", Arrays.asList(
            new MenuItem("티본스테이크", 55000),
            new MenuItem("바비큐립", 54000),
            new MenuItem("해산물파스타", 35000),
            new MenuItem("크리스마스파스타", 25000)
    ));

    public static final MenuCategory DESSERTS = new MenuCategory("디저트", Arrays.asList(
            new MenuItem("초코케이크", 15000),
            new MenuItem("아이스크림", 5000)
    ));

    public static final MenuCategory DRINKS = new MenuCategory("음료", Arrays.asList(
            new MenuItem("제로콜라", 3000),
            new MenuItem("레드와인", 60000),
            new MenuItem("샴페인", 25000)
    ));

    public static final List<MenuCategory> ALL_CATEGORIES = Arrays.asList(
            APPETIZERS, MAINS, DESSERTS, DRINKS
    );
}

package christmas.domain;

import java.util.List;

public class MenuCategory {
    private List<MenuItem> items;

    public MenuCategory(String categoryName, List<MenuItem> items){
        this.items = items;
    }
    public MenuItem getItemByName(String categoryName) throws IllegalArgumentException {
        for (MenuItem item : items) {
            if (item.getName().equalsIgnoreCase(categoryName)) {
                return item;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}

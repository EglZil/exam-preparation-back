package lt.techin.application.menus;

import lt.techin.application.meals.Meal;
import lt.techin.application.meals.MealDto;
import lt.techin.application.meals.MealEntityDto;

public class MenuMapper {

    public static MenuDto toMenuDto(Menu menu) {
        MenuDto menuDto = new MenuDto();

        menuDto.setTitle(menu.getTitle());

        return menuDto;
    }

    public static MenuEntityDto toMenuEntityDto(Menu menu) {
        MenuEntityDto menuEntityDto = new MenuEntityDto();

        menuEntityDto.setId(menu.getId());
        menuEntityDto.setTitle(menu.getTitle());

        return menuEntityDto;
    }

    public static Menu toMenu(MenuDto menuDto) {
        Menu menu = new Menu();

        menu.setTitle(menuDto.getTitle());

        return menu;
    }

    public static Menu toMenuFromEntityDto(MenuEntityDto menuEntityDto) {
        Menu menu = new Menu();

        menu.setId(menuEntityDto.getId());
        menu.setTitle(menuEntityDto.getTitle());

        return menu;
    }
}

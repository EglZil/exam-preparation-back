package lt.techin.application.menus;

import lt.techin.application.meals.MealEntityDto;
import lt.techin.application.meals.MealMapper;
import lt.techin.application.meals.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.application.menus.MenuMapper.toMenu;
import static lt.techin.application.menus.MenuMapper.toMenuDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/menus")
public class MenuController {
    public Logger logger = LoggerFactory.getLogger(MenuController.class);

    private final MenuService menuService;

    private final MealService mealService;

    public MenuController(MenuService menuService, MealService mealService) {
        this.menuService = menuService;
        this.mealService = mealService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MenuEntityDto> getMenus() {
        return menuService.getAll().stream().map(MenuMapper::toMenuEntityDto).collect(toList());
    }

    @GetMapping(value = "/{menuId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Menu> getMenu(@PathVariable Long menuId) {
        var menuOptional = menuService.getById(menuId);

        var responseEntity = menuOptional.map(menu -> ok(menu)).orElseGet(()-> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
        boolean deleted = menuService.deleteById(menuId);

        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuDto menuDto) {
        var createdMenu = menuService.create(toMenu(menuDto));

        return ok(toMenuDto(createdMenu));
    }

    @GetMapping(value = "/meals/{menuId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MealEntityDto> getMealsByMenuId(@PathVariable Long menuId) {
        return mealService.getAllByMenuId(menuId).stream().map(MealMapper::toMealEntityDto).collect(toList());
    }

    @PatchMapping("update/{menuId}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable Long menuId, @RequestBody MenuDto menuDto) {
        var updatedMenu = menuService.updateMenu(menuId, toMenu(menuDto));
        return ok(toMenuDto(updatedMenu));
    }
}

package lt.techin.application.meals;

import lt.techin.application.menus.MenuDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.application.meals.MealMapper.toMeal;
import static lt.techin.application.meals.MealMapper.toMealDto;
import static lt.techin.application.menus.MenuMapper.toMenu;
import static lt.techin.application.menus.MenuMapper.toMenuDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/meals")
public class MealController {
    public Logger logger = LoggerFactory.getLogger(MealController.class);

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MealEntityDto> getMeals() {
        return mealService.getAll().stream().map(MealMapper::toMealEntityDto).collect(toList());
    }

    @GetMapping(value = "/{mealId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Meal> getMeal(@PathVariable Long mealId) {
        var mealOptional = mealService.getById(mealId);

        var responseEntity = mealOptional.map(meal -> ok(meal)).orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value="/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MealDto> createMeal(@RequestBody MealDto mealDto) {
        var createdComment = mealService.create(toMeal(mealDto));
        return ok(toMealDto(createdComment));
    }

    @PatchMapping(value = "/update/{mealId}")
    public ResponseEntity<MealDto> updateMeal(@PathVariable Long mealId, @RequestBody MealDto mealDto) {
        var updatedMeal = mealService.updateMeal(mealId, toMeal(mealDto));
        return ok(toMealDto(updatedMeal));
    }

    @DeleteMapping(value = "/{mealId}")
    public ResponseEntity<Boolean> deleteMeal(@PathVariable Long mealId) {
        var isDeleted = mealService.deleteById(mealId);
        return ok(isDeleted);
    }

}

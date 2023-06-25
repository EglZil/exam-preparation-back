package lt.techin.application.meals;

public class MealMapper {
    public static MealDto toMealDto(Meal meal) {
        MealDto mealDto = new MealDto();

        mealDto.setTitle(meal.getTitle());
        mealDto.setDescription(meal.getDescription());
        mealDto.setQuantity(meal.getQuantity());
        mealDto.setMenu(meal.getMenu());

        return mealDto;
    }

    public static MealEntityDto toMealEntityDto(Meal meal) {
        MealEntityDto mealEntityDto = new MealEntityDto();

        mealEntityDto.setId(meal.getId());
        mealEntityDto.setTitle(meal.getTitle());
        mealEntityDto.setDescription(meal.getDescription());
        mealEntityDto.setQuantity(meal.getQuantity());
        mealEntityDto.setMenu(meal.getMenu());

        return mealEntityDto;
    }

    public static Meal toMeal(MealDto mealDto) {
        Meal meal = new Meal();

        meal.setTitle(mealDto.getTitle());
        meal.setDescription(mealDto.getDescription());
        meal.setQuantity(mealDto.getQuantity());
        meal.setMenu(mealDto.getMenu());

        return meal;
    }

    public static Meal toMealFromEntityDto(MealEntityDto mealEntityDto) {
        Meal meal = new Meal();

        meal.setId(mealEntityDto.getId());
        meal.setTitle(mealEntityDto.getTitle());
        meal.setDescription(mealEntityDto.getDescription());
        meal.setQuantity(mealEntityDto.getQuantity());
        meal.setMenu(mealEntityDto.getMenu());

        return meal;
    }
}

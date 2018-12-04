package pattern.builder;

public class NutritionFacts {
    private final int servings;
    private final int calories;
    private final int fat;

    public static class Builder{
        private final int servings;
        private int calories = 0;
        private int fat = 0;

        public Builder(int servings){
            this.servings = servings;
        }
        public Builder setCalories(int calories) {
            this.calories = calories;
            return this;
        }
        public Builder setFat(int fat) {
            this.fat = fat;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "servings=" + servings +
                    ", calories=" + calories +
                    ", fat=" + fat +
                    '}';
        }
    }

    private NutritionFacts(Builder builder){
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

    public static void main(String[] args) {
        NutritionFacts beaf = new Builder(10).setCalories(456).setFat(56).build();
        NutritionFacts prod = new Builder(2).setCalories(34).build();
        NutritionFacts mushrooms = new Builder(3).setFat(20).build();
    }
}

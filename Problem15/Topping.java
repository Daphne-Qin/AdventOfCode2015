public class Topping {
  //================================================================================
  // SETUP
  //================================================================================
  private int capacity, durability, flavor, texture, calories;
  public Topping (int capacity, int durability, int flavor, int texture, int calories) {
    this.capacity = capacity;
    this.durability = durability;
    this.flavor = flavor;
    this.texture = texture;
    this.calories = calories;
  }

  //================================================================================
  // CHARACTERISTIC RETURNERS
  //================================================================================
  public int getCapacity() {
    return capacity;
  }
  public int getDurability() {
    return durability;
  }
  public int getFlavor() {
    return flavor;
  }
  public int getTexture() {
    return texture;
  }
  public int getCalories() {
    return calories;
  }
  public String toString() {
    return ("capacity " + capacity + ", durability " + durability + ", flavor " + flavor + ", texture " + texture + ", calories " + calories);
  }
}

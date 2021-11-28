public class Reindeer {
  //================================================================================
  // SETUP
  //================================================================================
  private int speed, duration, rest, points;
  public Reindeer(int speed, int duration, int rest, int points) {
    this.speed = speed;
    this.duration = duration;
    this.rest = rest;
    this.points = points;
  }

  //================================================================================
  // CHARACTERISTIC RETURNERS
  //================================================================================
  public int getSpeed() {
    return speed;
  }
  public int getDuration() {
    return duration;
  }
  public int getRest() {
    return rest;
  }
  public int getPoints() {
    return points;
  }
  public String toString() {
    return ("{" + speed + ", " + duration + ", " + rest + ", " + points + "}");
  }

  //================================================================================
  // CHARACTERISTIC CHANGERS
  //================================================================================
  public void addPoints() {
    points++;
  }
  public void setPoints(int newPoints) {
    points = newPoints;
  }

  //================================================================================
  // VALUE RETURNERS
  //================================================================================
  public int distance(int time) {
    int completeCycles = time / (duration+rest); // scaling factor
    int remainingTime = time % (duration+rest); // unit of time
    if (remainingTime > duration) remainingTime = duration;
    return (speed * duration * completeCycles) + (speed * remainingTime);
  }
}

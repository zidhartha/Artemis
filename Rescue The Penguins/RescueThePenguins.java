
public class RescueThePenguins extends MiniJava {
  public static void main(String[] args) {
    // Get the number of time steps and check for validity
    int steps = readInt("Please insert the number of time steps (>= 1):");
    if (steps < 1) {
      write("number of steps >= 1 required");
      return;
    }

    int young = readInt("Initial number of young");
    int youngAdults = readInt("Initial number of young adults");
    int adults = readInt("Initial number of adults");
    int oldAdults = readInt("Initial number of old adults");
    int elders = readInt("Initial number of elders");

    int index = 0;
    int food = 0;
    int babies;
    // Start of Simulation Loop 
    while (index < steps) {
      index++;
      // 1. Penguins hunt for food.
      food = 3 * youngAdults + 2 * adults;
      // 2 . Food is distributed.
      // If there is not enough food, penguins starve immediately.
      if (food < young) {
        young = food;
        food = 0;
      } else {
        food -= young;
      }
      if (food < youngAdults) {
        youngAdults = food;
        food = 0;
      } else {
        food -= youngAdults;
      }
      if (food < adults) {
        adults = food;
        food = 0;
      } else {
        food -= adults;
      }
      if (food < oldAdults) {
        oldAdults = food;
        food = 0;
      } else {
        food -= oldAdults;
      }
      if (food < elders) {
        elders = food;
      }
      // 3 . Penguins breed.
      babies = youngAdults / 4 + adults / 2 + oldAdults / 3;
      // 4. Penguins age.
      elders = oldAdults;
      oldAdults = adults;
      adults = youngAdults;
      youngAdults = young;
      young = babies;
    } // End of Simulation Loop 

    // Output
    writeLineConsole("Final number of young:");
    writeLineConsole(young);
    writeLineConsole("Final number of young adults:");
    writeLineConsole(youngAdults);
    writeLineConsole("Final number of adults:");
    writeLineConsole(adults);
    writeLineConsole("Final number of old adults:");
    writeLineConsole(oldAdults);
    writeLineConsole("Final number of elders:");
    writeLineConsole(elders);
  }
}



public class ShutTheBox extends MiniJava {

  // Output of open boxes. Do not modify this
  public static void outputBoxes(boolean[] boxes) {
    StringBuilder sb = new StringBuilder("Open boxes: 1:");
    sb.append(boxes[0]);
    for (int i = 1; i < boxes.length; i++) {
      sb.append(" ").append(i + 1).append(":").append(boxes[i]);
    }
    write(sb.toString());
  }

  public static void main(String[] args) throws IllegalAccessException {
    int activePlayer = 2;
    boolean[] boxes = {true, true, true, true, true, true, true, true};
    int player1Points = 0;
    int player2Points = 0;
    int status = 0;
    int index = 0;

    boolean validInput;
    int dice1, dice2, input1, input2;
    boolean allBoxes = false;
    while (status == 0 && index < 16) {
      index++;
      // change active player
      if (activePlayer == 1) {
        activePlayer = 2;
      } else {
        activePlayer = 1;
      }

      dice1 = dice();
      dice2 = dice();

      validInput = false;
      while (!validInput) {
        // No string concat for now....
        if (activePlayer == 1) {
          write("Player 1 has thrown the numbers:");
        } else {
          write("Player 2 has thrown the numbers:");
        }
        write(dice1);
        write(dice2);
        outputBoxes(boxes);

        // No string concat for now....
        if (activePlayer == 1) {
          write("Which boxes to shut by player 1? (0 for no valid combination)");
        } else {
          write("Which boxes to shut by player 2? (0 for no valid combination)");
        }

        input1 = readInt("Box 1:");
        input2 = readInt("Box 2:");

        if (  input1 > 0 && input1 <= boxes.length &&
                input2 > 0 && input2 <= boxes.length &&
                input1 + input2 == dice1 + dice2 &&
                input1 != input2 &&
                boxes[input1 - 1] && boxes[input2 - 1]) {
          validInput = true;
          boxes[input1 - 1] = false;
          boxes[input2 - 1] = false;
        } else if (input1 == 0 || input2 == 0) {
          validInput = true;
          for (int i = 0; i < 8; i++) {
            if (activePlayer == 1 && boxes[i]) {
              player1Points += i + 1;
            } else if (activePlayer == 2 && boxes[i]) {
              player2Points += i + 1;
            }
          }
        }
      }

      allBoxes = true;
      for (int i = 0; i < 8; i++) {
        if (boxes[i]) {
          allBoxes = false;
        }
      }
      if (allBoxes) {
        status = activePlayer;
      }
    }
    if (status == 1) {
      write("Player 1 shuts all boxes! Player 1 wins!");
    } else if (status == 2) {
      write("Player 2 shuts all boxes! Player 2 wins!");
    } else {
      if (player1Points > player2Points) {
        write("Player 1 points:");
        write(player1Points);
        write("Player 2 points:");
        write(player2Points);
        write("Player 2 wins!");
      } else if (player2Points > player1Points) {
        write("Player 1 points:");
        write(player1Points);
        write("Player 2 points:");
        write(player2Points);
        write("Player 1 wins!");
      } else {
        write("Player 1 points:");
        write(player1Points);
        write("Player 2 points:");
        write(player2Points);
        write("Draw!");
      }
    }
  }
}

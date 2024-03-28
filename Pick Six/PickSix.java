
public class PickSix extends MiniJava {
  // sorting method from the lecture
  public static int[] sort(int[] a) {
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; ++i) {
      // begin of insert
      int j = 0;
      while (j < i && a[i] > b[j]) ++j;
      // end of locate
      for (int k = i - 1; k >= j; --k) b[k + 1] = b[k];
      // end of shift
      b[j] = a[i];
      // end of insert
    }
    return b;
  } // end of sort

  public static void main(String[] args) throws IllegalAccessException {
    int[][] batch = new int[4][5];
    int[] highestNumber = new int[4];

    int[][] playerCards = new int[2][10];
    int[] selectedCards = new int[2];
    int[][] playerLostCard = new int[2][40];
    int[] playerLostCardIndices = new int[2];
    int[] playerPoints = new int[2];

    givePlayerCards(playerCards);

    for (int i = 0; i < batch.length; i++) {
      batch[i][0] = drawCard();
      highestNumber[i] = batch[i][0];
    }

    // Loop for the game
    for (int round = 0; round < 10; round++) {
      outputBatch(batch);
      for (int j = 0; j < 2; j++) {
        selectedCards[j] = playerSelectCard(j + 1, playerCards);
      }

      for (int i = 0; i < batch.length; i++) {
        highestNumber[i] = batch[i][0];
      }
      highestNumber = sort(highestNumber);

      int activePlayer = 1;
      if (selectedCards[1] < selectedCards[0]) {
        activePlayer = 2;
      }
      // smaller than any batch, he has to take the first batch
      if (selectedCards[activePlayer - 1]  < highestNumber[0]) {
        for (int i = 0; i < batch[0].length; i++) {
          playerLostCard[activePlayer - 1][playerLostCardIndices[activePlayer - 1]] = batch[0][i];
          // clear the space after the card was taken
          batch[0][i] = 0;
          playerLostCardIndices[activePlayer - 1]++;
        }
        batch[0][0] = selectedCards[activePlayer - 1];
      } else {
        int index = 1;
        pickBatchForCard(batch, playerLostCard, playerLostCardIndices,
            activePlayer, selectedCards[activePlayer - 1]);
      }
      if (activePlayer == 2) {
        activePlayer = 1;
      } else {
        activePlayer = 2;
      }

      pickBatchForCard(batch, playerLostCard, playerLostCardIndices, activePlayer,
          selectedCards[activePlayer - 1]);
    }

    // get the points of the cards
    for (int i = 0; i < 2; i++) {
      playerPoints[i] = calculatePoints(playerLostCard[i]);
    }

    outputResult(playerPoints);
  }

  public static void pickBatchForCard(int[][] batch, int[][] playerLostCard,
      int[] playerLostCardIndices, int activePlayer, int selectedCard) {
    int[] highestNumber = new int[4];
    for (int i = 0; i < batch.length; i++) {
      highestNumber[i] = batch[i][0];
    }
    highestNumber = sort(highestNumber);
    int index = 0;

    while (index < 3 && highestNumber[index + 1] < selectedCard) {
      index++;
    }
    // find the batch with the highest number
    int indexBatch = 0;
    while (batch[indexBatch][0] != highestNumber[index]) {
      indexBatch++;
    }
    // check whether the batch is full
    if (batch[indexBatch][4] != 0) {
      for (int i = 0; i < batch[indexBatch].length; i++) {
        playerLostCard[activePlayer - 1][playerLostCardIndices[activePlayer - 1]] =
            batch[indexBatch][i];
        // clear the space after the card was taken
        batch[indexBatch][i] = 0;
        playerLostCardIndices[activePlayer - 1]++;
      }
      batch[indexBatch][0] = selectedCard;
    } else {
      for (int i = 4; i >= 1; i--) {
        batch[indexBatch][i] = batch[indexBatch][i - 1];
      }
      batch[indexBatch][0] = selectedCard;
    }
  }

  public static void outputBatch(int[][] batch) {
    String str = "";
    for (int i = 0; i < 4; i++) {
      str += "Batch " + (i + 1) + ":";
      for (int j = 0; j < 5; j++) {
        if (batch[i][j] > 0) {
          str += " " + batch[i][j];
        } else {
          break;
        }
      }
      if (i != 3) {
        str += "\n";
      }
    }
    write(str);
  }

  public static int playerSelectCard(int player, int[][] playerCards) {
    int index = -1;
    int result = -1;
    player--;
    while (index < 0) {
      String str = "Player " + (player + 1) + ", you have the following cards:";
      for (int i = 0; i < 10; i++) {
        if (playerCards[player][i] != 0) {
          str += " " + playerCards[player][i];
        }
      }

      write(str);
      result = readInt("Which card do you want to play?");

      index = -1;
      for (int i = 0; i < playerCards[player].length; i++) {
        if (playerCards[player][i] == result) {
           index = i;
           break;
        }
      }
    }
    playerCards[player][index] = 0;
    return result;
  }

  public static int calculatePoints(int[] lostCards) {
    int result = 0;
    for (int j = 0; j < lostCards.length; j++) {
       result += getValueOfCard(lostCards[j]);
    }
    return result;
  }

  public static void outputResult(int[] playerPoints) {
    // check winner
    if (playerPoints[0] < playerPoints[1]) {
      write("Player 1 wins with " + playerPoints[0] + " against player 2 with " + playerPoints[1] + " points.");
    } else if (playerPoints[0] > playerPoints[1]) {
      write("Player 2 wins with " + playerPoints[1] + " against player 1 with " + playerPoints[0] + " points.");
    } else {
      write("Draw! Both players have " + playerPoints[0] + " points.");
    }
  }

  /** getValueOfCard
   * Computes the value of the given card
   * @param card a value between 1 and 105 inclusively
   * @return the computed value
   */
  public static int getValueOfCard(int card) {
    if (card == 0) {
      return 0;
    }
    int valueOfCard = 1;
    // repdigits
    if (card < 100 & card % 10 == card / 10) {
      valueOfCard += 5;
    }
    // last number is 5
    if (card % 10 == 5) {
      valueOfCard += 1;
    }
    if (card % 10 == 0) {
      valueOfCard += 2;
    }
    return valueOfCard;
  }

  /**
   * givePlayerCards
   * Fills the given array with cards from the method drawCard() 
   * Important: we fill the array in the order as described in the assignment
   * @param playerCards an arbitrary 2-dim array
   * @throws IllegalAccessException
   */
  public static void givePlayerCards(int[][] playerCards) throws IllegalAccessException {
    for (int i = 0; i < playerCards.length; i++) {
      for (int j = 0; j < playerCards[i].length; j++) {
        playerCards[i][j] = drawCard();
      }
    }
  }
}

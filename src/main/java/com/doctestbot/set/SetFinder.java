package com.doctestbot.set;

import com.doctestbot.set.Card.Color;
import com.doctestbot.set.Card.Shading;
import com.doctestbot.set.Card.Shape;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetFinder {

  /**
   * returns a set from the given cards, or an empty set if there is none.
   *
   * <p>Strategies: one can loop over all combinations of 3 cards, and check if they are a set. all
   * combinations of 3 cards = n*(n-1)*(n-2) = n^3 check if they are a set: - check shapes are all
   * different or all same = (3+3) - check shading are all different or all same = (3+3) - check
   * colours are all different or all same = (3+3)
   *
   * <p>Or: loop over all possible sets, sort them, and per set, find if it can be found in the
   * cards. loop over all possible sets: 3 the same, 1 different. per attribute, 4*3=12 possible
   * sets. sort the sets: again 12. loop over cards: n.
   */
  public static Set<Card> findSet(Set<Card> cardsOnTheTable) {
    // The collection will not be changed during iteration.
    for (Card firstCard : cardsOnTheTable) {
      for (Card secondCard : cardsOnTheTable) {
        for (Card thirdCard : cardsOnTheTable) {
          if (firstCard != secondCard && firstCard != thirdCard && secondCard != thirdCard) {
            if (threeCardsFormSet(firstCard, secondCard, thirdCard)) {

              Set<Card> foundSet = new HashSet<>();
              foundSet.add(firstCard);
              foundSet.add(secondCard);
              foundSet.add(thirdCard);
              System.out.println("Found set!=" + foundSet);
              return foundSet;
            }
          }
        }
      }
    }
    System.out.println("cardsOnTheTable=" + cardsOnTheTable);
    return Collections.emptySet();
  }

  public static boolean threeCardsFormSet(Card firstCard, Card secondCard, Card thirdCard) {
    // all different.
    if (threeCountsAreAllDifferent(firstCard.count(), secondCard.count(), thirdCard.count())
        || threeCountsAreAllSame(firstCard.count(), secondCard.count(), thirdCard.count())) {
      if (threeShapesAreAllDifferent(firstCard.shape(), secondCard.shape(), thirdCard.shape())
          || threeShapesAreAllSame(firstCard.shape(), secondCard.shape(), thirdCard.shape())) {
        if (threeShadingAreAllDifferent(
                firstCard.shading(), secondCard.shading(), thirdCard.shading())
            || threeShadingAreAllSame(
                firstCard.shading(), secondCard.shading(), thirdCard.shading())) {
          if (threeColorAreAllDifferent(firstCard.color(), secondCard.color(), thirdCard.color())
              || threeColorAreAllSame(firstCard.color(), secondCard.color(), thirdCard.color())) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean threeCountsAreAllDifferent(int first, int second, int third) {
    if (first != second && first != third && second != third) {
      return true;
    }
    return false;
  }

  public static boolean threeCountsAreAllSame(int first, int second, int third) {
    if (first == second && second == third) {
      return true;
    }
    return false;
  }

  public static boolean threeShapesAreAllDifferent(Shape first, Shape second, Shape third) {
    if (first != second && first != third && second != third) {
      return true;
    }
    return false;
  }

  public static boolean threeShapesAreAllSame(Shape first, Shape second, Shape third) {
    if (first == second && second == third) {
      return true;
    }
    return false;
  }

  public static boolean threeShadingAreAllDifferent(Shading first, Shading second, Shading third) {
    if (first != second && first != third && second != third) {
      return true;
    }
    return false;
  }

  public static boolean threeShadingAreAllSame(Shading first, Shading second, Shading third) {
    if (first == second && second == third) {
      return true;
    }
    return false;
  }

  public static boolean threeColorAreAllDifferent(Color first, Color second, Color third) {
    if (first != second && first != third && second != third) {
      return true;
    }
    return false;
  }

  public static boolean threeColorAreAllSame(Color first, Color second, Color third) {
    if (first == second && second == third) {
      return true;
    }
    return false;
  }
}

package com.doctestbot.set;

import java.util.Objects;

public record Card(int count, Shape shape, Shading shading, Color color) {
  public boolean equals(Object object) {
    Card card = (Card) object;
    return count == card.count
        && shape == card.shape
        && shading == card.shading
        && color == card.color;
  }

  public int hashCode() {
    return Objects.hash(count, shape, shading, color);
  }

  public enum Shape {
    DIAMOND,
    SQUIGGLE,
    OVAL
  }

  public enum Shading {
    SOLID,
    STRIPED,
    OPEN
  }

  public enum Color {
    RED,
    GREEN,
    PURPLE
  }
}

package dev.mwhyte.errors;

/*
  A simple example that causes a StackOverflow exception
 */
public class SOExample {

  public void countdown(int i) {
    System.out.println(i);
    if (i >= 0) {
      countdown(i - 1);
    }
  }
}

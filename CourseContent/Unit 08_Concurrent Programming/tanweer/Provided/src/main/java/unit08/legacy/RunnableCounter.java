package unit08.legacy;

public class RunnableCounter 
	implements Runnable {

  private final String name;

  public RunnableCounter (String name) {
    this.name = name;
  }

  @Override
  public void run () {
    int count = 1;
    while (count < 101) {
      System.out.println (name + ":" + count);
      count++;
    }
  }
}


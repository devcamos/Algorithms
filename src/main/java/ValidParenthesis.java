import java.util.Stack;

public class ValidParenthesis {

  public static void main(String[] args) {
    // Create a new stack
    Stack<Integer> s = new Stack<>();

    // Push elements onto the stack
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    Stack<String> characters = new Stack<>();
    characters.push("[");
    characters.push("]");
    characters.push("[");
    characters.push("]");

    System.out.println(characters);

    // Pop elements from the stack
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }

  //    public boolean isValid(String s) {
  //        Deque
  //    }

}

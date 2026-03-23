import java.time.Month;
import java.util.*;

public class No1 {
    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";

        Stack<String> inputStack = new Stack<>();
        for (String s : input.split(" ")) {
            inputStack.push(s);
        }

        List<String[]> pairs = new ArrayList<>();
        for (int i = 0; i < inputStack.size(); i += 2) {
            pairs.add(new String[]{inputStack.get(i), inputStack.get(i + 1)});
        }

        pairs.sort(Comparator.comparingInt(pair -> 
            Month.valueOf(pair[1].toUpperCase()).getValue()
        ));

        Stack<String> resultStack = new Stack<>();
        for (String[] pair : pairs) {
            resultStack.push(pair[0]);
            resultStack.push(pair[1]);
        }

        String[] output = resultStack.toArray(String[]::new);
        System.out.println(Arrays.toString(output));
    }
}

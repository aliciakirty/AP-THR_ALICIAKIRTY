import java.util.*;

abstract class Stand {
    abstract boolean expose(String name);
}

class Josuke extends Stand {
    @Override
    boolean expose(String name) {
        return name.toLowerCase().startsWith("k");
    }
}

class Jotaro extends Stand {
    @Override
    boolean expose(String name) {
        return name.length() <= 3;
    }
}

class Okuyasu extends Stand {
    @Override
    boolean expose(String name) {
        name = name.toLowerCase();
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == name.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}

class Koichi extends Stand {
    @Override
    boolean expose(String name) {
        int count = 0;
        name = name.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                count++;
            }
        }
        return count >= 3;
    }
}

class Rohan extends Stand {
    @Override
    boolean expose(String name) {
        String lower = name.toLowerCase();
        String rev = new StringBuilder(lower).reverse().toString();
        return lower.equals(rev);
    }
}

public class No2 {
    @SuppressWarnings("ConvertToStringSwitch")
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String user = sc.nextLine();
            String[] input = sc.nextLine().split(" ");

            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(input));

            Stack<String> stack = new Stack<>();

            Stand stand = null;

            if (user.equals("Josuke")) stand = new Josuke();
            else if (user.equals("Jotaro")) stand = new Jotaro();
            else if (user.equals("Okuyasu")) stand = new Okuyasu();
            else if (user.equals("Koichi")) stand = new Koichi();
            else if (user.equals("Rohan")) stand = new Rohan();

            while (!queue.isEmpty()) {
                String name = queue.poll();

                if (stand.expose(name)) {
                    stack.push(name.toLowerCase());
                }
            }

            if (stack.isEmpty()) {
                System.out.println(user + " exposed no one.");
            } else {
                System.out.println(user + " exposed someone!");
            }

            System.out.print("Arrested: [");
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i));
                if (i != stack.size() - 1) System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
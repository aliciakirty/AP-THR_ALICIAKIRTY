class Food {
    String name;
    Integer basePrice;

    Food(String name, Integer basePrice) {
        if (basePrice >= 1000000) {
            System.out.println("Error: Base price must be below 1000000");
            this.basePrice = 0;
        } else {
            this.basePrice = basePrice;
        }
        this.name = name;
    }

    Integer calcPrice() {
        return basePrice + 5000;
    }

    void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + calcPrice());
    }
}

class RegularMenu extends Food {

    RegularMenu(String name, Integer basePrice) {
        super(name, basePrice);
    }

    @Override
    Integer calcPrice() {
        return basePrice + 5000 + 10000; 
    }
}

class SpecialMenu extends Food {

    SpecialMenu(String name, Integer basePrice) {
        super(name, basePrice);
    }

    @Override
    Integer calcPrice() {
        return basePrice + 5000 + 20000; 
    }
}

public class No3 {
    public static void main(String[] args) {

        Food f1 = new Food("Beef Rendang", 15000);
        Food f2 = new RegularMenu("Chicken Ramen", 20000);
        Food f3 = new SpecialMenu("Fiery Fried Rice", 80000);

        f1.getInfo();
        f2.getInfo();
        f3.getInfo();
    }
}
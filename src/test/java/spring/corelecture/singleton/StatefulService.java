package spring.corelecture.singleton;

public class StatefulService {

//    private int price; //공유되는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}

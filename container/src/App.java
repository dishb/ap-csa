public class App {
    public static void main(String[] args) throws Exception {
        Container rishonBox = new Container("Rishon's box", 0);
        rishonBox.insert("Basketball", 60);
        rishonBox.itemsInside(true);
        System.out.println(rishonBox.toString());

        Cup taruCup = new Cup("Taru's cup", 0, "ceramic", false);
        taruCup.insert("Water", 50);
        taruCup.itemsInside(true);
        System.out.println(taruCup.toString());
        taruCup.insert("ice", 120);
        System.out.println(taruCup.toString());
    }
}

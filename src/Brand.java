import java.util.Comparator;
import java.util.TreeSet;

public class Brand {
    private int id;
    private String name;
    private static TreeSet<Brand> brandlist = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    static{
        createBrands();
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public static void createBrands() {
        brandlist.add(new Brand(1, "Apple"));
        brandlist.add(new Brand(2, "Samsung"));
        brandlist.add(new Brand(3, "Xiaomi"));
        brandlist.add(new Brand(4, "Huawei"));
        brandlist.add(new Brand(5, "Lenovo"));
        brandlist.add(new Brand(6, "Asus"));
        brandlist.add(new Brand(7, "Casper"));
        brandlist.add(new Brand(8, "HP"));
    }

    public static void printBrands() {
        System.out.println("Birlikte Calistigimiz Markalar: ");
        for (Brand brand : brandlist) {
            System.out.println(brand.id + " " + brand.getName());
        }
        System.out.println("******************");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Brand getBrand(int id) {
        for (Brand n : brandlist) {
            if (id == n.getId()) {
                return n;
            }

        }
        return null;
    }
}


import java.util.*;

public class CellPhone extends Product{
    private static int pId=1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<CellPhone> phones=new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public CellPhone(int id, String name, double price, int discountRate, int amount, Brand brand, double screenSize,
                     int ram, int memory, int battery, String color, int camResolution) {
        super(id, name, price, discountRate, amount, brand, screenSize, ram, memory);
        pId++;
        this.battery = battery;
        this.color = color;
        this.camResolution = camResolution;

    }

    public CellPhone() {

    }

    public static int getpId() {
        return pId;
    }

    public static void setpId(int pId) {
        CellPhone.pId = pId;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }



    public CellPhone(String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory, int battery, String color, int camResolution) {
    }


    @Override
    public  void menu() {
        System.out.println("1- Yeni Telefon ekle\n" +
                "2- Telefon listesini görüntüle\n" +
                "3- Telefon sil\n" +
                "4- Telefonları id numarasına göre sırala\n" +
                "5- Telefonları markaya göre filtrele");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value= input.nextInt();
        switch (value){
            case 1:
                addItem();
                break;
            case 2,4:
                getProducts();
                break;
            case 3:
                deleteItem();
            case 5:
                brandSorting();
                break;
            default:
                System.out.println("Gecersiz Islem");
                break;
        }

    }

    @Override
    public  void addItem() {
        System.out.print("Ürünün fiyatı : ");
        double price= input.nextDouble();
        System.out.print("Ürünün adı : ");
        input.nextLine();
        String name=input.nextLine();
        System.out.print("Ürünün indirim oranı : ");
        int discountRate= input.nextInt();
        System.out.print("Ürünün stoğu : ");
        int amount= input.nextInt();
        System.out.print("Ürünün rami : ");
        int ram= input.nextInt();
        System.out.print("Ürünün ekranı : ");
        double screenSize= input.nextDouble();
        System.out.print("Ürünün hafızası :");
        int memory= input.nextInt();
        System.out.print("Ürünün pili : ");
        int battery= input.nextInt();
        input.nextLine();
        System.out.print("Ürünün rengi : ");
        String color= input.nextLine();
        System.out.print("Kamera çözünürlüğü : ");
        int camResolution= input.nextInt();
        Brand.printBrands();
        System.out.print("Marka Seçiniz : ");
        Brand brand=Brand.getBrand(input.nextInt());
        CellPhone phone=new CellPhone(name,price,discountRate,amount,brand,screenSize,ram,memory,battery,color,camResolution);
        phones.add(phone);
        System.out.println("Eklenen telefonun id'si :"+phone.getId());

    }

    @Override
    public  void deleteItem() {
        getProducts();
        System.out.print("Silinmesini istediğiniz telefonun Id numarasını giriniz : ");
        int id=input.nextInt();
        phones.remove(id-1);
        System.out.println("Güncel telefon listesi ");
        getProducts();

    }
    public static void brandSorting(){
        input.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter= input.nextLine();
        ArrayList<CellPhone> filterPhones=new ArrayList<>();
        for (CellPhone n:phones){
            if(filter.equals(n.getBrand().getName())){
                filterPhones.add(n);
            }
        }
        //print(filterPhones);
    }

    @Override
    public  void getProducts() {
        print(null);
    }
    public void print(ArrayList<CellPhone> phoneList){
        if(phoneList==null) phoneList=this.phones;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (CellPhone n:phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory(),n.getBattery(),n.getColor(),n.getCamResolution());
        }
    }
}

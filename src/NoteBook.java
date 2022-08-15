import java.util.*;

public class NoteBook extends Product{

    private static int nbId=1;
    private static ArrayList<NoteBook> noteBooks = new ArrayList<>();

    public NoteBook(int id, String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory) {
        super(id, name, price, discountRate, amount, brand, screenSize, ram, memory);
    }

    public NoteBook() {


    }


    @Override
    public void menu() {
        System.out.println("1- Yeni Notebook ekle\n" +
                "2- Notebook listesini goruntule\n" +
                "3- Notebook sil\n" +
                "4- Notebooklari id numaralarina gore sirala\n" +
                "5- Notebooklari markaya gore sirala");
        System.out.print("Yapmak istediginiz islemi seciniz : ");
        int select = input.nextInt();
        switch (select){
            case 1:
                addItem();
                break;
            case 2,4:
                getProducts();
                break;
            case 3:
                deleteItem();
                break;
            case 5:
                brandSorting();

        }

    }


    @Override
    public void addItem() {
        System.out.print("Urunun fiyati : ");
        double price= input.nextDouble();
        System.out.print("Urunun adi : ");
        input.nextLine();
        String name=input.nextLine();
        System.out.print("Urunun indirim orani : ");
        int discountRate= input.nextInt();
        System.out.print("Urunun stogu : ");
        int amount= input.nextInt();
        System.out.print("Urunun rami : ");
        int ram= input.nextInt();
        System.out.print("Urunun ekrani : ");
        double screenSize= input.nextDouble();
        System.out.print("Urunun hafizasi :");
        int memory= input.nextInt();

        Brand.printBrands();
        System.out.print("Marka Seciniz : ");
        Brand brand=Brand.getBrand(input.nextInt());
        NoteBook notebook=new NoteBook();
        noteBooks.add(notebook);
        System.out.println("Eklenen notebook'un id'si :"+notebook.getId());

    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinmesini istediginiz notebook'un Id numarasini giriniz : ");
        int id=input.nextInt();
        noteBooks.remove(id-1);
        System.out.println("Guncel notebook listesi ");
        getProducts();

    }

    @Override
    public void getProducts() {
        print(null);

    }
    public void print(ArrayList<NoteBook> notebookList){
        if(notebookList==null) notebookList=this.noteBooks;
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (NoteBook n:notebookList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getName(),n.getAmount(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }
    }
    private void brandSorting() {
        input.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter= input.nextLine();
        ArrayList<NoteBook> filterNotebooks=new ArrayList<>();
        for (NoteBook n:noteBooks){
            if(filter.equals(n.getBrand().getName())){
                filterNotebooks.add(n);
            }
        }
        print(filterNotebooks);
    }

    public static int getnbId() {
        return nbId;
    }
}


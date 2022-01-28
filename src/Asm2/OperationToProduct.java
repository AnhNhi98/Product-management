package Asm2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperationToProduct {
    static Scanner sc = new Scanner(System.in);
    static MyList list = new MyList();
    static MyStack stack = new MyStack();
    static MyQueue queue = new MyQueue();

    public OperationToProduct() {
        // TODO Auto-generated constructor stub
    }

    public static Product addProduct() {
        System.out.println("Input new ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input Product's Name: ");
        String title = sc.nextLine();
        System.out.println("Input Product's quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Input Product's price: ");
        int price = Integer.parseInt(sc.nextLine());

        //Tạo product mới với các giá trị nhập vào
        Product p = new Product(id, title, quantity, price);
        return p;
    }

    //Hàm ghi dữ liệu vào file
    public static void writeList(File file, MyList list) throws IOException {
        //Kiểm tra list có null hay ko
        if (list.isEmpty()) {
            System.out.println("Empty list!!!!");
            return;
        }
        //Tìm file để ghi
        FileWriter fw = new FileWriter(file);
        //Ghi từng hàng
        BufferedWriter bw = new BufferedWriter(fw);
        //Ghi list vào file mỗi node là 1 dòng
        bw.write(list.toString());

        bw.close();
        fw.close();
        System.out.println("\nSuccessfully!\n");
    }

    //Hàm đệ quy tìm số nhị phân của n
    public static void convertToBinary(int n) {
        //Nếu n = 0 thì kết thúc hàm
        if (n == 0) {
            return;
        }
        //Khai báo m = số dư của phép chia 2
        int m = n % 2;
        //Gọi lại hàm
        convertToBinary(n / 2);
        //In kết quả
        System.out.print(m);
    }

    public static void tieuDe() {
        System.out.println("ID| Title| Quantity| Price");
    }

    public static void xuLy(int c) throws IOException {
        File file = new File( "data.txt");

        switch (c) {
            case 1:
                list.getFormFile(file, list);
                list.getSize();
                tieuDe();
                System.out.println(list.toString());
                break;
            case 2:
                Product p = OperationToProduct.addProduct();
                tieuDe();
                System.out.println(p.toString());
                list.addAtTail(p);
                break;
            case 3:
                tieuDe();
                list.getSize();
                System.out.println(list.toString());
                break;
            case 4:
                writeList(file, list);
                break;
            case 5:
                System.out.print("Input the ID to search: ");
                int idSearch = Integer.parseInt(sc.nextLine());
                list.searchId(idSearch);
                break;
            case 6:
                System.out.print("Input the bcode to delete: ");
                int idDelete = sc.nextInt();
                tieuDe();
                list.searchId(idDelete);
                System.out.println("product list after deleted: ");
                tieuDe();
                list.deleteById(idDelete);
                System.out.println(list.toString());
                System.out.println("Deleted!");
                break;
            case 7:
                list.sortById();
                System.out.println(list.toString());
                break;
            case 8:
                int b = list.getHead().getProduct().getQuantity();
                System.out.print("\nQuantity = " + b + " => ");
                convertToBinary(b);
                System.out.println("\n");
                break;
            case 9:
                stack.getFormFile(file, stack);
                tieuDe();
                System.out.println(stack);
                break;
            case 10:
                queue.getFormFile(file, queue);
                tieuDe();
                System.out.println(queue.toString());
                break;
            case 0:
                System.out.println("THANKS!");
                break;
            default:
                System.out.println("**Invalid choice. Try again.**");
        }
    }
}


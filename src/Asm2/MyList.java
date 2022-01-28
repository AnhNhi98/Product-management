package Asm2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyList {
    private int size;
    private Node head;
    private Node tail;

    public MyList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public MyList(Node head, Node tail) {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    //Hàm đọc dữ liệu từ file
    public void getFormFile(File file, MyList list) throws IOException {
        // Đọc file
        FileReader fr = new FileReader(file);
        // Đọc 1 hàng trong file
        BufferedReader br = new BufferedReader(fr);
        // Line để đọc dữ liệu trên từng hàng
        String line;
        // Đọc dữ liệu từng hàng đến hết
        while ((line = br.readLine()) != null) {
            // Mảng s chứa dữ liệu từng hàng bỏ đi khoảng trắng
            String[] s = line.split("\\s+");
            Product p = new Product(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));

            list.addAtTail(p);
        }
        br.close();
    }

    //Hàm thêm một sản phẩm vào cuối của danh sách móc nối
    public void addAtTail(Product p) {
        //Tạo một node mới chứa p nhập vào
        Node node = new Node(p);
        //Nếu có toa cuối thì lấy next của toa cuối chỉ vào node new
        if (this.tail != null) {
            this.tail.setNext(node);
        }
        //Đổi toa cuối bằng node new
        this.tail = node;
        if (this.head == null) {
            this.head = node;
        }
        this.size++;
        return;
    }

    //Hàm tìm kiếm thông tin sản phẩm theo ID
    public void searchId(int idSearch) {
        Node node = this.head;
        //Chạy từ node đầu tiên
        //Nếu id của node đó bằng id nhập vào tìm được => in ra
        //Không thì trả về
        while (node != null) {
            if (node.getProduct().getId() == idSearch) {
                System.out.println("\n" + node.toString() + "\n");
                return;
            }
            node = node.getNext();
        }
        System.out.println("-1");
        return;
    }

    //Hàm sắp xếp các sản phẩm  trong danh sách móc nối theo ID
    public void sortById() {
        //Chạy vòng lặp từ đầu đến hết list
        for (int i = 0; i < this.size; i++) {
            //Tìm id từ node đầu đến node cuối
            for (Node node = this.head; node.getNext() != null; node = node.getNext()) {
                //dời Product có ID nhỏ lên trước
                if (node.getProduct().getId() > node.getNext().getProduct().getId()) {
                    Product temp = node.getProduct();
                    node.setProduct(node.getNext().getProduct());
                    node.getNext().setProduct(temp);
                }
            }
        }
    }

    //Hàm xóa sản phẩm trong danh sách theo ID
    public void deleteById(int idDelete) {
        //Tạo biến đếm số lần chạy currentNode (0 là head, bằng this.size là tail)
        int counter = 0;
        //Node hiện tại đang chạy tìm id <= xóa Node hiện tại
        Node currentNode = this.head;
        //Node trucows node đang chạy
        Node preNode = null;

        //Chạy node hiện tại đến null tìm id
        while (currentNode != null) {
            if (currentNode.getProduct().getId() == idDelete) {
                //Nếu biến đếm = 0 thì current đang ở head
                if (counter == 0) {
                    //Đổi head = node tiếp theo => xóa Node head hiện tại
                    this.head = this.head.getNext();
                    //Trường hợp chỉ có 1 node xóa xong list còn null thì head = tail = null
                    if (this.head == null) {
                        this.tail = null;
                    }
                } else if (counter == this.size - 1) {
                    //Nếu biến đếm = size thì currentN đang ở tail

                    //Xóa node hiện tại => node trước node hiện tại chỉ đến null
                    preNode.setNext(null);
                    this.tail = preNode;
                } else {//xóa Node giữa list
                    //Chỉ next của preNode đến Node sau Node hiện tại
                    preNode.setNext(currentNode.getNext());
                }
            }
            //Tăng biến đếm sau 1 lần chạy
            counter++;
            //Tăng 2 Node lên
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }

    }

    public boolean isEmpty() {
        return this.head == null;
    }
    @Override
    public String toString() {
        Node n = this.head;
        String s = "";
        while (n != null) {
            s += n.toString();
            n = n.getNext();
        }
        return s;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
}

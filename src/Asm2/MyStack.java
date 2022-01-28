package Asm2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyStack {
    private Node head;
    private int size;

    public MyStack() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    //Thêm node vào stack
    public void push(Node node) {
        //Nếu stack đang null thì cho head = node mới
        if (this.head == null) {
            this.head = node;
            this.size++;
        } else {
            node.setNext(this.head);
            this.head = node;
            this.size++;
        }
    }
    public void getFormFile(File file, MyStack stack) throws IOException {
        //Đọc file
        FileReader fr = new FileReader(file);
        //Đọc 1 hàng trong file
        BufferedReader br = new BufferedReader(fr);
        //Line để đọc dữ liệu trên từng hàng
        String line;
        //Đọc dữ liệu từng hàng đến hết
        while ((line = br.readLine()) != null) {
            //Mảng s chứa dữ liệu từng hàng bỏ đi khoảng trắng
            String[] s = line.split("\\s+");

            Node node = new Node(new Product(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3])));
            stack.push(node);
        }
        br.close();
        fr.close();
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

    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}

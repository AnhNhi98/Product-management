package Asm2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyQueue {
    private  Node head;
    private Node tail;
    private int size;

    public MyQueue() {
        // TODO Auto-generated constructor stub
    }

    public MyQueue(Node head, Node tail, int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enQueue(Node node) {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
            this.size++;
        }
        this.tail.setNext(node);
        this.tail = node;
        this.size++;
    }

    public void getFormFile(File file, MyQueue queue) throws IOException {
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
            queue.enQueue(node);
        }
        br.close();
        fr.close();
    }


    private boolean isEmpty() {
        return this.size == 0;
    }
    public String toString() {
        String s = "";
        Node n = this.head;
        while (n != null) {
            s += n.toString();
            n = n.getNext();
        }
        return s;
    }
}


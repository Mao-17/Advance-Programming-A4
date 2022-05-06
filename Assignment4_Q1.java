import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;
import java.io.*;
import java.util.*;

class book {
    String title;
    int barcode;
    int isbn;

    book(String title, int barcode, int isbn) {
        this.title = title;
        this.barcode = barcode;
        this.isbn = isbn;
        Library.add_book(this);
    }

    public String get_title() {
        return this.title;
    }

    public int get_barcode() {
        return this.barcode;
    }

    public int get_isbn() {
        return this.isbn;
    }
}

class inp {
    public static int n;
    public static int k;
}

class temp_book {
    public static ArrayList<book> sort_title(ArrayList<book> list) {

        if (list.size() > 1) {
            list.sort((n1, n2) -> n1.get_title().compareTo(n2.get_title()));

            return list;

        }
        return list;
    }

    public static ArrayList<book> sort_isbn(ArrayList<book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).get_title() == list.get(i + 1).get_title()) {
                if (list.get(i).get_isbn() > list.get(i + 1).get_isbn()) {
                    Collections.swap(list, i, i + 1);
                }
            }
        }
        return list;

    }

    public static ArrayList<book> sort_barcodes(ArrayList<book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).get_isbn() == list.get(i + 1).get_isbn()) {
                if (list.get(i).get_barcode() > list.get(i + 1).get_barcode()) {
                    Collections.swap(list, i, i + 1);
                }
            }
        }
        return list;

    }
}

class Library {

    public static ArrayList<book> book_list = new ArrayList<>();
    public static ArrayList<book> temp_book_list = new ArrayList<>();

    public static void add_book(book b) {

        book_list.add(b);
        if (book_list.size() > 1) {
            book_list = temp_book.sort_title(book_list);
            book_list = temp_book.sort_isbn(book_list);
            book_list = temp_book.sort_barcodes(book_list);
        }
    }


    public static void print() {
        for (int i = 0; i < slot.size(); i++) {
                System.out.println("book title: " + book_list.get(i).get_title());
                System.out.println("book isbn: " + book_list.get(i).get_isbn());
                System.out.println("book barcode: " + book_list.get(i).get_barcode());
            }
    }

}

public class Assignment4_Q1 {

    public static void menu() {
        System.out.println("1. Print the entire sorted list");
        System.out
                .println("2. Print slot of one book");
        System.out.println("3. Exit");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String titles; int isbnn; int br;
        System.out.println("Enter the number of books: ");
        inp.n = scan.nextInt();
        System.out.println("Enter the no of racks: ");
        inp.k = scan.nextInt();
        for (int i = 0; i < inp.n; i++) {
            System.out.println("Enter the title of book: ");
            titles = scan.next();
            System.out.println("Enter the barcode of book: ");
            br = scan.nextInt();
            System.out.println("Enter the isbn of book: ");
            isbnn = scan.nextInt();
            book b = new book(titles, br, isbnn);

        }
        int flag = 1;
        int start;
        while (flag == 1) {
            menu();
            start = scan.nextInt();
            if(start == 1){
                Library.print();
            }
            else if(start == 2){
                String name_book = scan.next();

            }
            else if(start == 3){
                flag = 0;
            }
        
        }
    }

}

package Praktikum2;

import java.util.Scanner;

public class Nasabah07 {
    String norek, nama, alamat;
    int umur;
    double saldo;

    Nasabah07(String norek, String nama, String alamat, int umur, double saldo) {
        this.norek = norek;
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
        this.saldo = saldo;
    }

    Nasabah07() {

    }

    Nasabah07[] data;
    int front, rear, size, max;

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Elemen terdepan: " + data[front].norek + ", " + data[front].nama + ", " + data[front].alamat + ", " + data[front].umur + ", " + data[front].saldo);
        } else {
            System.out.println("Queue Masih Kosong");
        }
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Queue Masih Kosong");
        } else {
            System.out.println("Data nasabah:");
            for (int i = front; i != rear; i = (i + 1) % max) {
                System.out.println(data[i].norek + ", " + data[i].nama + ", " + data[i].alamat + ", " + data[i].umur + ", " + data[i].saldo);
            }
            System.out.println(data[rear].norek + ", " + data[rear].nama + ", " + data[rear].alamat + ", " + data[rear].umur + ", " + data[rear].saldo);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue Berhasil Dikosongkan");
        } else {
            System.out.println("Queue Masih Kosong");
        }
    }

    public Nasabah07(int n) {
        max = n;
        data = new Nasabah07[max];
        size = 0;
        front = rear = -1;
    }

    public void Enqueue(Nasabah07 dt) {
        if (isFull()) {
            System.out.println("Maaf, Queue Sudah Penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
           
            data[rear] = new Nasabah07(dt.norek, dt.nama, dt.alamat, dt.umur, dt.saldo);
            size++;
        }
    }

    public Nasabah07 Dequeue() {
        Nasabah07 dt = new Nasabah07();
        if (isEmpty()) {
            System.out.println("Queue Masih Kosong");
        } else {
            dt = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }
}

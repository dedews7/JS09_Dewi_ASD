package Tugas;

public class QueuePasien07 {
    Pasien07[] antrian;
    int front;
    int rear;
    int size;
    int max;

    public QueuePasien07(int n) {
        max = n;
        antrian = new Pasien07[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Pasien07 pasien) {
        if (isFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            antrian[rear] = pasien;
            size++;
        }
    }

    public Pasien07 dequeue() {
        Pasien07 pasien = null;
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            pasien = antrian[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
        }
        return pasien;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            do {
                System.out.println("Nama: " + antrian[i].nama + ", No. ID: " + antrian[i].noID + ", Jenis Kelamin: " + antrian[i].jenisKelamin + ", Umur: " + antrian[i].umur);
                i = (i + 1) % max;
            } while (i != (rear + 1) % max);
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Pasien terdepan: " + antrian[front].nama);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Pasien paling belakang: " + antrian[rear].nama);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekPosition(String nama) {
        if (!isEmpty()) {
            int i = front;
            int position = 1;
            do {
                if (antrian[i].nama.equals(nama)) {
                    System.out.println("Posisi " + nama + " dalam antrian: " + position);
                    return;
                }
                position++;
                i = (i + 1) % max;
            } while (i != (rear + 1) % max);
            System.out.println("Pasien " + nama + " tidak ditemukan dalam antrian");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void daftarPasien() {
        if (!isEmpty()) {
            System.out.println("Daftar Pasien dalam Antrian:");
            int i = front;
            do {
                System.out.println("Nama: " + antrian[i].nama + ", No. ID: " + antrian[i].noID + ", Jenis Kelamin: " + antrian[i].jenisKelamin + ", Umur: " + antrian[i].umur);
                i = (i + 1) % max;
            } while (i != (rear + 1) % max);
        } else {
            System.out.println("Queue masih kosong");
        }
    }
}


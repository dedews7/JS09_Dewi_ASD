package Praktikum1;

public class Queue {
int [] data;
int front;
int rear;
int size;
int max;

public Queue( int n){
    max = n;
    data = new int[max];
    size = 0;
    front = rear = -1;
}

public boolean isEmpty() {
    if (size == 0) {
        return true; 
    } else {
        return false;
    }
}

public boolean isFull() {
    if (size == max) {
    return true;
    } else {
        return false;
    }
}

public void peek() {
    if (!isEmpty()) {
        System.out.println("Elemen terdepan: " + data[front]);
    } else {
        System.out.println("Queue Masih Kosong");
    }
}

public void print() {
    if (isEmpty()) {
        System.out.println("Queue Masih Kosong");
    } else {
        int i = front;
        while (i != rear) {
            System.out.println(data[i] + " ");
            i = (i + 1) % max;
        }
        System.out.println(data[i] + " ");
        System.out.println("Jumlah elemen = " + size);
    }
}
public void clear() {
    if (!isEmpty()) {
        front = rear = -1;
        size =0;
        System.out.println("Queue Berhasil Dikosongkan");
    } else {
        System.out.println("Queue Masih Kosong");
    }
}
 
public boolean enqueue(int dt) {
    if (isFull()) {
        System.out.println("Maaf, Queue Sudah Penuh");
        return false; // Mengembalikan false jika queue overflow
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
        data[rear] = dt;
        size++;
        return true; // Mengembalikan true jika operasi berhasil
    }
}

public boolean dequeue() {
    if (isEmpty()) {
        System.out.println("Queue Masih Kosong");
        return false; // Mengembalikan false jika queue underflow
    } else {
        int dt = data[front];
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
        return true; // Mengembalikan true jika operasi berhasil
    }
}

}
    
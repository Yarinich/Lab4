package LB4;

import java.util.List;

class NodeElement {
    NodeElement next;    // указатель на следующий элемент
    int data;            // данные
}


class Node {
    private NodeElement head;       // указатель на первый элемент
    private NodeElement tail;       // указатель последний элемент


    void addFront(int data)           //добавить спереди
    {
        NodeElement a = new NodeElement();  //создаём новый элемент
        a.data = data;              //инициализируем данные.
        // указатель на следующий элемент автоматически инициализируется как null
        if (head == null)            //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            a.next = head;          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }


    void addBack(int data) {          //добавление в конец списка
        NodeElement a = new NodeElement();  //создаём новый элемент
        a.data = data;
        if (tail == null)           //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            tail.next = a;          //иначе "старый" последний элемент теперь ссылается на новый
            tail = a;               //а в указатель на последний элемент записываем адрес нового элемента
        }
    }


    void printList()                //печать списка
    {
        NodeElement t = this.head;       //получаем ссылку на первый элемент
        while (t != null)           //пока элемент существуе
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next;                     //и переключаемся на следующий
        }
        System.out.println();
    }


    void addAfter(int prevEl, int nextEl) {//Мстод который задали вам
        NodeElement t = this.head; //Получаем ссылку на первоэлемент
        while (t != null) {
            if (prevEl == t.data) {
                NodeElement e = new NodeElement();
                e.data = nextEl;
                e.next = t.next;
                t.next = e;
                t = e;
            }
            t = t.next;
        }

    }


    void delEl(int data) {       //удаление элемента

        if (head == null)        //если список пуст -
            return;             //ничего не делаем

        if (head == tail) {     //если список состоит из одного элемента
            head = null;        //очищаем указатели начала и конца
            tail = null;
            return;             //и выходим
        }

        if (head.data == data) {    //если первый элемент - тот, что нам нужен
            head = head.next;       //переключаем указатель начала на второй элемент
            return;                 //и выходим
        }

        NodeElement t = head;       //иначе начинаем искать
        while (t.next != null) {    //пока следующий элемент существует
            if (t.next.data == data) {  //проверяем следующий элемент
                if (tail == t.next)      //если он последний
                {
                    tail = t;           //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next; //найденный элемент выкидываем
                int e = t.next.next.data;
                t.next.next.data = t.next.data;
                t.next.data = e;
                return;                 //и выходим
            }
            t = t.next;                //иначе ищем дальше
        }
    }


    public int size() {
        int size = 0;
        NodeElement CurrNode = head;
        while (CurrNode.next != null) {
            CurrNode = CurrNode.next;
            size++;
        }
        return size;
    }

    public void switchFive(Node l) {
        NodeElement t = l.head; //Получаем ссылку на первоэлемент
        for(int i = 0; i < l.size()+1; i+=5) {
           if(i == 0 || (i+1)%5 == 0 && l.size() >= i++) {
                int e = t.next.next.next.next.next.data;
                t.next.next.next.next.next.data = t.data;
                t.data = e;
            }
        }

    }
}

public class TryList {
    public static void main(String[] args) {
        Node l = new Node();
        for (int i = 0; i <= 21; i++) {
            l.addBack(i);
        }
        System.out.println((l.size() - l.size() % 5) / 5);
        l.printList();
//        l.addFront(100);
//        l.addAfter(4, 10);
        l.printList();
//        l.delEl(3);
//        l.printList();
        l.switchFive(l);
        l.printList();
    }
}

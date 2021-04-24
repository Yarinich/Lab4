package TryLB4;

class NodeElementSingle {
    NodeElementSingle next;
    int data;
}

class NodeSingle {
    private NodeElementSingle head;       // вказівник на 1 елемент
    private NodeElementSingle tail;       // вказівник на останні елемент


    //Перевіряємо чи список пуст
    boolean isEmpty() {
        return head == null;
    }


    //Виводимо список
    void print() {
        NodeElementSingle printer = this.head;
        while(printer != null) {
            System.out.print(printer.data + " ");
            printer = printer.next;
        }
        System.out.println();
    }


    //рахуємо кількість елементів у списку
    int size() {
        NodeElementSingle nodeElementSingle = head;
        int counter = 0;

        if(head == null) {
            System.out.println("EmptyLOL");
        }

        while(!(nodeElementSingle == null)) {
            nodeElementSingle = nodeElementSingle.next;
            counter++;
            if(nodeElementSingle == tail) {
                counter++;
            }
        }
        return counter;
    }


    //Додаємо елемент до списку спереду
    void addFront(int data) {
        NodeElementSingle node_element = new NodeElementSingle();
        node_element.data = data;
        if( head == null) {
            head = node_element;
            tail = node_element;
        }
        else {
            node_element.next = head;
            head = node_element;
        }
    }


    //Додаємо елемент ззаду
    void addBack(int data) {
        NodeElementSingle node_element = new NodeElementSingle();
        node_element.data = data;
        if(head == null) {
            head = node_element;
        }
        else {
            tail.next = node_element;
        }
        tail = node_element;
    }


    //Видаляємо елемент
    void deleteElement(int data) {
        if(head == null) {
            return;
        }

        if(head.data == data) {
            head = head.next;
            return;
        }

        NodeElementSingle node_element = head;
        while(node_element.next != null) {
            if(node_element.next.data == data) {
                if(tail == node_element.next) {
                    tail = node_element;
                }
                node_element.next = node_element.next.next;
                if (node_element != tail) {
                    Swap(node_element);
                }
                return;
            }
            node_element = node_element.next;
        }
    }


    //зміна місцями двох елементів
    void Swap(NodeElementSingle node_element) {
                int temp = node_element.next.next.data;
                node_element.next.next.data = node_element.next.data;
                node_element.next.data = temp;
    }

    //зміна місцями кожні 5 елементів
    void SwapFive(NodeElementSingle node_element) {
        int temp = node_element.data;
        node_element.data = node_element.next.next.next.next.data;
        node_element.next.next.next.next.data = temp;
    }

    //вибір кожних 5 елементів, які потрібно змінити
    void countForSwapFive() {
        NodeElementSingle node_element = head;
        for(int i = 0; i < size(); i++) {
            if(i%5 == 0 && (size() - i) > 5) {
                SwapFive(node_element);
            }
            node_element = node_element.next;
            if(node_element.next == tail) {
                return;
            }
        }
    }

}



class NodeElementDouble {
    public int data;
    public NodeElementDouble next;
    public NodeElementDouble prev;
}


class NodeDouble {
    private NodeElementDouble head;
    private NodeElementDouble tail;

    //перевіряємо, чи список пуст
    boolean isEmpty() {
        return head == null;
    }

    //виводимо двозв'язни список
    void print() {
        NodeElementDouble printer = this.head;
        while(printer != null) {
            System.out.print(printer.data + " ");
            printer = printer.next;
        }
        System.out.println();
    }

    //додаємо елемент спереду для двозв'язного списку
    void addFront(int data) {
        NodeElementDouble node_element = new NodeElementDouble();
        node_element.data = data;

        if(isEmpty()) {
            tail = node_element;
        }
        else {
            head.prev = node_element;
        }

        node_element.next = head;
        head = node_element;
    }

    //додаємо елемент ззаду для двозв'язного списку
    void addBack(int data) {
        NodeElementDouble node_element = new NodeElementDouble();
        node_element.data = data;

        if(isEmpty()) {
            head = node_element;
        }
        else {
            tail.next = node_element;
        }
        node_element.prev = tail;
        tail = node_element;
    }

    //видаляємо 1 елемент
    void deleteFirst() {
        if(head.next == null) {
            tail = null;
        }
        else {
            head.next.prev = null;
        }

        head = head.next;
    }

    //видаляємо останні елемент
    void deleteLast() {
        if(head.next == null) {
            tail = null;
        }
        else {
            tail.prev.next = null;
        }

        tail = tail.prev;
    }

    //видаляємо елемент
    void deleteElement(int data) {

        if(isEmpty()) {
            System.out.println("empty");
            return;
        }

        NodeElementDouble node_element = head;

        while (node_element.data != data) {
            node_element = node_element.next;

            if (node_element == null) {
                return;
            }
        }

            if (node_element == head) {
                deleteFirst();
            }
            else {
                node_element.prev.next = node_element.next;
            }

            if(node_element == tail) {
                deleteLast();
            }
            else {
                node_element.next.prev = node_element.prev;
            }


    }
}



public class Runner {
    public static void main(String[] args) {
        NodeSingle nodeSingle = new NodeSingle();
        NodeDouble nodeDouble = new NodeDouble();
        System.out.println("Перевіримо, чи створені списки пусті.");
        System.out.println("Однозв'язний пустий? - " + nodeSingle.isEmpty());
        System.out.println("Двозв'язний пустий? - " + nodeDouble.isEmpty());

        System.out.println();
        for (int i = 0; i < 80; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();


        nodeSingle.addFront(5);
        nodeSingle.addFront(4);
        nodeSingle.addFront(3);
        nodeSingle.addFront(2);
        nodeSingle.addFront(1);
        nodeSingle.addBack(6);
        nodeSingle.addBack(7);
        nodeSingle.addBack(8);
        nodeSingle.addBack(9);
        nodeSingle.addBack(10);
        nodeSingle.addBack(11);
        System.out.print("Наш однозв'язний список, після заповнення: ");
        nodeSingle.print();
        System.out.print("Видалимо елемент 4.");
        nodeSingle.deleteElement(4);
        System.out.print("Тепер наш список має вигляд: ");
        nodeSingle.print();
        System.out.print("Тепер згідно варіанту змінимо кожну п'ятірку елементів: ");
        nodeSingle.countForSwapFive();
        nodeSingle.print();

        System.out.println();
        for (int i = 0; i < 80; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println();


        nodeDouble.addFront(5);
        nodeDouble.addFront(4);
        nodeDouble.addFront(3);
        nodeDouble.addBack(6);
        nodeDouble.addBack(3);
        System.out.print("Наш двозв'язний список, після заповнення: ");
        nodeDouble.print();
        System.out.print("Видалимо елемент 3.");
        nodeDouble.deleteElement(3);
        System.out.print("Тепер наш список має вигляд: ");
        nodeDouble.print();
    }
}
package cpe200.week2;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(char i) {
        tail = new PNode(i,null,tail);
        if(tail == null)
        {
            tail = head;
        }
        else
        {
            tail.prev.next = tail;
            size++;
        }

    }

    public char popHead() {
        char i=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return i;
    }

    public char popTail() {
        char i = tail.data;
        PNode temp = tail;

        if(head == tail)
        {
            head = tail = null;
        }
        else
        {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size--;
        return i;
    }

    public boolean search(char i) {
        PNode temp = head;
        while(temp != null)
        {
            if(temp.data == i)
            {
                return true;
            }
            else
            temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode temp = tail;
        while(temp != null)
        {
            System.out.print(temp.data);
            temp = temp.prev;
        }
        System.out.println();

    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}

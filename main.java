abstract class Shape {
    abstract void draw();
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a square");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a triangle");
    }
}

class LinkedListNode {
    private Shape shape;
    private LinkedListNode next;

    public LinkedListNode(Shape shape) {
        this.shape = shape;
        this.next = null;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}

class LinkedList {
    private LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void addNode(Shape shape) {
        LinkedListNode newNode = new LinkedListNode(shape);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void drawAllShapes() {
        LinkedListNode current = head;
        while (current != null) {
            current.getShape().draw();
            current = current.getNext();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList shapeList = new LinkedList();

        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                shapeList.addNode(new Square());
            } else if (i % 3 == 1) {
                shapeList.addNode(new Rectangle());
            } else {
                shapeList.addNode(new Triangle());
            }
        }

        shapeList.drawAllShapes();
    }
}
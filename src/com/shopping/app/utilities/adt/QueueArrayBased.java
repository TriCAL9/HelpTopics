package com.shopping.app.utilities.adt;

import com.shopping.app.utilities.adt.exceptions.QueueException;

public class QueueArrayBased<E> implements QueueInterface<E> {
    private final int MAX_QUEUE = 100;
    private E[] items;
    private int front;
    private int back;
    private int count;

    public QueueArrayBased() {
        items = (E[]) new Object[MAX_QUEUE];
        front = 0;
        back = MAX_QUEUE - 1;
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX_QUEUE;
    }

    @Override
    public void enqueue(E newItem) throws QueueException {
        if (!isFull()) {
            back = (back + 1) % MAX_QUEUE;
            items[back] = newItem;
            ++count;
        } else {
            throw new QueueException("");
        }
    }

    @Override
    public E dequeue() throws QueueException {
        if (isEmpty()) {
            E queueFront = items[front];
            front = (front + 1) % MAX_QUEUE;
            --count;
            return queueFront;
        } else {
            throw new QueueException("");
        }
    }

    public void dequeueAll() {
        items = (E[])new Object[MAX_QUEUE];
        front = 0;
        back  = MAX_QUEUE - 1;
        count = 0;
    }
    @Override
    public E peek() throws QueueException {
        if (!isEmpty()) return items[front];
        else throw new QueueException("Queue exception on peek: " + "Queue empty");
    }
}

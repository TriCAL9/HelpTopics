package com.shopping.app.utilities.adt;

import com.shopping.app.utilities.adt.exceptions.QueueException;

public interface QueueInterface<E>{
    boolean isEmpty();
    void enqueue(E newItem) throws QueueException;
    E dequeue() throws QueueException;
    E peek() throws QueueException;
}

package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {

    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        for (Node<E> element : data) {
            if (condition.test(element)) {
                rsl = Optional.of(element);
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean isBinary = false;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        int cellCount = 0;
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            Predicate<Node<E>> equalsChild = e -> (e.equals(el));
                cellCount++;
            if (cellCount > 2) {
                isBinary = true;
                break;
            }
            data.addAll(el.children);
        }
        return isBinary;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        boolean result = parentNode.isPresent() && childNode.isEmpty();
        if (result) {
            parentNode.get().children.add(new Node<>(child));
        }
        return result;
    }
}

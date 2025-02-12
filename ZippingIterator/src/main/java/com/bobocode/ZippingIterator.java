package com.bobocode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ZippingIterator<A, B, C> implements Iterator<C> {
    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final BiFunction<A, B, C> combiner;

    public ZippingIterator(Iterator<A> iteratorA, Iterator<B> iteratorB, BiFunction<A, B, C> combiner) {
        this.iteratorA = iteratorA;
        this.iteratorB = iteratorB;
        this.combiner = combiner;
    }

    @Override
    public boolean hasNext() {
        return iteratorA.hasNext() && iteratorB.hasNext();
    }

    @Override
    public C next() {
        return combiner.apply(iteratorA.next(), iteratorB.next());
    }


    public static void main(String[] args) {

        List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5);
        List<String> listB = Arrays.asList("a", "b", "c", "d", "e");

        Iterator<Integer> iterA = listA.iterator();
        Iterator<String> iterB = listB.iterator();

        BiFunction<Integer, String, String> combiner = (num, str) -> num + str;
        ZippingIterator<Integer, String, String> zipIter = new ZippingIterator<>(iterA, iterB, combiner);

        while (zipIter.hasNext()) {
            System.out.println(zipIter.next());
        }

    }

}
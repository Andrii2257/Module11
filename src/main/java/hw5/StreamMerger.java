package hw5;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamMerger {
    public static <T> Stream<T> merge(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> mergedIterator = new Iterator<T>() {
            private boolean firstExhausted = !firstIterator.hasNext();
            private boolean secondExhausted = !secondIterator.hasNext();

            @Override
            public boolean hasNext() {
                return !firstExhausted || !secondExhausted;
            }

            @Override
            public T next() {
                if (!firstExhausted) {
                    T next = firstIterator.next();
                    firstExhausted = !firstIterator.hasNext();
                    return next;
                }
                if (!secondExhausted) {
                    T next = secondIterator.next();
                    secondExhausted = !secondIterator.hasNext();
                    return next;
                }
                throw new IllegalStateException("No more elements");
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(mergedIterator, 0);

        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3);
        Stream<Integer> secondStream = Stream.of(4, 5, 6, 7);

        Stream<Integer> mergedStream = StreamMerger.merge(firstStream, secondStream);
        mergedStream.forEach(System.out::println);
    }
}


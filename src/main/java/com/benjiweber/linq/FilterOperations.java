package com.benjiweber.linq;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

public interface FilterOperations<T> {
    Linq<T> where(Predicate<T> predicate);
    interface CollectionCondition<T,U,V> {
        Linq<T> all(Predicate<U> condition);
        Linq<T> any(Predicate<U> condition);
        Linq<T> contains(U item);
    }

    <U,V extends Collection<U>> CollectionCondition<T,U,V> where(CollectionGetter<T,U,V> collectionGetter);
    interface PropertyComparison<T,U> {
        Linq<T> equalTo(U value);
        Linq<T> lessThan(U value);
        Linq<T> greaterThan(U value);
    }
    <U extends Comparable<U>> PropertyComparison<T,U> where(PropertyGetter<T,U> propertyExtractor);

}

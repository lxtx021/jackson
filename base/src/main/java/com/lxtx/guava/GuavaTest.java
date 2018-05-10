package com.lxtx.guava;

import com.google.common.base.Optional;

/**
 * @author jackson
 */
public class GuavaTest {
    public static void main(String args[]){
        GuavaTest guavaTester = new GuavaTest();
        Integer invalidInput = null;
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(guavaTester.sum(a,b));

//        Multiset.Entry
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        return a.get() + b.get();
    }
}

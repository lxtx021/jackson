package com.lxtx.base.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Eternity
 * @version 1.0
 * @description
 * stream和parallelStream的简单区分： stream是顺序流，由主线程按顺序对流执行操作，
 * 而parallelStream是并行流，内部以多线程并行执行的方式对流进行操作，但前提是流中的数据处理没有顺序要求。
 * @date 2022/3/3
 **/
public class Java8Stream {
    /**
     * Stream将要处理的元素集合看作一种流，在流的过程中，借助Stream API对流中的元素进行操作，比如：筛选、排序、聚合等。
     * Stream可以由数组或集合创建，对流的操作分为两种：
     *
     *
     * 中间操作，每次返回一个新的流，可以有多个。
     *
     *
     * 终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。
     *
     *
     * 另外，Stream有几个特性：
     *
     *
     * stream不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
     *
     *
     * stream不会改变数据源，通常情况下会产生一个新的集合或一个值。
     *
     *
     * stream具有延迟执行特性，只有调用终端操作时，中间操作才会执行。
     *
     * 作者：Levng
     * 链接：https://juejin.cn/post/7064757819165114404
     * 来源：稀土掘金
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        stream();
//        streamFunc();
    }

    /**
     * 1、通过 java.util.Collection.stream() 方法用集合创建流
     */
    public static void stream(){
        // 1、通过 java.util.Collection.stream() 方法用集合创建流
        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(System.out::println);

//        Optional<Integer> findFirst = list.stream().parallel().filter(x->x>6).findFirst();

    }

    /**
     * 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
     */
    public static void IntStream(){
        int[] array={1,3,5,6,8};
        IntStream stream = Arrays.stream(array);
        stream.forEach(System.out::println);
    }

    /**
     * 3、使用Stream的静态方法：of()、iterate()、generate()
     */
    public static void streamFunc(){
        Stream<Integer> stream = Stream.of(1, 6, 7,3, 1, 6);
        stream.forEach(System.out::println);
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

    }



}

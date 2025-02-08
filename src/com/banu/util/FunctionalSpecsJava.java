package com.banu.util;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalSpecsJava {

	public static void main(String[] args) {

		// Supplier - takes no args - gives output
		Supplier<Integer> supplier = () -> new Random().nextInt(100);

		System.out.println(supplier.get());

		Supplier<String> supplier1 = () -> "Hello world";
		System.out.println(supplier1.get());

		// Consumer - accepts 1 arg - gives output
		Consumer<String> con = (name) -> System.out.println("hello there! " + name);
		con.accept("Banu");

		Consumer<Integer> con2 = (num) -> System.out.println(num);
		con2.accept(23);

		// BiConsumer -- accepts 2 args - gives output
		BiConsumer<Integer, String> biCon1 = (key, val) -> System.out
				.println("hello " + val + "! Your token no is : " + key);
		biCon1.accept(12, "Banu");

		BiConsumer<String, String> strBiCon = (str1, str2) -> {
			String strconcat = str1.concat("").concat(str2);
			System.out.println(strconcat);
		};

		strBiCon.accept("Jungle ", "book!");

		// Function example - takes Type T and returns Type S
		// Function<T,S> --> use apply
		Function<String, String> findLenght = (text) -> text.toUpperCase();
		Function<String, String> appendString = (text) -> text.concat(" hello");
		String str = "Bender";
		Function<String, String> composedFunc = findLenght.andThen(appendString);
		System.out.println("Length of the String " + str + " is " + findLenght.apply("Bender"));
		String composedString = composedFunc.apply(str);
		System.out.println(composedString);
	}

}

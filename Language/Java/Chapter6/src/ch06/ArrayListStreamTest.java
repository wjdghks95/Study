package ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {

		Stream<String> stream1 = Arrays.stream(arr);
		stream1.forEach(s->System.out.println(s));

		List<String> sList = new ArrayList<String>();
		sList.add("Tomas");
		sList.add("Edward");
		sList.add("Jack");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.println(s));
		
		sList.stream().sorted().forEach(s->System.out.print(s + "\t"));
		System.out.println();
		
		sList.stream().map(s->s.length()).forEach(n->System.out.print(n + "\t"));
		System.out.println();
		
		sList.stream().filter(s->s.length() >= 5).forEach(n->System.out.print(n + "\t"));
		
	}

}

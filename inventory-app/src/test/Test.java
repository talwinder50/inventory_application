package services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test implements TestInterface{

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tes31() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(9,1,2);
		
		Collections.sort(list, (a, b) -> b.compareTo(a));
		System.out.println(list);
	}

	
}

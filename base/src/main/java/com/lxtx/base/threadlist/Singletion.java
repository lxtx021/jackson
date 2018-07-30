package com.lxtx.base.threadlist;

public class Singletion {
	
	private static class InnerSingletion {
		private static Singletion single = new Singletion();
	}
	
	public static Singletion getInstance(){
		return InnerSingletion.single;
	}

	public static void main(String[] args) {
		Singletion s = Singletion.getInstance();
		System.out.println("singletion :"+s.hashCode());
	}
	
}

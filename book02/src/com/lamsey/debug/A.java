package com.lamsey.debug;

public class A {
	public void abc(String name){
		System.out.println("����A���abc����");
		System.out.println("����name��ֵΪ"+name);
		B b = new B();
		String bbbReturnValue = b.bb(name);
		System.out.println("����b.bb�����ķ���ֵ");
	}
}

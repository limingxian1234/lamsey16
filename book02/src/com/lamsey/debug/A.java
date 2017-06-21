package com.lamsey.debug;

public class A {
	public void abc(String name){
		System.out.println("进入A类的abc方法");
		System.out.println("参数name的值为"+name);
		B b = new B();
		String bbbReturnValue = b.bb(name);
		System.out.println("调用b.bb犯法的返回值");
	}
}

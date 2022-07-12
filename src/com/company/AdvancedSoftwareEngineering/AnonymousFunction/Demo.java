package com.company.AdvancedSoftwareEngineering.AnonymousFunction;

public class Demo {
    public static void main(String[] args) {

        // 接口中只定义了1个抽象方法，可以利用Lambda表达式
        // 来重写这唯一的一个抽象方法
// 方式一
/*		Cacl c = new Cacl() {

		@Override
		public double add(double i, double j) {
			return i + j;
		}
	}; */

        //  方式2
        // 表示重写Cacl中唯一的一个抽象方法add
        // Lambda表达式只能作用在函数式接口上
/*		Cacl c = (double a, double b) -> {
        		return a + b;
       	}; // 这里必须加分号，结尾
      	// 方法体只有一句，可以省略{}和return不写
       Cacl c = (double i,double j) -> i + j;  */



        //   方式3
        // 重写的是Cacl接口中的方法add
        // add方法的参数列表的类型是已知的
        // 可以省略参数类型不写
        // Cacl c = (x, y) -> x + y;
        Cacl c = Double::sum;  // 可读性很差，看不到重写的是哪个方法
        // 但是符合函数式编程方式，大数据方向常用的方式

        System.out.println(c.add(5.6, 9.9));
    }
}

interface Cacl{
    public double add(double i, double j);
}

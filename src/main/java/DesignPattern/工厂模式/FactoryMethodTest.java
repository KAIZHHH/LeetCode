package DesignPattern.工厂模式;

/**
 * @author kai
 * @date 2022/3/17 下午2:11
 */
//抽象产品
interface Product {
    void print();
}

//具体产品A
class ProductA implements Product {
    @Override
    public void print() {
        System.out.println("ProductA正在打印");
    }
}

//抽象工厂
interface abstractFactory {
    Product createProduct();//生产产品
}

//具体工厂A
class factoryA implements abstractFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        abstractFactory factoryA = new factoryA();
        factoryA.createProduct().print();
    }
}

/*

//具体产品B
class ProductB implements Product {
    @Override
    public void print() {
        System.out.println("ProductB正在打印");
    }
}

//具体工厂B
class factoryB implements abstractFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
 */

package DesignPattern.工厂模式;

/**
 * @author kai
 * @date 2022/3/17 下午2:08
 */
//抽象工厂
interface IFactory {
    void createProduct();//生产产品
}

//具体工厂A
class FactoryA implements IFactory {
    @Override
    public void createProduct() {
        System.out.println("工厂A生产产品A");
    }
}

//具体工厂B
class FactoryB implements IFactory {
    @Override
    public void createProduct() {
        System.out.println("工厂B生产产品B");
    }
}

public class EasyFactory {
    //根据参数指定工厂 来执行方法
    public IFactory createFactory(String type) {
        if (type.equals("A")) {
            return new FactoryA();
        } else {
            return new FactoryB();
        }
    }

    public static void main(String[] args) {
        EasyFactory factory = new EasyFactory();
        IFactory a = factory.createFactory("A");
        a.createProduct();
    }
}

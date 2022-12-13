package DesignModel.工厂模式;

/**
 * @author kai
 * @date 2022/3/17 下午2:48
 */


//抽象产品A
interface IFridge {
    void coldStorage();
}

//具体工厂A的产品A
class MeideFridge implements IFridge {
    public void coldStorage() {
        System.out.println("美的冰箱");
    }
}

//抽象产品B
interface IWasher {
    void wash();
}

//具体工厂A的产品B
class MeideWasher implements IWasher {
    public void wash() {
        System.out.println("美的洗衣机");
    }
}

//抽象工厂
interface AbstractFactory {
    IFridge createFridge();

    IWasher createWasher();
}

//具体工厂A 生产：A工厂的产品A、A工厂的产品B
class MeideFactory implements AbstractFactory {
    public IFridge createFridge() {
        return new MeideFridge();
    }

    public IWasher createWasher() {
        return new MeideWasher();
    }
}

public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory = new MeideFactory();
        factory.createFridge().coldStorage();
        factory.createWasher().wash();
    }
}

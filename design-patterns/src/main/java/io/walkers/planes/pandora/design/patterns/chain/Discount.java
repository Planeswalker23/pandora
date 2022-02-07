package io.walkers.planes.pandora.design.patterns.chain;

/**
 * @author Planeswalker23
 */
public abstract class Discount {
    // 后继节点
    private Discount next;

    // 本优惠需要进行计算
    abstract boolean match(Order order);

    // 计算价格
    abstract void calculatePrice(Order order);

    void doCalculate(Order order) {
        System.out.println("责任链 " + this.getClass().getSimpleName() + " 开始处理");
        // 如果满足计算条件才进行优惠叠加
        if (this.match(order)) {
            calculatePrice(order);
        }
        System.out.println("责任链 " + this.getClass().getSimpleName() + " 处理结束");
        if (this.next != null) {
            this.next.doCalculate(order);
        }
    }

    public Discount getNext() {
        return next;
    }

    public void setNext(Discount next) {
        this.next = next;
    }
}

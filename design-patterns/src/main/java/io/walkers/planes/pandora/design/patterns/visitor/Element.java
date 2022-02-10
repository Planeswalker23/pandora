package io.walkers.planes.pandora.design.patterns.visitor;

/**
 * @author Planeswalker23
 */
public abstract class Element {
    // 消息具体内容
    private String content;

    public Element(String content) {
        this.content = content;
    }

    // 访问者进行访问
    public abstract void accept(Visitor visitor);

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

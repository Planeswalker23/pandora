package io.walkers.planes.pandora.design.patterns.flyweight;

/**
 * 基础信息
 *
 * @author 范逸东(东稚)
 */
public class BaseInfo {
    // 会员名，不可更改，将作为享元工厂的 key
    private String memberName;
    // 昵称
    private String memberNickname;

    public BaseInfo(String memberName, String memberNickname) {
        this.memberName = memberName;
        this.memberNickname = memberNickname;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    @Override
    public String toString() {
        return "{" +
                "会员名='" + memberName + '\'' +
                ", 昵称='" + memberNickname + '\'' +
                '}';
    }
}

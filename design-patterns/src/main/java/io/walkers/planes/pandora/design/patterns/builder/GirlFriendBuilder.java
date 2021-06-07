package io.walkers.planes.pandora.design.patterns.builder;

/**
 * 构造者类
 *
 * @author planeswalker23
 */
public class GirlFriendBuilder {
    /**
     * 性别
     */
    private String sexual;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 发型
     */
    private String hire;
    /**
     * 爱好
     */
    private String hobby;

    public String getSexual() {
        return sexual;
    }

    public GirlFriendBuilder setSexual(String sexual) {
        this.sexual = sexual;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public GirlFriendBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getHire() {
        return hire;
    }

    public GirlFriendBuilder setHire(String hire) {
        this.hire = hire;
        return this;
    }

    public String getHobby() {
        return hobby;
    }

    public GirlFriendBuilder setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    /**
     * build 方法，作为 GirlFriendBuilder -> GirlFriend 转换的方法，调用 GirlFriend 的全参构造方法
     *
     * @return GirlFriend
     */
//        public GirlFriend build() {
//            return new GirlFriend(this);
//        }
    public GirlFriend build() {
        // 性别、年龄必填
        if (this.sexual == null || this.age == null) {
            throw new IllegalArgumentException("GirlFriend sexual is null");
        }
        // 若设置发型属性，爱好属性也需要必填
        if (this.hire != null && this.hobby == null) {
            throw new IllegalArgumentException("GirlFriend hire is not null but hobby is null");
        }
        return new GirlFriend(this);
    }
}

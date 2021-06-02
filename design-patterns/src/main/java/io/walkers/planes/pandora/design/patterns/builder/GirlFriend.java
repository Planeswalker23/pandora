package io.walkers.planes.pandora.design.patterns.builder;

import java.math.BigDecimal;

/**
 * "女朋友" 类
 *
 * @author planeswalker23
 */
public class GirlFriend {
    /** 性别 */
    private String sexual;
    /** 年龄 */
    private Integer age;
    /** 发型 */
    private String hire;
    /** 爱好 */
    private String hobby;

    public GirlFriend(Integer age, String hire, String hobby) {
        this.sexual = "女";
        if (age == null || age < 0) {
            throw new RuntimeException("年龄非法！");
        }
        this.age = age;
        this.hire = hire;
        this.hobby = hobby;
    }

    public GirlFriend(GirlFriendBuilder builder) {
        this.sexual = builder.sexual;
        this.age = builder.age;
        this.hire = builder.hire;
        this.hobby = builder.hobby;
    }



    public static void main(String[] args) {
        GirlFriend myGirl = new GirlFriend(18, "长发及腰", "打球");
        myGirl.setSexual("女");
        myGirl.setAge(18);
        myGirl.setHire("长发及腰");
        myGirl.setHobby("打球");
        System.out.println(myGirl);

        GirlFriend newMyGirl = new GirlFriendBuilder().setSexual("女").setAge(18).setHire("长发及腰").setHobby("打球").build();
        System.out.println(newMyGirl);
    }


    public String getSexual() {
        return sexual;
    }

    public void setSexual(String sexual) {
        this.sexual = sexual;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "sexual='" + sexual + '\'' +
                ", age=" + age +
                ", hire='" + hire + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public static class GirlFriendBuilder {
        /** 性别 */
        private String sexual;
        /** 年龄 */
        private Integer age;
        /** 发型 */
        private String hire;
        /** 爱好 */
        private String hobby;

        public GirlFriendBuilder setSexual(String sexual) {
            this.sexual = sexual;
            return this;
        }

        public GirlFriendBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public GirlFriendBuilder setHire(String hire) {
            this.hire = hire;
            return this;
        }

        public GirlFriendBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public String getSexual() {
            return sexual;
        }

        public Integer getAge() {
            return age;
        }

        public String getHire() {
            return hire;
        }

        public String getHobby() {
            return hobby;
        }

        /**
         * build 方法，作为 GirlFriendBuilder -> GirlFriend 转换的方法，调用 GirlFriend 的全参构造方法
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
}

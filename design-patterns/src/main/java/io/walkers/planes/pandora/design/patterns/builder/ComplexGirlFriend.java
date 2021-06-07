package io.walkers.planes.pandora.design.patterns.builder;

/**
 * 包含复杂对象的"女朋友"类
 *
 * @author planeswalker23
 */
public class ComplexGirlFriend {
    /**
     * 作为人的基本属性(年龄、姓名等)
     */
    private Person person;
    /**
     * 职业
     */
    private Profession profession;

    public ComplexGirlFriend(ComplexGirlFriendBuilder complexGirlFriendBuilder) {
        this.person = complexGirlFriendBuilder.getPerson();
        this.profession = complexGirlFriendBuilder.getProfession();
    }

    @Override
    public String toString() {
        return "ComplexGirlFriend{" +
                "person=" + person +
                ", profession=" + profession +
                '}';
    }
}

class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Profession {
    private String professionName;
    private String professionType;

    public Profession(String professionName, String professionType) {
        this.professionName = professionName;
        this.professionType = professionType;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "professionName='" + professionName + '\'' +
                ", professionType='" + professionType + '\'' +
                '}';
    }
}
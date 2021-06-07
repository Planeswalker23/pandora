package io.walkers.planes.pandora.design.patterns.builder;

/**
 * 构造者类
 *
 * @author planeswalker23
 */
public class ComplexGirlFriendBuilder {

    private Person person;
    private Profession profession;

    public Person getPerson() {
        return person;
    }

    public ComplexGirlFriendBuilder setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Profession getProfession() {
        return profession;
    }

    public ComplexGirlFriendBuilder setProfession(Profession profession) {
        this.profession = profession;
        return this;
    }

    public ComplexGirlFriend build() {
        return new ComplexGirlFriend(this);
    }

    public static void main(String[] args) {
        ComplexGirlFriend complexGirlFriend = new ComplexGirlFriendBuilder()
                .setPerson(new Person(18, "小猫"))
                .setProfession(new Profession("医生", "医护类"))
                .build();
        System.out.println(complexGirlFriend);
    }
}

package ioc.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 包含集合类型属性
 *
 * @author planeswalker23
 */
public class UserCollection {

    private String[] names;
    private List<Integer> ages;
    private List<User> users;
    private Map<String, Integer> map;

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setAges(List<Integer> ages) {
        this.ages = ages;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "UserCollection{" +
                "names=" + Arrays.toString(names) +
                ", ages=" + ages +
                ", users=" + users +
                ", map=" + map +
                '}';
    }
}

package io.walkers.planes.pandora.jdk.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 范逸东(东稚)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String gender;
    private Integer age;

    public User(Long id) {
        this.id = id;
    }
}

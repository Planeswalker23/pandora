package io.walkers.planes.pandora.redis.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * user 实体类
 * @author Planeswalker23
 * @date Created in 2020/3/5
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private int id;

    private String name;
}

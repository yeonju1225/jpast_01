package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//테이블 명이 USER라고 되있으면 이렇게.
//@Table(name = "USER")
public class Member {

    @Id
    private Long id;

    //컬럼명이 다를때
    //@Column(name = "username")
    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

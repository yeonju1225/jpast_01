package org.example;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")
//이렇게 유니크값을 설정 가능 아래에 Colums에서 주는 것보다 낫다.
//@Table(uniqueConstraints)
//테이블 명이 USER라고 되있으면 이렇게.
//@Table(name = "USER")
public class Member {

    /*@Id
    private Long id;

    //컬럼명이 다를때
    @Column(unique = true, length = 10)
    private String name;
    private int age;
    private String adrress;
    private String adrress2;

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
    }*/

    //필드와 컬럼맵핑
    /*@Id
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username; //객체는 username으로 사용하고 DB컬럼명은 name인 경우 설정 가능

    private BigDecimal age;

    // ORDINAL이 들어가면 만약 새로운 값이 추가 되었을 때 순서 값이 들어가면서 순서가 바뀐다.
    /*
        예를 들어 ) USER, ADMIN 이라서 USER = 0 , ADMIN = 1 의 순서였는데
        GUEST가 추가되면  GUEST, USER, ADMIN 이 되면서 순서가 0, 1, 2 가 되버린다
        그러면 초기에 저장했던 USER는 0 GUEST가 추가된 후 저장한 GUEST가 0 이 되서 값이 꼬이기 때문에 STRING으로 사용.
    /*
    @Enumerated(EnumType.STRING)
    private RoleType roleType; //DB에서 이넘타입을 쓰고 싶다.

    //옛날에 많이 사용했음. 현재는 별로 필요 없음 ( localDate, localDateTime 최신버전에 사용됨. 자바 8 이상)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; //날짜 타입

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate test1; //년월
    private LocalDateTime test2; //년월일

    @Lob
    private String description; //DB에 바차를 넘어서는 큰 값을 넣고 싶은 경우

    @Transient
    private int temp;

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getTest1() {
        return test1;
    }

    public void setTest1(LocalDate test1) {
        this.test1 = test1;
    }

    public LocalDateTime getTest2() {
        return test2;
    }

    public void setTest2(LocalDateTime test2) {
        this.test2 = test2;
    }*/

    //기본키 맵핑
    // IDENTITY
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Member() {}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

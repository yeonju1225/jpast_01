package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Team {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String teamname;

    // 읽기만 가능
    @OneToMany(mappedBy = "team") // 일대다 맵핑에서 뭐랑 연결되어있는지 적기.
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamname='" + teamname + '\'' +
                ", members=" + members +
                '}';
    }
}

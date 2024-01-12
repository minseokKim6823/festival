package com.admin.festival.entity;

import com.admin.festival.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id // pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    //    @Column(unique = true)
    private String userid;

    @Column
    private String userpw;


    // MemberDTO 객체에서 MemberEntity 객체로 변환하는 정적 메서드입니다.
    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
//        System.out.println(memberDTO.getUserid());
//        System.out.println(memberDTO.getUserpw());

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setUserid(memberDTO.getUserid());
        memberEntity.setUserpw(memberDTO.getUserpw());

        return memberEntity;
    }
}

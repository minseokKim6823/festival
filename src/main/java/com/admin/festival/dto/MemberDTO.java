package com.admin.festival.dto;

import com.admin.festival.entity.MemberEntity;
import lombok.*;

@Getter // lombok: Getter 자동으로
@Setter // lombok: Setter 자동으로
@NoArgsConstructor // lombok: 기본생성자를 자동으로 만들어준다.
@AllArgsConstructor
@ToString // lombok: ToString 메서드를 자동으로 만들어준다.
public class MemberDTO {

    private Long id;
    private String userid;
    private String userpw;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){

        MemberDTO memberDTO = new MemberDTO();

//        System.out.println(memberEntity.getId());
//        System.out.println(memberEntity.getUserid());
//        System.out.println(memberEntity.getUserpw());

        memberDTO.setId(memberEntity.getId());
        memberDTO.setUserid(memberEntity.getUserid());
        memberDTO.setUserpw(memberEntity.getUserpw());
        return memberDTO;
    }
}

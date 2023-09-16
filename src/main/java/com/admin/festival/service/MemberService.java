package com.admin.festival.service;

import com.admin.festival.dto.MemberDTO;
import com.admin.festival.entity.MemberEntity;
import com.admin.festival.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberrepository;

    public MemberDTO login(MemberDTO memberDTO){
        /*
        1. 회원이 입력한 이메일로 DB에서 조회를 함
        2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        */
        Optional<MemberEntity> byUserId = memberrepository.findByUserid(memberDTO.getUserid());
//        System.out.println("byUserId"+byUserId);
        if (byUserId.isPresent()) { // 존재한다면 ==> DB에 회원정보가 있다면, pw도 같은지 확인해야함
            MemberEntity memberEntity = byUserId.get();

            // 엔티티에 담겨있는 pw가 DTO에 담겨있는 pw와 같은지 보자.
            if (memberEntity.getUserpw().equals(memberDTO.getUserpw()))
            {
                // 비밀번호 일치 시
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            }else{
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else{
            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }

    public boolean isSessionUserValid(String sessionId) {
        Optional<MemberEntity> byUserId = memberrepository.findByUserid(sessionId);

        if (byUserId.isPresent()) return true;
        else return false;
    }
}

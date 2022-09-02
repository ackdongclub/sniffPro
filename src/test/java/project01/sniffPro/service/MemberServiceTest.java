package project01.sniffPro.service;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project01.sniffPro.domain.Member;
import project01.sniffPro.repository.MemberRepository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("kim");
        //when
        Long saveId = memberService.join(member);

        //then
        //em.flush(); //내용읇 볼 수 있다
        assertEquals(member, memberRepository.findOne(saveId));
     }

     @Test
     public void 회원가입_중복() throws Exception{
         //given
         Member member1 = new Member();
         member1.setName("kim");

         Member member2 = new Member();
         member2.setName("kim");

         //when
         memberService.join(member1);

         //then
         IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
         AssertionsForClassTypes.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
      }
}
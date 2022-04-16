package hello.servlet.domain.member;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {//junit 부터는 public 없어도 됨
    MemberRepository memberRepository = MemberRepository.getInstance(); //spring 쓰면 싱글톤(new ~ ) 보장해줌
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void save(){
        //given (실행했을때 결과가 이거여야함)
        Member member = new Member("hello",20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());

        //Assertions.assertThat(findMember).isEqualTo(savedMember);
        assertThat(findMember).isEqualTo(savedMember);
    }
    @Test
    void findAll(){
        //given
       Member member1 =  new Member("member1", 20);
        Member member2 = new Member("member2",30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }

}

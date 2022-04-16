package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private Long id;
    private String username;
    private int age;
    //alert + ins
    public Member() { //기본생성자
    }

    public Member( String username, int age) { //생성자
        this.username = username;
        this.age = age;

    }
}

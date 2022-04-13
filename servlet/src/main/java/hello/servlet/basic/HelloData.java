package hello.servlet.basic;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName(value = "Hello")
public class HelloData {
    private String username;
    private int age;
}
package com.jolbook.springboot;
import com.jolbook.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //junit에 내장된 실행자 외에 다른 실행자 실행
                             //여기서는 SpringRunner라는 스프링 실행자를 사용해서 스프링 푸트 테스트와 JUNIT사이에 연결자 역할

@WebMvcTest(controllers = HelloController.class) //스프링 MVC에 집중할 수 있는 어노테이션
                                                 //선언하면 @Controller , @ControllerAdvice 사용이 가능하다.
                                                 //@Service . Component, Repository는 사용불가 , 여기서는 Controller만 사용


public class HelloControllerTest {
    @Autowired  //스프링이 관리하는 bean을 주입받는다.
    private MockMvc mvc; //웹 API를 테스트 할 때 사용
                          //스프링 MVC테스트의 시작점 , 이 클래스를 통해 get , post 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))   //Mockmvc를 통해 /hello 주소로 get요청을 한다.
                .andExpect(status().isOk())     //perform의 결과를 검증 , http header의 status를 검증 , ok = 200
                .andExpect(content().string(hello));  //응답 본문의 내용을 검증 , 기대값 hello
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name" , name)
                        .param("amount" , String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name" , is(name)))
                .andExpect(jsonPath("$.amount" , is(amount)));
    }
}

package com.jolbook.springboot.web;
import com.jolbook.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON을 반환하는 컨트롤러로 만들어준다.

public class HelloController {
    @GetMapping("/hello") //get요청을 받을 수 있는 API
    public String hello(){
        return  "hello";
    }

    @GetMapping("/hello/dto")
    //외부에서 API로 넘긴 파라미터를 가져오는 어노테이션인 리퀘스트 파람
    //넘어온 파라미터를 name, amount에 저장한다.
    public HelloResponseDto helloDto(@RequestParam("name") String name , @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}


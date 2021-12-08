package com.jolbook.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//메인 클래스

@SpringBootApplication // 스프링 부트의 자동설정, 스프링 bean읽기 , 생성 이 위치 부터 설정을 읽어가기 때문에 이 클래스는 프로젝트의 최상단에 위치해야 한다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);//내장 WAS 실행 , 톰캣설치 필요없이 스프링 부트로 만들어진 ajr파일을 실행하면된

        //이렇게 내장 WAS를 이용하는 이유 : 언제 어디서나 같은 환경에서 스프링부트를 베포할 수 있다.

    }
}

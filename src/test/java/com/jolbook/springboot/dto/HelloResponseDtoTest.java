package com.jolbook.springboot.dto;
import com.jolbook.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {


    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "Test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //assertj라는 라이브러리의 검증 메소드, 검증하고 시은 대상을 인자로 받는다.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

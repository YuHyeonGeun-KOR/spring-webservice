package com.jolbook.springboot.domain.posts;
import  lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import  javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //클래스 내 모든 필드에 getter메소드 자동 생성
@NoArgsConstructor // 기본생성자 자동추가
@Entity//클래스와 링크될 클래스임을 나타된다. 매칭방법은 카멜케이스 이름을 언더스코어네이밍으로 바꾸어 테이블의 이름과 매핑한다.
//실제 DB의 테이블과 매칭될 클래스, 엔티티클래스라고도 부른다. 실제로 쿼리를 날리기 보다는 클래스의 수정을 통해 작업한다.
//엔티티 클래스에서는 절대 setter메소드를 만들지 않는다.

//디비에 삽입하는 방법 : 생성자를 통해 값을 채워 삽입 , 변경이 필요한 경우 이벤트에 맞는 public메소드를 호출하여 변경
public class Posts {
    @Id //해당 테이블의 프라이머리 키를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프라이머리 키의 생성규칙 , 오토인크리먼트 적용
    private Long id;

    @Column(length = 500 , nullable = false) // 테이블의 칼럼을 나타내며 선언하지 않아도 칼럼이다. 추가로 변경할 값이 있으면 선언한다. 길이 256을 500으로 변경
    private String title;

    @Column(columnDefinition = "TEXT" , nullable = false) // 타입을 TEXT로 변경
    private String content;

    private String author;

    @Builder
    public Posts(String title , String content , String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}

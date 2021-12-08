package com.jolbook.springboot.domain.posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // jnit에서 단위테스트가 끝날 떄마다 수행되는 메소드를 지정 , 보통 배포전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용한다.

    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title  = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("jatyu62@gmail.com").build());
        //테이블 posts에 insert, update쿼리를 실행한다.
        //id값이 있으면 insert  , 없으면 update

        //when
        //테이블 posts에 있는 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat((posts.getContent())).isEqualTo(content);

    }
}

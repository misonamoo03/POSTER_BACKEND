package com.misonamoo.poster.service;

import com.misonamoo.poster.domain.Category;
import com.misonamoo.poster.domain.Poster;
import com.misonamoo.poster.repository.ApiRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApiServiceTests {

    @Autowired
    ApiService apiService;
    @Autowired ApiRepository apiRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(false)
    public void 카테고리저장() throws Exception {
        Category category = new Category();
        category.setCtgryNm("주점");
        category.setCtgryRegistDt(new Date());
        category.setCtgryUpdtDt(new Date());
        // 로그인 된 유저로 처리
        category.setCtgryRegister(4L);

        Long savedNo = apiService.joinCategory(category);

        assertEquals(category, apiRepository.findCategoryOne(savedNo));
    }

   /* @Test
    public void 중복_회원_예외() throws Exception {

        Category category1 = new Category();
        category1.setCtgryNm("운동");

        Category category2 = new Category();
        category2.setCtgryNm("운동");

        apiService.join(category1);
        try {
            apiService.join(category2);
        } catch (IllegalStateException e) {
            return;
        }

        fail("예외가 발생한다.");
    }*/

    /* PosterType
     1 : 미용
     2 : 음식점
     3 : 헬스
     */
    @Test
    @Rollback(false)
    public void 포스터저장() throws Exception {
        Poster poster = new Poster();
        poster.setPosterType(4);
        poster.setPosterTitle("주점 포스터 제목 2");
        poster.setPosterContent("주점 포스터 제목 2");
        poster.setPosterRegistDt(new Date());

        // 로그인 된 유저로 처리
        poster.setPosterRegister(2L);
        Long savedNo = apiService.joinPoster(poster);

        assertEquals(poster, apiRepository.findPosterOne(savedNo));
    }
}

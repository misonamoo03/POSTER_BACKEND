package com.misonamoo.poster.service;

import com.misonamoo.poster.domain.Category;
import com.misonamoo.poster.domain.Poster;
import com.misonamoo.poster.repository.ApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApiService {

    private final ApiRepository apiRepository;

    private void validateDuplicateCategory(Category category) {
        List<Category> findCategories = apiRepository.findByName(category.getCtgryEngNm());
        if(!findCategories.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 카테고리 전체 조회
    public List<Category> findCategories() {
        return apiRepository.findCategoryAll();
    }

    // 카테고리 단건 조회
    public Category findCategoryOne(Long ctgryNo) {
        return apiRepository.findCategoryOne(ctgryNo);
    }

    //카테고리 저장
    @Transactional
    public Long joinCategory(Category category) {

        validateDuplicateCategory(category);
        apiRepository.saveCategory(category);
        return category.getCtgryNo();
    }

    // 포스터 전체 조회
    public List<Poster> findPosters() {
        return apiRepository.findPosterAll();
    }

    // 포스터 단건 조회
    public Poster findPosterOne(Long id) {
        return apiRepository.findPosterOne(id);
    }

    // 포스터 저장
    public Long joinPoster(Poster poster) {

        apiRepository.savePoster(poster);
        return poster.getPosterNo();
    }


    public List<Poster> findPosterHealth(int type) {
        return apiRepository.findPosterOne(type);
    }

    public List<Poster> findPosterFood(int type) {
        return apiRepository.findPosterOne(type);
    }

    public List<Poster> findPosterBeauty(int type) {
        return apiRepository.findPosterOne(type);
    }

    public List<Poster> findPosterBar(int type) {
        return apiRepository.findPosterOne(type);
    }
}

package com.misonamoo.poster.controller;

import com.misonamoo.poster.domain.Category;
import com.misonamoo.poster.domain.Poster;
import com.misonamoo.poster.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Type 1 미용
 * Type 2 음식점
 * Type 3 헬스
 * Type 4 주점
 */
@RestController
public class ApiController {

    @Autowired
    ApiService apiService;

    // 카테고리 전체 조회
    @GetMapping("/api/category")
    @ResponseBody
    public Map<String, Object> findCategoryAll() {
        Map<String, Object> categoryMap = new HashMap<>();
        List<Category> list = new ArrayList<>();
        list = apiService.findCategories();
        categoryMap.put("category", list);
        return categoryMap;
    }

    // 포스터 전체 조회
    @GetMapping("/api/poster")
    public Map<String, Object> findPosterAll() throws Exception {
        Map<String, Object> PosterMap = new HashMap<>();
        List<Poster> list = new ArrayList<>();
        list = apiService.findPosters();
                PosterMap.put("health", list);
                return PosterMap;
    }

/*    // 포스터 단건 조회
    @GetMapping("/api/poster/health")
    public Map<String, Object> findPosterOne(Poster poster) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Poster> list = new ArrayList<>();
        poster = apiService.findPosterOne(3L);
        list.add(poster);
        resultMap.put("health",list);
        return resultMap;
    }*/

    // 포스터 Health 조회
    @GetMapping("/api/poster/health")
    public Map<String, Object> findPosterHealth(Poster poster) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Poster> list = new ArrayList<>();
        list = apiService.findPosterHealth(3);
        resultMap.put("health",list);
        return resultMap;
    }

    // 포스터 Food 조회
    @GetMapping("/api/poster/food")
    public Map<String, Object> findPosterFood(Poster poster) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Poster> list = new ArrayList<>();
        list = apiService.findPosterFood(2);
        resultMap.put("food",list);
        return resultMap;
    }

    // 포스터 Beauty 조회
    @GetMapping("/api/poster/beauty")
    public Map<String, Object> findPosterBeauty(Poster poster) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Poster> list = new ArrayList<>();
        list = apiService.findPosterBeauty(1);
        resultMap.put("beauty",list);
        return resultMap;
    }

    // 포스터 bar 조회
    @GetMapping("/api/poster/bar")
    public Map<String, Object> findPosterBar(Poster poster) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Poster> list = new ArrayList<>();
        list = apiService.findPosterBar(4);
        resultMap.put("bar",list);
        return resultMap;
    }
}

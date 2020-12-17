package com.misonamoo.poster.repository;

import com.misonamoo.poster.domain.Category;
import com.misonamoo.poster.domain.Poster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApiRepository {

    private final EntityManager em;

    public void saveCategory(Category category) {
        em.persist(category);
    }

    public Category findCategoryOne(Long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findCategoryAll() {
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    public List<Category> findByName(String engName) {
        return em.createQuery("select c from Category c where c.ctgryEngNm = :ctgryEngNm", Category.class)
                .setParameter("ctgryEngNm", engName)
                .getResultList();
    }

    public List<Poster> findPosterAll() {
        return em.createQuery("select p from Poster p", Poster.class)
                .getResultList();
    }

    public Poster findPosterOne(Long id) {
        return em.find(Poster.class, id);
    }

    public void savePoster(Poster poster) {
            em.persist(poster);
    }

    public List<Poster> findPosterOne(int type) {
        return em.createQuery("select p from Poster p where p.posterType = :posterType", Poster.class)
                .setParameter("posterType", type)
                .getResultList();
    }
}

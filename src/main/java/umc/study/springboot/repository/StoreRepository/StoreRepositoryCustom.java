package umc.study.springboot.repository.StoreRepository;

import umc.study.springboot.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}

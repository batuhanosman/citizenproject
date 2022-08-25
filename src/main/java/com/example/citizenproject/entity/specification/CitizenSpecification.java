package com.example.citizenproject.entity.specification;

import com.example.citizenproject.controller.request.CitizenFindByParametersRequest;
import com.example.citizenproject.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class CitizenSpecification implements Specification<Citizen> {

    private CitizenFindByParametersRequest request;

    @Override
    public Predicate toPredicate(Root<Citizen> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        //TODO: add children count

        if(Objects.nonNull(request.getIsCitizen())){
            predicates.add(criteriaBuilder.equal(root.get("isCitizen"), request.getIsCitizen()));
        }

        if(StringUtils.isNoneBlank(request.getName())){
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + request.getName() + "%"));
        }

        if(Objects.nonNull(request.getHasDrivingLicense())){
            predicates.add(criteriaBuilder.equal(root.get("hasDrivingLicense"), request.getHasDrivingLicense()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}

package com.fstg.demo.utils;

import com.fstg.demo.DTO.PaginationSearchAndFilterRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class UtilService {

    public static Pageable getPageable(PaginationSearchAndFilterRequest searchAndFilterRequest) {
        String direction = searchAndFilterRequest.getDirection();
        int pageNo = searchAndFilterRequest.getPageNo();
        int pageSize = searchAndFilterRequest.getPageSize();
        String sortBy = searchAndFilterRequest.getSortBy();

        Sort.Direction sortDirection = Sort.Direction.ASC;


        if(direction == null || direction.isBlank())
            return null;
        if(sortBy == null || sortBy.isBlank())
            sortBy = "id";

        sortDirection = Sort.Direction.fromString(direction);

        return PageRequest.of(pageNo, pageSize, sortDirection, sortBy);

    }
}

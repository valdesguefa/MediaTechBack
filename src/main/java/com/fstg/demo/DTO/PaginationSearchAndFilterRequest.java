package com.fstg.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginationSearchAndFilterRequest {

    private int pageNo;
    private int pageSize;
    private String searchText;
    private String sortBy;
    private String direction;
}

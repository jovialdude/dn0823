package com.example.pos.repository.interfaces;

import com.example.pos.beans.tool.Tool;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ToolRepository extends PagingAndSortingRepository<Tool, String> {

}

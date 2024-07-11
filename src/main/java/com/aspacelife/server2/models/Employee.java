package com.aspacelife.server2.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Employee {
    private String id;
    private String name;
    private String department;
}

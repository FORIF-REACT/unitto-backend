package com.group.unittoapp.user.dto.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private Long admissionYear;
    private String major;
    private String email;
    private String gender;
    private String preferRegion;
}

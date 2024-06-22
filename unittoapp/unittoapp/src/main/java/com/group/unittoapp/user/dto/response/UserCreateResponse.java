package com.group.unittoapp.user.dto.response;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserCreateResponse {

    private String username;
    private Long admissionYear;
    private String major;
    private String email;
    private String gender;
    private String preferRegion;

}

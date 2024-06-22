package com.group.unittoapp.lecture.dto.request;

import lombok.Data;

@Data
public class LectureApplyRequest {
    private Long lectureId;
    private String applyContent;
    private String email;
}

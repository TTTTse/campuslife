package com.graduationproject.campuslifecommon.response;

import com.graduationproject.campuslifecommon.constant.ResultCode;
import lombok.Builder;
import lombok.Data;

/**
 * @program: campuslife
 * @description: 结果类
 * @author: ttttse
 * @create: 2021-03-07 19:26
 **/
@Data
@Builder
public class ResponseResult {
    /**
     * 响应编码
     */
    @Builder.Default
    private Long code = ResultCode.NORMAL.getCode();

    /**
     * 响应编码
     */
    @Builder.Default
    private String message = ResultCode.NORMAL.getMessage();

    /**
     * 返回结果
     */
    private Object data;
}

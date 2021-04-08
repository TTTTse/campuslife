package com.graduationproject.campuslifecommon.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: campuslife
 * @description: 腾讯cos配置类
 * @author: ttttse
 * @create: 2021-04-09 00:03
 **/

@Data
@Component
@ConfigurationProperties(prefix = "tencent.cos")
public class TencentCosProperties4Pic {

    private String appId;
    private String secretId;
    private String secretKey;
    private String bucketName;
    private String regionId;
    private String baseUrl;

}

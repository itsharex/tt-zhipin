package com.whoiszxl.zhipin.im.cqrs.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 好友批量导入结果返回实体
 * @author whoiszxl
 */
@Data
@AllArgsConstructor
@Schema(description = "好友批量导入结果返回实体")
public class FriendImportMultiResultResponse {

    @Schema(description = "失败的好友账号ID列表")
    private List<String> failAccounts;
    
}

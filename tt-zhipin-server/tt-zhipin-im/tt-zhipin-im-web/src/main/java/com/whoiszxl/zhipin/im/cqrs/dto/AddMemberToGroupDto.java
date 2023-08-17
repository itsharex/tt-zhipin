package com.whoiszxl.zhipin.im.cqrs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * 添加用户到群组的DTO
 * @author whoiszxl
 */
@Data
@Builder
@Schema(description = "添加用户到群组的DTO")
public class AddMemberToGroupDto {

    @Schema(description = "账号ID")
    private String memberId;

    @Schema(description = "成员类型: 1-普通成员 2-群主 3-管理员")
    private Integer memberType;

    @Schema(description = "群组主键ID")
    private Long groupId;

    @Schema(description = "加群方式: 1-扫码 2-群主邀请")
    private Integer joinType;


}

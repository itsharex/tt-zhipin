package com.whoiszxl.zhipin.im.controller;


import com.whoiszxl.zhipin.im.cqrs.command.FriendAddCommand;
import com.whoiszxl.zhipin.im.cqrs.command.FriendDeleteCommand;
import com.whoiszxl.zhipin.im.cqrs.command.FriendRequestApproveCommand;
import com.whoiszxl.zhipin.im.cqrs.query.FriendFetchOneQuery;
import com.whoiszxl.zhipin.im.cqrs.query.FriendFetchQuery;
import com.whoiszxl.zhipin.im.cqrs.query.FriendRequestListQuery;
import com.whoiszxl.zhipin.im.cqrs.response.FriendImportMultiResultResponse;
import com.whoiszxl.zhipin.im.entity.Friend;
import com.whoiszxl.zhipin.im.entity.FriendRequest;
import com.whoiszxl.zhipin.im.service.IFriendService;
import com.whoiszxl.zhipin.tools.common.entity.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 好友表 前端控制器
 * </p>
 *
 * @author whoiszxl
 * @since 2023-08-17
 */
@Tag(name = "好友 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/friend")
public class FriendController {

    private final IFriendService friendService;


    /**
     * 添加好友
     * 参考:<a href="https://cloud.tencent.com/document/product/269/8301">导入好友</a>
     * @return 添加结果
     */
    @PostMapping("/add")
    @Operation(summary = "添加好友", description = "添加好友，不支持批量添加")
    public ResponseResult<FriendImportMultiResultResponse> friendAdd(@Validated @RequestBody FriendAddCommand command) {
        Boolean flag = friendService.friendAdd(command);
        return ResponseResult.buildByFlag(flag);
    }

    /**
     * 删除好友
     * 参考:<a href="https://cloud.tencent.com/document/product/269/1644">删除好友</a>
     * @return 是否删除成功
     */
    @PostMapping("/delete")
    @Operation(summary = "删除好友", description = "删除好友，支持单向删除好友和双向删除好友。")
    public ResponseResult<Boolean> friendDelete(@Validated @RequestBody FriendDeleteCommand command) {
        Boolean flag = friendService.friendDelete(command);
        return ResponseResult.buildByFlag(flag);
    }

    /**
     * 拉取好友
     * 参考:<a href="https://cloud.tencent.com/document/product/269/1647">拉取好友</a>
     * @return 好友记录
     */
    @PostMapping("/fetch")
    @Operation(summary = "拉取好友", description = "拉取全量好友数据")
    public ResponseResult<List<Friend>> friendFetch(@Validated @RequestBody FriendFetchQuery query) {
        List<Friend> friendList = friendService.friendFetch(query);
        return ResponseResult.buildSuccess(friendList);
    }

    /**
     * 拉取指定好友
     * 参考:<a href="https://cloud.tencent.com/document/product/269/8609">拉取指定好友</a>
     * @return 好友记录
     */
    @PostMapping("/fetch/one")
    @Operation(summary = "拉取指定好友", description = "拉取指定好友的好友数据和资料数据。")
    public ResponseResult<Friend> friendFetchOne(@Validated @RequestBody FriendFetchOneQuery query) {
        Friend friend = friendService.friendFetchOne(query);
        return ResponseResult.buildSuccess(friend);
    }


    @PostMapping("/request/approve")
    @Operation(summary = "好友请求审批", description = "好友请求审批")
    public ResponseResult<FriendImportMultiResultResponse> friendRequestApprove(@Validated @RequestBody FriendRequestApproveCommand command) {
        Boolean flag = friendService.friendRequestApprove(command);
        return ResponseResult.buildByFlag(flag);
    }

    @PostMapping("/request/list")
    @Operation(summary = "好友请求列表", description = "好友请求列表")
    public ResponseResult<List<FriendRequest>> friendRequestList(@Validated @RequestBody FriendRequestListQuery query) {
        List<FriendRequest> friendRequestList = friendService.friendRequestList(query);
        return ResponseResult.buildSuccess(friendRequestList);
    }
}


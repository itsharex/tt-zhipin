package com.whoiszxl.zhipin.im.session;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.json.JSONUtil;
import com.whoiszxl.zhipin.im.constants.ConnectStatusEnum;
import com.whoiszxl.zhipin.im.constants.ImRedisKeysEnum;
import com.whoiszxl.zhipin.im.entity.MemberSession;
import com.whoiszxl.zhipin.tools.common.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户的session持久工具
 */
@Component
@RequiredArgsConstructor
public class MemberSessionHolder {

    private final RedisUtils redisUtils;

    /**
     * 获取用户所有的session
     * @param memberId 用户ID
     * @return 用户所有的session
     */
    public List<MemberSession> getAllMemberSession(Long memberId) {
        List<MemberSession> results = new ArrayList<>();
        String key = String.format(ImRedisKeysEnum.MEMBER_SESSION_KEY.getPrefix(), memberId);
        Map<Object, Object> allValues = redisUtils.hGetAll(key);
        for (Object value : allValues.values()) {
            MemberSession memberSession = JSONUtil.toBean((String) value, MemberSession.class);
            if(ObjUtil.equal(memberSession.getConnectStatus(), ConnectStatusEnum.ONLINE.getCode())) {
                results.add(memberSession);
            }
        }
        return results;
    }

    public MemberSession getMemberSession(Long memberId, Byte clientType, String imei) {
        String key = String.format(ImRedisKeysEnum.MEMBER_SESSION_KEY.getPrefix(), memberId);
        Object value = redisUtils.hGet(key, String.format("%s:%s", clientType, imei));
        return JSONUtil.toBean((String) value, MemberSession.class);
    }
}

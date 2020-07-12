package com.damon.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @auther Caesar.Wang
 * @date 2019/8/13 13:22
 **/

/**
 * 用户消息表推送表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserNoticePushEntity {
//    @ApiModelProperty(example = "用户id")
    private String userId;
//    @ApiModelProperty(example = "系统消息")
    private List<UserNoticePushSysMessage> userNoticePushSysMessageList;
}

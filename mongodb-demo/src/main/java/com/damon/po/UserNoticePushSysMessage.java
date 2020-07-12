package com.damon.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @auther Caesar.Wang
 * @date 2019/8/13 13:46
 **/

/**
 * 系统消息
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserNoticePushSysMessage {
//    @ApiModelProperty(example = "id")
    private String objId;
//    @ApiModelProperty(example = "时间戳")
    private String timeTamp;
//    @ApiModelProperty(example = "是否已读 1-已读，0未读")
    private String isRead;
//    @ApiModelProperty(example = "标题")
    private String title;
//    @ApiModelProperty(example = "内容")
    private String content;
//    @ApiModelProperty(example = "  type 类型 1审核通知 2收益通知  3.红包通知 4.奖品通知 5.签到通知 6.积分过期提醒 7.优惠券过期提醒,8.订单过期提醒,9活动提醒,10达人过期提醒,11达人礼包通知,12合伙人过期提醒,13合伙人礼包通知,14合伙人审核，15订单通知")
    private String type;
//    @ApiModelProperty(example = "跳转,审核通过-1，审核不通过-2,红包到账-1，红包过期-4")
    private String jumpFlag;
}

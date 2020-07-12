package com.damon;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSONObject;
import com.damon.po.Comment;
import com.damon.po.UserNoticePushEntity;
import com.damon.po.UserNoticePushSysMessage;
import com.damon.service.CommentService;
import com.damon.utils.UUIDGenerator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.sun.javafx.collections.SortableList;
import javafx.collections.transformation.SortedList;
import org.bson.Document;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ArticleApplication.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询指定属性
     */
    @Test
    public void testQueryFields() {
        Query query = new Query(Criteria.where("userId").is("ff8080816d77d649016d77fc77d2001c"));
        query.fields().include("userNoticePushSysMessageList").include("userId");
        UserNoticePushEntity vo = mongoTemplate.findOne(query, UserNoticePushEntity.class);
        System.err.println(vo);
    }

    /**
     * 测试自定义语句
     */
    @Test
    public void testCustomer() {
        Aggregation aggregation = Aggregation.newAggregation(UserNoticePushEntity.class,
                Aggregation.match(Criteria.where("userId").is("ff8080816d3cef90016d3cef92a50001")),
                Aggregation.unwind("userNoticePushSysMessageList"),
                Aggregation.match(Criteria.where("userNoticePushSysMessageList.isRead").is("0")),
                Aggregation.project("userNoticePushSysMessageList.isRead", "userNoticePushSysMessageList.type"),
                Aggregation.group("type").count().as("count")
        );
        AggregationResults<Document> count = mongoTemplate.aggregate(aggregation, "userNoticePushEntity", Document.class);
        System.err.println(count.getRawResults());
        count.getMappedResults().forEach(d -> System.err.println(d.toString()));

//        List<Document> group = Arrays.asList(
//                new Document("$match",
//                        new Document("userId","ff8080816d3cef90016d3cef92a50001")
//                ),
//                new Document("$unwind","$userNoticePushSysMessageList"),
//                new Document("$match",
//                        new Document("userNoticePushSysMessageList.isRead",
//                                new Document("$eq","1")
//                        )
//                ),
//                new Document("$group",
//                        new Document("_id","$userId")
//                        .append("count",new Document("$sum","1"))
//                )
//        );
    }

    @Test
    public void testCount() {
        Query query = new Query(Criteria.where("userId").is("ff8080816d77d649016d77fc77d2001c")).addCriteria(Criteria.where("userNoticePushSysMessageList.isRead").is("1"));
        long count = mongoTemplate.count(query, UserNoticePushSysMessage.class);
        System.err.println(count);
    }

    /**
     * 测试UUIDGenerator是否会重复
     */
    @Test
    public void testUUIDGenerator() {
        Set<String> set = new HashSet<>(10000000);
        for (int i = 0; i < 10000000; i++) {
            set.add(UUIDGenerator.generate());
        }
        System.out.println(set.size());
    }

    /**
     * 测试Gson
     */
    @Test(timeout = 10 * 1000)
    public void testSaveGson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "chenchen");
        jsonObject.addProperty("age", 18);
        jsonObject.addProperty("birthday", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        JsonObject save = mongoTemplate.save(jsonObject);
        System.out.println(save);
    }

    /**
     * 测试JSON
     */
    @Test(timeout = 10 * 1000)
    public void testSaveFastJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "chenchen");
        jsonObject.put("age", 18);
        jsonObject.put("birthday", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        JSONObject save = mongoTemplate.save(jsonObject);
        System.out.println(save);
    }

    /**
     * 点赞数+1
     */
    @Test
    public void updateCommentLikeNum() {
        commentService.updateCommentLikeNum("5e5ce49a18585651968b53f4");
    }

    /**
     * 测试根据父id查询子评论的分页列表
     */
    @Test
    public void testFindCommentListPageByParentId() {
        Page<Comment> commentPage = commentService.findCommentListPageByParentId("0", 1, 2);
        System.out.println(commentPage.getTotalElements()); // 总数据量
        System.out.println(commentPage.getTotalPages());    // 总页数
        System.out.println(commentPage.getSize());  // 总页数
        System.out.println(commentPage.getNumberOfElements());  // 当前页数据总数
        System.out.println(commentPage.getContent());   // 获得内容
    }

    /**
     * 测试保存评论
     */
    @Test(timeout = 10 * 1000)
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setArticleId("1003")
                .setContent("今天天气真好")
                .setState("0")
                .setLikeNum(10)
                .setNickname("卑鄙的我")
                .setParentId("0")
                .setReplyNum(1)
                .setUserId("007")
                .setPublishTime(new Date())
                .setCreateDateTime(LocalDateTime.now());
        commentService.saveComment(comment);
    }

    /**
     * 测试查询全部
     */
    @Test
    public void testFindAll() {
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList.size());
        System.out.println(commentList);
    }

    /**
     * 测试根据id查询
     */
    @Test
    public void testFindById() {
        Comment comment = commentService.findById("5e5cde45df89a12340380042");
        System.out.println(comment);
    }
}

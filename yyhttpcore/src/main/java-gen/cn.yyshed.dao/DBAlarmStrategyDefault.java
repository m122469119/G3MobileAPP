package cn.yyshed.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table DBALARM_STRATEGY_DEFAULT.
 */
public class DBAlarmStrategyDefault {

    private String strategy_id;
    private String content;

    public DBAlarmStrategyDefault() {
    }

    public DBAlarmStrategyDefault(String strategy_id, String content) {
        this.strategy_id = strategy_id;
        this.content = content;
    }

    public String getStrategy_id() {
        return strategy_id;
    }

    public void setStrategy_id(String strategy_id) {
        this.strategy_id = strategy_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
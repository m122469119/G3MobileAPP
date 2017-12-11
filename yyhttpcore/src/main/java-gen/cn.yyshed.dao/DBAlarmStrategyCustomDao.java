package cn.yyshed.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import cn.yyshed.dao.DBAlarmStrategyCustom;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table DBALARM_STRATEGY_CUSTOM.
*/
public class DBAlarmStrategyCustomDao extends AbstractDao<DBAlarmStrategyCustom, Void> {

    public static final String TABLENAME = "DBALARM_STRATEGY_CUSTOM";

    /**
     * Properties of entity DBAlarmStrategyCustom.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Strategy_id = new Property(0, String.class, "strategy_id", false, "STRATEGY_ID");
        public final static Property Content = new Property(1, String.class, "content", false, "CONTENT");
    }


    public DBAlarmStrategyCustomDao(DaoConfig config) {
        super(config);
    }
    
    public DBAlarmStrategyCustomDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DBALARM_STRATEGY_CUSTOM' (" + //
                "'STRATEGY_ID' TEXT UNIQUE ," + // 0: strategy_id
                "'CONTENT' TEXT);"); // 1: content
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DBALARM_STRATEGY_CUSTOM'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DBAlarmStrategyCustom entity) {
        stmt.clearBindings();
 
        String strategy_id = entity.getStrategy_id();
        if (strategy_id != null) {
            stmt.bindString(1, strategy_id);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public DBAlarmStrategyCustom readEntity(Cursor cursor, int offset) {
        DBAlarmStrategyCustom entity = new DBAlarmStrategyCustom( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // strategy_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // content
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DBAlarmStrategyCustom entity, int offset) {
        entity.setStrategy_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(DBAlarmStrategyCustom entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(DBAlarmStrategyCustom entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

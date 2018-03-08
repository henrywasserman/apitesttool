package com.pqi.responsecompare.sql;

import com.pqi.responsecompare.configuration.CreateOutput;
import com.pqi.responsecompare.configuration.PropertiesSingleton;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

public enum SQLToMap {

    Instance;

    static Logger logger = Logger.getLogger(SQLToMap.class);

    private HashMap<String,ArrayList<String>> sqlMap = null;
    private ArrayList<HashMap> sqlMapArray = null;

    private SQLToMap() {
        Properties responseCompare = PropertiesSingleton.Instance.getProps();
        sqlMap = new HashMap<String,ArrayList<String>>();
        sqlMapArray = new ArrayList<HashMap>();
        //combineMaps(new HashMap<String,Object>((Map)responseCompare));
    }

    public void cleanSQLMap() {
        sqlMap = new HashMap<String,ArrayList<String>>();
    }

    public void cleanSQLMapArray() {sqlMapArray = new ArrayList<HashMap>(); }

    public void appendMap(ResultSet rs) throws Exception{
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();

        sqlMap.put("COLUMN_NAMES",new ArrayList<String>());
        for (int i = 1; i <= numberOfColumns; i++) {
            sqlMap.get("COLUMN_NAMES").add(rsmd.getColumnName(i));
        }

        int maxRows = 50;
        int rows = 0;
        while (rs.next() && rows <= maxRows) {
            rows++;
            for (int i = 1; i <= numberOfColumns; i++) {
                if (sqlMap.containsKey(rsmd.getColumnName(i))) {
                    if (rs.getObject(rsmd.getColumnName(i)) == null) {
                        sqlMap.get(rsmd.getColumnName(i)).add("null");
                    } else {
                        sqlMap.get(rsmd.getColumnName(i)).add(
                                rs.getObject(rsmd.getColumnName(i)).toString());
                    }
                } else {
                    sqlMap.put(rsmd.getColumnName(i),new ArrayList<String>());
                    if (rs.getObject(rsmd.getColumnName(i)) == null) {
                        sqlMap.get(rsmd.getColumnName(i)).add("null");
                    } else {
                        sqlMap.get(rsmd.getColumnName(i)).add(
                                rs.getObject(rsmd.getColumnName(i)).toString());
                    }
                }
            }
        }

        sqlMapArray.add(sqlMap);
        sqlMap = new HashMap<String,ArrayList<String>>();

    }

    public String getSQLHtml(int i) throws Exception {
        return CreateOutput.Instance.sqlMapToHTML(sqlMapArray.get(i));
    }

    public String getSqlJSON(int i) throws Exception {
        return CreateOutput.Instance.sqlMapToJSON(sqlMapArray.get(i));
    }

    public HashMap<String,ArrayList<String>> getSqlMap() {
        return sqlMap;
    }



    public void combineMaps(HashMap<String,Object> source) {

    }
}
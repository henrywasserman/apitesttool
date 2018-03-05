package com.pqi.responsecompare.sql;

import com.pqi.responsecompare.configuration.PropertiesSingleton;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

public enum SQLToMap {

    Instance;

    static Logger logger = Logger.getLogger(SQLToMap.class);

    private HashMap<String,ArrayList<String>> sqlMap = null;
    private ArrayList<String> list = new ArrayList<String>();

    private SQLToMap() {
        Properties responseCompare = PropertiesSingleton.Instance.getProps();
        sqlMap = new HashMap<String,ArrayList<String>>();
        //combineMaps(new HashMap<String,Object>((Map)responseCompare));
    }

    public void cleanSQLToMap() {
        sqlMap = new HashMap<String,ArrayList<String>>();
    }

    public void appendMap(ResultSet rs) throws Exception{
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
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
                }
            }
        }
    }

    public HashMap<String,ArrayList<String>> getSqlMap() {
        return sqlMap;
    }

    public void combineMaps(HashMap<String,Object> source) {

    }
}
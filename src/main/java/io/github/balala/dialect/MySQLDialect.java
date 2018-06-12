package io.github.balala.dialect;


import io.github.balala.core.SQLParams;
import io.github.balala.page.PageRow;

/**
 * MySQL dialect
 *
 * @author biezhi
 * @date 2018/3/17
 */
public class MySQLDialect implements Dialect {

    @Override
    public String paginate(SQLParams sqlParams) {
        PageRow pageRow  = sqlParams.getPageRow();
        int     limit    = pageRow.getPageSize();
        int     offset   = limit * (pageRow.getPageNum() - 1);
        String  limitSQL = " LIMIT " + offset + "," + limit;

        StringBuilder sql = new StringBuilder();
        sql.append(select(sqlParams)).append(limitSQL);
        return sql.toString();
    }

}

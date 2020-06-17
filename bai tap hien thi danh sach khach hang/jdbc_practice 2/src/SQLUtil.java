import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static String getHTMLTable(ResultSet results) throws SQLException {
        StringBuilder htmlTable=new StringBuilder();
        htmlTable.append("<table border='1'>");
        int columnCount=results.getMetaData().getColumnCount();

        for (int i=1;i<columnCount;i++){
            htmlTable.append("<th>");
            htmlTable.append(results.getMetaData().getColumnName(i));
            htmlTable.append("</th>");
        }
        while(results.next()){
            htmlTable.append("<tr>");
            for (int i=1;i<columnCount;i++){
                htmlTable.append("<td>");
                htmlTable.append(results.getString(i));
                htmlTable.append("</td>");
            }
            htmlTable.append("</tr>");
        }

        htmlTable.append("</table>");
        return htmlTable.toString();
    }
}

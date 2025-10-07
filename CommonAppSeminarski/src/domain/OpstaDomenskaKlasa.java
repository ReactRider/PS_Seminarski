package domain;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;

public interface OpstaDomenskaKlasa extends Serializable {
    public String getTableName();
    public String getColumnsForInsert();
    public String getValuesForInsert();
    public String getCondition();
    public String getJoinCondition();
    public String getConditionForDelete(OpstaDomenskaKlasa t);
    public String getValueForUpdate();
    public String getConditionForUpdate();
    public String getConditionForFind(String s, OpstaDomenskaKlasa t2);
    public OpstaDomenskaKlasa getObject(ResultSet rs) throws Exception;
    public List<OpstaDomenskaKlasa> getList(ResultSet rs) throws Exception;
}

import org.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.management.Query;
import javax.management.relation.Relation;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Json_task {
    public static void main(String[] args) {

        JSONParser jsonp = new JSONParser();
        try (FileReader reader = new FileReader("Task-1.json")){
            Object obj = jsonp.parse(reader);
            JSONArray dataList = (JSONArray) obj;




            HashMap<JSONArray, JSONArray> data1 = (HashMap<JSONArray, JSONArray>) dataList.get(0);
            HashMap<JSONArray, JSONArray> data2 = (HashMap<JSONArray, JSONArray>) dataList.get(1);
            HashMap<JSONArray, JSONArray> data3 = (HashMap<JSONArray, JSONArray>) dataList.get(2);
            HashMap<JSONArray, JSONArray> data4 = (HashMap<JSONArray, JSONArray>) dataList.get(3);



//            System.out.println(data1);
//            System.out.println(data2);
//            System.out.println(data3);
//            System.out.println(data4);
//            System.out.println(data4.get("Text"));


            HashMap<JSONArray, JSONArray> relationship_data1 = (HashMap<JSONArray, JSONArray>)  data1.get("Relationships").get(0);
            HashMap<JSONArray, JSONArray> relationship_data2 = (HashMap<JSONArray, JSONArray>)  data3.get("Relationships").get(0);

//            JSONObject result = jsonObject.getJSONObject("Query");
            org.json.JSONArray Query1 = (org.json.JSONArray)  data1.get("Query").get(0);
            System.out.println(Query1.get(0));

//            System.out.println(relationship_data1.get("Type"));

//            System.out.println(data1.get("Query").toString());






            for (int i=0 ; i< dataList.size();i++){


                HashMap<String, String> data = (HashMap<String, String>) dataList.get(i);
//                System.out.println(data.get("BlockType"));
//                System.out.println(data);


                if (data.get("BlockType").length() == 5){
                    System.out.println(data1.get("Query"));
                    if (Objects.equals(data2.get("Id"),(relationship_data1.get("Ids").get(0)))){
//                        System.out.println("name id matched");

//                        System.out.println("Query_Result");
                        System.out.println(data2.get("Text"));

                        System.out.println(data3.get("Query"));

                        if (Objects.equals(data4.get("Id"),(relationship_data2.get("Ids").get(0)))) {

//                            System.out.println("dob id matched");
                            System.out.println(data4.get("Text"));
                        }
                        else {
                            System.out.println("dob id not matched");
                        }

                    }
                    else {
                        System.out.println("name id not matched");
                    }
//                    System.out.println(data.get("Text"));
//                    System.out.println(data.get("alias"));
                    }

                else if (data.get("BlockType").length() == 12){

                }

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

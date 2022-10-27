package za.ac.cput.requests;
/*
 * Author Lelihle Gazi - (214258041)
 * markRequest.java
 * Capstone Project
 * 2022
 */
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.domain.mark;
import za.ac.cput.factory.markFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class markRequest {
    private static OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static String get(String getURL) throws IOException {
        Request request = new Request.Builder()
                .url(getURL)
                .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();

        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return getURL;
    }

        private static String post(final String postUrl, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(postUrl)
                    .post(body)
                    .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();

            } catch (IOException e) {
                System.out.println((e.getMessage()));
            }
            return postUrl;
        }
        private static String delete(final String deleteUrl) throws IOException {
            Request request = new Request.Builder()
                    .url(deleteUrl)
                    .delete()
                    .addHeader("Authorization", Credentials.basic("AdminA", "0000"))
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            } catch (IOException e) {
                System.out.println((e.getMessage()));
            }
            return deleteUrl;
        }

        public static void deleteMark(String markId)
        {
            try
            {
                final String deleteURL = "http://localhost:8080/Student_Management-ADP3-Group14/mark/deleteMark/" + markId;
                delete(deleteURL);
                String responseBody = get(deleteURL);
                JOptionPane.showMessageDialog(null, "successfully Deleted");
            } catch (IOException e) {
                System.out.println((e.getMessage()));
            }
        }

        public static List<mark> getAll()
        {
            List<mark>markList = new ArrayList<>();
            try
            {
                final String getUrl = "http://localhost:8080/Student_Management-ADP3-Group14/mark/readAllMarks";
                String responseBody = get(getUrl);
                JSONArray marks = new JSONArray(responseBody);

                for(int i = 0; i < marks.length(); i++)
                {
                    JSONObject mark = marks.getJSONObject(i);
                    Gson get = new Gson();
                    mark c = get.fromJson(mark.toString(), mark.class);
                    markList.add(c);
                    System.out.println(c);
                }

            } catch (IOException e) {
                System.out.println((e.getMessage()));
            }
            return markList;
        }

        public static void save_mark(String markID, String markDescription, String markStudentId, String markSubjectId, Float markResult)
        {
            try
            {
                final String postUrl = "http://localhost:8080/Student_Management-ADP3-Group14/mark/save_mark";
                mark mark = markFactory.createMark("ID1", "Pass", "student17","ADP", 25.5F);
                Gson post = new Gson();
                String jsonString = post.toJson(mark);
                String c = post(postUrl, jsonString);
                if (c != null)
                    JOptionPane.showMessageDialog(null, "successfully saved");
                else
                    JOptionPane.showMessageDialog(null, "Error - Could not Save");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

}

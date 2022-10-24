package za.ac.cput.views;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class app
{
    private static OkHttpClient client = new OkHttpClient();

    private static  String run(String URL) throws IOException
    {
        Request request = new Request.Builder()
                .url(URL)
                .build();
        try (Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }

    // INPUT THE CRUD METHOD BELOW
    // RUN THE METHOD THROUGH PSVM

    public static void main(String[] args) {
        System.out.println("CALL CRUD METHOD");
    }


}

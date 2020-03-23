import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class USD extends Coin {

    public USD() throws IOException {}

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("https://free.currencyconverterapi.com/api/v6/convert?q=USD_ILS&compact=y&apiKey=b01c495c218a465c8e62")
            .build();
    Response response = client.newCall(request).execute();
    String jsonData = response.body().string();

    JSONObject mainJsonObject = new JSONObject(jsonData);
    JSONObject convertUSDtoILS = mainJsonObject.getJSONObject("USD_ILS");
    double valUSD = convertUSDtoILS.getDouble("val");


    final private double value = valUSD;

    @Override
    public double getValue() {
        return value;
    }



}

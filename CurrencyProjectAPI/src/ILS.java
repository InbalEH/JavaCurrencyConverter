import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class ILS extends Coin {

    public ILS() throws IOException {}

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("https://free.currencyconverterapi.com/api/v6/convert?q=ILS_USD&compact=y&apiKey=b01c495c218a465c8e62")
            .build();
    Response response = client.newCall(request).execute();
    String jsonData = response.body().string();

    JSONObject mainJsonObject = new JSONObject(jsonData);
    JSONObject convertILStoUSD = mainJsonObject.getJSONObject("ILS_USD");
    double valNIS = convertILStoUSD.getDouble("val");

    final private double value = valNIS;

    @Override
    public double getValue() {
        return value;
    }

}

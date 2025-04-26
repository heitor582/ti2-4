import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

class produto3{
    public static void main(String[] args) throws Exception {
        String subscriptionKey = "38MnikOcF27F27lhwiaZNspjF6ZrBKmTRKVH11irB80NxPivRmILJQQJ99BDACZoyfiXJ3w3AAAbACOGvdCa";
        String endpoint = "https://api.cognitive.microsofttranslator.com";
        String region = "brazilsouth";

        String textToTranslate = "Hello, how are you?";
        String url = endpoint + "/translate?api-version=3.0&to=pt";
        String requestBody = "[{\"Text\": \"" + textToTranslate + "\"}]";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Ocp-Apim-Subscription-Key", subscriptionKey)
                .header("Ocp-Apim-Subscription-Region", region)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Resposta:");
        System.out.println(response.body());
    }
}
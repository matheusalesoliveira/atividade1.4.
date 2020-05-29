import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BrazillianStates {

	public static void main(String args[]){
		System.out.println("Minha rua: "+getCepAddres("15053025")[1]);
	}

    public static ObservableList<String> brazilianStates = FXCollections.observableArrayList(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
            "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");

    public static String[] getCepAddress(String cep) {
        String json;
        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();

            // JOptionPane.showMessageDialog(null, json);
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");
            String array[] = json.split("\n");
            if (array[1].equals("erro")) {
                String resp[] = {array[1], array[2]};
                return resp;
            }else{
                String resp[] = {array[3], array[7], array[11], array[15], array[19], array[23]};//cep,logradouro,complemento,bairro,cidade,uf
                return resp;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getState(int state) {
        switch (state) {
            case 0:
                return "Acre";
            case 1:
                return "Alagoas";
            case 2:
                return "Amapá";
            case 3:
                return "Amazonas";
            case 4:
                return "Bahia";
            case 5:
                return "Ceará";
            case 6:
                return "Distrito Federal";
            case 7:
                return "Espírito Santo";
            case 8:
                return "Goiás";
            case 9:
                return "Maranhão";
            case 10:
                return "Mato Grosso";
            case 11:
                return "Mato Grosso do Sul";
            case 12:
                return "Minas Gerais";
            case 13:
                return "Pará";
            case 14:
                return "Paraíba";
            case 15:
                return "Paraná";
            case 16:
                return "Pernambuco";
            case 17:
                return "Piauí";
            case 18:
                return "Rio de Janeiro";
            case 19:
                return "Rio Grande do Norte";
            case 20:
                return "Rio Grande do Sul";
            case 21:
                return "Rondônia";
            case 22:
                return "Roraima";
            case 23:
                return "Santa Catarina";
            case 24:
                return "São Paulo";
            case 25:
                return "Sergipe";
            case 26:
                return "Tocantins";
            default:
                return "";
        }
    }

    public static String getStateInitials(int state) {
        switch (state) {
            case 0:
                return "AC";
            case 1:
                return "AL";
            case 2:
                return "AP";
            case 3:
                return "AM";
            case 4:
                return "BA";
            case 5:
                return "CE";
            case 6:
                return "DF";
            case 7:
                return "ES";
            case 8:
                return "GO";
            case 9:
                return "MA";
            case 10:
                return "MT";
            case 11:
                return "MS";
            case 12:
                return "MG";
            case 13:
                return "PA";
            case 14:
                return "PB";
            case 15:
                return "PR";
            case 16:
                return "PE";
            case 17:
                return "PI";
            case 18:
                return "RJ";
            case 19:
                return "RN";
            case 20:
                return "RS";
            case 21:
                return "RO";
            case 22:
                return "RR";
            case 23:
                return "SC";
            case 24:
                return "SP";
            case 25:
                return "SE";
            case 26:
                return "TO";
            default:
                return "";
        }
    }
}

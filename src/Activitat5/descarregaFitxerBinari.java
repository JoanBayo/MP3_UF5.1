package Activitat5;
import java.io.*;
import java.net.*;

public class descarregaFitxerBinari {
    public static void descarrega(String url) throws Exception {
        URL urlFitxer = new URL(url);
        URLConnection connexio = urlFitxer.openConnection();
        int midaFitxer = connexio.getContentLength();
        InputStream fluxDadesEntrada = connexio.getInputStream();
        byte[] dadesFitxer = new byte[midaFitxer];
        int byteLlegit = 0;
        int offset = 0;
        while (offset < midaFitxer) {
            byteLlegit = fluxDadesEntrada.read(dadesFitxer, offset, midaFitxer - offset);
            if (byteLlegit == -1) {
                break;
            }
            offset += byteLlegit;
        }

        fluxDadesEntrada.close();

        String nomFitxer = url.substring(url.lastIndexOf('/') + 1);
        FileOutputStream fluxDadesSortida = new FileOutputStream(nomFitxer);
        fluxDadesSortida.write(dadesFitxer);
        fluxDadesSortida.flush();
        fluxDadesSortida.close();

    }

    public static void main(String[] args) {
        try {
            descarrega("https://dungeonofbits.com/importantDATA.png");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}



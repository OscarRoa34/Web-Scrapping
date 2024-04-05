package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener el HTML de la página web
            Document doc = Jsoup.connect("https://es.wikipedia.org/wiki/Anexo:Municipios_de_Colombia").get();

            // Seleccionar el contenido relevante
            Element content = doc.selectFirst("#mw-content-text");

            // Encontrar todas las listas ordenadas
            Elements lists = content.select("ol");

            // Iterar sobre cada lista ordenada
            for (Element list : lists) {
                // Obtener los elementos de la lista
                Elements items = list.select("li");

                // Iterar sobre cada elemento de la lista
                for (Element item : items) {
                    // Obtener solo el nombre del municipio
                    Element link = item.selectFirst("a");
                    if (link != null) {
                        String name = link.text();
                        System.out.println(name);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
